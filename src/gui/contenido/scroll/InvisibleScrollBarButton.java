package gui.contenido.scroll;
import javax.swing.*;
public class InvisibleScrollBarButton extends JButton {
    protected InvisibleScrollBarButton() {
        setOpaque(false);
        setFocusable(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setBorder(BorderFactory.createEmptyBorder());
    }
}