package gui.principal;
import java.awt.*;
import javax.swing.*;
public final class Desktop extends JFrame {
    /**
     * Ventana principal de proyecto
     */
    public Desktop() {
        super("Desktop");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        init();
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
    }
    private void init() {
        setContentPane(new Panel());
    }
}