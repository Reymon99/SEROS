package gui.principal;
import java.awt.*;
import javax.swing.*;
public class Desktop extends JFrame {
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