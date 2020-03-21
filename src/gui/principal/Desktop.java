package gui.principal;
import tools.Archivos;
import java.awt.*;
import java.util.Objects;
import java.util.Optional;
import javax.swing.*;
public final class Desktop extends JFrame {
    /**
     * Apuntador de la instancia de Desktop
     */
    private static Desktop instance;
    /**
     * Frame del proyecto
     */
    private Desktop() {
        super("Seros");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setContentPane(new Contenedor());
        setExtendedState(MAXIMIZED_BOTH);
        setIconImage(Objects.requireNonNull(
                Archivos.image("/resources/image/icon.png", -1, -1)).getImage()
        );
    }

    /**
     * Patron Singleton de Desktop
     * @return Instancia del Frame
     */
    public static Desktop getInstance() {
        if (Optional.ofNullable(instance).isEmpty()) instance = new Desktop();
        return instance;
    }
}