package gui.contenido;
import tools.Colour;
import tools.Fuentes;
import javax.swing.JButton;
import java.awt.event.ActionListener;
public class ButtonSimulador extends JButton {
    /**
     * Boton enfocado al Simulador del Proyecto
     * @param text {@link String} en el boton
     * @param enable estado de habilidez
     */
    public ButtonSimulador(String text, boolean enable, ActionListener listener){
        super(text);
        setFont(Fuentes.UBUNTULIGHT14.getFont());
        setBackground(Colour.GRISBUTTON.getColor());
        setEnabled(enable);
        addActionListener(listener);
    }
}