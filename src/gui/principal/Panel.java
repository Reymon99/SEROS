package gui.principal;
import eventos.Eventos;
import gui.contenido.Contenido;
import gui.simulador.lienzos.Graficador;
import gui.contenido.TextPane;
import gui.contenido.Texto;
import gui.editor.Editor;
import gui.simulador.Simulador;
import tools.Constrains;
import tools.Fuentes;
import tools.Paneles;
import tools.Text;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Panel extends JPanel {
    /**
     * Panel principal de proyecto
     * @author Sergio Majé
     */
    public Panel() {
        setLayout(new CardLayout());
        init();
        Eventos.setPanel(this);
    }
    /**
     * Se añaden los paneles secundarios al principal<br>
     * Se agrega el evento para circular entre los paneles
     * @see Eventos#setPanel(JPanel)
     * @author Sergio Majé
     */
    private void init() {
        add(Paneles.PRINCIPAL.toString(), new Principal());
        add(Paneles.TDA.toString(), tda());
        add(Paneles.SIMULADORTDA.toString(), simuladorTDA());
        add(Paneles.MODULARIDAD.toString(), modularidad());
        add(Paneles.RECURSIVIDAD.toString(), recursividad());
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
     * @see Panel#simuladorTDA()
     * @author Sergio Majé
     */
    private Contenido tda(){
        Contenido con=new Contenido();
        con.getTitle().setText("Tipos de Datos Abstratos (tda)");
        con.getNext().setToolTipText("Simulador TDA");
        con.getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        JLabel formula=new JLabel(Text.FORMULATDA.toString(),SwingConstants.CENTER);
        formula.setFont(Fuentes.PURISA18.getFont());
        formula.setOpaque(false);
        Constrains.addComp(new Texto(Text.TDA.toString()), con.getContenido(), 0, 0, 1, 1, 1,1, 10, 25, 15, 12, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);
        Constrains.addComp(Editor.editor("/recourses/codes/tda/Punto.txt"),con.getContenido(),0,1,1,1,0,0,5,5,5,5,GridBagConstraints.CENTER, GridBagConstraints.NONE);
        Constrains.addComp(new Texto(Text.TDA1.toString()), con.getContenido(),0,2,1,1,1,1,10,25,3,12, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new Texto(Text.TDA2.toString()), con.getContenido(),0,3,1,1,1,1,3,40,3,12, GridBagConstraints.NORTHEAST,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new Texto(Text.TDA3.toString()), con.getContenido(),0,4,1,1,1,1,5,25,5,12, GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(formula, con.getContenido(),0,5,1,1,1,1,10,25,5,25, GridBagConstraints.CENTER,GridBagConstraints.NONE);
        return con;
    }
    /**
     * Contenido del panel Modularidad
     * @see Contenido
     * @author Sergio Majé
     */
    private Contenido modularidad(){
        Contenido con =  new Contenido();
        con.getTitle().setText("Modularidad");
        con.getNext().setToolTipText("");
        con.getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        Constrains.addComp(new Texto(Text.MODULARIDAD.toString()),con.getContenido(),0,0,1,1,1,1,10, 25, 15, 12, GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new Texto(Text.MODULARIDAD1.toString()),con.getContenido(),0,1,1,1,1,1,10, 25, 15, 12, GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        return con;
    }
    /**
     * Contenido del panel Pilas
     * @see Contenido
     * @author Sergio Majé
     */
    private Contenido pilas(){
        Contenido con = new Contenido();
        con.getTitle().setText("Pilas");
        con.getNext().setToolTipText("");
        con.getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        return con;
    }
    /**
     * Contenido del panel Recursividad
     * @see Contenido
     * @author Sergio Majé
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
        Constrains.addComp(new Texto(Text.RECURSIVIDAD.toString()), con.getContenido(), 0,0,1,1,1,1,10, 25, 1, 12, GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(editor, con.getContenido(),0,1,1,1,0.2,1,2,25,180,25, GridBagConstraints.NORTH,GridBagConstraints.NONE);
        return con;
    }
    /**
     * Contenido del panel Ordenamiento
     * @see Contenido
     * @author Sergio Majé
     */
    private Contenido ordenamiento(){
        Contenido con= new Contenido();
        con.getTitle().setText("Ordenamiento");
        con.getNext().setToolTipText("");
        con.getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        return con;
    }
    /**
     * Contenido del panel Nodos
     * @see Contenido
     * @author Sergio Majé
     */
    private Contenido nodos(){
        Contenido con = new Contenido();
        con.getTitle().setText("Nodos");
        con.getNext().setToolTipText("");
        con.getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        Constrains.addComp(new Texto(Text.NODOS.toString()),con.getContenido(),0,0,1,1,1,1,10, 25, 15, 12, GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new Texto(Text.NODOS1.toString()),con.getContenido(),0,2,1,1,1,1,10, 25, 15, 12, GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new Texto(Text.NODOS2.toString()),con.getContenido(),0,4,1,1,1,1,10, 25, 5, 12, GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        return con;
    }
    /**
     * Contenido del panel Listas
     * @see Contenido
     * @author Sergio Majé
     */
    private Contenido listas(){
        Contenido con=new Contenido();
        con.getTitle().setText("Listas Enlazadas");
        con.getNext().setToolTipText("");
        con.getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        return con;
    }
    /**
     * Contenido del panel Grafos
     * @see Contenido
     * @author Sergio Majé
     */
    private Contenido grafos(){
        Contenido con = new Contenido();
        con.getTitle().setText("Grafos");
        con.getNext().setToolTipText("");
        con.getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        return con;
    }
    /**
     * Contenido del panel Colas
     * @see Contenido
     * @author Sergio Majé
     */
    private Contenido colas(){
        Contenido con = new Contenido();
        con.getTitle().setText("Colas");
        con.getNext().setToolTipText("");
        con.getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        return con;
    }
    /**
     * Contenido del panel Busqueda
     * @see Contenido
     * @author Sergio Majé
     */
    private Contenido busqueda(){
        Contenido con = new Contenido();
        con.getTitle().setText("Busqueda");
        con.getNext().setToolTipText("");
        con.getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        return con;
    }
    /**
     * Contenido del panel Arreglos
     * @see Contenido
     * @author Sergio Majé
     */
    private Contenido arreglos(){
        Contenido con = new Contenido();
        con.getTitle().setText("Arreglos");
        con.getNext().setToolTipText("");
        con.getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        Constrains.addComp(new Texto(Text.ARREGLOS.toString()),con.getContenido(),0,0,1,1,1,1,10, 25, 15, 12, GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new Texto(Text.ARREGLOS1.toString()),con.getContenido(),0,2,1,1,1,1,10, 25, 15, 12, GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new Texto(Text.ARREGLOS2.toString()),con.getContenido(),0,4,1,1,1,1,10, 25, 5, 12, GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        return con;
    }
    /**
     * Contenido del panel Arboles
     * @see Contenido
     * @author Sergio Majé
     */
    private Contenido arboles(){
        Contenido con = new Contenido();
        con.getTitle().setText("Arboles");
        con.getNext().setToolTipText("");
        con.getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        return con;
    }
    /**
     * Simulador enfocado a explicar los TDA
     * @see Simulador#Simulador(Canvas)
     * @see Graficador
     * @author Sergio Majé
     */
    private Simulador simuladorTDA(){
        Simulador simulador=new Simulador(new Graficador());
        simulador.getTexto().setText(Text.SIMULADORTDA2.toString());
        simulador.getBack().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.TDA);
            }
        });
        simulador.addCodes(Editor.editor("/recourses/codes/tda/MainPunto.txt"),"Main");
        simulador.addCodes(Editor.editor("/recourses/codes/tda/Punto.txt"),"Punto");
        return simulador;
    }
}