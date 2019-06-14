package gui.contenido;
import tools.Colour;
import tools.Fuentes;
import javax.swing.*;
public class ButtonSimulador extends JButton {
    public ButtonSimulador(String text, boolean enable){
        super(text);
        setFont(Fuentes.UBUNTULIGHT14.getFont());
        setBackground(Colour.GRISBUTTON.getColor());
        setEnabled(enable);
    }
}