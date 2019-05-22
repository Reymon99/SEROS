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
        setExtendedState(MAXIMIZED_BOTH);
        setIconImage(Objects.requireNonNull(Archivos.image("/recourses/image/logo.png", -1, 52)).getImage());
    }
    private void init() {
        setContentPane(new Panel());
    }
}