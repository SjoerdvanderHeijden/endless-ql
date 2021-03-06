package nl.uva.js.qlparser.logic;

import nl.uva.js.qlparser.models.ql.enums.DataType;
import nl.uva.js.qlparser.models.ql.expressions.Form;
import nl.uva.js.qlparser.models.ql.expressions.form.FormExpression;
import nl.uva.js.qlparser.models.ql.expressions.form.Question;
import nl.uva.js.qlparser.models.qls.Stylesheet;
import nl.uva.js.qlparser.models.qls.elements.Page;
import nl.uva.js.qlparser.models.qls.elements.ExpressionReference;
import nl.uva.js.qlparser.models.qls.elements.Section;
import nl.uva.js.qlparser.models.qls.enums.WidgetType;
import nl.uva.js.qlparser.models.qls.style.DefaultStyle;

import java.util.*;

public class QLSChecker {
    public static final String UNPLACED_FORM_EXPRESSION = "Unplaced form expression: ";
    public static final String INVALID_FORM_EXPRESSION = "Invalid form expression: ";
    public static final String DUPLICATE_REFERENCE_TO_FORM_EXPRESSION = "Duplicate reference to form expression: ";
    public static final String CAN_NOT_USE_WIDGET = "Can not use widget ";

    private List<String> errors = Collections.emptyList();

    public List<String> checkForErrors(Form form, Stylesheet stylesheet) {
        errors = new ArrayList<>();

        Map<String, FormExpression> expressionsByName = form.getExpressionsByName();
        Map<String, ExpressionReference> expressionRefsByName = getCheckedExpressionReferencesByName(stylesheet);

        this.checkQuestionsExist(expressionsByName.keySet(), expressionRefsByName.keySet());

        this.checkWidgetAssignments(expressionsByName, expressionRefsByName, stylesheet.getDefaultStyles());

        return errors;
    }

    private void checkQuestionsExist(Set<String> questionNames, Set<String> questionRefNames) {
        compareLeftToRight(questionNames, questionRefNames, UNPLACED_FORM_EXPRESSION);
        compareLeftToRight(questionRefNames, questionNames, INVALID_FORM_EXPRESSION);
    }

    private void compareLeftToRight(Set<String> left, Set<String> right, String errorMessage) {
        List<String> difference = new ArrayList<>(left);
        difference.removeAll(right);

        for (String question : difference) {
            errors.add(errorMessage + question);
        }
    }

    private Map<String, ExpressionReference> getCheckedExpressionReferencesByName(Stylesheet stylesheet) {
        Map<String, ExpressionReference> expressionReferencesByName = new HashMap<>();

        LinkedList<Page> pages = stylesheet.getPages();
        if (null != pages) {
            LinkedList<Section> sections = new LinkedList<>();
            pages.stream().map(Page::getSections).forEach(sections::addAll);

            for (Section section : sections) {
                LinkedList<ExpressionReference> refs = section.getExpressionReferences();
                for (ExpressionReference ref : refs) {
                    if(expressionReferencesByName.containsKey(ref.getName())) {
                        errors.add(DUPLICATE_REFERENCE_TO_FORM_EXPRESSION + ref.getName());
                    } else {
                        expressionReferencesByName.put(ref.getName(), ref);
                    }
                }
            }
        }
        return expressionReferencesByName;
    }

    private void checkWidgetAssignments(
            Map<String, FormExpression> questions,
            Map<String, ExpressionReference> questionRefs,
            LinkedList<DefaultStyle> defaultStyles
    ) {
        for (ExpressionReference ref : questionRefs.values()) {
            FormExpression formExpression = questions.get(ref.getName());
            if (!(formExpression instanceof Question)) {
                continue;
            }

            DataType dataType = formExpression.getVariable().getDataType();
            WidgetType widgetType = ref.getWidgetType();

            if (null != widgetType && !WidgetType.mapDataTypeToWidget.get(dataType).contains(widgetType)) {
                errors.add(CAN_NOT_USE_WIDGET + widgetType.name().toLowerCase()
                           + " for question " + ref.getName() + "with data type " + dataType.name().toLowerCase());
            }
        }

        for (DefaultStyle def : defaultStyles) {
            DataType dataType = def.getDataType();
            WidgetType widgetType = def.getWidgetType();
            if (!WidgetType.mapDataTypeToWidget.get(dataType).contains(widgetType)) {
                errors.add(CAN_NOT_USE_WIDGET + widgetType.name().toLowerCase()
                           + " for data type " + dataType.name().toLowerCase());
            }
        }
    }
}
