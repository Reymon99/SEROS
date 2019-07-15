package gui.principal;
import eventos.Eventos;
import gui.contenido.Boton;
import gui.contenido.Contenido;
import gui.contenido.Ejercicios;
import gui.contenido.Lienzo;
import gui.contenido.Texto;
import gui.contenido.TextPane;
import gui.contenido.Tree;
import gui.editor.Editor;
import gui.simulador.Dato;
import gui.simulador.Simulador;
import gui.simulador.liezos.Graficador;
import hilos.LineLocation;
import hilos.Lines;
import tools.Acciones;
import tools.Archivos;
import tools.Constrains;
import tools.Fuentes;
import tools.Operaciones;
import tools.Paneles;
import tools.Text;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.atomic.AtomicReferenceArray;
final class Contenedor extends JPanel {
    /**
     * Contenedor de los paneles del proyecto
     */
    Contenedor() {
        setLayout(new CardLayout());
        init();
        Eventos.setPanel(this);
    }
    /**
     * Se añaden los paneles secundarios al principal<br>
     * Se agrega el evento para circular entre los paneles
     * @see Eventos#setPanel(JPanel)
     * @see tools.Paneles
     */
    private void init() {
        add(Paneles.POTENCIA.toString(), potencia());
        add(Paneles.PRINCIPAL.toString(), principal());
        add(Paneles.TDA.toString(), tda());
        add(Paneles.SIMULADORTDA.toString(), simuladorTda());
        add(Paneles.MODULARIDAD.toString(), modularidad());
        add(Paneles.RECURSIVIDAD.toString(), recursividad());
        add(Paneles.FACTORIAL.toString(), factorial());

        add(Paneles.EJERCICIOS_RECURSIVIDAD.toString(), ejerciciosRecursividad());
        add(Paneles.ARREGLOS.toString(), arreglos());
        add(Paneles.NODOS.toString(), nodos());
        add(Paneles.ORDENAMIENTO.toString(), ordenamiento());
        add(Paneles.BUSQUEDA.toString(), busqueda());
        add(Paneles.PILAS.toString(), pilas());
        add(Paneles.COLAS.toString(), colas());
        add(Paneles.LISTAS_ENLAZADAS.toString(), listas());
        add(Paneles.ARBOLES.toString(), arboles());
        add(Paneles.GRAFOS.toString(), grafos());
    }
    /**
     * Menu principal de la interfaz grafica del proyecto
     * @return panel principal de SEROS
     */
    private Lienzo principal(){
        Lienzo lienzo=new Lienzo(new GridBagLayout(),true);
        Constrains.addCompY(new Boton("TDA","Tipos de Datos Abstratos", Archivos.image("/recourses/image/TDA.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.TDA);
            }
        }),lienzo,new Rectangle(0,0,1,4),0,new Insets(30,57,30,18),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Modularidad","Complejidad Algoritmica", Archivos.image("/recourses/image/Modularidad y Mapas.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.MODULARIDAD);
            }
        }), lienzo,new Rectangle(1,0,1,1),0,new Insets(30,18,0,18),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Recursividad","Metodos Recursivos", Archivos.image("/recourses/image/Recursividad.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.RECURSIVIDAD);
            }
        }),lienzo,new Rectangle(1,1,1,1),0,new Insets(13,18,13,18),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Arreglos", "Vectores y Matrices", Archivos.image("/recourses/image/Arreglos y Arboles.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.ARREGLOS);
            }
        }),lienzo,new Rectangle(1,2,1,1),0,new Insets(13,18,13,18),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Nodos","Enlazamiento de Datos", Archivos.image("/recourses/image/Nodos.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.NODOS);
            }
        }),lienzo,new Rectangle(1,3,1,1),0,new Insets(13,18,30,18),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Ordenamiento", "Metodos de Ordenamiento Interno", Archivos.image("/recourses/image/Ordenamiento.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.ORDENAMIENTO);
            }
        }),lienzo,new Rectangle(2,0,1,2),0,new Insets(30,18,13,18), GridBagConstraints.SOUTH, GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Busqueda","Metodos de Busqueda", Archivos.image("/recourses/image/Busqueda.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.BUSQUEDA);
            }
        }),lienzo,new Rectangle(2,2,1,2),0,new Insets(13,18,30,18),GridBagConstraints.NORTH,GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Pilas","Pilas Dinámicas y Estáticas", Archivos.image("/recourses/image/Pilas.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.PILAS);
            }
        }),lienzo,new Rectangle(3,0,1,2),0,new Insets(30,18,13,18),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Colas","Colas Dinámicas y Estáticas", Archivos.image("/recourses/image/Colas.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.COLAS);
            }
        }),lienzo,new Rectangle(3,1,1,2),0,new Insets(13,18,13,13),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Listas","Listas Enlazadas", Archivos.image("/recourses/image/Listas Enlazadas.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.LISTAS_ENLAZADAS);
            }
        }),lienzo,new Rectangle(3,2,1,2),0,new Insets(13,18,30,18),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Árboles","Árboles Binarios y AVL", Archivos.image("/recourses/image/Arreglos y Arboles.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.ARBOLES);
            }
        }),lienzo,new Rectangle(4,0,1,2),0,new Insets(30,18,13,75),GridBagConstraints.SOUTH,GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Grafos","Algoritmo del Camino más Corto", Archivos.image("/recourses/image/Grafos.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.GRAFOS);
            }
        }),lienzo,new Rectangle(4,2,1,2),0,new Insets(13,18,30,75),GridBagConstraints.NORTH,GridBagConstraints.NONE);
        Constrains.addComp(new Boton("Acerca de Seros", Archivos.image("/recourses/image/about.png",-1,-1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.about(lienzo);
            }
        }),lienzo,new Rectangle(6,3,1,1),0,0,new Insets(0,0,6,0),GridBagConstraints.SOUTHEAST,GridBagConstraints.NONE);
        return lienzo;
    }
    /**
     * Contenido del panel TDA
     * @see Contenido
     * @see Contenedor#simuladorTda()
     */
    private Contenido tda(){
        Contenido con=new Contenido();
        con.getTitle().setText("Tipos de Datos Abstratos (tda)");
        con.next("Simulador TDA",Paneles.SIMULADORTDA);
        JLabel formula=new JLabel(Text.FORMULATDA.toString(),SwingConstants.CENTER);
        formula.setFont(Fuentes.PURISA18.getFont());
        formula.setOpaque(false);
        Constrains.addComp(new Texto(Text.TDA.toString()), con.getContenido(), new Rectangle(0, 0, 1, 1), 1,1, new Insets(10, 25, 15, 12), GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);
        Constrains.addComp(Editor.editor("/recourses/codes/tda/Punto.seros"),con.getContenido(),new Rectangle(0,1,1,1), 0,0,new Insets(5,5,5,5),GridBagConstraints.CENTER, GridBagConstraints.NONE);
        Constrains.addComp(new Texto(Text.TDA1.toString()), con.getContenido(),new Rectangle(0,2,1,1),1,1,new Insets(10,25,3,12), GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new Texto(Text.TDA2.toString()), con.getContenido(),new Rectangle(0,3,1,1),1,1,new Insets(3,40,3,12), GridBagConstraints.NORTHEAST,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new Texto(Text.TDA3.toString()), con.getContenido(),new Rectangle(0,4,1,1), 1,1,new Insets(5,25,5,12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(formula, con.getContenido(),new Rectangle(0,5,1,1), 1,1,new Insets(10,25,5,25), GridBagConstraints.CENTER,GridBagConstraints.NONE);
        return con;
    }
    /**
     * Contenido del panel Modularidad
     * @see Contenido
     */
    private Contenido modularidad(){
        Contenido con =  new Contenido();
        con.getTitle().setText("Modularidad");
        con.next("",null);
        Constrains.addComp(new Texto(Text.MODULARIDAD.toString()),con.getContenido(),new Rectangle(0,0,1,1), 1,1,new Insets(10, 25, 15, 12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new Texto(Text.MODULARIDAD1.toString()),con.getContenido(),new Rectangle(0,1,1,1),1,1,new Insets(10, 25, 15, 12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        return con;
    }
    /**
     * Contenido del panel Pilas
     * @see Contenido
     */
    private Contenido pilas(){
        Contenido con = new Contenido();
        con.getTitle().setText("Pilas");
        con.next("",null);
        return con;
    }
    /**
     * Contenido del panel Recursividad
     * @see Contenido
     */
    private Contenido recursividad(){
        Contenido con= new Contenido();
        con.getTitle().setText("Recursividad");
        TextPane editor=new TextPane(false);
        String[] recur = Text.RECURSIVIDAD1.toString().split("\u279c");
        for (String n:recur){
            editor.append(n,Fuentes.PURISA22.getFont());
            if (!n.equals(recur[recur.length-1])) editor.append("\u279c",Fuentes.SEGOEUISYMBOL22.getFont());
        }
        con.next("Panel de Ejercicios de Recursividad",Paneles.EJERCICIOS_RECURSIVIDAD);
        Constrains.addComp(new Texto(Text.RECURSIVIDAD.toString()), con.getContenido(), new Rectangle(0,0,1,1), 1,1,new Insets(10, 25, 1, 12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(editor, con.getContenido(),new Rectangle(0,1,1,1), 0.2,1,new Insets(2,25,180,25), GridBagConstraints.NORTH,GridBagConstraints.NONE);
        return con;
    }
    /**
     * Contenido del panel Ordenamiento
     * @see Contenido
     */
    private Contenido ordenamiento(){
        Contenido con= new Contenido();
        con.getTitle().setText("Ordenamiento");
        con.next("",null);
        return con;
    }
    /**
     * Contenido del panel Nodos
     * @see Contenido
     */
    private Contenido nodos(){
        Contenido con = new Contenido();
        con.getTitle().setText("Nodos");
        con.next("",null);
        Constrains.addComp(new Texto(Text.NODOS.toString()),con.getContenido(),new Rectangle(0,0,1,1), 1,1,new Insets(10, 25, 15, 12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new Texto(Text.NODOS1.toString()),con.getContenido(),new Rectangle(0,2,1,1),1,1,new Insets(10, 25, 15, 12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new Texto(Text.NODOS2.toString()),con.getContenido(),new Rectangle(0,4,1,1), 1,1,new Insets(10, 25, 5, 12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        return con;
    }
    /**
     * Contenido del panel Listas
     * @see Contenido
     */
    private Contenido listas(){
        Contenido con=new Contenido();
        con.getTitle().setText("Listas Enlazadas");
        con.next("",null);
        return con;
    }
    /**
     * Contenido del panel Grafos
     * @see Contenido
     */
    private Contenido grafos(){
        Contenido con = new Contenido();
        con.getTitle().setText("Grafos");
        con.next("",null);
        return con;
    }
    /**
     * Contenido del panel Colas
     * @see Contenido
     */
    private Contenido colas(){
        Contenido con = new Contenido();
        con.getTitle().setText("Colas");
        con.next("",null);
        return con;
    }
    /**
     * Contenido del panel Busqueda
     * @see Contenido
     */
    private Contenido busqueda(){
        Contenido con = new Contenido();
        con.getTitle().setText("Busqueda");
        con.next("",null);
        return con;
    }
    /**
     * Contenido del panel Arreglos
     * @see Contenido
     */
    private Contenido arreglos(){
        Contenido con = new Contenido();
        con.getTitle().setText("Arreglos");
        con.next("",null);
        Constrains.addComp(new Texto(Text.ARREGLOS.toString()),con.getContenido(),new Rectangle(0,0,1,1),1,1,new Insets(10, 25, 15, 12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new Texto(Text.ARREGLOS1.toString()),con.getContenido(),new Rectangle(0,2,1,1),1,1,new Insets(10, 25, 15, 12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new Texto(Text.ARREGLOS2.toString()),con.getContenido(),new Rectangle(0,4,1,1),1,1,new Insets(10, 25, 5, 12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        return con;
    }
    /**
     * Contenido del panel Arboles
     * @see Contenido
     */
    private Contenido arboles(){
        Contenido con = new Contenido();
        con.getTitle().setText("Arboles");
        con.next("",null);
        return con;
    }
    /**
     * Ejercicios simulados de recursividad
     * @return panel de simuladores en recursividad
     * @see Ejercicios
     */
    private Ejercicios ejerciciosRecursividad(){
        Ejercicios ejercicios=new Ejercicios();
        ejercicios.back("Recursividad",Paneles.RECURSIVIDAD);
        MouseAdapter mouse=new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switch (((Boton) e.getSource()).getText()) {
                    case "Factorial" -> Eventos.show(Paneles.FACTORIAL);
                    case "Potencia" -> Eventos.show(Paneles.POTENCIA);
                    default -> throw new IllegalStateException("Unexpected value: " + ((Boton) e.getSource()).getText());
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                switch (((Boton) e.getSource()).getText()) {
                    case "Factorial" -> ejercicios.getTexto().setText("Simulador recursivo para factorial");
                    case "Potencia" -> ejercicios.getTexto().setText("Simulación recursiva para Potencia");
                    default -> throw new IllegalStateException("Unexpected value: " + ((Boton) e.getSource()).getText());
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                ejercicios.getTexto().setText("");
            }
        };
        ejercicios.setBotones(new Boton(Archivos.image("/recourses/image/factorial.png", -1, -1), "Factorial", mouse), new Boton(Archivos.image("/recourses/image/potencia.png", -1, -1), "Potencia", mouse));
        return ejercicios;
    }
    /**
     * Simulador para la temática TDA<br>
     * Simula un punto en el eje cartesiano
     * @return simulador de un punto en el plano cartesiano para TDA
     * @see Graficador
     * @see Simulador
     */
    private Simulador simuladorTda(){
        JSpinner x=new JSpinner(new SpinnerNumberModel(0,-10,10,1));
        JSpinner y=new JSpinner(new SpinnerNumberModel(0,-10,10,1));
        ((JSpinner.NumberEditor)x.getEditor()).getTextField().setEditable(false);
        ((JSpinner.NumberEditor)y.getEditor()).getTextField().setEditable(false);
        Tree punto=new Tree(new JTree.DynamicUtilTreeNode(new Dato("Punto","punto","",true), new Dato[]{new Dato("int","x",""),new Dato("int","y","")}));
        punto.expandNode(0);
        Simulador simulador=new Simulador(new Graficador());
        simulador.setAcciones(new Acciones() {
            @Override
            public void iteracion0() {
                ((Graficador)simulador.getComponent()).graficar(Integer.parseInt(x.getValue().toString()),Integer.parseInt(y.getValue().toString()));
                Eventos.enable(true,simulador.getClean());
                Eventos.enable(false,simulador.getNextIteracion(),simulador.getSend(),x,y,simulador.getPause(),simulador.getBack());
                simulador.setTexto(Text.SIMULADORTDA1.toString());
                Eventos.variable(punto,0,x.getValue());
                Eventos.variable(punto,1,y.getValue());
                punto.expandNode(0);
            }
            @Override
            public void iteracion1() {
                Eventos.enable(true,simulador.getNextIteracion());
                Eventos.enable(false,simulador.getSend(),x,y,simulador.getPause(),simulador.getClean(),simulador.getBack());
                if (simulador.getIteracion()==0) asignacionX();
                else if (simulador.getIteracion()==1) asignacionY();
                else mostrarCoordenadas();
                simulador.incrementIteracion();
            }
            @Override
            public void clean() {
                simulador.clean();
                ((Graficador)simulador.getComponent()).limpiar();
                Eventos.variable(punto,0,"");
                Eventos.variable(punto,1,"");
                Eventos.enable(true,x,y);
                simulador.setTexto(Text.SIMULADORTDA2.toString());
                x.setValue(0);
                y.setValue(0);
                punto.expandNode(0);
            }
            /**
             * Muestra los datos y códigos que se asignan al eje x
             */
            private void asignacionX(){
                ((Editor) simulador.getCodigos().getComponentAt(0)).drawLineIn(4);
                Eventos.variable(punto,0,x.getValue());
                Eventos.scroll((Editor) simulador.getCodigos().getComponentAt(0),0);
                simulador.setTexto(Text.SIMULADORTDA3.toString());
            }
            /**
             * Muestra los datos y códigos que se asignan al eje y
             */
            private void asignacionY(){
                ((Editor) simulador.getCodigos().getComponentAt(0)).drawLineIn(5);
                Eventos.variable(punto,1,y.getValue());
                Eventos.scroll((Editor) simulador.getCodigos().getComponentAt(0),0);
                simulador.setTexto(Text.SIMULADORTDA4.toString());
            }
            /**
             * Grafica las coordenadas (x,y) muestra los códigos asignados a estos
             */
            private void mostrarCoordenadas(){
                Eventos.enable(true,simulador.getClean());
                Eventos.enable(false,simulador.getNextIteracion());
                Eventos.scroll((Editor) simulador.getCodigos().getComponentAt(0),((Editor) simulador.getCodigos().getComponentAt(0)).getVerticalScrollBar().getMaximum());
                ((Editor) simulador.getCodigos().getComponentAt(0)).drawLineIn(21);
                simulador.setTexto(Text.SIMULADORTDA1.toString());
                ((Graficador)simulador.getComponent()).graficar(Integer.parseInt(x.getValue().toString()),Integer.parseInt(y.getValue().toString()));
            }
        });
        simulador.addCodes(Editor.editor("/recourses/codes/tda/Punto.seros"),"Punto");
        simulador.back("Tipos de Datos Abstratos",Paneles.TDA);
        simulador.getSend().setText("Graficar");
        simulador.setDatos(punto);
        Box box=Box.createHorizontalBox();
        box.add(x);
        box.add(Box.createHorizontalStrut(1));
        box.add(y);
        box.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(),"(x,y)"));
        Constrains.addCompX(box,simulador.getPanel(),new Rectangle(2,0,2,1),1,new Insets(3,80,5,5), GridBagConstraints.EAST,GridBagConstraints.BOTH);
        Constrains.addCompX(simulador.getSend(),simulador.getPanel(),new Rectangle(4,0,2,1),1,new Insets(10,5,5,100),GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(simulador.getPause(),simulador.getPanel(),new Rectangle(2,1,1,1),1,new Insets(5,35,10,8),GridBagConstraints.EAST,GridBagConstraints.NONE);
        Constrains.addCompX(simulador.getNextIteracion(),simulador.getPanel(),new Rectangle(3,1,2,1),1,new Insets(5,8,10,8),GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(simulador.getClean(),simulador.getPanel(),new Rectangle(5,1,1,1),1,new Insets(5,5,10,100),GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL);
        return simulador;
    }
    /**
     * Simulador para la temática Recursividad<br>
     * Simulador para el proceso recursivo del factorial
     * @return simulador factorial
     */
    private Simulador factorial(){
        Simulador simulador=new Simulador();
        Operaciones.setFormat("#,###,###");
        JSpinner valorI=new JSpinner(new SpinnerNumberModel(0,0,10,1));
        ((JSpinner.NumberEditor)valorI.getEditor()).getTextField().setEditable(false);
        Tree variaI=new Tree(new Dato("int","n",""));
        simulador.setDatos(variaI);
        simulador.addCodes(Editor.editor("/recourses/codes/recursividad/Factorial.seros"),"Factorial");
        simulador.setTexto(Text.FACTORIAL.toString());
        simulador.back("Panel de Ejercicios de Recursividad",Paneles.EJERCICIOS_RECURSIVIDAD);
        JLabel producto=new JLabel(Operaciones.operacion("n!","0"),SwingConstants.CENTER);
        producto.setFont(Fuentes.UBUNTULIGHT40.getFont());
        JLabel number=new JLabel("0",SwingConstants.CENTER);
        number.setFont(Fuentes.UBUNTULIGHTB120.getFont());
        simulador.setAcciones(new Acciones() {
            @Override
            public void iteracion0() {
                Eventos.enable(false,simulador.getNextIteracion(),simulador.getSend(),valorI,simulador.getPause(),simulador.getBack(),simulador.getClean(),simulador.getCodigo(),simulador.getHome());
                simulador.setTexto(Text.FACTORIAL1.toString());
                number.setText(Operaciones.formatNumber(Operaciones.factorial(Integer.parseInt(valorI.getValue().toString()))));
                producto.setText(Operaciones.operacion(valorI.getValue().toString()+'!',Operaciones.productoFactorial(Integer.parseInt(valorI.getValue().toString()))));
                Eventos.variable(variaI,-1,valorI.getValue());
                Eventos.enable(true,simulador.getClean());
            }
            @Override
            public void iteracion1() {
                Eventos.enable(false,valorI,simulador.getClean(),simulador.getNextIteracion(),simulador.getSend(),simulador.getPause(),simulador.getBack(),simulador.getCodigo(),simulador.getHome());
                int valor=Integer.parseInt(valorI.getValue().toString())-simulador.getIteracion();
                Eventos.variable(variaI,-1,valor);
                if (Eventos.contains(valor,0,1)){
                    if (simulador.getCodigo().isOnOff()){
                        new Lines(simulador, new LineLocation(0,1,null),new LineLocation(0,2,Text.FACTORIAL3.toString()),new LineLocation(0,3,Text.FACTORIAL4.toString())){
                            @Override
                            public void actions() {
                                if (Eventos.contains(Integer.parseInt(valorI.getValue().toString()),0,1)) casoBaseTerminal(valor);
                                else casoBase(valor,false);
                            }
                        }.start();
                    }else{
                        if (Eventos.contains(Integer.parseInt(valorI.getValue().toString()),0,1)) casoBaseTerminal(valor);
                        else casoBase(valor,true);
                    }
                }else if (simulador.getIteracion()==0 && !simulador.isDecremento()){
                    if (simulador.getCodigo().isOnOff()){
                        new Lines(simulador, new LineLocation(0,5,Text.FACTORIAL6.toString())){
                            @Override
                            public void actions() {
                                casoTerminal(valor);
                            }
                        }.start();
                    }else casoTerminal(valor);
                }else if (!simulador.isDecremento()){
                    if (simulador.getCodigo().isOnOff()){
                        new Lines(simulador, new LineLocation(0,5,Text.FACTORIAL7.toString(),false)){
                            @Override
                            public void actions() {
                                casoIncrementativo(valor,false);
                            }
                        }.start();
                    }else casoIncrementativo(valor,true);
                }else{
                    if (simulador.getCodigo().isOnOff()){
                        new Lines(simulador, new LineLocation(0,1,null),new LineLocation(0,2,Text.FACTORIAL3.toString()),new LineLocation(0,4,Text.FACTORIAL2.toString()),new LineLocation(0,5,null,false)){
                            @Override
                            public void actions() {
                                casoDecrementativo(valor);
                            }
                        }.start();
                    }else casoDecrementativo(valor);
                }
            }
            @Override
            public void clean() {
                simulador.clean();
                simulador.setTexto(Text.FACTORIAL.toString());
                Eventos.variable(variaI,-1,"");
                Eventos.enable(true,valorI);
                valorI.setValue(0);
                number.setText("0");
                producto.setText(Operaciones.operacion("n!","0"));
                simulador.setDecremento(true);
            }
            /**
             * Acción del caso base terminal
             * @param valor valor n a trabajar
             */
            private void casoBaseTerminal(int valor){
                simulador.setTexto(Text.FACTORIAL1.toString());
                number.setText(String.valueOf(Operaciones.factorial(valor)));
                producto.setText(Operaciones.operacion(valorI.getValue().toString()+'!',Operaciones.productoFactorial(valor)));
                Eventos.enable(true, simulador.getClean());
            }
            /**
             * Acción del caso base para decrementar la iteracción
             * @param valor valor n a trabajar
             * @param found texto a mostrar
             */
            private void casoBase(int valor,boolean found){
                simulador.setTexto(found ? Text.FACTORIAL4.toString() : Text.FACTORIAL5.toString());
                number.setText(String.valueOf(Operaciones.factorial(valor)));
                producto.setText(Operaciones.operacion(valorI.getValue().toString()+'!',Operaciones.productoFactorial(valor+simulador.getIteracion())));
                simulador.decrementIteracion();
                simulador.setDecremento(false);
                Eventos.enable(true, simulador.getNextIteracion());
            }
            /**
             * Acción caso terminal
             * @param valor valor n a trabajar
             */
            private void casoTerminal(int valor){
                simulador.setTexto(Text.FACTORIAL1.toString());
                number.setText(Operaciones.formatNumber(Operaciones.factorial(valor)));
                producto.setText(Operaciones.operacion(valorI.getValue().toString()+'!',Operaciones.productUpFactorial(Integer.parseInt(valorI.getValue().toString()),valor)));
                Eventos.enable(true,simulador.getClean());
            }
            /**
             * Acción caso a incrementar
             * @param valor valor n a trabajar
             * @param mult texto a mostrar
             */
            private void casoIncrementativo(int valor,boolean mult){
                if (mult) simulador.setTexto(Text.FACTORIAL7.toString());
                number.setText(Operaciones.formatNumber(Operaciones.factorial(valor)));
                producto.setText(Operaciones.operacion(valorI.getValue().toString()+'!',Operaciones.productUpFactorial(Integer.parseInt(valorI.getValue().toString()),valor)));
                simulador.decrementIteracion();
                Eventos.enable(true,simulador.getNextIteracion());
            }
            /**
             * Acción caso a decrementar
             * @param valor valor n a trabajar
             */
            private void casoDecrementativo(int valor){
                number.setText("0");
                producto.setText(Operaciones.operacion(valorI.getValue().toString()+'!',Operaciones.productoFactorial(Integer.parseInt(valorI.getValue().toString()),valor)));
                simulador.incrementIteracion();
                Eventos.enable(true,simulador.getNextIteracion());
            }
        });
        simulador.acomodamientoProducto(number, producto);
        simulador.acomodamientoPanelControl(valorI);
        return simulador;
    }
    /**
     * Simulador para la temática Recursividad<br>
     * Simulador para el proceso recursivo del potencia
     * @return simulador potencia
     */
    private Simulador potencia(){
        Operaciones.setFormat("#,###,###");
        JSpinner valorBase=new JSpinner(new SpinnerNumberModel(1,1,10,1));
        JSpinner valorExponente=new JSpinner(new SpinnerNumberModel(0,0,10,1));
        JLabel producto=new JLabel(Eventos.html(Operaciones.operacion(Operaciones.exponente("b","e"),"0")),SwingConstants.CENTER);
        JLabel number=new JLabel("0",SwingConstants.CENTER);
        Tree base=new Tree(new Dato("int","base",""));
        Tree exponente=new Tree(new Dato("int","exponente",""));
        Box box=Box.createHorizontalBox();
        Simulador simulador=new Simulador();
        ((JSpinner.NumberEditor)valorBase.getEditor()).getTextField().setEditable(false);
        ((JSpinner.NumberEditor)valorExponente.getEditor()).getTextField().setEditable(false);
        producto.setFont(Fuentes.UBUNTULIGHT40.getFont());
        number.setFont(Fuentes.UBUNTULIGHTB118.getFont());
        box.add(valorBase);
        box.add(Box.createHorizontalStrut(1));
        box.add(valorExponente);
        box.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(),"Base  -  Exponente"));
        simulador.addCodes(Editor.editor("/recourses/codes/recursividad/Potencia.seros"),"Potencia");
        simulador.back("Panel de Ejercicios de Recursividad",Paneles.EJERCICIOS_RECURSIVIDAD);
        simulador.setDatos(base,exponente);
        simulador.setTexto(Text.POTENCIA.toString());
        simulador.setAcciones(new Acciones() {
            @Override
            public void iteracion0() {
                Eventos.enable(false,valorBase,valorExponente,simulador.getNextIteracion(),simulador.getSend(),simulador.getPause(),simulador.getBack(),simulador.getClean(),simulador.getCodigo(),simulador.getHome());
                simulador.setTexto(Text.POTENCIA1.toString());
                number.setText(Operaciones.formatNumber(Operaciones.potencia(valorBase.getValue(),valorExponente.getValue())));
                producto.setText(Eventos.html(Operaciones.operacion(Operaciones.exponente(valorBase.getValue(),valorExponente.getValue()),Operaciones.productoPotencia(Integer.parseInt(valorBase.getValue().toString()),Integer.parseInt(valorExponente.getValue().toString())))));
                Eventos.variable(base,-1,valorBase.getValue());
                Eventos.variable(exponente,-1,valorExponente.getValue());
                Eventos.enable(true,simulador.getClean());
            }
            @Override
            public void iteracion1() {
                Eventos.enable(false,valorBase,valorExponente,simulador.getClean(),simulador.getNextIteracion(),simulador.getSend(),simulador.getPause(),simulador.getBack(),simulador.getCodigo(),simulador.getHome());
                int valor=Integer.parseInt(valorExponente.getValue().toString())-simulador.getIteracion();
                Eventos.variable(exponente,-1,valor);
                Eventos.variable(base,-1,valorBase.getValue());
                if (Integer.parseInt(valorExponente.getValue().toString())==0){
                    if (simulador.getCodigo().isOnOff()) {
                        new Lines(simulador,new LineLocation(0,1,null),new LineLocation(0,2,Text.POTENCIA2.toString()),new LineLocation(0,3,Text.POTENCIA5.toString())){
                            @Override
                            public void actions() {
                                casoTerminal0();
                            }
                        }.start();
                    } else casoTerminal0();
                } else if (valor==1){
                    if (simulador.getCodigo().isOnOff()){
                        new Lines(simulador,new LineLocation(0,1,null),new LineLocation(0,2,Text.POTENCIA2.toString()),new LineLocation(0,4,Text.POTENCIA4.toString()),new LineLocation(0,5,Text.POTENCIA6.toString())){
                            @Override
                            public void actions() {
                                if (Integer.parseInt(valorExponente.getValue().toString())==1) casoTerminal1(valor);
                                else casoIncrementativo(valor);
                            }
                        }.start();
                    } else if (Integer.parseInt(valorExponente.getValue().toString())==2) casoTerminal1(valor);
                    else casoIncrementativo(valor);
                } else if (simulador.getIteracion()==0 && !simulador.isDecremento()){
                    if (simulador.getCodigo().isOnOff()){
                        new Lines(simulador){
                            @Override
                            public void actions() {
                                casoTerminal(valor);
                            }
                        }.start();
                    }else casoTerminal(valor);
                } else if (!simulador.isDecremento()){
                    if (simulador.getCodigo().isOnOff()){
                        new Lines(simulador){
                            @Override
                            public void actions() {
                                casoIncrementativo(valor);
                            }
                        }.start();
                    }else casoIncrementativo(valor);
                } else {
                    if (simulador.getCodigo().isOnOff()){
                        new Lines(simulador) {
                            @Override
                            public void actions() {
                                casoDecrementativo(valor);
                            }
                        }.start();
                    } else casoDecrementativo(valor);
                }
            }
            @Override
            public void clean() {
                simulador.clean();
                Eventos.enable(true,valorBase,valorExponente);
                simulador.setTexto(Text.POTENCIA.toString());
                number.setText("0");
                producto.setText(Eventos.html(Operaciones.operacion(Operaciones.exponente("a","n"),"0")));
                valorBase.setValue(1);
                valorExponente.setValue(0);
                Eventos.variable(base,-1,"");
                Eventos.variable(exponente,-1,"");
            }
            private void casoTerminal(int valor){

            }
            private void casoTerminal0(){
                base(Text.POTENCIA3.toString(),String.valueOf(Operaciones.potencia(valorBase.getValue(),0)),Eventos.html(Operaciones.operacion(Operaciones.exponente(valorBase.getValue(),0),Operaciones.potencia(valorBase.getValue(),0))),true);
            }
            private void casoTerminal1(int valor) {
                simulador.setTexto(Text.POTENCIA3.toString());
            }
            private void casoIncrementativo(int valor) {

            }
            private void casoDecrementativo(int valor) {

            }
            private void base(String texto,String numberText,String productoText,boolean clean){
                if (texto!=null) simulador.setTexto(texto);
                number.setText(numberText);
                producto.setText(productoText);
                Eventos.enable(true,clean ? simulador.getClean() : simulador.getNextIteracion());
            }
        });
        simulador.acomodamientoProducto(number, producto);
        simulador.acomodamientoPanelControl(box);
        return simulador;
    }
}