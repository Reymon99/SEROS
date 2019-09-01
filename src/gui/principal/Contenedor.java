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
import tools.Dato;
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
import tools.Operaciones.Operacion;
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
        JLabel formula=new JLabel(Text.FORMULA_TDA.toString(),SwingConstants.CENTER);
        formula.setFont(Fuentes.PURISA_18.getFont());
        formula.setOpaque(false);
        Constrains.addComp(new Texto(Text.TDA.toString()), con.getContenido(), new Rectangle(0, 0, 1, 1), 1,1, new Insets(10, 25, 15, 12), GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);
        Constrains.addComp(Editor.editor("/resources/codes/tda/Punto.seros", "Punto"),con.getContenido(),new Rectangle(0,1,1,1), 0,0,new Insets(5,5,5,5),GridBagConstraints.CENTER, GridBagConstraints.NONE);
        Constrains.addComp(new Texto(Text.TDA_1.toString()), con.getContenido(),new Rectangle(0,2,1,1),1,1,new Insets(10,25,3,12), GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new Texto(Text.TDA_2.toString()), con.getContenido(),new Rectangle(0,3,1,1),1,1,new Insets(3,40,3,12), GridBagConstraints.NORTHEAST,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new Texto(Text.TDA_3.toString()), con.getContenido(),new Rectangle(0,4,1,1), 1,1,new Insets(5,25,5,12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
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
        Constrains.addComp(new Texto(Text.MODULARIDAD_1.toString()),con.getContenido(),new Rectangle(0,2,1,1),1,1,new Insets(10, 25, 15, 12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
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
        String[] recur = Text.RECURSIVIDAD_1.toString().split("\u279c");
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
        Constrains.addComp(new Texto(Text.NODOS_1.toString()),con.getContenido(),new Rectangle(0,2,1,1),1,1,new Insets(5, 25, 15, 12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new JLabel(Archivos.image("/resources/image/memoria.png",-1,150)),con.getContenido(), new Rectangle(0,3,1,1),1,1,new Insets(3,3,3,3),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addComp(new Texto(Text.NODOS_2.toString()),con.getContenido(),new Rectangle(0,4,1,1), 1,1,new Insets(10, 25, 5, 12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
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
        Constrains.addComp(new Texto(Text.ARREGLOS_1.toString()),con.getContenido(),new Rectangle(0,2,1,1),1,1,new Insets(8, 25, 8, 12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new JLabel(Archivos.image("/resources/image/arregloDatos.png",-1,130)),con.getContenido(), new Rectangle(0,3,1,1),1,1,new Insets(5,5,5,5),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addComp(new Texto(Text.ARREGLOS_2.toString()),con.getContenido(),new Rectangle(0,4,1,1),1,1,new Insets(8, 25, 10, 12), GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
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
        simulador.getLienzo().setLayout(new BorderLayout());
        simulador.getLienzo().add(graficador, BorderLayout.CENTER);
        simulador.setAcciones(new Acciones() {
            @Override
            public void iteracion0() {
                graficador.graficar(Integer.parseInt(x.getValue().toString()), Integer.parseInt(y.getValue().toString()));
                Eventos.enable(true, simulador.getClean(), simulador.getBack(), simulador.getHome());
                Eventos.enable(false, simulador.getSend(), x, y, simulador.getPause(), simulador.getNextIteracion());
                simulador.setTexto(Text.SIMULADOR_TDA_1);
                Eventos.variable(punto, 0, x.getValue());
                Eventos.variable(punto, 1, y.getValue());
                punto.expandNode(0);
            }
            @Override
            public void iteracion1() {
                Eventos.enable(false, simulador.getSend(), x, y, simulador.getPause(), simulador.getClean(), simulador.getBack(), simulador.getHome(), simulador.getNextIteracion());
                if (simulador.getIteracion()==0) asignacionX();
                else if (simulador.getIteracion()==1) asignacionY();
                else mostrarCoordenadas();
                simulador.incrementIteracion();
            }
            @Override
            public void clean() {
                simulador.cleanComponents();
                graficador.limpiar();
                Eventos.variable(punto, 0, "");
                Eventos.variable(punto, 1, "");
                Eventos.enable(true, x, y);
                simulador.setTexto(Text.SIMULADOR_TDA_2);
                x.setValue(0);
                y.setValue(0);
                punto.expandNode(0);
            }
            /**
             * Muestra los datos y códigos que se asignan al eje x
             */
            private void asignacionX(){
                base(Text.SIMULADOR_TDA_3, 5, 0, false);
                Eventos.variable(punto, 0, x.getValue());
            }
            /**
             * Muestra los datos y códigos que se asignan al eje y
             */
            private void asignacionY(){
                base(Text.SIMULADOR_TDA_4, 6, 0, false);
                Eventos.variable(punto, 1, y.getValue());
            }
            /**
             * Grafica las coordenadas (x,y) muestra los códigos asignados a estos
             */
            private void mostrarCoordenadas(){
                base(Text.SIMULADOR_TDA_1, 22, ((Editor) simulador.getCodigos().getComponentAt(0)).getVerticalScrollBar().getMaximum(), true);
                graficador.graficar(Integer.parseInt(x.getValue().toString()), Integer.parseInt(y.getValue().toString()));
            }
            /**
             * Acciones comunes de interactividad
             * @param text {@link Text} a fijar
             * @param line línea seleccionar
             * @param scroll posición del scroll a fijar
             * @param clean acción de habilitar la opción de limpiar o de interactividad
             */
            private void base(Text text, int line, int scroll, boolean clean){
                simulador.setTexto(text);
                Eventos.scroll((Editor) simulador.getCodigos().getComponentAt(0), scroll);
                ((Editor) simulador.getCodigos().getComponentAt(0)).drawLineIn(line);
                Eventos.enable(true, clean ? simulador.getClean() : simulador.getNextIteracion(), simulador.getBack(), simulador.getHome());
            }
        });
        simulador.addCodes(Editor.editor("/resources/codes/tda/Punto.seros", "Punto"));
        simulador.back("Tipos de Datos Abstratos",Paneles.TDA);
        simulador.getSend().setText("Graficar");
        simulador.setDatos(punto);
        simulador.setTexto(Text.SIMULADOR_TDA_2);
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
        Operaciones.addFormat(Operacion.FACTORIAL, "#,###,###");
        JSpinner valorI=new JSpinner(new SpinnerNumberModel(0,0,10,1));
        ((JSpinner.NumberEditor)valorI.getEditor()).getTextField().setEditable(false);
        Tree variaI=new Tree(new Dato("int","n",""));
        Recursividad recursividad = new Recursividad(null, valorI) {
            @Override
            protected void casoTerminal() {
                base(Text.FACTORIAL_1,
                        Operaciones.formatNumber(Operaciones.factorial(getValor()), Operacion.FACTORIAL),
                        Operaciones.operacion(valorI.getValue().toString()+'!', Operaciones.productUpFactorial(Integer.parseInt(valorI.getValue().toString()), getValor())),
                        true);
            }
            @Override
            protected void casoDecrementativo() {
                base(Text.CASO_RECURSIVO,
                        0,
                        Operaciones.operacion(valorI.getValue().toString()+'!', Operaciones.productoFactorial(Integer.parseInt(valorI.getValue().toString()), getValor())),
                        false);
                incrementIteracion();
            }
            @Override
            protected void casoIncrementativo() {
                base(Text.FACTORIAL_2,
                        Operaciones.formatNumber(Operaciones.factorial(getValor()), Operacion.FACTORIAL),
                        Operaciones.operacion(valorI.getValue().toString()+'!', Operaciones.productUpFactorial(Integer.parseInt(valorI.getValue().toString()), getValor())),
                        false);
                decrementIteracion();
            }
            @Override
            protected void casoBase(boolean found) {
                base(found ? Text.FACTORIAL_1 : Text.CASO_BASE_RETURN_2,
                        Operaciones.factorial(getValor()),
                        Operaciones.operacion(valorI.getValue().toString()+'!', Operaciones.productoFactorial(Integer.parseInt(valorI.getValue().toString()))),
                        found);
                if (!found) {
                    decrementIteracion();
                    setDecremento(false);
                }
            }
            @Override
            protected Lines[] lines() {
                LineLocation[] lines = new LineLocation[] {
                        new LineLocation(0, 1, null),
                        new LineLocation(0, 2, Text.CASO_BASE.toString()),
                        new LineLocation(0, 5, null, false)
                };
                return new Lines[] {new Lines(this,
                        lines[0],
                        lines[1],
                        new LineLocation(0, 3, Text.CASO_BASE_FOUND.toString())) {
                    @Override
                    protected void actions() {
                        accionesCasoBase(false);
                    }
                }, new Lines(this,
                        new LineLocation(0, 5, Text.CASO_RECURSIVO_FINISHED.toString())) {
                    @Override
                    protected void actions() {
                        accionesCasoTerminal(false);
                    }
                }, new Lines(this, lines[2]) {
                    @Override
                    protected void actions() {
                        accionesCasoIncrementativo(false);
                    }
                }, new Lines(this,
                        lines[0],
                        lines[1],
                        new LineLocation(0, 4, Text.CASO_RECURSIVO.toString()),
                        lines[2]) {
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
                Eventos.enable(false,getNextIteracion(), getSend(), valorI, getPause(), getBack(), getClean(), getCodigo(), getHome());
                Eventos.variable(variaI,-1, valorI.getValue());
                base(Text.FACTORIAL_1,
                        Operaciones.formatNumber(Operaciones.factorial(Integer.parseInt(valorI.getValue().toString())), Operacion.FACTORIAL),
                        Operaciones.operacion(valorI.getValue().toString()+'!',Operaciones.productoFactorial(Integer.parseInt(valorI.getValue().toString()))),
                        true);
            }
            @Override
            public void iteracion1() {
                Eventos.enable(false, valorI);
                setValor(Integer.parseInt(valorI.getValue().toString()) - getIteracion());
                Eventos.variable(variaI, -1, getValor());
                super.iteracion1();
            }
            @Override
            public void clean() {
                cleanComponents();
                setTexto(Text.FACTORIAL);
                Eventos.variable(variaI,-1,"");
                Eventos.enable(true, valorI);
                valorI.setValue(0);
                setNumber(String.valueOf(0));
                setProducto(Operaciones.operacion("n!","0"));
            }
            @Override
            protected void base(Text text, Object numberText, String productoText, boolean clean){
                super.base(text, numberText, productoText, clean);
                setNumber(numberText.toString());
                setProducto(productoText);
            }
        };
        recursividad.setDatos(variaI);
        recursividad.addCodes(Editor.editor("/resources/codes/recursividad/Factorial.seros", "Factorial"));
        recursividad.setTexto(Text.FACTORIAL);
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
        Operaciones.addFormat(Operacion.POTENCIA, "##,###,###,###.#");
        JSpinner valorBase = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        JSpinner valorExponente = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        ((JSpinner.NumberEditor) valorBase.getEditor()).getTextField().setEditable(false);
        ((JSpinner.NumberEditor) valorExponente.getEditor()).getTextField().setEditable(false);
        Tree base = new Tree(new Dato("int", "base", ""));
        Tree exponente = new Tree(new Dato("int", "exponente", ""));
        Recursividad recursividad = new Recursividad("Base  -  Exponente", valorBase, valorExponente) {
            @Override
            protected void casoTerminal() {
                base(Text.POTENCIA_1,
                        Operaciones.potencia(valorBase.getValue(), valorExponente.getValue()),
                        Operaciones.operacion(Operaciones.exponente(valorBase.getValue(), valorExponente.getValue()), Operaciones.potencia(valorBase.getValue(), valorExponente.getValue())),
                        true);
            }
            @Override
            protected void casoDecrementativo() {
                base(Text.CASO_RECURSIVO,
                        0,
                        Operaciones.operacion(Operaciones.exponente(valorBase.getValue(), valorExponente.getValue()), Operaciones.productoPotenciaUp(valorBase.getValue(), getIteracion() + 1)),
                        false);
                incrementIteracion();
            }
            @Override
            protected void casoIncrementativo() {
                base(Text.POTENCIA_3,
                        Operaciones.potencia(valorBase.getValue(), getValor()),
                        Operaciones.operacion(Operaciones.exponente(valorBase.getValue(), valorExponente.getValue()), Operaciones.productoPotenciaUpN(valorBase.getValue(), getIteracion(), getValor())),
                        false);
                decrementIteracion();
            }
            @Override
            protected void casoBase(boolean found) {
                base(found ? Text.POTENCIA_1 : Text.CASO_BASE_RETURN_2,
                        Operaciones.potencia(valorBase.getValue(), getValor()),
                        Operaciones.operacion(Operaciones.exponente(valorBase.getValue(), valorExponente.getValue()), found ? Operaciones.potencia(valorBase.getValue(), getValor()) : Operaciones.productoPotenciaUp(valorBase.getValue(), valorExponente.getValue())),
                        found);
                if (!found){
                    setDecremento(false);
                    decrementIteracion();
                }
            }
            /**
             * Acción del caso base 0 lanzando una excepción aritmética
             */
            private void casoArithmetic(){
                base(Text.ARITHMETIC_1, '-', Text.INDETERMINADO.toString(), true);
            }
            @Override
            protected Lines[] lines() {
                LineLocation[] lines = new LineLocation[]{
                        new LineLocation(0, 1, null),
                        new LineLocation(0, 2, Text.CASO_BASE.toString()),
                        new LineLocation(0, 3, Text.POTENCIA_2.toString()),
                        new LineLocation(0, 8, null),
                        new LineLocation(0, 9, Text.CASO_BASE_FOUND.toString()),
                        new LineLocation(0, 11, null, false)
                };
                return new Lines[]{new Lines(this,
                        lines[0],
                        lines[1],
                        lines[2],
                        new LineLocation(0, 4, Text.ARITHMETIC.toString()),
                        new LineLocation(0, -1, null, false)) {
                    @Override
                    protected void actions() {
                        accionesCasoBase(false);
                    }
                }, new Lines(this,
                        lines[0],
                        lines[1],
                        lines[2],
                        new LineLocation(0, 5, Text.CASO_BASE_FOUND.toString()),
                        new LineLocation(0, 6, null, false)) {
                    @Override
                    protected void actions() {
                        accionesCasoBase(false);
                    }
                }, new Lines(this,
                        lines[0],
                        lines[1],
                        lines[3],
                        lines[4],
                        new LineLocation(0, -1, Text.CASO_BASE_RETURN_1.toString())) {
                    @Override
                    protected void actions() {
                        accionesCasoBase(false);
                    }
                }, new Lines(this,
                        lines[0],
                        lines[1],
                        lines[3],
                        lines[4]) {
                    @Override
                    protected void actions() {
                        accionesCasoBase(false);
                    }
                }, new Lines(this,
                        lines[0],
                        lines[1],
                        lines[3],
                        new LineLocation(0, 10, Text.CASO_RECURSIVO.toString()),
                        lines[5]) {
                    @Override
                    protected void actions() {
                        accionesCasoDecrementativo(false);
                    }
                }, new Lines(this, lines[5]) {
                    @Override
                    protected void actions() {
                        accionesCasoIncrementativo(false);
                    }
                }, new Lines(this,
                        new LineLocation(0, 11, Text.CASO_RECURSIVO_FINISHED.toString())) {
                    @Override
                    protected void actions() {
                        accionesCasoTerminal(false);
                    }
                }};
            }
            @Override
            protected boolean isCasoBase() {
                int basePot = Integer.parseInt(valorBase.getValue().toString());
                return getValor()==1 || getValor()==0 || basePot == 1 || basePot == 0;
            }
            @Override
            protected void accionesCasoBase(boolean code) {
                int basePot = Integer.parseInt(valorBase.getValue().toString());
                if (getValor() == 0){
                    if (basePot == 0){
                        if (code) lines()[0].start();
                        else casoArithmetic();
                    } else if (code) lines()[1].start();
                    else casoBase(true);
                } else if (basePot == 1 || basePot == 0 || Integer.parseInt(valorExponente.getValue().toString()) == 1) {
                    if (code) lines()[2].start();
                    else casoBase(true);
                } else if (code) lines()[3].start();
                else casoBase(false);
            }
            @Override
            protected void accionesCasoTerminal(boolean code) {
                if (code) lines()[6].start();
                else casoTerminal();
            }
            @Override
            protected void accionesCasoIncrementativo(boolean code) {
                if (code) lines()[5].start();
                else casoIncrementativo();
            }
            @Override
            protected void accionesCasoDecrementativo(boolean code) {
                if (code) lines()[4].start();
                else casoDecrementativo();
            }
            @Override
            public void iteracion0() {
                Eventos.enable(false, valorBase, valorExponente, getNextIteracion(), getSend(), getPause(), getBack(), getClean(), getCodigo(), getHome());
                Eventos.variable(base, -1, valorBase.getValue());
                Eventos.variable(exponente, -1, valorExponente.getValue());
                if (Integer.parseInt(valorBase.getValue().toString()) == 0 &&
                        Integer.parseInt(valorExponente.getValue().toString()) == 0) casoArithmetic();
                else base(Text.FACTORIAL_1,
                        Operaciones.potencia(valorBase.getValue(), valorExponente.getValue()),
                        Operaciones.operacion(Operaciones.exponente(valorBase.getValue(), valorExponente.getValue()), Operaciones.productoPotencia(Integer.parseInt(valorBase.getValue().toString()), Integer.parseInt(valorExponente.getValue().toString()))),
                        true);
            }
            @Override
            public void iteracion1() {
                Eventos.enable(false, valorBase, valorExponente);
                setValor(Integer.parseInt(valorExponente.getValue().toString()) - getIteracion());
                Eventos.variable(base, -1, valorBase.getValue());
                Eventos.variable(exponente, -1, getValor());
                super.iteracion1();
            }
            @Override
            public void clean() {
                cleanComponents();
                Eventos.enable(true, valorBase, valorExponente);
                setTexto(Text.POTENCIA);
                setNumber("0");
                setProducto(Eventos.html(Operaciones.operacion(Operaciones.exponente("a", "n"), "0")));
                valorBase.setValue(0);
                valorExponente.setValue(0);
                Eventos.variable(base, -1, "");
                Eventos.variable(exponente, -1, "");
            }
            @Override
            protected void base(Text text, Object numberText, String productoText, boolean clean) {
                super.base(text, numberText, productoText, clean);
                try{
                    setNumber(Operaciones.formatNumber(numberText, Operacion.POTENCIA));
                } catch (IllegalArgumentException e) {
                    setNumber(numberText.toString());
                }
                setProducto(Eventos.html(productoText));
            }
        };
        recursividad.setProducto(Eventos.html(Operaciones.operacion(Operaciones.exponente("b", "e"), "0")));
        recursividad.setDatos(base, exponente);
        recursividad.setTexto(Text.POTENCIA);
        recursividad.addCodes(Editor.editor("/resources/codes/recursividad/Potencia.seros", "Potencia"));
        return recursividad;
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