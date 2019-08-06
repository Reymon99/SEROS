package gui.simulador;
import tools.Acciones;
import tools.Constrains;
import tools.Fuentes;
import javax.swing.*;
import java.awt.*;
public abstract class Recursividad extends Simulador implements Acciones {
    private boolean decremento;
    private JLabel number;
    private JLabel producto;
    private JComponent componentRegistro;
    {
        componentRegistro = new JLabel("Overwrite");
    }
    public Recursividad(){
        super();
        decremento = true;
        number = new JLabel("0", SwingConstants.CENTER);
        producto = new JLabel("", SwingConstants.CENTER);
        number.setFont(Fuentes.UBUNTULIGHTB118.getFont());
        producto.setFont(Fuentes.UBUNTULIGHT40.getFont());
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
    public void setDecremento(boolean decremento) {
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
    public void setNumber(String number) {
        this.number.setText(number);
    }
    /**
     * Componentes de registro de datos
     * @param title título del borde
     * @param components {@link JComponent}s de registro
     */
    public void setComponentRegistro(String title, JComponent... components){
        Box box = Box.createHorizontalBox();
        for (JComponent component : components) {
            box.add(component);
            if (component != components[components.length-1]) box.add(Box.createHorizontalStrut(1));
        }
        box.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(),title));
        componentRegistro = box;
        componentRegistro.updateUI();
        getPanel().updateUI();
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
    protected abstract void casoTerminal(int dato);
    protected abstract void casoDecrementativo(int dato);
    protected abstract void casoIncrementativo(int dato);
    protected abstract void casoBase(int dato, boolean found);
    @Override
    protected void acomodamientoPanelControl() {
        Constrains.addCompX(componentRegistro,getPanel(),new Rectangle(2,0,1,1),1,new Insets(10,80,5,5), GridBagConstraints.EAST,GridBagConstraints.BOTH);
        Constrains.addCompX(getSend(),getPanel(),new Rectangle(3,0,1,1),1,new Insets(10,5,5,5),GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(getPause(),getPanel(),new Rectangle(4,0,1,1),1,new Insets(10,5,5,100),GridBagConstraints.WEST,GridBagConstraints.NONE);
        Constrains.addCompX(getCodigo(),getPanel(),new Rectangle(4,1,1,1),1,new Insets(5,8,10,100),GridBagConstraints.WEST,GridBagConstraints.NONE);
        Constrains.addCompX(getNextIteracion(),getPanel(),new Rectangle(3,1,1,1),1,new Insets(5,5,10,5),GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(getClean(),getPanel(),new Rectangle(2,1,1,1),1,new Insets(5,80,10,5),GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL);
    }
}