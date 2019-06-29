package gui.simulador;
import eventos.Eventos;
import gui.contenido.Tree;
import gui.editor.Editor;
import tools.Colour;
import tools.Constrains;
import tools.Fuentes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static tools.Text.*;
public class Factorial extends Simulador {
    private Editor code;
    private Tree variaI;
    private JSpinner valorI;
    private JLabel number;
    private JLabel producto;
    /**
     * Simulador para el ejercicio Fibonacci de la tematica recursividad
     * @see Simulador
     */
    public Factorial() {
        super();
        getTexto().setText(FACTORIAL.toString());
        addCodes(code=Editor.editor("/recourses/codes/recursividad/factorial.seros"),"Fibonacci");
        setDatos(variaI=new Tree(new Dato("int","i","")));
        valorI=new JSpinner(new SpinnerNumberModel(0,0,10,1));
        ((JSpinner.NumberEditor)valorI.getEditor()).getTextField().setEditable(false);
        number=new JLabel("0",SwingConstants.CENTER);
        number.setFont(Fuentes.UBUNTULIGHTB120.getFont());
        getComponent().setBackground(Colour.BLANCO.getColor());
        producto=new JLabel("n!    =    ",SwingConstants.CENTER);
        producto.setFont(Fuentes.UBUNTULIGHT40.getFont());
        getBack().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clean();
            }
        });
        Constrains.addCompX(number, (Container) getComponent(),0,0,1,1,1,40,50,50,50, GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(producto,(Container) getComponent(),0,1,1,1,1,40,30,50,30,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(valorI,getPanel(),1,0,2,1,1,8,80,5,5, GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(getSend(),getPanel(),3,0,2,1,1,10,5,5,100,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(getPause(),getPanel(),1,1,1,1,1,5,35,10,8,GridBagConstraints.EAST,GridBagConstraints.NONE);
        Constrains.addCompX(getNext(),getPanel(),2,1,2,1,1,5,8,10,8,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(getClean(),getPanel(),4,1,1,1,1,5,5,10,100,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL);
    }
    @Override
    protected void iteracion0() {
        getTexto().setText(FACTORIAL1.toString());
        number.setText(Eventos.formatNumber(fac(Integer.parseInt(valorI.getValue().toString())),"#,###,###"));
        producto.setText(valorI.getValue().toString()+"!    =    "+producto(Integer.parseInt(valorI.getValue().toString())));
        Eventos.variable(variaI,-1,valorI.getValue());
        Eventos.enable(true,getClean());
        Eventos.enable(false,getNext(),getSend(),valorI,getPause(),getBack());
    }
    @Override
    protected void iteracion1() {
        if (Integer.parseInt(valorI.getValue().toString())==0 || Integer.parseInt(valorI.getValue().toString())==1) casoBase();
        else casoRecursivo();
    }
    @Override
    protected void clean() {
        getTexto().setText(FACTORIAL.toString());
        Eventos.variable(variaI,-1,"");
        Eventos.enable(true,getSend(),valorI,getPause(),getBack());
        Eventos.enable(false,getClean(),getNext());
        getPause().setOnOff(false);
        valorI.setValue(0);
        setInteraccion(0);
        Eventos.scroll(code,0);
        code.setLine(false);
        number.setText("0");
        producto.setText("n!    =    ");
    }
    /**
     * Genera el factorial de n
     * @param i número a dar el factorial
     * @return factorial de n
     */
    public long fac(int i){
        return (i==0 || i==1) ? 1 : i*fac(i-1);
    }
    /**
     * Genera la multiplicación de un factorial n
     * @param i número a generar la multiplicación del factorial
     * @return multiplicación del factorial n
     */
    public String producto(int i){
        return (i==0 || i==1) ? "1" : i+" * "+producto(i-1);
    }
    /**
     * Ejecución del paso a paso en el caso de un valor llevado directamente al caso base el factorial
     */
    private void casoBase(){
        Eventos.enable(false, getNext(), valorI, getBack(), getPause(), getSend());
        Eventos.enable(true, getClean());
        getTexto().setText(FACTORIAL2.toString());
        new hilos.Factorial(this,hilos.Factorial.CASO_BASE).start();
    }
    /**
     * Ejecución del paso a paso en el caso de un valor que requiera iniciar en el caso recursivo
     */
    private void casoRecursivo(){
        Eventos.enable(false, getClean(), valorI,getBack(),getPause(),getSend(),getClean());
        Eventos.enable(true,getNext());
        new hilos.Factorial(this,hilos.Factorial.CASO_RECURSIVO,true);
    }
    /**
     * Obtiene le código utilizado en el simulador
     * @return código de factorial
     */
    public Editor getCode() {
        return code;
    }
    /**
     * Árbol de variables del factorial
     * @return variable ingresada
     */
    public Tree getVariaI() {
        return variaI;
    }
    /**
     * Datos posibles a efectuar al factorial
     * @return datos entre 0 y 10
     */
    public JSpinner getValorI() {
        return valorI;
    }
    /**
     * Obtiene la etiqueta del resultado del factorial
     * @return resultado del factorial
     */
    public JLabel getNumber() {
        return number;
    }
    /**
     * Obtiene la etiqueta del resultado del producto del factorial
     * @return producto del factorial
     */
    public JLabel getProducto() {
        return producto;
    }
}