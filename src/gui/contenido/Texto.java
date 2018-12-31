package gui.contenido;
import fuentes.Fuentes;
import javax.swing.*;
public class Texto extends JTextArea {
    /**
     * Area de texto con parametros predefinidos enfocados hacia el proyecto
     * @param text {@link String}
     */
    public Texto(String text){
        super(text);
        setFont(Fuentes.UBUNTULIGHT20.getFont());
        setTabSize(4);
        setEditable(false);
        setOpaque(false);
        setLineWrap(true);
        setWrapStyleWord(true);
    }
}