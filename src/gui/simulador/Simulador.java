package gui.simulador;

import org.constrains.Constrains;
import org.constrains.View;
import org.constrains.Weight;

import acciones.Eventos;
import gui.contenido.Components;
import gui.contenido.Lienzo;
import gui.contenido.PackageCode;
import gui.contenido.Switch;
import gui.contenido.Tree;
import gui.contenido.scroll.ModernScrollPane;
import gui.editor.Editor;
import tools.Archivos;
import tools.Colour;
import tools.Fuentes;
import tools.Text;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.Optional;

public abstract class Simulador extends Lienzo {
    private Integer iteracion;
    private final JComponent lienzo;
    private JPanel datos;
    private JPanel control;
    private PackageCode codigos;
    private JButton clean;
    private JButton nextIteracion;
    private JButton send;
    private Switch codigo;
    private Switch pause;
    private JTextArea texto;

    /**
     * Esquema de los simuladores del proyecto
     * @param title      título de los componentes de registro de datos
     * @param components {@link JComponent}s de registro de datos
     */
    public Simulador(String title, JComponent... components) {
        this(new JPanel(new GridBagLayout()), title, components);
    }

    /**
     * Esquema de los simuladores del proyecto
     * @param lienzo     {@link JComponent} a mostrar el objeto simulado
     * @param title      título de los componentes de registro de datos
     * @param components {@link JComponent}s de registro de datos
     */
    public Simulador(JComponent lienzo, String title, JComponent... components) {
        super(new GridBagLayout(), false);
        Dimension dimCanvas = canvasSize();
        this.lienzo = lienzo;
        this.lienzo.setPreferredSize(dimCanvas);
        this.lienzo.setSize(dimCanvas);
        this.lienzo.setMinimumSize(dimCanvas);
        this.lienzo.setComponentPopupMenu(menuLienzo());
        this.lienzo.setBorder(BorderFactory.createEtchedBorder(0));
        this.lienzo.setBackground(Colour.BLANCO_OPACO.getColor());
        iteracion = 0;
        init();
        acomodamientoPanelControl(title, components);
    }

    /**
     * Instanciación y acomodamiento de los componentes del panel
     */
    private void init() {
        codigo = new Switch("Visualización del Código", false);
        pause = new Switch("Paso a Paso", false);
        send = Components.getButtonSimulador("Enviar", true, e -> {
            if (pause.isOnOff()) getAcciones().iteracion1();
            else getAcciones().iteracion0();
        });
        clean = Components.getButtonSimulador("Limpiar", false, e -> getAcciones().clean());
        nextIteracion = Components.getButtonSimulador("Siguiente", false, e -> getAcciones().iteracion1());
        control = new JPanel(new GridBagLayout());
        control.setBackground(Colour.GRIS_PANEL.getColor());
        JLabel desc = new JLabel("Descripción");
        desc.setFont(Fuentes.UBUNTU_LIGHT_14.getFont());
        desc.setForeground(Colour.BLANCO.getColor());
        desc.setBackground(Colour.AZUL_TITLE.getColor());
        desc.setOpaque(true);
        codigo.setModificable(false);
        pause.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                codigo.setModificable(pause.isOnOff());
                if (!pause.isOnOff() && codigo.isOnOff()) codigo.setOnOff(pause.isOnOff());
            }
        });
        datos = new JPanel(new GridBagLayout());
        datos.setToolTipText("Variables de Simulación");
        addComponents(
                desc,
                texto = Components.getTexto(4, 55),
                new ModernScrollPane(datos),
                codigos = new PackageCode()
        );
    }

    private void addComponents(Component... components) {
        Insets insets = new Insets(0, 0, 0, 0);
        Weight weight00 = new Weight(0, 0);
        Weight weight10 = new Weight(1, 0);
        Point placeWN = new Point(GridBagConstraints.WEST, GridBagConstraints.NONE);
        Point placeCH = new Point(GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        Point placeCB = new Point(GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        Constrains.addComp(
                new View(lienzo, this),
                new Rectangle(0, 0, 1, 4),
                weight00,
                insets,
                new Point(GridBagConstraints.NORTHWEST, GridBagConstraints.NONE)
        );
        Constrains.addComp(
                new View(getBack(), control),
                new Rectangle(0, 0, 1, 2),
                weight00,
                new Insets(15, 15, 15, 5),
                placeWN
        );
        Constrains.addComp(
                new View(getHome(), control),
                new Rectangle(1, 0, 1, 2),
                weight00,
                new Insets(20, 5, 20, 15),
                placeWN
        );
        Constrains.addComp(
                new View(control, this),
                new Rectangle(0, 4, 1, 1),
                weight00,
                insets,
                placeCB
        );
        Constrains.addCompX(
                new View(components[0], this),
                new Rectangle(1, 0, 1, 1),
                1,
                insets,
                placeCH
        );
        Constrains.addCompIy(
                new View(components[1], this),
                new Rectangle(1, 1, 1, 1),
                weight10,
                insets,
                40,
                placeCH
        );
        Constrains.addCompIy(
                new View(components[2], this),
                new Rectangle(1, 2, 1, 1),
                weight10,
                insets,
                190,
                placeCB
        );
        Constrains.addComp(
                new View(components[3], this),
                new Rectangle(1, 3, 1, 2),
                new Weight(1, 1),
                insets,
                placeCB
        );
    }

    /**
     * Plantilla por defecto para reiniciar el simulador
     */
    public void cleanComponents() {
        Eventos.enable(true, send, pause, getBack(), getHome());
        Eventos.enable(false, nextIteracion, clean, codigo);
        pause.setOnOff(false);
        codigo.setOnOff(false);
        setIteracion(0);
        Eventos.scroll((Editor) codigos.getComponentAt(0), 0);
        ((Editor) codigos.getComponentAt(0)).setLine(false);
    }

    /**
     * Plantilla por defecto de acomodamiento para el panel de control
     * @param title      título de los componentes de registro de datos
     * @param components {@link JComponent}s de registro de datos
     */
    protected abstract void acomodamientoPanelControl(String title, JComponent... components);

    /**
     * Componentes de registro de datos
     * @param title      título del borde
     * @param components {@link JComponent}s de registro
     */
    protected Box componentRegistro(String title, JComponent... components) {
        Box box = Box.createHorizontalBox();
        for (JComponent component : components) {
            box.add(component);
            if (component != components[components.length - 1]) box.add(Box.createHorizontalStrut(1));
        }
        if (Optional.ofNullable(title).isPresent())
            box.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), title));
        return box;
    }

    /**
     * Añade los codigos que necesita el simulador
     * @param editor {@link Editor} con el código correspondiente
     */
    protected void addCodes(Editor editor) {
        codigos.add(editor.getCode(), editor);
    }

    /**
     * Fijar un texto determinado en el área de notificaciones
     * @param texto texto a fijar determinadamente
     */
    public void setTexto(String texto) {
        this.texto.setEditable(true);
        this.texto.setText(texto);
        this.texto.setEditable(false);
    }

    /**
     * Fijar un texto determinado en el área de notificaciones
     * @param texto texto a fijar determinadamente
     */
    public void setTexto(Text texto) {
        setTexto(texto.toString());
    }

    /**
     * Variables que se van a agregar
     * @param trees {@link Tree} a agregar
     */
    protected void setDatos(Tree... trees) {
        for (int i = 0; i < trees.length; i++)
            Constrains.addComp(
                    new View(trees[i], datos),
                    new Rectangle(0, i, 1, 1),
                    new Weight(1, 1),
                    new Insets(i == 0 ? 7 : 1, 10, i == trees.length - 1 ? sizeTree(trees.length) : 1, 5),
                    new Point(GridBagConstraints.CENTER, GridBagConstraints.BOTH)
            );
    }

    /**
     * Da el tamaño del espacio libre en el panel datos
     * @param length {@link Tree} en el panel
     * @return espacio libre en el panel
     */
    private int sizeTree(int length) {
        int size = 200 - (10 * length);
        return size > 0 ? size : 8;
    }

    /**
     * Opciones para el lienzo</br>
     * <ul>
     *     <li>Exportar el Lienzo como Imagen JPG</li>
     * </ul>
     * @return menú para las opciones del Lienzo
     */
    private JPopupMenu menuLienzo() {
        JPopupMenu menu = new JPopupMenu();
        JMenuItem save = new JMenuItem("Exportar Lienzo");
        save.addActionListener(e -> {
            try {
                Components.getMessage(
                        Archivos.exportImage(
                                Eventos.saveFile(true),
                                Eventos.createImageOf(lienzo)
                        ),
                        lienzo
                ).setVisible(true);
            } catch (FileNotFoundException ex) {//None
            }
        });
        menu.add(save);
        return menu;
    }

    /**
     * Componente de área de Notificaciones
     * @return área de notificaciones
     */
    protected JTextArea getTexto() {
        return texto;
    }

    /**
     * Panel de control de comandos del simulador
     * @return panel de control
     */
    protected JPanel getControl() {
        return control;
    }

    /**
     * Obtiene el área gráfica del simulador
     * @return área gráfica del simulador
     */
    protected JComponent getLienzo() {
        return lienzo;
    }

    /**
     * Obtiene el contenedor de los códigos del simulador
     * @return Contenedor de los códigos del simulador
     */
    public PackageCode getCodigos() {
        return codigos;
    }

    /**
     * Obtiene la cantidad pulsaciones del paso a paso del simulador
     * @return cantidad de pulsaciones
     */
    protected int getIteracion() {
        return iteracion;
    }

    /**
     * Fija un nuevo valor a la iteración de pulsaciones del simulador
     * @param iteracion nuevo valor de iteración
     */
    private void setIteracion(Integer iteracion) {
        this.iteracion = iteracion;
    }

    /**
     * Incrementa a paso uno las pulsaciones del paso a paso del simulador en la ejecución
     */
    protected void incrementIteracion() {
        iteracion++;
    }

    /**
     * Decrementa a paso uno las pulsaciones del paso a paso del simulador en la ejecución
     */
    protected void decrementIteracion() {
        iteracion--;
    }

    /**
     * Obtiene el componente de paso a paso del simulador
     * @return elección del paso a paso del simulador
     */
    protected Switch getPause() {
        return pause;
    }

    /**
     * Obtiene el componente de visualización del código en el paso a paso en el simulador
     * @return visualización del paso a paso
     */
    protected Switch getCodigo() {
        return codigo;
    }

    /**
     * Boton de envio de datos al simulador
     * @return envio de datos
     */
    protected JButton getSend() {
        return send;
    }

    /**
     * Boton de reinicio del simulador
     * @return reinicio del simulador
     */
    protected JButton getClean() {
        return clean;
    }

    /**
     * Boton de paso a paso del simulador
     * @return boton del paso a paso
     */
    protected JButton getNextIteracion() {
        return nextIteracion;
    }

    /**
     * Porciona el tamaño de completo de la pantalla para el lienzo de simulación (canvas)
     * @return width 73% height 80%
     */
    public static Dimension canvasSize() {
        Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
        return new Dimension(
                (int) (dimScreen.width * 0.73),
                (int) (dimScreen.height * 0.8)
        );
    }
}