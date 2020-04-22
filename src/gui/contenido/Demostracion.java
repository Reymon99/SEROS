package gui.contenido;

import org.constrains.Constrains;
import org.constrains.View;
import org.constrains.Weight;

import acciones.Acciones;
import tools.Archivos;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;

public class Demostracion extends Lienzo {
    private JLabel image;
    private JTextArea texto;
    private JPanel botones;

    /**
     * Plantilla para los paneles de Demostración
     * @param path ruta de imagen a utilizar
     */
    public Demostracion(String path) {
        super(new GridBagLayout(), true);
        setAcciones(new Acciones() {
            @Override
            public void iteracion0() {//none
            }

            @Override
            public void iteracion1() {//none
            }

            @Override
            public void clean() {
                setIcon(path);
            }
        });
        init(Archivos.image(path, -1, -1));
    }

    /**
     * Construcción del panel
     * @param icon imagen a mostrar en el panel
     */
    private void init(ImageIcon icon) {
        Weight weight11 = new Weight(1, 1);
        Weight weight00 = new Weight(0, 0);
        Point placeSWN = new Point(GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE);
        Constrains.addComp(
                new View(image = new JLabel(icon), this),
                new Rectangle(0, 0, 3, 1),
                weight11,
                new Insets(20, 30, 8, 15),
                new Point(GridBagConstraints.CENTER, GridBagConstraints.NONE)
        );
        Constrains.addComp(
                new View(botones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)), this),
                new Rectangle(0, 1, 3, 1),
                weight11,
                new Insets(5, 30, 3, 20),
                new Point(GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL)
        );
        Constrains.addComp(
                new View(texto = Components.getTexto("", 10, 55), this),
                new Rectangle(0, 2, 3, 1),
                weight11,
                new Insets(5, 90, 10, 80),
                new Point(GridBagConstraints.SOUTH, GridBagConstraints.BOTH)
        );
        Constrains.addComp(
                new View(getBack(), this),
                new Rectangle(0, 3, 1, 1),
                weight00,
                new Insets(10, 7, 10, 5),
                placeSWN
        );
        Constrains.addComp(
                new View(getHome(), this),
                new Rectangle(1, 3, 1, 1),
                weight00,
                new Insets(10, 5, 25, 5),
                placeSWN
        );
        botones.setOpaque(false);
    }

    /**
     * Añade el componente de navegación siguiente, en el caso de nesecitarse
     */
    public void nextPanel() {
        Constrains.addComp(
                new View(getNext(), this),
                new Rectangle(2, 3, 1, 1),
                new Weight(0, 0),
                new Insets(10, 50, 10, 7),
                new Point(GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE)
        );
    }

    /**
     * Establece los ítems que se van a utilizar en el panel,</br>
     * <ul>
     *     <li>En el evento del ítem se fija acción o imagen a mostrar en el panel</li>
     * </ul>
     * @param buttons ítems a añadir al panel
     */
    public void setBotones(JButton... buttons) {
        for (JButton button : buttons) botones.add(button);
    }

    /**
     * Fija el texto de explicación del panel
     * @param text texto a fijar en el panel
     */
    public void setTexto(String text) {
        texto.setText(text);
    }

    /**
     * Imagen a fijar el panel
     * @param path ruta del archivo de imagen
     */
    public void setIcon(String path) {
        image.setIcon(Archivos.image(path, -1, -1));
    }
}