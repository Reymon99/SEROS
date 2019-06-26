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
import java.text.DecimalFormat;

import static tools.Text.*;
public class Factorial extends Simulador {
    private Editor code;
    private Tree variaI;
    private DecimalFormat format;
    private JSpinner valorI;
    private JLabel number;
    private JLabel sucesion;
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
        number=new JLabel(format.format(fac(10)),SwingConstants.CENTER);
        number.setFont(Fuentes.UBUNTULIGHTB120.getFont());
        getComponent().setBackground(Colour.BLANCO.getColor());
        sucesion=new JLabel("10 * (9 * (8* (7 * (6 * (5 * (4 * (3 * (2 * (1)))))))))",SwingConstants.CENTER);
        sucesion.setFont(Fuentes.UBUNTULIGHT40.getFont());
        getBack().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clean();
            }
        });
        Constrains.addCompX(number, (Container) getComponent(),0,0,1,1,1,40,50,50,50, GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(sucesion,(Container) getComponent(),0,1,1,1,1,40,30,50,30,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(valorI,getPanel(),1,0,2,1,1,3,80,5,5, GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(send,getPanel(),3,0,2,1,1,10,5,5,100,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(pause,getPanel(),1,1,1,1,1,5,35,10,8,GridBagConstraints.EAST,GridBagConstraints.NONE);
        Constrains.addCompX(next,getPanel(),2,1,2,1,1,5,8,10,8,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(clean,getPanel(),4,1,1,1,1,5,5,10,100,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL);
    }
    @Override
    protected void iteracion0() {
        getTexto().setText(FACTORIAL1.toString());
        number.setText(format.format(fac(Integer.parseInt(valorI.getValue().toString()))));
        Eventos.variable(variaI,-1,valorI.getValue());
        Eventos.enable(true,clean);
        Eventos.enable(false,next,send,valorI,pause,getBack());
    }
    @Override
    protected void iteracion1() {

    }
    @Override
    protected void clean() {
        getTexto().setText(FACTORIAL.toString());
        Eventos.variable(variaI,-1,"");
    }
    private long fac(int i){
        return (i==0 || i==1) ? 1 : i*fac(i-1);
    }
}