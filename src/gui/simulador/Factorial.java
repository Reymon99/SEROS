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
     * @author Sergio Majé
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
    public long fac(int i){
        return (i==0 || i==1) ? 1 : i*fac(i-1);
    }
    public String producto(int i){
        return (i==0 || i==1) ? "1" : i+" * "+producto(i-1);
    }
    private void casoBase(){
        Eventos.enable(false, getNext(), valorI, getBack(), getPause(), getSend());
        Eventos.enable(true, getClean());
        new hilos.Factorial(this,hilos.Factorial.CASO_BASE).start();
    }
    public Editor getCode() {
        return code;
    }
    public Tree getVariaI() {
        return variaI;
    }
    public JSpinner getValorI() {
        return valorI;
    }
    public JLabel getNumber() {
        return number;
    }
    public JLabel getProducto() {
        return producto;
    }
}