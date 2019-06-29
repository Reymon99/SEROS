package gui.contenido.scroll;
import javax.swing.*;
public class InvisibleScrollBarButton extends JButton {
    /**
     * Ocultar el boton de incremento y decremento en el ScrollBar
     */
    protected InvisibleScrollBarButton() {
        setOpaque(false);
        setFocusable(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setBorder(BorderFactory.createEmptyBorder());
    }
}