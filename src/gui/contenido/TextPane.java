package gui.contenido;
import tools.Colour;
import tools.Fuentes;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
public class TextPane extends JTextPane {
    /**
     *JTextPane adaptado para realizar estilos sencillos a textos
     * @param opaque Opacacidad del componente
     */
    public TextPane(boolean opaque) {
        setEditable(false);
        setOpaque(opaque);
    }
    /**
     *JTextPane adaptado para realizar cuadros de código
     */
    public TextPane() {
        setContentType("text/plain");
        setBackground(Colour.NEGROEDITOR.getColor());
        setForeground(Colour.BLANCO.getColor());
        setFont(Fuentes.UBUNTULIGHT15.getFont());
        setEditable(false);
        setMargin(new Insets(0,10,5,39));
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    }
    /**
     * Da un determinado estilo de fuente al texto añadido al JTextPane
     * @param n texto a dar estilo
     * @param font fuente determinada al estilo del texto
     */
    public void append(String n, Font font){
        setEditable(true);
        StyledDocument document = getStyledDocument();
        Style def= StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
        Style regular= document.addStyle("",def);
        StyleConstants.setFontFamily(def,font.getFamily());
        StyleConstants.setFontSize(def,font.getSize());
        setCharacterAttributes(def,false);
        setCaretPosition(getStyledDocument().getLength());
        replaceSelection(n);
        setCaretPosition(getStyledDocument().getLength());
        setEditable(false);
    }
    /**
     * Añade texto de un determinado color al editor
     * @param n {@link String} texto que será personalizado
     * @param color {@link Colour} color a personalizar
     * @author Sergio Majé
     */
    public void append(String n, Color color){
        setEditable(true);
        StyleContext sc=StyleContext.getDefaultStyleContext();
        AttributeSet set=sc.addAttribute(SimpleAttributeSet.EMPTY,StyleConstants.Foreground,color);
        setCaretPosition(getStyledDocument().getLength());
        setCharacterAttributes(set,false);
        replaceSelection(n);
        setCaretPosition(getStyledDocument().getLength());
        setEditable(false);
    }
}