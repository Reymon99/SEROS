package gui.contenido;
import tools.Colour;
import tools.Fuentes;
import javax.swing.*;
import java.awt.*;
public class Texto extends JTextArea {
    /**
     * Area de texto con parametros predefinidos enfocados hacia el proyecto
     */
    public Texto(){
        setEditable(false);
        setBackground(Colour.NEGRO_INDICE.getColor());
        setForeground(Colour.BLANCO.getColor());
        setMargin(new Insets(3,5,0,7));
        setFont(Fuentes.UBUNTU_LIGHT_15.getFont());
    }
    /**
     * Area de texto con parametros predefinidos enfocados hacia el proyecto
     * @param text {@link String} a dar en el {@link Texto}
     */
    public Texto(String text){
        super(text);
        init();
    }
    /**
     * Area de texto con parametros predefinidos enfocados hacia el proyecto
     * @param text {@link String} a dar en el {@link Texto}
     * @param rows filas
     * @param columns columnas
     */
    public Texto(String text, int rows, int columns){
        super(text,rows,columns);
        init();
        setBorder(BorderFactory.createSoftBevelBorder(1));
    }
    /**
     * Area de texto con parametros predefinidos enfocados hacia el proyecto
     * @param rows filas
     * @param columns columnas
     */
    public Texto(int rows, int columns){
        super(rows, columns);
        setEditable(false);
        setLineWrap(true);
        setWrapStyleWord(true);
        setFont(Fuentes.UBUNTU_LIGHT_15.getFont());
        setCaretColor(Colour.BLANCO.getColor());
        setForeground(Colour.BLANCO.getColor());
        setBackground(Colour.AZUL_TEXT.getColor());
        setMargin(new Insets(28,24,20,20));
    }
    private void init(){
        setFont(Fuentes.UBUNTU_LIGHT_20.getFont());
        setTabSize(2);
        setEditable(false);
        setOpaque(false);
        setLineWrap(true);
        setWrapStyleWord(true);
    }
}