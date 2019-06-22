package gui.contenido;
import static tools.Colour.*;
import static tools.Fuentes.*;
import javax.swing.*;
import java.awt.*;
public class Texto extends JTextArea {
    /**
     * Area de texto con parametros predefinidos enfocados hacia el proyecto
     * @author Sergio Majé
     */
    public Texto(){
        setEditable(false);
        setBackground(NEGROINDICE.getColor());
        setForeground(BLANCO.getColor());
        setMargin(new Insets(3,5,0,7));
        setFont(UBUNTULIGHT15.getFont());
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
    /**
     * Area de texto con parametros predefinidos enfocados hacia el proyecto
     * @param rows int
     * @param columns int
     * @author Sergio Majé
     */
    public Texto(int rows, int columns){
        super(rows, columns);
        setEditable(false);
        setLineWrap(true);
        setWrapStyleWord(true);
        setFont(UBUNTULIGHT15.getFont());
        setCaretColor(BLANCO.getColor());
        setForeground(BLANCO.getColor());
        setBackground(AZULTEXT.getColor());
        setMargin(new Insets(28,24,20,20));
    }
    private void init(){
        setFont(UBUNTULIGHT20.getFont());
        setTabSize(2);
        setEditable(false);
        setOpaque(false);
        setLineWrap(true);
        setWrapStyleWord(true);
    }
}