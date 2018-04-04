package nl.uva.js.qlparser.ui.components.gui;

import javax.swing.*;
import java.awt.*;


public class TextPanel extends JPanel{

    private final TextArea textArea;

    public TextPanel(int width, int height, Color color, boolean editable) {
        this.setBackground(Color.gray);
        this.setPreferredSize(new Dimension(width, height));

        textArea = new TextArea("",0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        textArea.setPreferredSize(new Dimension(width, height-10));
        textArea.setBackground(color);
        textArea.setForeground(Color.white);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        textArea.setEditable(editable);

        this.add(textArea);
        this.setVisible(true);
    }

    public void setText(String text) {
        textArea.setText(text);
    }

    public String getText() {
        return textArea.getText();
    }

    public void setTextColor(Color color) {
        textArea.setForeground(color);
    }
}
