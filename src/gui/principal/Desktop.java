package gui.principal;
import java.awt.*;
import javax.swing.*;
public final class Desktop extends JFrame {
    /**
     * Ventana principal de proyecto
     * @author Sergio Majé
     */
    public Desktop() {
        super("Desktop");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        init();
        pack();
        setLocationRelativeTo(null);
    }
    private void init() {
        setContentPane(new Panel());
    }
}