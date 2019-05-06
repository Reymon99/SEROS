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
     * @author Sergio Majé
     */
    public Boton(String text, String tip, ImageIcon icon, MouseAdapter adapter){
        super(text,icon,CENTER);
        setFont(Fuentes.PURISA18.getFont());
        setVerticalTextPosition(BOTTOM);
        setHorizontalTextPosition(CENTER);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setToolTipText(tip);
        setOpaque(false);
        addMouseListener(adapter);
    }
    /**
     * Etiqueta con parametros predefinidos enfocados hacia el proyecto,<br>
     * para permitirles funcionar como botones
     * @param tip {@link String} tool tip de la etiqueta
     * @param icon {@link ImageIcon} icono de la etiqueta
     * @param adapter {@link MouseAdapter} evento del mouse de la etiqueta
     * @author Sergio Majé
     */
    public Boton(String tip, ImageIcon icon, MouseAdapter adapter){
        super(icon,CENTER);
        setFont(Fuentes.PURISA18.getFont());
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setToolTipText(tip);
        setOpaque(false);
        addMouseListener(adapter);
    }
    /**
     * Etiqueta con parametros predefinidos enfocados hacia el proyecto,<br>
     * para permitirles funcionar como botones
     * @param icon {@link ImageIcon} icono de la etiqueta
     * @author Sergio Majé
     */
    public Boton(ImageIcon icon){
        super(icon,CENTER);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setOpaque(false);
    }
}