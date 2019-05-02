package gui.principal;
import tools.Archivos;
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
        setIconImage(Archivos.image("/recourses/image/logo.png",-1,48).getImage());
    }
    private void init() {
        setContentPane(new Panel());
    }
}