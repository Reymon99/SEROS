package gui.simulador;
import eventos.Eventos;
import gui.contenido.Tree;
import gui.editor.Editor;
import hilos.LineLocation;
import hilos.Lines;
import tools.Colour;
import tools.Constrains;
import tools.Fuentes;
import tools.Paneles;
import tools.Text;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Factorial extends Simulador {
    private Editor code;
    private Tree variaI;
    private JSpinner valorI;
    private JLabel number;
    private JLabel producto;
    private Lines lines;
    private boolean decremento;
    private final String patron = "#,###,###";
    /**
     * Simulador para el ejercicio Fibonacci de la tematica recursividad
     * @see Simulador
     */
    public Factorial() {
        super();
        decremento=true;
        lines=null;
        getBack().setToolTipText("Panel de Ejercicios de Recursividad");
        getTexto().setText(Text.FACTORIAL.toString());
        addCodes(code=Editor.editor("/recourses/codes/recursividad/Factorial.seros"),"Fibonacci");
        setDatos(variaI=new Tree(new Dato("int","n","")));
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
                Eventos.show(Paneles.EJERCICIOS_RECURSIVIDAD);
            }
        });
        getNext().addActionListener(e -> iteracion1());
        Constrains.addCompX(number, (Container) getComponent(),new Rectangle(0,0,1,1),1,new Insets(40,50,50,50), GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(producto,(Container) getComponent(),new Rectangle(0,1,1,1),1,new Insets(40,30,50,30),GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(valorI,getPanel(),new Rectangle(2,0,1,1),1,new Insets(10,80,5,5), GridBagConstraints.EAST,GridBagConstraints.BOTH);
        Constrains.addCompX(getSend(),getPanel(),new Rectangle(3,0,1,1),1,new Insets(10,5,5,5),GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(getPause(),getPanel(),new Rectangle(4,0,1,1),1,new Insets(10,5,5,100),GridBagConstraints.WEST,GridBagConstraints.NONE);
        Constrains.addCompX(getCodigo(),getPanel(),new Rectangle(4,1,1,1),1,new Insets(5,8,10,100),GridBagConstraints.WEST,GridBagConstraints.NONE);
        Constrains.addCompX(getNext(),getPanel(),new Rectangle(3,1,1,1),1,new Insets(5,5,10,5),GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(getClean(),getPanel(),new Rectangle(2,1,1,1),1,new Insets(5,80,10,5),GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL);
    }
    @Override
    protected void iteracion0() {
        Eventos.enable(false,getNext(),getSend(),valorI,getPause(),getBack(),getClean(),getCodigo());
        getTexto().setText(Text.FACTORIAL1.toString());
        number.setText(Eventos.formatNumber(fac(Integer.parseInt(valorI.getValue().toString())),patron));
        producto.setText(valorI.getValue().toString()+"!    =    "+producto(Integer.parseInt(valorI.getValue().toString())));
        Eventos.variable(variaI,-1,valorI.getValue());
        Eventos.enable(true,getClean());
    }
    @Override
    protected void iteracion1() {
        Eventos.enable(false,valorI,getClean(),getNext(),getSend(),getPause(),getBack(),getCodigo());
        int valor=Integer.parseInt(valorI.getValue().toString())-getIteraccion();
        System.out.println(valor);
        Eventos.variable(variaI,-1,valor);
        if (Eventos.contains(valor,0,1)) {
            LineLocation[] lineLocations = !getCodigo().isOnOff() ? null : new LineLocation[]{new LineLocation(0,1,null),new LineLocation(0,2,Text.FACTORIAL3.toString()),new LineLocation(0,3,Text.FACTORIAL4.toString())};
            if (Eventos.contains(Integer.parseInt(valorI.getValue().toString()),0,1)) {//caso terminal
                if (getCodigo().isOnOff()) {
                    new Lines(this,lineLocations) {
                        @Override
                        public void actions() {
                            casoBaseTerminal(valor);
                        }
                    };
                }
                else casoBaseTerminal(valor);
            } else {
                if (getCodigo().isOnOff()) {
                    if (lines!=null && lines.isAlive()) lines.detener();
                    lines=new Lines(this,lineLocations){
                        @Override
                        public void actions() {
                            casoBase(valor,false);
                        }
                    };
                    lines.start();
                }
                else casoBase(valor,true);
            }
        } else if (getIteraccion()==0 && !decremento){
            if (getCodigo().isOnOff()) {
                if (lines!=null && lines.isAlive()) lines.detener();
                lines=new Lines(this,new LineLocation(0,5,Text.FACTORIAL6.toString())){
                    @Override
                    public void actions() {
                        casoTerminal(valor);
                    }
                };
                lines.start();
            } else casoTerminal(valor);
        } else if (!decremento){
            if (getCodigo().isOnOff()) {
                if (lines!=null && lines.isAlive()) lines.detener();
                lines=new Lines(this,new LineLocation(0,5,Text.FACTORIAL7.toString(),false)){
                    @Override
                    public void actions() {
                        casoIncrementativo(valor,false);
                    }
                };
                lines.start();
            } else casoIncrementativo(valor,true);
        } else {
            if (getCodigo().isOnOff()) {
                if (lines!=null && lines.isAlive()) lines.detener();
                lines=new Lines(this,new LineLocation(0,1,null),new LineLocation(0,2,Text.FACTORIAL3.toString()),new LineLocation(0,4,Text.FACTORIAL2.toString()),new LineLocation(0,5,null,false)){
                    @Override
                    public void actions() {
                        casoDecrementativo(valor);
                    }
                };
                lines.start();
            } else casoDecrementativo(valor);
        }
    }
    @Override
    protected void clean() {
        getTexto().setText(Text.FACTORIAL.toString());
        Eventos.variable(variaI,-1,"");
        Eventos.enable(true,getSend(),valorI,getPause(),getBack(),getCodigo());
        Eventos.enable(false,getClean(),getNext());
        getPause().setOnOff(false);
        valorI.setValue(0);
        setIteraccion(0);
        Eventos.scroll(code,0);
        code.setLine(false);
        number.setText("0");
        producto.setText("n!    =    ");
        decremento=true;
    }
    /**
     * Genera el factorial de n
     * @param i número a dar el factorial
     * @return factorial de n
     */
    private long fac(int i){
        return (i==0 || i==1) ? 1 : i*fac(i-1);
    }
    /**
     * Genera la multiplicación de un factorial n
     * @param i número a generar la multiplicación del factorial
     * @return multiplicación recursiva del factorial n
     */
    private String producto(int i){
        return (i==0 || i==1) ? "1" : i+" * "+producto(i-1);
    }
    /**
     * Genera la multiplicación de un número n hasta el establecido
     * @param i valor inicial
     * @param valor valor final
     * @return multiplicación recursiva de un valor inicial al valor final
     */
    private String producto(int i,int valor){
        return i==valor ? String.valueOf(valor) : i+" * "+producto(i-1,valor);
    }
    /**
     * Genera la multiplicación de un número n hasta el factorial del valor limite
     * @param i valor inicial
     * @param fac valor a dar factorial
     * @return multiplicación recursiva de un valor inicial al factorial del valor final
     */
    private String productofac(int i,int fac){
        return i==fac ? Eventos.formatNumber(fac(fac),patron) : i+" * "+productofac(i-1,fac);
    }
    /**
     * Cancatena el factorial n con su producto
     * @param producto producto del factorial n
     * @return factorial con su respectivo producto
     */
    private String mulFac(String producto){
        return valorI.getValue().toString()+"!    =    "+producto;
    }
    /**
     * Acción del caso base terminal
     * @param valor valor n a trabajar
     */
    private void casoBaseTerminal(int valor){
        getTexto().setText(Text.FACTORIAL1.toString());
        number.setText(String.valueOf(fac(valor)));
        producto.setText(mulFac(producto(valor)));
        Eventos.enable(true, getClean());
    }
    /**
     * Acción del caso base para decrementar la iteracción
     * @param valor valor n a trabajar
     * @param found texto a mostrar
     */
    private void casoBase(int valor,boolean found){
        getTexto().setText(found ? Text.FACTORIAL4.toString() : Text.FACTORIAL5.toString());
        number.setText(String.valueOf(fac(valor)));
        producto.setText(mulFac(producto(valor+getIteraccion())));
        decrementoIteraccion();
        decremento=false;
        Eventos.enable(true, getNext());
    }
    /**
     * Acción caso terminal
     * @param valor valor n a trabajar
     */
    private void casoTerminal(int valor){
        getTexto().setText(Text.FACTORIAL1.toString());
        number.setText(Eventos.formatNumber(fac(valor),patron));
        producto.setText(mulFac(productofac(Integer.parseInt(valorI.getValue().toString()),valor)));
        Eventos.enable(true,getClean());
    }
    /**
     * Acción caso a incrementar
     * @param valor valor n a trabajar
     * @param mult texto a mostrar
     */
    private void casoIncrementativo(int valor,boolean mult){
        if (mult) getTexto().setText(Text.FACTORIAL7.toString());
        number.setText(Eventos.formatNumber(fac(valor),patron));
        producto.setText(mulFac(productofac(Integer.parseInt(valorI.getValue().toString()),valor)));
        decrementoIteraccion();
        Eventos.enable(true,getNext());
    }
    /**
     * Acción caso a decrementar
     * @param valor valor n a trabajar
     */
    private void casoDecrementativo(int valor){
        number.setText("0");
        producto.setText(mulFac(producto(Integer.parseInt(valorI.getValue().toString()),valor)));
        incrementIteraccion();
        Eventos.enable(true,getNext());
    }
}