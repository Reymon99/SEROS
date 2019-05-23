package gui.paneles.recursividad;
import gui.contenido.Contenido;
import gui.contenido.Texto;
import tools.Constrains;
import tools.Fuentes;
import tools.Text;
import javax.swing.*;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import java.awt.*;
public class Recursividad extends Contenido {
    /**
     * Contenido del panel Recursividad
     * @see Contenido
     * @author Sergio Majé
     */
    public Recursividad(){
        getTitle().setText("Recursividad");
        JTextPane editor=new JTextPane();
        editor.setEditable(false);
        editor.setOpaque(false);
        String recur[] = Text.RECURSIVIDAD1.toString().split("\u279c");
        for (String n:recur){
            append(n,Fuentes.PURISA22.getFont(),editor);
            if (!n.equals(recur[recur.length-1])) append("\u279c",Fuentes.SEGOEUISYMBOL22.getFont(),editor);
        }
        Constrains.addComp(new Texto(Text.RECURSIVIDAD.toString()), getContenido(), 0,0,1,1,1,1,10, 25, 1, 12, GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(editor, getContenido(),0,1,1,1,0.2,1,2,25,20,25, GridBagConstraints.NORTH,GridBagConstraints.NONE);
    }
    /**
     * Da un determinado estilo de fuente al texto añadido al JTextPane
     * @param n texto a dar estilo
     * @param font fuente determinada al estilo del texto
     * @param editor JTextPane en el se llevará el proceso del estilo de fuente
     */
    private void append(String n, Font font, JTextPane editor){
        editor.setEditable(true);
        StyledDocument document = editor.getStyledDocument();
        Style def= StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
        Style regular= document.addStyle("",def);
        StyleConstants.setFontFamily(def,font.getFamily());
        StyleConstants.setFontSize(def,font.getSize());
        editor.setCharacterAttributes(def,false);
        editor.setCaretPosition(editor.getStyledDocument().getLength());
        editor.replaceSelection(n);
        editor.setCaretPosition(editor.getStyledDocument().getLength());
        editor.setEditable(false);
    }
}