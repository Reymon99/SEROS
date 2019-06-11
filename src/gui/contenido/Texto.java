package gui.contenido;
import tools.Colour;
import tools.Fuentes;
import javax.swing.*;
import java.awt.*;
public class Texto extends JTextArea {
    /**
     * Area de texto con parametros predefinidos enfocados hacia el proyecto
     * @author Sergio Majé
     */
    public Texto(){
        setEditable(false);
        setBackground(Colour.NEGROINDICE.getColor());
        setForeground(Colour.BLANCO.getColor());
        setMargin(new Insets(3,5,0,7));
        setFont(Fuentes.UBUNTULIGHT15.getFont());
    }
    /**
     * Area de texto con parametros predefinidos enfocados hacia el proyecto
     * @param text {@link String}
     * @author Sergio Majé
     */
    public Texto(String text){
        super(text);
        init();
    }
    /**
     * Area de texto con parametros predefinidos enfocados hacia el proyecto
     * @param text {@link String}
     * @param rows int
     * @param columns int
     * @author Sergio Majé
     */
    public Texto(String text,int rows,int columns){
        super(text,rows,columns);
        init();
        setBorder(BorderFactory.createSoftBevelBorder(1));
    }
    private void init(){
        setFont(Fuentes.UBUNTULIGHT20.getFont());
        setTabSize(2);
        setEditable(false);
        setOpaque(false);
        setLineWrap(true);
        setWrapStyleWord(true);
    }
}