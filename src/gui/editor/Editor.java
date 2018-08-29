package gui.editor;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.*;
public class Editor extends JTextPane {
    public Editor(){
        setBackground(new Color(48,47,51));
        setForeground(Color.WHITE);
    }
    public void append(Color color,String n){
        setCaretPosition(getDocument().getLength());
        setCharacterAttributes(StyleContext.getDefaultStyleContext().addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground,color),false);
        replaceSelection(n);
        setCaretPosition(getDocument().getLength());
    }
}