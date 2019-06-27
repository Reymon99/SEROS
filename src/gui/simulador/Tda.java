package gui.simulador;
import eventos.Eventos;
import gui.contenido.Tree;
import gui.editor.Editor;
import gui.simulador.liezos.Graficador;
import tools.Constrains;
import tools.Paneles;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static tools.Text.*;
public class Tda extends Simulador {
    private Editor code;
    private Tree punto;
    private JSpinner x;
    private JSpinner y;
    /**
     * Simulador para la tematica TDA<br>
     * Simula un punto en el eje cartesiano
     * @see Graficador
     * @see Simulador
     * @author Sergio Majé
     */
    public Tda() {
        super(new Graficador());
        getTexto().setText(SIMULADORTDA2.toString());
        addCodes(code=Editor.editor("/recourses/codes/tda/Punto.seros"),"Punto");
        punto=new Tree(new JTree.DynamicUtilTreeNode(new Dato("Punto","punto","",true),new Dato[]{new Dato("int","x",""),new Dato("int","y","")}));
        punto.expandNode(0);
        setDatos(punto);
        getSend().setText("Graficar");
        x=new JSpinner(new SpinnerNumberModel(0,-10,10,1));
        y=new JSpinner(new SpinnerNumberModel(0,-10,10,1));
        ((JSpinner.NumberEditor)x.getEditor()).getTextField().setEditable(false);
        ((JSpinner.NumberEditor)y.getEditor()).getTextField().setEditable(false);
        Box box=Box.createHorizontalBox();
        box.add(x);
        box.add(Box.createHorizontalStrut(1));
        box.add(y);
        box.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(),"(x,y)"));
        getBack().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.TDA);
                clean();
            }
        });
        Constrains.addCompX(box,getPanel(),1,0,2,1,1,3,80,5,5, GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(getSend(),getPanel(),3,0,2,1,1,10,5,5,100,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(getPause(),getPanel(),1,1,1,1,1,5,35,10,8,GridBagConstraints.EAST,GridBagConstraints.NONE);
        Constrains.addCompX(getNext(),getPanel(),2,1,2,1,1,5,8,10,8,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(getClean(),getPanel(),4,1,1,1,1,5,5,10,100,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL);
    }
    @Override
    protected void iteracion0() {
        ((Graficador)getComponent()).graficar(Integer.parseInt(x.getValue().toString()),Integer.parseInt(y.getValue().toString()));
        Eventos.enable(true,getClean());
        Eventos.enable(false,getNext(),getSend(),x,y,getPause(),getBack());
        getTexto().setText(SIMULADORTDA1.toString());
        Eventos.variable(punto,0,x.getValue());
        Eventos.variable(punto,1,y.getValue());
        punto.expandNode(0);
    }
    @Override
    protected void iteracion1() {
        Eventos.enable(true,getNext());
        Eventos.enable(false,getSend(),x,y,getPause(),getClean(),getBack());
        if (getInteraccion()==0) asignacionX();
        else if (getInteraccion()==1) asignacionY();
        else mostrarCoordenadas();
        setInteraccion(getInteraccion()+1);
    }
    @Override
    protected void clean() {
        ((Graficador)getComponent()).limpiar();
        Eventos.variable(punto,0,"");
        Eventos.variable(punto,1,"");
        Eventos.enable(true,getSend(),x,y,getPause(),getBack());
        Eventos.enable(false,getClean(),getNext());
        getTexto().setText(SIMULADORTDA2.toString());
        x.setValue(0);
        y.setValue(0);
        punto.expandNode(0);
        getPause().setOnOff(false);
        setInteraccion(0);
        Eventos.scroll(code,0);
        code.setLine(false);
    }
    /**
     * Muestra los datos y códigos que se asignan al eje x
     * @author Sergio Majé
     */
    private void asignacionX(){
        code.drawLineIn(4);
        Eventos.variable(punto,0,x.getValue());
        Eventos.scroll(code,0);
        getTexto().setText(SIMULADORTDA3.toString());
    }
    /**
     * Muestra los datos y códigos que se asignan al eje y
     * @author Sergio Majé
     */
    private void asignacionY(){
        code.drawLineIn(5);
        Eventos.variable(punto,1,y.getValue());
        Eventos.scroll(code,0);
        getTexto().setText(SIMULADORTDA4.toString());
    }
    /**
     * Grafica las coordenadas (x,y) muestra los códigos asignados a estos
     * @author Sergio Majé
     */
    private void mostrarCoordenadas(){
        Eventos.enable(true,getClean());
        Eventos.enable(false,getNext());
        Eventos.scroll(code,code.getVerticalScrollBar().getMaximum());
        code.drawLineIn(21);
        getTexto().setText(SIMULADORTDA1.toString());
        ((Graficador)getComponent()).graficar(Integer.parseInt(x.getValue().toString()),Integer.parseInt(y.getValue().toString()));
    }
}