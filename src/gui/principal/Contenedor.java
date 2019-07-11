package gui.principal;
import eventos.Eventos;
import gui.contenido.Contenido;
import gui.contenido.Ejercicios;
import gui.contenido.TextPane;
import gui.contenido.Texto;
import gui.contenido.Boton;
import gui.simulador.Factorial;
import gui.simulador.Tda;
import gui.editor.Editor;
import tools.Archivos;
import tools.Constrains;
import tools.Fuentes;
import tools.Paneles;
import tools.Text;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Contenedor extends JPanel {
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
        add(Paneles.FACTORIAL.toString(),new Factorial());
        add(Paneles.PRINCIPAL.toString(), new Principal());
        add(Paneles.TDA.toString(), tda());
        add(Paneles.SIMULADORTDA.toString(), new Tda());
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
     * Contenido del panel TDA
     * @see Contenido
     * @see Tda
     */
    private Contenido tda(){
        Contenido con=new Contenido();
        con.getTitle().setText("Tipos de Datos Abstratos (tda)");
        con.getNext().setToolTipText("Simulador TDA");
        con.getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.SIMULADORTDA);
                Eventos.scroll(con.getPane(),0);
            }
        });
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
        con.getNext().setToolTipText("");
        con.getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.scroll(con.getPane(),0);
            }
        });
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
        con.getNext().setToolTipText("");
        con.getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.scroll(con.getPane(),0);
            }
        });
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
        con.getNext().setToolTipText("Panel de Ejercicios de Recursividad");
        con.getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.scroll(con.getPane(),0);
                Eventos.show(Paneles.EJERCICIOS_RECURSIVIDAD);
            }
        });
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
        con.getNext().setToolTipText("");
        con.getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.scroll(con.getPane(),0);
            }
        });
        return con;
    }
    /**
     * Contenido del panel Nodos
     * @see Contenido
     */
    private Contenido nodos(){
        Contenido con = new Contenido();
        con.getTitle().setText("Nodos");
        con.getNext().setToolTipText("");
        con.getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.scroll(con.getPane(),0);
            }
        });
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
        con.getNext().setToolTipText("");
        con.getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.scroll(con.getPane(),0);
            }
        });
        return con;
    }
    /**
     * Contenido del panel Grafos
     * @see Contenido
     */
    private Contenido grafos(){
        Contenido con = new Contenido();
        con.getTitle().setText("Grafos");
        con.getNext().setToolTipText("");
        con.getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.scroll(con.getPane(),0);
            }
        });
        return con;
    }
    /**
     * Contenido del panel Colas
     * @see Contenido
     */
    private Contenido colas(){
        Contenido con = new Contenido();
        con.getTitle().setText("Colas");
        con.getNext().setToolTipText("");
        con.getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.scroll(con.getPane(),0);
            }
        });
        return con;
    }
    /**
     * Contenido del panel Busqueda
     * @see Contenido
     */
    private Contenido busqueda(){
        Contenido con = new Contenido();
        con.getTitle().setText("Busqueda");
        con.getNext().setToolTipText("");
        con.getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.scroll(con.getPane(),0);
            }
        });
        return con;
    }
    /**
     * Contenido del panel Arreglos
     * @see Contenido
     */
    private Contenido arreglos(){
        Contenido con = new Contenido();
        con.getTitle().setText("Arreglos");
        con.getNext().setToolTipText("");
        con.getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.scroll(con.getPane(),0);
            }
        });
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
        con.getNext().setToolTipText("");
        con.getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.scroll(con.getPane(),0);
            }
        });
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
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                switch (((Boton) e.getSource()).getText()) {
                    case "Factorial" -> ejercicios.getTexto().setText("Simulador recursivo para factorial");
                    case "Potencia" -> ejercicios.getTexto().setText("Simulación recursiva para Potencia");
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
}