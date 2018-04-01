package nl.khonraad.ql.gui.visuals;

import java.awt.Dimension;
import java.text.DecimalFormat;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import nl.khonraad.ql.algebra.Value;
import nl.khonraad.ql.algebra.value.Type;
import nl.khonraad.ql.ast.data.Question;
import nl.khonraad.ql.cdi.QuestionnaireAccessor;

@SuppressWarnings("serial") 

public class IntegerWidget extends JSpinner implements QuestionnaireAccessor {

    public IntegerWidget(Question question) {
        
        super( new SpinnerNumberModel( new Integer( question.string() ), null, null, 1 ) );

        JSpinner.NumberEditor editor = (JSpinner.NumberEditor) getEditor();

        DecimalFormat format = editor.getFormat();
        format.setMaximumFractionDigits( 0 );
        format.setMinimumFractionDigits( 0 );
        editor.getTextField().setHorizontalAlignment( SwingConstants.RIGHT );
        Dimension d = getPreferredSize();
        d.width = 185;
        setPreferredSize( d );

        addChangeListener( e -> {

            JSpinner source = (JSpinner) e.getSource();

            String current = source.getModel().getValue().toString();

            questionnaire().storeAnswer( question.identifier(), new Value( Type.Integer, current ) );
        } );
    }
}