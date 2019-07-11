package gui.principal;
import eventos.Eventos;
import gui.contenido.*;
import gui.editor.Editor;
import gui.simulador.Simulador;
import gui.simulador.liezos.Graficador;
import tools.Archivos;
import tools.Constrains;
import tools.Fuentes;
import tools.Paneles;
import tools.Text;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public final class Contenedor extends JPanel {
    /**
     * Contenedor de los paneles del proyecto
     */
    protected Contenedor() {
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
        add(Paneles.PRINCIPAL.toString(), principal());
        add(Paneles.TDA.toString(), tda());
        add(Paneles.SIMULADORTDA.toString(), simuladorTda());
        add(Paneles.MODULARIDAD.toString(), modularidad());
        add(Paneles.RECURSIVIDAD.toString(), recursividad());
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
        Lienzo lienzo=new Lienzo(new GridBagLayout(),true) {
            @Override
            public void clean() {//None
            }
        };
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
        ejercicios.setBotones(new Boton(Archivos.image("/recourses/image/factorial.png", -1, -1), "Factorial", mouse),
                new Boton(Archivos.image("/recourses/image/potencia.png", -1, -1), "Potencia", mouse));
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
        Simulador simulador=new Simulador(new Graficador()) {
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
        return simulador;
    }
}