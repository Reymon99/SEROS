package gui.simulador;
import gui.contenido.Switch;
import gui.contenido.Tree;
import gui.editor.Editor;

import javax.swing.*;
import java.text.DecimalFormat;

import static tools.Text.*;
public class Factorial extends Simulador {
    private Editor code;
    private Tree variaI;
    private DecimalFormat format;
    private JSpinner valorI;
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
        format=new DecimalFormat("#,###,###");
        valorI=new JSpinner(new SpinnerNumberModel(0,0,10,1));
        ((JSpinner.NumberEditor)valorI.getEditor()).getTextField().setEditable(false);

    }
    @Override
    protected void iteracion0() {

    }
    @Override
    protected void iteracion1() {

    }
    @Override
    protected void clean() {

    }
    private long fac(int i){
        return (i==0 || i==1) ? 1 : i*fac(i-1);
    }
}