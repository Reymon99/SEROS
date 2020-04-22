package gui.contenido;

import org.constrains.Constrains;
import org.constrains.View;
import org.constrains.Weight;

import eventos.Eventos;
import tools.Archivos;
import tools.Colour;
import tools.Fuentes;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.Objects;

public final class About extends JDialog {
    public static boolean show;
    private String link;

    static {
        About.show = true;
    }

    /**
     * Ventana Acerca de Seros.<br>
     * Logo y descripción del proyecto.<br>
     * Desarrollo y versión.
     * @param component {@link Component} del cual es dependiente, para que al ejecutarse se centre respectivamente hacia este.
     */
    public About(Component component) {
        setTitle("Acerca de Seros");
        setFocusable(true);
        getContentPane().setLayout(new GridBagLayout());
        init();
        pack();
        setLocationRelativeTo(component);
        setIconImage(Objects.requireNonNull(
                Archivos.image("/resources/image/icon.png", -1, -1)).getImage()
        );
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                exit();
            }
        });
    }

    private void init() {
        LinkedHashMap<String, String> contenido = Archivos.getContenidos("about");
        JLabel seros = new JLabel("Simulador de Estructura de Datos", SwingConstants.CENTER);
        seros.setFont(Fuentes.UBUNTU_LIGHT_30.getFont());
        seros.setHorizontalTextPosition(SwingConstants.CENTER);
        JLabel seros1 = new JLabel("Seros", SwingConstants.CENTER);
        seros1.setFont(Fuentes.UBUNTU_LIGHT_B_30.getFont());
        seros1.setHorizontalTextPosition(SwingConstants.CENTER);
        JTextArea texto = Components.getTexto(contenido.get("description"));
        texto.setFont(Fuentes.UBUNTU_LIGHT_14.getFont());
        JLabel label = new JLabel(link = contenido.get("link"));
        label.setFont(Fuentes.UBUNTU_LIGHT_14.getFont());
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label.setForeground(Colour.CURIOUS_BLUE.getColor());
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.link(link);
            }
        });
        Weight weight00 = new Weight(0, 0);
        Weight weight10 = new Weight(1, 0);
        Point placeNH = new Point(GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);
        Point placeCH = new Point(GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        Constrains.addComp(
                new View(
                        new JLabel(Archivos.image("/resources/image/logo.png", 200, -1)),
                        getContentPane()
                ),
                new Rectangle(0, 0, 1, 1),
                weight00,
                new Insets(30, 15, 3, 15),
                new Point(GridBagConstraints.CENTER, GridBagConstraints.NONE)
        );
        Constrains.addComp(
                new View(seros, getContentPane()),
                new Rectangle(0, 1, 1, 1),
                weight00,
                new Insets(3, 18, 5, 15),
                placeNH
        );
        Constrains.addComp(
                new View(seros1, getContentPane()),
                new Rectangle(0, 2, 1, 1),
                weight00,
                new Insets(5, 15, 5, 15),
                placeNH
        );
        Constrains.addComp(
                new View(texto, getContentPane()),
                new Rectangle(0, 3, 1, 1),
                weight10,
                new Insets(15, 15, 3, 15),
                placeCH
        );
        Constrains.addComp(
                new View(label, getContentPane()),
                new Rectangle(0, 4, 1, 1),
                weight10,
                new Insets(0, 15, 30, 15),
                placeCH
        );
    }

    /**
     * Acción salir del {@link About} y reiniciar su estado inicial
     */
    private void exit() {
        About.show = true;
        dispose();
    }
}