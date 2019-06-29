package gui.contenido;
import tools.Fuentes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
public class Boton extends JLabel {
    /**
     * Etiqueta con parametros predefinidos enfocados hacia el proyecto,<br>
     * para permitirles funcionar como botones
     * @param text {@link String} text de la etiqueta
     * @param tip {@link String} tool tip de la etiqueta
     * @param icon {@link ImageIcon} icono de la etiqueta
     * @param adapter {@link MouseAdapter} evento del mouse de la etiqueta
     */
    public Boton(String text, String tip, ImageIcon icon, MouseAdapter adapter){
        this(icon, text, adapter);
        setToolTipText(tip);
    }
    /**
     * Etiqueta con parametros predefinidos enfocados hacia el proyecto,<br>
     * para permitirles funcionar como botones
     * @param tip {@link String} tool tip de la etiqueta
     * @param icon {@link ImageIcon} icono de la etiqueta
     * @param adapter {@link MouseAdapter} evento del mouse de la etiqueta
     */
    public Boton(String tip, ImageIcon icon, MouseAdapter adapter){
        super(icon,CENTER);
        setToolTipText(tip);
        init(adapter);
    }
    /**
     * Etiqueta con parametros predefinidos enfocados hacia el proyecto,<br>
     * para permitirles funcionar como botones
     * @param icon {@link ImageIcon} icono de la etiqueta
     */
    public Boton(ImageIcon icon){
        super(icon,CENTER);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setOpaque(false);
    }
    /**
     * Etiqueta con parametros predefinidos enfocados hacia el proyecto,<br>
     * para permitirles funcionar como botones
     * @param icon {@link ImageIcon} icono de la etiqueta
     * @param text {@link String} text de la etiqueta
     * @param adapter {@link MouseAdapter} evento del mouse de la etiqueta
     */
    public Boton(ImageIcon icon, String text, MouseAdapter adapter){
        super(text,icon,CENTER);
        setVerticalTextPosition(BOTTOM);
        setHorizontalTextPosition(CENTER);
        init(adapter);
    }
    private void init(MouseAdapter adapter){
        setFont(Fuentes.PURISA18.getFont());
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setOpaque(false);
        addMouseListener(adapter);
    }
}