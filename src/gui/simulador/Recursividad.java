package gui.simulador;
import eventos.Eventos;
import hilos.Lines;
import tools.Acciones;
import tools.Constrains;
import tools.Fuentes;
import javax.swing.*;
import java.awt.*;
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
    }
    /**
     * Indica el decremento o incremento de la iteración
     * @return true: decremento | false: incremento
     */
    public boolean isDecremento() {
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
    public void setProducto(String producto) {
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
     * Acomodamiento por defecto cuando se utiliza productos
     */
    private void acomodamientoProducto(){
        Constrains.addCompX(number, (Container) getComponent(),new Rectangle(0,0,1,1),1,new Insets(40,50,50,50), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(producto,(Container) getComponent(),new Rectangle(0,1,1,1),1,new Insets(40,30,50,30),GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
    }
    /**
     * Camino paso a paso de la simulación para Recursividad
     */
    protected void iteracion(){
        //None
    }
    /**
     * Acción caso terminal
     * @param dato valor n a trabajar
     */
    protected abstract void casoTerminal(int dato);
    /**
     * Acción caso a decrementar
     * @param dato valor n a trabajar
     */
    protected abstract void casoDecrementativo(int dato);
    /**
     * Acción caso a incrementar
     * @param dato valor n a trabajar
     */
    protected abstract void casoIncrementativo(int dato);
    /**
     * Acción del caso base
     * @param dato valor n a trabajar
     * @param found si fue encontrado se termina con la ejecución de la simulación
     */
    protected abstract void casoBase(int dato, boolean found);
    /**
     * Líneas que se van a simular
     * @return arreglo de las líneas que se van a simular
     */
    protected abstract Lines[] lines();
    protected abstract boolean isCasoBase();
    protected abstract void accionesCasoBase();
    protected abstract void accionesCasoBaseCode();
    @Override
    protected void acomodamientoPanelControl(String title, JComponent... components) {
        Constrains.addCompX(componentRegistro(title, components),getPanel(),new Rectangle(2,0,1,1),1,new Insets(10,80,5,5), GridBagConstraints.EAST,GridBagConstraints.BOTH);
        Constrains.addCompX(getSend(),getPanel(),new Rectangle(3,0,1,1),1,new Insets(10,5,5,5),GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(getPause(),getPanel(),new Rectangle(4,0,1,1),1,new Insets(10,5,5,100),GridBagConstraints.WEST,GridBagConstraints.NONE);
        Constrains.addCompX(getCodigo(),getPanel(),new Rectangle(4,1,1,1),1,new Insets(5,8,10,100),GridBagConstraints.WEST,GridBagConstraints.NONE);
        Constrains.addCompX(getNextIteracion(),getPanel(),new Rectangle(3,1,1,1),1,new Insets(5,5,10,5),GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(getClean(),getPanel(),new Rectangle(2,1,1,1),1,new Insets(5,80,10,5),GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL);
    }
    @Override
    public void iteracion1() {
        Eventos.enable(false, getClean(),getNextIteracion(),getSend(),getPause(),getBack(),getCodigo(),getHome());
        if (isCasoBase()){
            if (getCodigo().isOnOff()) accionesCasoBaseCode();
            else accionesCasoBase();
        }
    }
}