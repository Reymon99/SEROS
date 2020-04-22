package gui.principal;

import tools.Archivos;

import java.awt.GridBagLayout;
import java.util.Objects;
import javax.swing.JFrame;

public final class Desktop extends JFrame {
    /**
     * Frame del proyecto
     */
    protected Desktop() {
        super("Seros");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setContentPane(new Contenedor());
        setExtendedState(MAXIMIZED_BOTH);
        setIconImage(Objects.requireNonNull(
                Archivos.image("/resources/image/icon.png", -1, -1)).getImage()
        );
    }

    public static void main(String[] args) {
        new Desktop().setVisible(true);
    }
}