package gui.principal;
import eventos.Eventos;
import gui.contenido.Boton;
import gui.contenido.Contenido;
import gui.contenido.Demostracion;
import gui.contenido.Ejercicios;
import gui.contenido.Lienzo;
import gui.contenido.Texto;
import gui.contenido.TextPane;
import gui.editor.Editor;
import gui.simulador.simuladores.Punto;
import gui.simulador.simuladores.recursividad.Factorial;
import gui.simulador.simuladores.recursividad.Potencia;
import tools.Archivos;
import tools.Constrains;
import tools.Fuentes;
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
        Lienzo lienzo = new Lienzo(new GridBagLayout(), true);
        Constrains.addCompY(new Boton("TDA", "Tipos de Datos Abstratos", Archivos.image("/resources/image/TDA.png", -1, -1), Eventos.menu(Paneles.TDA, Paneles.SIMULADOR_TDA), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.TDA);
            }
        }), lienzo,new Rectangle(0, 0, 1, 4), 0, new Insets( 30, 57, 30, 18), GridBagConstraints.CENTER, GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Modularidad", "Division de tareas", Archivos.image("/resources/image/Modularidad y Mapas.png", -1, -1), Eventos.menu(Paneles.MODULARIDAD, Paneles.DEMOSTRACION_MODULARIDAD), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.MODULARIDAD);
            }
        }), lienzo, new Rectangle(1, 0, 1, 1), 0, new Insets(30, 18, 0, 18), GridBagConstraints.CENTER, GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Recursividad", "Métodos Recursivos", Archivos.image("/resources/image/Recursividad.png", -1, -1), Eventos.menu(Paneles.RECURSIVIDAD, Paneles.EJERCICIOS_RECURSIVIDAD, Paneles.FACTORIAL, Paneles.POTENCIA), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.RECURSIVIDAD);
            }
        }), lienzo, new Rectangle(1, 1, 1, 1), 0, new Insets(13, 18, 13, 18), GridBagConstraints.CENTER, GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Arreglos", "Vectores y Matrices", Archivos.image("/resources/image/Arreglos y Arboles.png", -1, -1), Eventos.menu(Paneles.ARREGLOS), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.ARREGLOS);
            }
        }), lienzo, new Rectangle(1, 2, 1, 1), 0, new Insets(13, 18, 13, 18), GridBagConstraints.CENTER, GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Nodos", "Enlazamiento de Datos", Archivos.image("/resources/image/Nodos.png", -1, -1), Eventos.menu(Paneles.NODOS), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.NODOS);
            }
        }), lienzo, new Rectangle(1, 3, 1, 1), 0, new Insets(13, 18, 30, 18), GridBagConstraints.CENTER, GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Ordenamiento", "Métodos de Ordenamiento Interno", Archivos.image("/resources/image/Ordenamiento.png", -1, -1), Eventos.menu(Paneles.ORDENAMIENTO), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.ORDENAMIENTO);
            }
        }), lienzo, new Rectangle(2, 0, 1, 2), 0, new Insets( 30, 18, 13, 18), GridBagConstraints.SOUTH, GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Busqueda", "Métodos de Busqueda", Archivos.image("/resources/image/Busqueda.png", -1, -1), Eventos.menu(Paneles.BUSQUEDA), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.BUSQUEDA);
            }
        }), lienzo, new Rectangle(2, 2, 1, 2), 0, new Insets( 13, 18, 30, 18), GridBagConstraints.NORTH, GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Pilas", "Pilas Dinámicas y Estáticas", Archivos.image("/resources/image/Pilas.png", -1, -1), Eventos.menu(Paneles.PILAS), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.PILAS);
            }
        }), lienzo, new Rectangle(3, 0, 1, 2), 0, new Insets( 30, 18, 13, 18), GridBagConstraints.CENTER, GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Colas", "Colas Dinámicas y Estáticas", Archivos.image("/resources/image/Colas.png", -1, -1), Eventos.menu(Paneles.COLAS), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.COLAS);
            }
        }), lienzo, new Rectangle(3, 1, 1, 2), 0, new Insets(13, 18, 13, 13), GridBagConstraints.CENTER, GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Listas", "Listas Enlazadas", Archivos.image("/resources/image/Listas Enlazadas.png", -1, -1), Eventos.menu(Paneles.LISTAS_ENLAZADAS), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.LISTAS_ENLAZADAS);
            }
        }), lienzo, new Rectangle(3, 2, 1, 2), 0, new Insets(13, 18, 30, 18), GridBagConstraints.CENTER, GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Árboles", "Árboles Binarios y AVL", Archivos.image("/resources/image/Arreglos y Arboles.png", -1, -1), Eventos.menu(Paneles.ARBOLES), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.ARBOLES);
            }
        }),lienzo,new Rectangle(4, 0, 1, 2), 0, new Insets(30, 18, 13, 75), GridBagConstraints.SOUTH, GridBagConstraints.NONE);
        Constrains.addCompY(new Boton("Grafos", "Algoritmo del Camino más Corto", Archivos.image("/resources/image/Grafos.png", -1, -1), Eventos.menu(Paneles.GRAFOS), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.show(Paneles.GRAFOS);
            }
        }), lienzo, new Rectangle(4, 2, 1, 2), 0, new Insets(13, 18, 30, 75), GridBagConstraints.NORTH, GridBagConstraints.NONE);
        Constrains.addComp(new Boton("Acerca de Seros", Archivos.image("/resources/image/about.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Eventos.about(lienzo);
            }
        }), lienzo, new Rectangle(6, 3, 1, 1), 0, 0, new Insets(0, 0, 6, 0), GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE);
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
     * @see Punto
     * @see Contenedor#tda()
     */
    private Punto simuladorTda(){
        JSpinner x=new JSpinner(new SpinnerNumberModel(0,-10,10,1));
        JSpinner y=new JSpinner(new SpinnerNumberModel(0,-10,10,1));
        ((JSpinner.NumberEditor)x.getEditor()).getTextField().setEditable(false);
        ((JSpinner.NumberEditor)y.getEditor()).getTextField().setEditable(false);
        return new Punto(x, y);
    }
    /**
     * Simulador para la temática Recursividad<br>
     * Simulador para el proceso recursivo del factorial
     * @return simulador factorial
     * @see Factorial
     * @see Contenedor#recursividad()
     */
    private Factorial factorial(){
        JSpinner valorDato=new JSpinner(new SpinnerNumberModel(0,0,10,1));
        ((JSpinner.NumberEditor)valorDato.getEditor()).getTextField().setEditable(false);
        return new Factorial(valorDato);
    }
    /**
     * Simulador para la temática Recursividad<br>
     * Simulador para el proceso recursivo del potencia
     * @return simulador potencia
     * @see Potencia
     * @see Contenedor#recursividad()
     */
    private Potencia potencia(){
        JSpinner valorBase = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        JSpinner valorExponente = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        ((JSpinner.NumberEditor) valorBase.getEditor()).getTextField().setEditable(false);
        ((JSpinner.NumberEditor) valorExponente.getEditor()).getTextField().setEditable(false);
        return new Potencia(valorBase, valorExponente);
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