package gui.principal;
import eventos.Eventos;
import gui.contenido.Boton;
import gui.contenido.Contenido;
import gui.contenido.Demostracion;
import gui.contenido.Ejercicios;
import gui.contenido.Lienzo;
import gui.contenido.Texto;
import gui.contenido.TextPane;
import gui.contenido.Tree;
import gui.editor.Editor;
import gui.simulador.Dato;
import gui.simulador.Recursividad;
import gui.simulador.Simulador;
import gui.simulador.lienzos.Graficador;
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
import java.util.HashMap;
public final class Contenedor extends JPanel {
    public static HashMap<Paneles, Lienzo> paneles;
    public static Paneles panelActivo;
    static {
        paneles = new HashMap<>();
        panelActivo = Paneles.PRINCIPAL;
    }
    /**
     * Contenedor de los paneles del proyecto
     */
    Contenedor() {
        setLayout(new CardLayout());
        init();
        Eventos.setPanel(this);
        Eventos.show(Contenedor.panelActivo);
    }
    /**
     * Se añaden los paneles secundarios al principal<br>
     * Se agrega el evento para circular entre los paneles
     * @see Eventos#setPanel(JPanel)
     * @see tools.Paneles
     */
    private void init() {
        paneles.put(Paneles.PRINCIPAL, principal());
        paneles.put(Paneles.TDA, tda());
        paneles.put(Paneles.SIMULADOR_TDA, simuladorTda());
        paneles.put(Paneles.MODULARIDAD, modularidad());
        paneles.put(Paneles.DEMOSTRACION_MODULARIDAD, demoModularidad());
        paneles.put(Paneles.RECURSIVIDAD, recursividad());
        paneles.put(Paneles.FACTORIAL, factorial());
        paneles.put(Paneles.POTENCIA, potencia());
        paneles.put(Paneles.EJERCICIOS_RECURSIVIDAD, ejerciciosRecursividad());
        paneles.put(Paneles.ARREGLOS, arreglos());
        paneles.put(Paneles.NODOS, nodos());
        paneles.put(Paneles.ORDENAMIENTO, ordenamiento());
        paneles.put(Paneles.BUSQUEDA, busqueda());
        paneles.put(Paneles.PILAS, pilas());
        paneles.put(Paneles.COLAS, colas());
        paneles.put(Paneles.LISTAS_ENLAZADAS, listas());
        paneles.put(Paneles.ARBOLES, arboles());
        paneles.put(Paneles.GRAFOS, grafos());
        paneles.forEach((k,v) -> add(k.toString(), v));
    }
    /**
     * Menu principal de la interfaz gráfica del proyecto
     * @return panel principal de SEROS
     */
    private Lienzo principal(){
        Lienzo lienzo=new Lienzo(new GridBagLayout(),true);
        Constrains.addCompY(new Boton("TDA","Tipos de Datos Abstratos", Archivos.image("/resources/image/TDA.png", -1, -1),Eventos.menu(Paneles.TDA,Paneles.SIMULADOR_TDA), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.TDA);
            }
        }),lienzo,new Rectangle(0,0,1,4),0,new Insets(30,57,30,18),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Modularidad","Division de tareas", Archivos.image("/resources/image/Modularidad y Mapas.png", -1, -1), Eventos.menu(Paneles.MODULARIDAD,Paneles.DEMOSTRACION_MODULARIDAD),new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.MODULARIDAD);
            }
        }), lienzo,new Rectangle(1,0,1,1),0,new Insets(30,18,0,18),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Recursividad","Métodos Recursivos", Archivos.image("/resources/image/Recursividad.png", -1, -1),Eventos.menu(Paneles.RECURSIVIDAD,Paneles.EJERCICIOS_RECURSIVIDAD,Paneles.FACTORIAL,Paneles.POTENCIA), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.RECURSIVIDAD);
            }
        }),lienzo,new Rectangle(1,1,1,1),0,new Insets(13,18,13,18),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Arreglos", "Vectores y Matrices", Archivos.image("/resources/image/Arreglos y Arboles.png", -1, -1),Eventos.menu(Paneles.ARREGLOS), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.ARREGLOS);
            }
        }),lienzo,new Rectangle(1,2,1,1),0,new Insets(13,18,13,18),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Nodos","Enlazamiento de Datos", Archivos.image("/resources/image/Nodos.png", -1, -1), Eventos.menu(Paneles.NODOS),new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.NODOS);
            }
        }),lienzo,new Rectangle(1,3,1,1),0,new Insets(13,18,30,18),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Ordenamiento", "Métodos de Ordenamiento Interno", Archivos.image("/resources/image/Ordenamiento.png", -1, -1),Eventos.menu(Paneles.ORDENAMIENTO), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.ORDENAMIENTO);
            }
        }),lienzo,new Rectangle(2,0,1,2),0,new Insets(30,18,13,18), GridBagConstraints.SOUTH, GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Busqueda","Métodos de Busqueda", Archivos.image("/resources/image/Busqueda.png", -1, -1),Eventos.menu(Paneles.BUSQUEDA), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.BUSQUEDA);
            }
        }),lienzo,new Rectangle(2,2,1,2),0,new Insets(13,18,30,18),GridBagConstraints.NORTH,GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Pilas","Pilas Dinámicas y Estáticas", Archivos.image("/resources/image/Pilas.png", -1, -1),Eventos.menu(Paneles.PILAS), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.PILAS);
            }
        }),lienzo,new Rectangle(3,0,1,2),0,new Insets(30,18,13,18),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Colas","Colas Dinámicas y Estáticas", Archivos.image("/resources/image/Colas.png", -1, -1),Eventos.menu(Paneles.COLAS), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.COLAS);
            }
        }),lienzo,new Rectangle(3,1,1,2),0,new Insets(13,18,13,13),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Listas","Listas Enlazadas", Archivos.image("/resources/image/Listas Enlazadas.png", -1, -1),Eventos.menu(Paneles.LISTAS_ENLAZADAS), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.LISTAS_ENLAZADAS);
            }
        }),lienzo,new Rectangle(3,2,1,2),0,new Insets(13,18,30,18),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Árboles","Árboles Binarios y AVL", Archivos.image("/resources/image/Arreglos y Arboles.png", -1, -1),Eventos.menu(Paneles.ARBOLES), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.ARBOLES);
            }
        }),lienzo,new Rectangle(4,0,1,2),0,new Insets(30,18,13,75),GridBagConstraints.SOUTH,GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Grafos","Algoritmo del Camino más Corto", Archivos.image("/resources/image/Grafos.png", -1, -1),Eventos.menu(Paneles.GRAFOS), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.GRAFOS);
            }
        }),lienzo,new Rectangle(4,2,1,2),0,new Insets(13,18,30,75),GridBagConstraints.NORTH,GridBagConstraints.NONE);
        Constrains.addComp(new Boton("Acerca de Seros", Archivos.image("/resources/image/about.png",-1,-1), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
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
        con.next("Simulador TDA",Paneles.SIMULADOR_TDA);
        JLabel formula=new JLabel(Text.FORMULATDA.toString(),SwingConstants.CENTER);
        formula.setFont(Fuentes.PURISA_18.getFont());
        formula.setOpaque(false);
        Constrains.addComp(new Texto(Text.TDA.toString()), con.getContenido(), new Rectangle(0, 0, 1, 1), 1,1, new Insets(10, 25, 15, 12), GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);
        Constrains.addComp(Editor.editor("/resources/codes/tda/Punto.seros"),con.getContenido(),new Rectangle(0,1,1,1), 0,0,new Insets(5,5,5,5),GridBagConstraints.CENTER, GridBagConstraints.NONE);
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
        Contenido con = new Contenido();
        con.getTitle().setText("Modularidad");
        con.next("Demostración Interactiva de Modularidad",Paneles.DEMOSTRACION_MODULARIDAD);
        Constrains.addComp(new Texto(Text.MODULARIDAD.toString()),con.getContenido(),new Rectangle(0,0,1,1), 1,1,new Insets(10, 25, 5, 12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new JLabel(Archivos.image("/resources/image/saluda.png",-1,290)),con.getContenido(),new Rectangle(0,1,1,1),1,1,new Insets(3,7,7,7),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addComp(new Texto(Text.MODULARIDAD1.toString()),con.getContenido(),new Rectangle(0,2,1,1),1,1,new Insets(10, 25, 15, 12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
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
            editor.append(n,Fuentes.PURISA_22.getFont());
            if (!n.equals(recur[recur.length-1])) editor.append("\u279c",Fuentes.SEGOE_UI_SYMBOL_22.getFont());
        }
        con.next("Panel de Ejercicios de Recursividad",Paneles.EJERCICIOS_RECURSIVIDAD);
        Constrains.addComp(new Texto(Text.RECURSIVIDAD.toString()), con.getContenido(), new Rectangle(0,0,1,1), 1,1,new Insets(10, 25, 1, 12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(editor, con.getContenido(),new Rectangle(0,1,1,1), 0.2,1,new Insets(7,25,180,25), GridBagConstraints.NORTH,GridBagConstraints.NONE);
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
        Constrains.addComp(new Texto(Text.NODOS.toString()),con.getContenido(),new Rectangle(0,0,1,1), 1,1,new Insets(10, 25, 1, 12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new JLabel(Archivos.image("/resources/image/nodo.png",-1,89)),con.getContenido(),new Rectangle(0,1,1,1),1,1,new Insets(1,3,1,3),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addComp(new Texto(Text.NODOS1.toString()),con.getContenido(),new Rectangle(0,2,1,1),1,1,new Insets(5, 25, 15, 12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new JLabel(Archivos.image("/resources/image/memoria.png",-1,150)),con.getContenido(), new Rectangle(0,3,1,1),1,1,new Insets(3,3,3,3),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addComp(new Texto(Text.NODOS2.toString()),con.getContenido(),new Rectangle(0,4,1,1), 1,1,new Insets(10, 25, 5, 12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new JLabel(Archivos.image("/resources/image/mateo.png",-1,450)),con.getContenido(), new Rectangle(0,5,1,1),1,1,new Insets(10,3,10,3),GridBagConstraints.CENTER,GridBagConstraints.NONE);
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
        Constrains.addComp(new Texto(Text.ARREGLOS.toString()),con.getContenido(),new Rectangle(0,0,1,1),1,1,new Insets(10, 25, 8, 12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new JLabel(Archivos.image("/resources/image/arreglo.png",-1,170)),con.getContenido(), new Rectangle(0,1,1,1),1,1,new Insets(5,5,5,5),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addComp(new Texto(Text.ARREGLOS1.toString()),con.getContenido(),new Rectangle(0,2,1,1),1,1,new Insets(8, 25, 8, 12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new JLabel(Archivos.image("/resources/image/arregloDatos.png",-1,130)),con.getContenido(), new Rectangle(0,3,1,1),1,1,new Insets(5,5,5,5),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addComp(new Texto(Text.ARREGLOS2.toString()),con.getContenido(),new Rectangle(0,4,1,1),1,1,new Insets(8, 25, 10, 12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
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
     * @see Contenedor#recursividad()
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
                    case "Factorial" -> ejercicios.getTexto().setText("Simulador recursivo para Factorial");
                    case "Potencia" -> ejercicios.getTexto().setText("Simulación recursiva para Potencia");
                    default -> throw new IllegalStateException("Unexpected value: " + ((Boton) e.getSource()).getText());
                }
            }
            @Override
            public void mouseExited(MouseEvent e) {
                ejercicios.getTexto().setText("");
            }
        };
        ejercicios.setBotones(new Boton(Archivos.image("/resources/image/factorial.png", -1, -1), "Factorial", mouse), new Boton(Archivos.image("/resources/image/potencia.png", -1, -1), "Potencia", mouse));
        return ejercicios;
    }
    /**
     * Simulador para la temática TDA<br>
     * Simula un punto en el eje cartesiano
     * @return simulador de un punto en el plano cartesiano para TDA
     * @see Graficador
     * @see Simulador
     * @see Contenedor#tda()
     */
    private Simulador simuladorTda(){
        JSpinner x=new JSpinner(new SpinnerNumberModel(0,-10,10,1));
        JSpinner y=new JSpinner(new SpinnerNumberModel(0,-10,10,1));
        ((JSpinner.NumberEditor)x.getEditor()).getTextField().setEditable(false);
        ((JSpinner.NumberEditor)y.getEditor()).getTextField().setEditable(false);
        Tree punto=new Tree(new JTree.DynamicUtilTreeNode(new Dato("Punto","punto","",true), new Dato[]{new Dato("int","x",""),new Dato("int","y","")}));
        punto.expandNode(0);
        Simulador simulador= new Simulador("(x,y)", x, y) {
            @Override
            protected void acomodamientoPanelControl(String title, JComponent... components) {
                Constrains.addCompX(componentRegistro(title, components), getControl(),new Rectangle(2,0,2,1),1,new Insets(3,80,5,5), GridBagConstraints.EAST,GridBagConstraints.BOTH);
                Constrains.addCompX(getSend(), getControl(),new Rectangle(4,0,2,1),1,new Insets(10,5,5,100),GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
                Constrains.addCompX(getPause(), getControl(),new Rectangle(2,1,1,1),1,new Insets(5,35,10,8),GridBagConstraints.EAST,GridBagConstraints.NONE);
                Constrains.addCompX(getNextIteracion(), getControl(),new Rectangle(3,1,2,1),1,new Insets(5,8,10,8),GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
                Constrains.addCompX(getClean(), getControl(),new Rectangle(5,1,1,1),1,new Insets(5,5,10,100),GridBagConstraints.WEST,GridBagConstraints.HORIZONTAL);
            }
        };
        Graficador graficador=new Graficador();
        ((JPanel)simulador.getLienzo()).setLayout(new BorderLayout());
        ((JPanel)simulador.getLienzo()).add(graficador, BorderLayout.CENTER);
        simulador.setAcciones(new Acciones() {
            @Override
            public void iteracion0() {
                graficador.graficar(Integer.parseInt(x.getValue().toString()),Integer.parseInt(y.getValue().toString()));
                Eventos.enable(true,simulador.getClean(),simulador.getBack(),simulador.getHome());
                Eventos.enable(false,simulador.getSend(),x,y,simulador.getPause(),simulador.getNextIteracion());
                simulador.setTexto(Text.SIMULADORTDA1.toString());
                Eventos.variable(punto,0,x.getValue());
                Eventos.variable(punto,1,y.getValue());
                punto.expandNode(0);
            }
            @Override
            public void iteracion1() {
                Eventos.enable(false,simulador.getSend(),x,y,simulador.getPause(),simulador.getClean(),simulador.getBack(),simulador.getHome(),simulador.getNextIteracion());
                if (simulador.getIteracion()==0) asignacionX();
                else if (simulador.getIteracion()==1) asignacionY();
                else mostrarCoordenadas();
                simulador.incrementIteracion();
            }
            @Override
            public void clean() {
                simulador.cleanComponents();
                graficador.limpiar();
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
                base(Text.SIMULADORTDA3,4,0,false);
                Eventos.variable(punto,0,x.getValue());
            }
            /**
             * Muestra los datos y códigos que se asignan al eje y
             */
            private void asignacionY(){
                base(Text.SIMULADORTDA4,5,0,false);
                Eventos.variable(punto,1,y.getValue());
            }
            /**
             * Grafica las coordenadas (x,y) muestra los códigos asignados a estos
             */
            private void mostrarCoordenadas(){
                base(Text.SIMULADORTDA1,21,((Editor) simulador.getCodigos().getComponentAt(0)).getVerticalScrollBar().getMaximum(),true);
                graficador.graficar(Integer.parseInt(x.getValue().toString()),Integer.parseInt(y.getValue().toString()));
            }
            /**
             * Acciones comunes de interactividad
             * @param text {@link Text} a fijar
             * @param line línea seleccionar
             * @param scroll posición del scroll a fijar
             * @param clean acción de habilitar la opción de limpiar o de interactividad
             */
            private void base(Text text,int line,int scroll,boolean clean){
                simulador.setTexto(text.toString());
                Eventos.scroll((Editor) simulador.getCodigos().getComponentAt(0),scroll);
                ((Editor) simulador.getCodigos().getComponentAt(0)).drawLineIn(line);
                Eventos.enable(true,clean ? simulador.getClean() : simulador.getNextIteracion(),simulador.getBack(),simulador.getHome());
            }
        });
        simulador.addCodes(Editor.editor("/resources/codes/tda/Punto.seros"),"Punto");
        simulador.back("Tipos de Datos Abstratos",Paneles.TDA);
        simulador.getSend().setText("Graficar");
        simulador.setDatos(punto);
        simulador.setTexto(Text.SIMULADORTDA2.toString());
        return simulador;
    }
    /**
     * Simulador para la temática Recursividad<br>
     * Simulador para el proceso recursivo del factorial
     * @return simulador factorial
     * @see Recursividad
     * @see Contenedor#recursividad()
     */
    private Recursividad factorial(){
        Operaciones.addFormat(Operaciones.Operacion.FACTORIAL, "#,###,###");
        JSpinner valorI=new JSpinner(new SpinnerNumberModel(0,0,10,1));
        ((JSpinner.NumberEditor)valorI.getEditor()).getTextField().setEditable(false);
        Tree variaI=new Tree(new Dato("int","n",""));
        Recursividad recursividad = new Recursividad(null, valorI) {
            @Override
            protected void casoTerminal() {
                base(Text.FACTORIAL1, Operaciones.formatNumber(Operaciones.factorial(getValor()), Operaciones.Operacion.FACTORIAL), Operaciones.operacion(valorI.getValue().toString()+'!', Operaciones.productUpFactorial(Integer.parseInt(valorI.getValue().toString()), getValor())), true);
            }
            @Override
            protected void casoDecrementativo() {
                base(null, String.valueOf(0), Operaciones.operacion(valorI.getValue().toString()+'!', Operaciones.productoFactorial(Integer.parseInt(valorI.getValue().toString()), getValor())), false);
                incrementIteracion();
            }
            @Override
            protected void casoIncrementativo() {
                base(Text.FACTORIAL7, Operaciones.formatNumber(Operaciones.factorial(getValor()), Operaciones.Operacion.FACTORIAL), Operaciones.operacion(valorI.getValue().toString()+'!', Operaciones.productUpFactorial(Integer.parseInt(valorI.getValue().toString()), getValor())), false);
                decrementIteracion();
            }
            @Override
            protected void casoBase(boolean found) {
                base(found ? Text.FACTORIAL1 : Text.FACTORIAL5, Operaciones.factorial(getValor()), Operaciones.operacion(valorI.getValue().toString()+'!', Operaciones.productoFactorial(Integer.parseInt(valorI.getValue().toString()))), found);
                if (!found) {
                    decrementIteracion();
                    setDecremento(false);
                }
            }
            @Override
            protected Lines[] lines() {
                return new Lines[]{new Lines(this, new LineLocation(0,1,null),new LineLocation(0,2,Text.FACTORIAL3.toString()),new LineLocation(0,3,Text.FACTORIAL4.toString())) {
                    @Override
                    public void actions() {
                        accionesCasoBase(false);
                    }
                }, new Lines(this, new LineLocation(0, 5, Text.FACTORIAL6.toString())) {
                    @Override
                    protected void actions() {
                        accionesCasoTerminal(false);
                    }
                }, new Lines(this, new LineLocation(0, 5, null, false)) {
                    @Override
                    protected void actions() {
                        accionesCasoIncrementativo(false);
                    }
                }, new Lines(this, new LineLocation(0, 1, null), new LineLocation(0, 2, Text.FACTORIAL3.toString()), new LineLocation(0, 4, Text.FACTORIAL2.toString()), new LineLocation(0, 5, null, false)) {
                    @Override
                    protected void actions() {
                        accionesCasoDecrementativo(false);
                    }
                }};
            }
            @Override
            protected boolean isCasoBase() {
                return getValor()==1 || getValor()==0;
            }
            @Override
            protected void accionesCasoBase(boolean code) {
                if (code) lines()[0].start();
                else {
                    int n=Integer.parseInt(valorI.getValue().toString());
                    casoBase(n==1 || n==0);
                }
            }
            @Override
            protected void accionesCasoTerminal(boolean code) {
                if (code) lines()[1].start();
                else casoTerminal();
            }
            @Override
            protected void accionesCasoIncrementativo(boolean code) {
                if (code) lines()[2].start();
                else casoIncrementativo();
            }
            @Override
            protected void accionesCasoDecrementativo(boolean code) {
                if (code) lines()[3].start();
                else casoDecrementativo();
            }
            @Override
            public void iteracion0() {
                Eventos.enable(false,getNextIteracion(),getSend(),valorI,getPause(),getBack(),getClean(),getCodigo(),getHome());
                Eventos.variable(variaI,-1,valorI.getValue());
                base(Text.FACTORIAL1, Operaciones.formatNumber(Operaciones.factorial(Integer.parseInt(valorI.getValue().toString())), Operaciones.Operacion.FACTORIAL), Operaciones.operacion(valorI.getValue().toString()+'!',Operaciones.productoFactorial(Integer.parseInt(valorI.getValue().toString()))), true);
            }
            @Override
            public void iteracion1() {
                Eventos.enable(false,valorI);
                setValor(Integer.parseInt(valorI.getValue().toString()) - getIteracion());
                Eventos.variable(variaI,-1,getValor());
                super.iteracion1();
            }
            @Override
            public void clean() {
                cleanComponents();
                setTexto(Text.FACTORIAL.toString());
                Eventos.variable(variaI,-1,"");
                Eventos.enable(true, valorI);
                valorI.setValue(0);
                setNumber(String.valueOf(0));
                setProducto(Operaciones.operacion("n!","0"));
                setDecremento(true);
            }
            /**
             * Acciones comunes de interactividad
             * @param text {@link Text}
             * @param number1 número resultado a fijar
             * @param producto1 producto a fijar
             * @param clean acción de habilitar la opción de limpiar o de interactividad
             */
            private void base(Text text,Object number1,String producto1,boolean clean){
                if (text!=null) setTexto(text.toString());
                setNumber(number1.toString());
                setProducto(producto1);
                Eventos.enable(true,clean ? getClean() : getNextIteracion(),getBack(),getHome());
            }
        };
        recursividad.setDatos(variaI);
        recursividad.addCodes(Editor.editor("/resources/codes/recursividad/Factorial.seros"),"Factorial");
        recursividad.setTexto(Text.FACTORIAL.toString());
        recursividad.back("Panel de Ejercicios de Recursividad",Paneles.EJERCICIOS_RECURSIVIDAD);
        recursividad.setProducto(Operaciones.operacion("n!","0"));
        return recursividad;
    }
    /**
     * Simulador para la temática Recursividad<br>
     * Simulador para el proceso recursivo del potencia
     * @return simulador potencia
     * @see Recursividad
     * @see Contenedor#recursividad()
     */
    private Recursividad potencia(){
        JSpinner valorBase=new JSpinner(new SpinnerNumberModel(1,1,10,1));
        JSpinner valorExponente=new JSpinner(new SpinnerNumberModel(0,0,10,1));
        ((JSpinner.NumberEditor)valorBase.getEditor()).getTextField().setEditable(false);
        ((JSpinner.NumberEditor)valorExponente.getEditor()).getTextField().setEditable(false);
        Recursividad recursividad = new Recursividad("Base  -  Exponente", valorBase, valorExponente) {
            @Override
            protected void casoTerminal() {

            }
            @Override
            protected void casoDecrementativo() {

            }
            @Override
            protected void casoIncrementativo() {

            }
            @Override
            protected void casoBase(boolean found) {

            }
            @Override
            protected Lines[] lines() {
                return new Lines[0];
            }
            @Override
            protected boolean isCasoBase() {
                return false;
            }
            @Override
            protected void accionesCasoBase(boolean code) {

            }
            @Override
            protected void accionesCasoTerminal(boolean code) {

            }
            @Override
            protected void accionesCasoIncrementativo(boolean code) {

            }
            @Override
            protected void accionesCasoDecrementativo(boolean code) {

            }
            @Override
            public void iteracion0() {

            }
            @Override
            public void iteracion1() {

            }
            @Override
            public void clean() {

            }
        };
        return recursividad;
        /*Operaciones.setFormat(Operaciones.Operacion.POTENCIA,"##,###,###,###.#");
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
        simulador.addCodes(Editor.editor("/resources/codes/recursividad/Potencia.seros"),"Potencia");
        simulador.back("Panel de Ejercicios de Recursividad",Paneles.EJERCICIOS_RECURSIVIDAD);
        simulador.setDatos(base,exponente);
        simulador.setTexto(Text.POTENCIA.toString());
        simulador.setAcciones(new Acciones() {
            @Override
            public void iteracion0() {
                Eventos.enable(false,valorBase,valorExponente,simulador.getNextIteracion(),simulador.getSend(),simulador.getPause(),simulador.getBack(),simulador.getClean(),simulador.getCodigo(),simulador.getHome());
                simulador.setTexto(Text.POTENCIA1.toString());
                number.setText(Operaciones.formatNumber(Operaciones.potencia(valorBase.getValue(),valorExponente.getValue()), Operaciones.Operacion.POTENCIA));
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
                if (valor==0){
                    if (simulador.getCodigo().isOnOff()){
                        new Lines(simulador,new LineLocation(0,1,null),new LineLocation(0,2,3,Text.POTENCIA2.toString()),new LineLocation(0,3,4,Text.POTENCIA4.toString())){
                            @Override
                            public void actions() {
                                casoBase(valor,true);
                            }
                        }.start();
                    }else casoBase(valor,true);
                }else if (valor==1){
                    if (simulador.getCodigo().isOnOff()){
                        new Lines(simulador,new LineLocation(0,1,null),new LineLocation(0,2,3,Text.POTENCIA2.toString()),new LineLocation(0,4,5,Text.POTENCIA3.toString()),new LineLocation(0,5,6,Text.POTENCIA5.toString())){
                            @Override
                            public void actions() {
                                if (Integer.parseInt(valorExponente.getValue().toString())==1) casoBase(valor,true);
                                else casoBase(valor,false);
                            }
                        }.start();
                    }else if (Integer.parseInt(valorExponente.getValue().toString())==1) casoBase(valor,true);
                    else casoBase(valor,false);
                }else if (simulador.getIteracion()==0 && !simulador.isDecremento()){
                    if (simulador.getCodigo().isOnOff()){
                        new Lines(simulador, new LineLocation(0,7,8,Text.FACTORIAL6.toString())){
                            @Override
                            public void actions() {
                                casoTerminal(valor);
                            }
                        }.start();
                    }else casoTerminal(valor);
                }else if (!simulador.isDecremento()){
                    if (simulador.getCodigo().isOnOff()){
                        new Lines(simulador,new LineLocation(0,7,8,Text.POTENCIA8.toString(),false)){
                            @Override
                            public void actions() {
                                casoIncrementativo(valor);
                            }
                        }.start();
                    }else casoIncrementativo(valor);
                }else{
                    if (simulador.getCodigo().isOnOff()){
                        new Lines(simulador,new LineLocation(0,1,null),new LineLocation(0,2,3,Text.POTENCIA2.toString()),new LineLocation(0,4,5,Text.POTENCIA3.toString()),new LineLocation(0,6,7,Text.POTENCIA9.toString()),new LineLocation(0,7,8,null)) {
                            @Override
                            public void actions() {
                                casoDecrementativo();
                            }
                        }.start();
                    }else casoDecrementativo();
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
            private void casoBase(int valor,boolean found){
                base(found ? Text.POTENCIA1 : Text.POTENCIA7,Operaciones.potencia(valorBase.getValue(),valor),Operaciones.operacion(Operaciones.exponente(valorBase.getValue(),valorExponente.getValue()),found ? Operaciones.potencia(valorBase.getValue(),valorExponente.getValue()) : Operaciones.productoPotenciaUp(valorBase.getValue(),valorExponente.getValue())),found);
                if (!found){
                    simulador.setDecremento(false);
                    simulador.decrementIteracion();
                }
            }
            private void casoTerminal(int valor){
                base(Text.POTENCIA1,Operaciones.potencia(valorBase.getValue(),valorExponente.getValue()),Operaciones.operacion(Operaciones.exponente(valorBase.getValue(),valorExponente.getValue()),Operaciones.potencia(valorBase.getValue(),valorExponente.getValue())),true);
            }
            private void casoIncrementativo(int valor){
                base(Text.POTENCIA8,Operaciones.potencia(valorBase.getValue(),valor),Operaciones.operacion(Operaciones.exponente(valorBase.getValue(),valorExponente.getValue()),Operaciones.productoPotenciaUpN(valorBase.getValue(),simulador.getIteracion(),valor)),false);
                simulador.decrementIteracion();
            }
            private void casoDecrementativo(){
                base(null,0,Operaciones.operacion(Operaciones.exponente(valorBase.getValue(),valorExponente.getValue()),Operaciones.productoPotenciaUp(valorBase.getValue(),simulador.getIteracion()+1)),false);
                simulador.incrementIteracion();
            }
            private void base(Text texto,double numberText,String productoText,boolean clean){
                if (texto!=null) simulador.setTexto(texto.toString());
                number.setText(Operaciones.formatNumber(numberText, Operaciones.Operacion.POTENCIA));
                producto.setText(Eventos.html(productoText));
                Eventos.enable(true,clean ? simulador.getClean() : simulador.getNextIteracion(), simulador.getBack(), simulador.getHome());
            }
        });
        simulador.acomodamientoProducto(number, producto);
        simulador.acomodamientoPanelControl(box);
        return simulador;*/
    }
    /**
     * Demostración utilizada en Modularidad
     * @return Demostración de Modularidad
     * @see Demostracion
     * @see Contenedor#modularidad()
     */
    private Demostracion demoModularidad(){
        Demostracion demostracion=new Demostracion("/resources/image/moduDemo1.png");
        demostracion.setTexto(Text.DEMOSTRACION_MODULARIDAD.toString());
        JButton demo1=new JButton("Inventar");
        JButton demo2=new JButton("Programar");
        JButton demo3=new JButton("Leer");
        JButton demo4=new JButton("Jugar");
        demo1.addActionListener(e -> demostracion.setIcon("/resources/image/moduDemo1.png"));
        demo2.addActionListener(e -> demostracion.setIcon("/resources/image/moduDemo2.png"));
        demo3.addActionListener(e -> demostracion.setIcon("/resources/image/moduDemo3.png"));
        demo4.addActionListener(e -> demostracion.setIcon("/resources/image/moduDemo4.png"));
        demostracion.setBotones(demo1, demo2, demo3, demo4);
        return demostracion;
    }
}