package gui.simulador.simuladores.tda;

import org.constrains.Constrains;
import org.constrains.View;

import acciones.Acciones;
import acciones.Eventos;
import gui.contenido.Tree;
import gui.editor.Editor;
import gui.simulador.Simulador;
import gui.simulador.lienzos.Cartesiano;
import tools.Dato;
import tools.Paneles;
import tools.Text;

import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.JTree;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;

public final class Punto extends Simulador implements Acciones {
    private final JSpinner x;
    private final JSpinner y;
    private final Tree punto;
    private final Cartesiano cartesiano;

    /**
     * Simulador para la temática TDA<br>
     * Simula un punto en el eje cartesiano
     * @see Cartesiano
     * @see Simulador
     * @see Acciones
     */
    public Punto(JSpinner x, JSpinner y) {
        super("(x, y)", x, y);
        this.x = x;
        this.y = y;
        punto = new Tree(new JTree.DynamicUtilTreeNode(
                new Dato("Punto", "punto", "", true),
                new Dato[]{
                        new Dato("int", "x", ""),
                        new Dato("int", "y", "")
                }
        ));
        punto.expandNode(0);
        cartesiano = new Cartesiano();
        getLienzo().setLayout(new BorderLayout());
        getLienzo().add(cartesiano, BorderLayout.CENTER);
        setAcciones(this);
        addCodes(Editor.editor("Punto"));
        back("Tipos de Datos Abstractos", Paneles.TDA);
        getSend().setText("Graficar");
        setDatos(punto);
        setTexto(Text.SIMULADOR_TDA_2);
        getCodigos().setPackageName("tda");
    }

    /**
     * Muestra los datos y códigos que se asignan al eje x
     */
    private void asignacionX() {
        base(Text.INSTANCIA_X, 5, 0, false);
        Eventos.variable(punto, 0, x.getValue());
    }

    /**
     * Muestra los datos y códigos que se asignan al eje y
     */
    private void asignacionY() {
        base(Text.INSTANCIA_Y, 6, 0, false);
        Eventos.variable(punto, 1, y.getValue());
    }

    /**
     * Grafica las coordenadas (x, y) muestra los códigos asignados a estos
     */
    private void mostrarCoordenadas() {
        base(
                Text.SIMULADOR_TDA_1,
                22,
                ((Editor) getCodigos().getComponentAt(0)).getVerticalScrollBar().getMaximum(),
                true
        );
        cartesiano.graficar(
                Integer.parseInt(x.getValue().toString()),
                Integer.parseInt(y.getValue().toString())
        );
    }

    /**
     * Acciones comunes de interactividad
     * @param text   {@link Text} a fijar
     * @param line   línea seleccionar
     * @param scroll posición del scroll a fijar
     * @param clean  acción de habilitar la opción de limpiar o de interactividad
     */
    private void base(Text text, int line, int scroll, boolean clean) {
        setTexto(text);
        Eventos.scroll((Editor) getCodigos().getComponentAt(0), scroll);
        ((Editor) getCodigos().getComponentAt(0)).drawLineIn(line);
        Eventos.enable(true, clean ? getClean() : getNextIteracion(), getBack(), getHome());
    }

    @Override
    protected void acomodamientoPanelControl(String title, JComponent... components) {
        Point placeCH = new Point(GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(
                new View(componentRegistro(title, components), getControl()),
                new Rectangle(2, 0, 2, 1),
                1,
                new Insets(3, 80, 5, 5),
                new Point(GridBagConstraints.EAST, GridBagConstraints.BOTH)
        );
        Constrains.addCompX(
                new View(getSend(), getControl()),
                new Rectangle(4, 0, 2, 1),
                1,
                new Insets(10, 5, 5, 100),
                placeCH
        );
        Constrains.addCompX(
                new View(getPause(), getControl()),
                new Rectangle(2, 1, 1, 1),
                1,
                new Insets(5, 35, 10, 8),
                new Point(GridBagConstraints.EAST, GridBagConstraints.NONE)
        );
        Constrains.addCompX(
                new View(getNextIteracion(), getControl()),
                new Rectangle(3, 1, 2, 1),
                1,
                new Insets(5, 8, 10, 8),
                placeCH
        );
        Constrains.addCompX(
                new View(getClean(), getControl()),
                new Rectangle(5, 1, 1, 1),
                1,
                new Insets(5, 5, 10, 100),
                new Point(GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL)
        );
    }

    @Override
    public void iteracion0() {
        cartesiano.graficar(Integer.parseInt(x.getValue().toString()), Integer.parseInt(y.getValue().toString()));
        Eventos.enable(true, getClean(), getBack(), getHome());
        Eventos.enable(false, getSend(), x, y, getPause(), getNextIteracion());
        setTexto(Text.SIMULADOR_TDA_1);
        Eventos.variable(punto, 0, x.getValue());
        Eventos.variable(punto, 1, y.getValue());
        punto.expandNode(0);
    }

    @Override
    public void iteracion1() {
        Eventos.enable(
                false,
                getSend(),
                x,
                y,
                getPause(),
                getClean(),
                getBack(),
                getHome(),
                getNextIteracion()
        );
        if (getIteracion() == 0) asignacionX();
        else if (getIteracion() == 1) asignacionY();
        else mostrarCoordenadas();
        incrementIteracion();
    }

    @Override
    public void clean() {
        cleanComponents();
        cartesiano.limpiar();
        Eventos.variable(punto, 0, "");
        Eventos.variable(punto, 1, "");
        Eventos.enable(true, x, y);
        setTexto(Text.SIMULADOR_TDA_2);
        x.setValue(0);
        y.setValue(0);
        punto.expandNode(0);
    }
}