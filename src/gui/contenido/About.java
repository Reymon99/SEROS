package gui.contenido;
import eventos.Eventos;
import tools.Archivos;
import tools.Colour;
import tools.Fuentes;
import tools.Text;
import tools.Constrains;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
public final class About extends JDialog {
    public static boolean show;
    static {
        About.show = true;
    }
    /**
     * Ventana Acerca de Seros.<br>
     * Logo y descripción del proyecto.<br>
     * Desarrollo y versión.
     * @param component {@link Component} del cual es dependiente, para que al ejecutarse se centre respectivamente hacia este.
     */
    public About(Component component){
        setTitle("Acerca de Seros");
        setUndecorated(true);
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
    private void init(){
        JLabel seros = new JLabel("Simulador de Estructura de Datos", SwingConstants.CENTER);
        seros.setFont(Fuentes.UBUNTU_LIGHT_30.getFont());
        seros.setHorizontalTextPosition(SwingConstants.CENTER);
        JLabel seros1 = new JLabel("Seros", SwingConstants.CENTER);
        seros1.setFont(Fuentes.UBUNTU_LIGHT_B_30.getFont());
        seros1.setHorizontalTextPosition(SwingConstants.CENTER);
        JTextArea texto = Components.getTexto(Text.ABOUT.toString());
        texto.setFont(Fuentes.UBUNTU_LIGHT_14.getFont());
        JLabel label = new JLabel(Text.LINK.toString());
        label.setFont(Fuentes.UBUNTU_LIGHT_14.getFont());
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label.setForeground(Colour.CURIOUS_BLUE.getColor());
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.link(Text.LINK.toString());
            }
        });
        Constrains.addComp(
                new JLabel(Archivos.image("/resources/image/logo.png", 200, -1)),
                getContentPane(),
                new Rectangle(0, 0, 1, 1),
                0,
                0,
                new Insets(30, 15, 3, 15),
                GridBagConstraints.CENTER,
                GridBagConstraints.NONE
        );
        Constrains.addComp(
                seros,
                getContentPane(),
                new Rectangle(0, 1, 1, 1),
                0,
                0,
                new Insets(3, 18, 5, 15),
                GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL
        );
        Constrains.addComp(
                seros1,
                getContentPane(),
                new Rectangle(0, 2, 1, 1),
                0,
                0,
                new Insets(5, 15, 5, 15),
                GridBagConstraints.NORTH,
                GridBagConstraints.HORIZONTAL
        );
        Constrains.addComp(
                texto,
                getContentPane(),
                new Rectangle(0, 3, 1, 1),
                1,
                0,
                new Insets(15, 15, 3, 15),
                GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL
        );
        Constrains.addComp(
                label,
                getContentPane(),
                new Rectangle(0, 4, 1, 1),
                1,
                0,
                new Insets(0, 15, 30, 15),
                GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL
        );
    }
    /**
     * Acción salir del {@link About} y reiniciar su estado inicial
     */
    private void exit(){
        About.show = true;
        dispose();
    }
}