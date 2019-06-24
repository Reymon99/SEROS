package gui.contenido;
import tools.Colour;
import tools.Fuentes;
import javax.swing.*;
public class ButtonSimulador extends JButton {
    /**
     * Boton enfocado al Simulador del Proyecto
     * @param text {@link String} en el boton
     * @param enable estado de habilidez
     * @author Sergio Majé
     */
    public ButtonSimulador(String text, boolean enable){
        super(text);
        setFont(Fuentes.UBUNTULIGHT14.getFont());
        setBackground(Colour.GRISBUTTON.getColor());
        setEnabled(enable);
    }
}