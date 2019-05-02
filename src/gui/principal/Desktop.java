package gui.principal;
import tools.Archivos;
import java.awt.*;
import java.util.Objects;
import javax.swing.*;
public final class Desktop extends JFrame {
    /**
     * Ventana principal de proyecto
     * @author Sergio Majé
     */
    public Desktop() {
        super("Seros");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        init();
        pack();
        setLocationRelativeTo(null);
        setIconImage(Objects.requireNonNull(Archivos.image("/recourses/image/logo.png", -1, 48)).getImage());
    }
    private void init() {
        setContentPane(new Panel());
    }
}