package gui.simulador;
import eventos.Eventos;
import gui.contenido.ButtonSimulador;
import gui.contenido.Switch;
import gui.contenido.Tree;
import gui.editor.Editor;
import gui.simulador.liezos.Graficador;
import tools.Constrains;
import tools.Paneles;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static tools.Text.*;
public class Tda extends Simulador {
    private int interaccion;
    private Editor code;
    private Tree punto;
    private JSpinner x;
    private JSpinner y;
    private Switch pause;
    private ButtonSimulador send;
    private ButtonSimulador clean;
    private ButtonSimulador next;
    /**
     * Simulador para la tematica TDA<br>
     * Simula un punto en el eje cartesiano
     * @param canvas {@link Graficador} en el que se verá reflejado el plano cartesiano
     * @author Sergio Majé
     */
    public Tda(Graficador canvas) {
        super(canvas);
        interaccion=0;
        getTexto().setText(SIMULADORTDA2.toString());
        addCodes(code=Editor.editor("/recourses/codes/tda/Punto.seros"),"Punto");
        punto=new Tree(new JTree.DynamicUtilTreeNode(new Dato("Punto","punto","",true),new Dato[]{new Dato("int","x",""),new Dato("int","y","")}));
        punto.expandNode(0);
        setDatos(punto);
        send=new ButtonSimulador("Graficar",true);
        clean=new ButtonSimulador("Limpiar",false);
        next=new ButtonSimulador("Siguiente",false);
        x=new JSpinner(new SpinnerNumberModel(0,-10,10,1));
        y=new JSpinner(new SpinnerNumberModel(0,-10,10,1));
        ((JSpinner.NumberEditor)x.getEditor()).getTextField().setEditable(false);
        ((JSpinner.NumberEditor)y.getEditor()).getTextField().setEditable(false);
        pause=new Switch("Paso a Paso",false);
        Box box=Box.createHorizontalBox();
        box.add(x);
        box.add(Box.createHorizontalStrut(1));
        box.add(y);
        box.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(),"(x,y)"));
        clean.addActionListener(e -> clean());
        send.addActionListener(e -> {
            if (pause.isOnOff()) iteracion1();
            else iteracion0();
        });
        next.addActionListener(e -> iteracion1());
        getBack().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.TDA);
                clean();
            }
        });
        Constrains.addCompX(box,getPanel(),1,0,2,1,1,3,80,5,5, GridBagConstraints.EAST,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(send,getPanel(),3,0,2,1,1,10,5,5,100,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(pause,getPanel(),1,1,1,1,1,5,35,10,8,GridBagConstraints.EAST,GridBagConstraints.NONE);
        Constrains.addCompX(next,getPanel(),2,1,2,1,1,5,8,10,8,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(clean,getPanel(),4,1,1,1,1,5,5,10,100,GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL);
    }
    @Override
    protected void iteracion0() {
        ((Graficador)getCanvas()).graficar(Integer.parseInt(x.getValue().toString()),Integer.parseInt(y.getValue().toString()));
        Eventos.enable(true,clean);
        Eventos.enable(false,next,send,x,y,pause,getBack());
        getTexto().setText(SIMULADORTDA1.toString());
        Eventos.variable(punto,0,x.getValue());
        Eventos.variable(punto,1,y.getValue());
        punto.expandNode(0);
    }
    @Override
    protected void iteracion1() {
        Eventos.enable(true,next);
        Eventos.enable(false,send,x,y,pause,clean,getBack());
        if (interaccion==0) asignacionX();
        else if (interaccion==1) asignacionY();
        else mostrarCoordenadas();
        interaccion++;
    }
    @Override
    protected void clean() {
        ((Graficador)getCanvas()).limpiar();
        Eventos.variable(punto,0,"");
        Eventos.variable(punto,1,"");
        Eventos.enable(true,send,x,y,pause,getBack());
        Eventos.enable(false,clean,next);
        getTexto().setText(SIMULADORTDA2.toString());
        x.setValue(0);
        y.setValue(0);
        punto.expandNode(0);
        pause.setOnOff(false);
        interaccion=0;
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
        Eventos.enable(true,clean);
        Eventos.enable(false,next);
        Eventos.scroll(code,code.getVerticalScrollBar().getMaximum());
        code.drawLineIn(21);
        getTexto().setText(SIMULADORTDA1.toString());
        ((Graficador)getCanvas()).graficar(Integer.parseInt(x.getValue().toString()),Integer.parseInt(y.getValue().toString()));
    }
}