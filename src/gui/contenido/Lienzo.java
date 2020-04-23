package gui.contenido;

import acciones.Acciones;
import acciones.Eventos;
import tools.Archivos;
import tools.Paneles;
import tools.Text;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class Lienzo extends JPanel {
    private final boolean lienzo;
    private Acciones acciones;
    private JLabel back;
    private JLabel home;
    private JLabel next;

    /**
     * Esquema de los paneles del simulador
     */
    public Lienzo() {
        this(false);
    }

    /**
     * Esquema de los paneles del simulador
     * @param lienzo decide si se pinta el lienzo o no
     */
    public Lienzo(boolean lienzo) {
        super();
        this.lienzo = lienzo;
        init();
    }

    /**
     * Esquema de los paneles del simulador
     * @param manager {@link LayoutManager} a utilizar
     * @param lienzo  decide si se pinta el lienzo o no
     */
    public Lienzo(LayoutManager manager, boolean lienzo) {
        super(manager);
        this.lienzo = lienzo;
        init();
    }

    /**
     * Inicializador de componente
     */
    private void init() {
        back = Components.getBoton(
                Archivos.image("/resources/image/back.png"),
                Eventos.menu(Paneles.values())
        );
        home = Components.getBoton(
                Text.VENTANA_PRINCIPAL.toString(),
                Archivos.image("/resources/image/home.png"),
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        acciones.clean();
                        Eventos.show(Paneles.PRINCIPAL);
                    }
                }
        );
        next = Components.getBoton(Archivos.image("/resources/image/next.png"));
    }

    /**
     * Atributos del botón retroceder
     * @param toolTipText mensaje de ayuda
     * @param paneles     panel a retroceder
     */
    public void back(String toolTipText, Paneles paneles) {
        back.setToolTipText(toolTipText);
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                acciones.clean();
                Eventos.show(paneles);
            }
        });
    }

    /**
     * Atributos del botón avanzar
     * @param toolTipText mensaje de ayuda
     * @param paneles     panel a avanzar
     */
    public void next(String toolTipText, Paneles paneles) {
        next.setToolTipText(toolTipText);
        next.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                acciones.clean();
                Eventos.show(paneles);
            }
        });
    }

    /**
     * Obtiene el componente retorno al panel anterior
     * @return Retorna al panel anterior
     */
    public JLabel getBack() {
        return back;
    }

    /**
     * Obtiene el componente de retorno al panel principal
     * @return Retorna al panel principal de Seros
     */
    public JLabel getHome() {
        return home;
    }

    /**
     * Obtiene el componente retorno al panel siguiente
     * @return Retorna al panel siguiente
     */
    public JLabel getNext() {
        return next;
    }

    /**
     * Obtiene las acciones a realizar en el panel
     * @return acciones del panel
     */
    public Acciones getAcciones() {
        return acciones;
    }

    /**
     * Da nuevas acciones al panel
     * @param acciones nuevas acciones
     */
    public void setAcciones(Acciones acciones) {
        this.acciones = acciones;
    }

    /**
     * Tapiz del panel
     * @param g {@link Graphics}
     */
    @Override
    public void paint(Graphics g) {
        if (lienzo) {
            g.drawImage(
                    Objects.requireNonNull(Archivos.image("/resources/image/Lienzo.jpg")).getImage(),
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    this
            );
            setOpaque(false);
        }
        super.paint(g);
    }
}