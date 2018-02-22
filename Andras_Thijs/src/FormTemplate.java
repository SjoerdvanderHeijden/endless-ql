import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

public class FormTemplate {
    private FormLayout layout;
    private JFrame frame;
    private JPanel mainPanel;
    private QLForm body;
    private JButton submit;
    private List<Component> components;

    public FormTemplate(){
        body  = new QLForm("Undefined");
    }

    public FormTemplate(QLForm form){
        body = form;
    }

    public final void initGUI(){

        frame = new JFrame(body.getName());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setPanel(initPanel());
    }

    private JPanel initPanel(){

        layout = new FormLayout(
                "left:default, 3dlu default"); // 5 columns; add rows later

        DefaultFormBuilder builder = new DefaultFormBuilder(layout);
        try{
            List<Question> questions = body.getQuestions();
            Iterator<Question> iterator = questions.iterator();
            while (iterator.hasNext()) {
                Question question = iterator.next();
                builder.append(question.getLabel(), getComponent(question.getType()));
            }
            builder.append(submit);
        } catch (Exception e){
            e.printStackTrace();
        }
        return builder.getPanel();

    }

    private void setPanel(JPanel newPanel){

        mainPanel = newPanel;

        frame.add(mainPanel);

        frame.pack();

        frame.setVisible(true);
    }

    private Component getComponent(Type type){
        switch (type){
            case BOOL: return new JCheckBox();

            case INT: return new JFormattedTextField(intField());

            default: return new JLabel(String.valueOf(type));
        }
    }

    private NumberFormatter intField(){
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(false);
        return formatter;
    }


//    public void setTitle(String title){
//
//        frame.setTitle(title);
//    }
//
//    public void addQuestion(Question question){
//
//        questionPanel.add(new JLabel(question.getType()));
//
//        mainPanel.add(questionPanel);
//
////        frame.revalidate();
//    }
}
