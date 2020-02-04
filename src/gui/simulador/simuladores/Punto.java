package gui.simulador.simuladores;
import eventos.Eventos;
import gui.contenido.Tree;
import gui.editor.Editor;
import gui.simulador.Simulador;
import gui.simulador.lienzos.Graficador;
import tools.Acciones;
import tools.Constrains;
import tools.Dato;
import tools.Paneles;
import tools.Text;
import javax.swing.*;
import java.awt.*;
public final class Punto extends Simulador implements Acciones {
    private JSpinner x;
    private JSpinner y;
    private Tree punto;
    private Graficador graficador;
    /**
     * Simulador para la temática TDA<br>
     * Simula un punto en el eje cartesiano
     * @see Graficador
     * @see Simulador
     * @see Acciones
     */
    public Punto(JSpinner x, JSpinner y) {
        super("(x,y)", x, y);
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
        graficador = new Graficador();
        getLienzo().setLayout(new BorderLayout());
        getLienzo().add(graficador, BorderLayout.CENTER);
        setAcciones(this);
        addCodes(Editor.editor("/resources/codes/tda/Punto.seros", "Punto"));
        back("Tipos de Datos Abstractos", Paneles.TDA);
        getSend().setText("Graficar");
        setDatos(punto);
        setTexto(Text.SIMULADOR_TDA_2);
        getCodigos().setPackageName("tda");
    }
    /**
     * Muestra los datos y códigos que se asignan al eje x
     */
    private void asignacionX(){
        base(Text.INSTANCIA_X, 5, 0, false);
        Eventos.variable(punto, 0, x.getValue());
    }
    /**
     * Muestra los datos y códigos que se asignan al eje y
     */
    private void asignacionY(){
        base(Text.INSTANCIA_Y, 6, 0, false);
        Eventos.variable(punto, 1, y.getValue());
    }
    /**
     * Grafica las coordenadas (x,y) muestra los códigos asignados a estos
     */
    private void mostrarCoordenadas(){
        base(
                Text.SIMULADOR_TDA_1,
                22,
                ((Editor) getCodigos().getComponentAt(0)).getVerticalScrollBar().getMaximum(),
                true
        );
        graficador.graficar(
                Integer.parseInt(x.getValue().toString()),
                Integer.parseInt(y.getValue().toString())
        );
    }
    /**
     * Acciones comunes de interactividad
     * @param text {@link Text} a fijar
     * @param line línea seleccionar
     * @param scroll posición del scroll a fijar
     * @param clean acción de habilitar la opción de limpiar o de interactividad
     */
    private void base(Text text, int line, int scroll, boolean clean){
        setTexto(text);
        Eventos.scroll((Editor) getCodigos().getComponentAt(0), scroll);
        ((Editor) getCodigos().getComponentAt(0)).drawLineIn(line);
        Eventos.enable(true, clean ? getClean() : getNextIteracion(), getBack(), getHome());
    }
    @Override
    protected void acomodamientoPanelControl(String title, JComponent... components) {
        Constrains.addCompX(
                componentRegistro(title, components),
                getControl(),
                new Rectangle(2, 0, 2, 1),
                1,
                new Insets(3, 80, 5, 5),
                GridBagConstraints.EAST,
                GridBagConstraints.BOTH
        );
        Constrains.addCompX(
                getSend(),
                getControl(),
                new Rectangle(4, 0, 2, 1),
                1,
                new Insets(10, 5, 5, 100),
                GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL
        );
        Constrains.addCompX(
                getPause(),
                getControl(),
                new Rectangle( 2, 1, 1, 1),
                1,
                new Insets( 5, 35, 10, 8),
                GridBagConstraints.EAST,
                GridBagConstraints.NONE
        );
        Constrains.addCompX(
                getNextIteracion(),
                getControl(),
                new Rectangle(3, 1, 2, 1),
                1,
                new Insets(5, 8, 10, 8),
                GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL
        );
        Constrains.addCompX(
                getClean(),
                getControl(),
                new Rectangle(5, 1, 1, 1),
                1,
                new Insets(5, 5, 10, 100),
                GridBagConstraints.WEST,
                GridBagConstraints.HORIZONTAL
        );
    }
    @Override
    public void iteracion0() {
        graficador.graficar(Integer.parseInt(x.getValue().toString()), Integer.parseInt(y.getValue().toString()));
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
        graficador.limpiar();
        Eventos.variable(punto, 0, "");
        Eventos.variable(punto, 1, "");
        Eventos.enable(true, x, y);
        setTexto(Text.SIMULADOR_TDA_2);
        x.setValue(0);
        y.setValue(0);
        punto.expandNode(0);
    }
}