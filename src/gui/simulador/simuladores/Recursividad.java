package gui.simulador.simuladores;
import eventos.Eventos;
import gui.simulador.Simulador;
import hilos.Lines;
import tools.Acciones;
import tools.Constrains;
import tools.Fuentes;
import tools.Paneles;
import tools.Text;
import javax.swing.*;
import java.awt.*;
import java.util.Optional;
public abstract class Recursividad extends Simulador implements Acciones {
    private int valor;
    private boolean decremento;
    private JLabel number;
    private JLabel producto;
    /**
     * Plantilla para los simuladores de recursividad
     * @param title título de los componentes de registro de datos
     * @param components {@link JComponent}s de registro de datos
     * @see Acciones
     * @see Simulador
     * @see Lines
     */
    public Recursividad(String title, JComponent... components){
        super(title, components);
        decremento = true;
        number = new JLabel("0", SwingConstants.CENTER);
        producto = new JLabel("", SwingConstants.CENTER);
        number.setFont(Fuentes.UBUNTU_LIGHT_B_118.getFont());
        producto.setFont(Fuentes.UBUNTU_LIGHT_40.getFont());
        setAcciones(this);
        acomodamientoProducto();
        back("Panel de Ejercicios de Recursividad", Paneles.EJERCICIOS_RECURSIVIDAD);
        getCodigos().setPackageName("recursividad");
    }
    /**
     * Indica el decremento o incremento de la iteración
     * @return true: decremento | false: incremento
     */
    private boolean isDecremento() {
        return decremento;
    }
    /**
     * Da un nuevo estado para el control de la iteración
     * @param decremento nuevo estado
     */
    protected void setDecremento(boolean decremento) {
        this.decremento = decremento;
    }
    /**
     * Obtiene la demostración de la operación que se está realizando
     * @return demostración de la operación indicada
     */
    public JLabel getProducto() {
        return producto;
    }
    /**
     * Da una nueva demostración de la operación que se está realizando
     * @param producto nueva demostración de la operación indicada
     */
    protected void setProducto(String producto) {
        this.producto.setText(producto);
    }
    /**
     * Resultado de la operación que se está realizando
     * @return resultado de la operación indicada
     */
    public JLabel getNumber() {
        return number;
    }
    /**
     * Da un nuevo resultado de la operación que se está realizando
     * @param number nuevo resultado de la operación indicada
     */
    protected void setNumber(String number) {
        this.number.setText(number);
    }
    /**
     * Valor de la ejecución recursiva
     * @return valor de ejecución
     */
    protected int getValor() {
        return valor;
    }
    /**
     * Da nuevo valor de la ejecución recursiva
     * @param valor nuevo valor a al ejecución
     */
    protected void setValor(int valor) {
        this.valor = valor;
    }
    /**
     * Acciones comunes de interacción
     * @param text {@link Text} de la descripción de la acción
     * @param numberText número resultado a fijar
     * @param productoText producto a fijar
     * @param clean acción de habilitar la opción de limpiar o de interactividad
     */
    protected void base(Text text, Object numberText, String productoText, boolean clean){
        if (Optional.ofNullable(text).isPresent()) setTexto(text);
        Eventos.enable(true, clean ? getClean() : getNextIteracion(), getBack(), getHome());
    }
    /**
     * Acomodamiento por defecto cuando se utiliza productos
     */
    private void acomodamientoProducto(){
        Constrains.addCompX(
                number,
                getLienzo(),
                new Rectangle(0, 0, 1, 1),
                1,
                new Insets(40, 50, 50, 50),
                GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL
        );
        Constrains.addCompX(
                producto,
                getLienzo(),
                new Rectangle(0, 1, 1, 1),
                1,
                new Insets(40, 30, 50, 30),
                GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL
        );
    }
    /**
     * Acción caso terminal
     */
    protected abstract void casoTerminal();
    /**
     * Acción caso a decrementar
     */
    protected abstract void casoDecrementativo();
    /**
     * Acción caso a incrementar
     */
    protected abstract void casoIncrementativo();
    /**
     * Acción del caso base
     * @param found si fue encontrado se termina con la ejecución de la simulación
     */
    protected abstract void casoBase(boolean found);
    /**
     * Líneas que se van a simular
     * <ul>
     *     <li>0 - acciones caso Terminal</li>
     *     <li>1 - acciones caso Incrementativo</li>
     *     <li>2 - acciones caso Decrementativo</li>
     *     <li>3 > - acciones caso Base</li>
     * </ul>
     * @return arreglo de las líneas que se van a simular
     */
    protected abstract Lines[] lines();
    /**
     * Define el caso base que se va a utilizar en el simulador
     * @return caso base
     */
    protected abstract boolean isCasoBase();
    /**
     * acciones a realizar en el caso base del simulador
     * @param code define si se va a utilizar la simulación paso a paso con código o no
     */
    protected abstract void accionesCasoBase(boolean code);
    /**
     * acciones a realizar en el caso terminal del simulador
     * @param code define si se va a utilizar la simulación paso a paso con código o no
     */
    protected void accionesCasoTerminal(boolean code){
        if (code) lines()[0].start();
        else casoTerminal();
    }
    /**
     * acciones a realizar en el caso incrementativo del simulador
     * @param code define si se va a utilizar la simulación paso a paso con código o no
     */
    protected void accionesCasoIncrementativo(boolean code){
        if (code) lines()[1].start();
        else casoIncrementativo();
    }
    /**
     * acciones a realizar en el caso decrementativo del simulador
     * @param code define si se va a utilizar la simulación paso a paso con código o no
     */
    protected void accionesCasoDecrementativo(boolean code){
        if (code) lines()[2].start();
        else casoDecrementativo();
    }
    @Override
    protected void acomodamientoPanelControl(String title, JComponent... components) {
        Constrains.addCompX(
                componentRegistro(title, components),
                getControl(),
                new Rectangle(2, 0, 1, 1),
                1,
                new Insets(10, 80, 5, 5),
                GridBagConstraints.EAST,
                GridBagConstraints.BOTH
        );
        Constrains.addCompX(
                getSend(),
                getControl(),
                new Rectangle(3, 0, 1, 1),
                1,
                new Insets(10, 5, 5, 5),
                GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL
        );
        Constrains.addCompX(
                getPause(),
                getControl(),
                new Rectangle(4, 0, 1, 1),
                1,
                new Insets(10, 5, 5, 100),
                GridBagConstraints.WEST,
                GridBagConstraints.NONE
        );
        Constrains.addCompX(
                getCodigo(),
                getControl(),
                new Rectangle(4, 1, 1, 1),
                1,
                new Insets(5, 8, 10, 100),
                GridBagConstraints.WEST,
                GridBagConstraints.NONE
        );
        Constrains.addCompX(
                getNextIteracion(),
                getControl(),
                new Rectangle(3, 1, 1, 1),
                1,
                new Insets(5, 5, 10, 5),
                GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL
        );
        Constrains.addCompX(
                getClean(),
                getControl(),
                new Rectangle(2, 1, 1, 1),
                1,
                new Insets(5, 80, 10, 5),
                GridBagConstraints.WEST,
                GridBagConstraints.HORIZONTAL
        );
    }
    @Override
    public void iteracion1() {
        Eventos.enable(
                false,
                getClean(),
                getNextIteracion(),
                getSend(),
                getPause(),
                getBack(),
                getCodigo(),
                getHome()
        );
        if (isCasoBase()) {
            if (getCodigo().isOnOff()) accionesCasoBase(true);
            else accionesCasoBase(false);
        } else if (getIteracion() == 0 && !isDecremento()) {
            if (getCodigo().isOnOff()) accionesCasoTerminal(true);
            else accionesCasoTerminal(false);
        } else if (!isDecremento()) {
            if (getCodigo().isOnOff()) accionesCasoIncrementativo(true);
            else accionesCasoIncrementativo(false);
        } else {
            if (getCodigo().isOnOff()) accionesCasoDecrementativo(true);
            else accionesCasoDecrementativo(false);
        }
    }
    @Override
    public void cleanComponents() {
        super.cleanComponents();
        setDecremento(true);
    }
}