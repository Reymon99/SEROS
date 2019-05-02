package gui.principal;
import eventos.Eventos;
import gui.paneles.about.About;
import tools.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Principal extends JPanel {
    /**
     * Menu principal de la interfaz grafica del proyecto
     * @author Sergio Majé
     */
    public Principal(){
        setLayout(new GridBagLayout());
        init();
    }
    private void init()  {
        JLabel tda=label("TDA","Tipos de Datos Abstratos", Archivos.image("/recourses/image/TDA.png", 88, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.TDA.toString());
            }
        });
        JLabel modularidad=label("Modularidad","Complejidad Algoritmica", Archivos.image("/recourses/image/Modularidad y Mapas.png", 88, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        JLabel recursividad=label("Recursividad","Metodos Recursivos", Archivos.image("/recourses/image/Recursividad.png", 88, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        JLabel arreglos=label("Arreglos","Vectores y Matrices", Archivos.image("/recourses/image/Arreglos y Arboles.png", 88, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        JLabel nodos=label("Nodos","Enlazamiento de Datos", Archivos.image("/recourses/image/Nodos.png", 88, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        JLabel ordenamiento=label("Ordenamiento", "Metodos de Ordenamiento Interno", Archivos.image("/recourses/image/Ordenamiento.png", 88, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        JLabel busqueda=label("Busqueda","Metodos de Busqueda", Archivos.image("/recourses/image/Busqueda.png", 88, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        JLabel pila=label("Pilas","Pilas Dinamicas y Estaticas", Archivos.image("/recourses/image/Pilas.png", 88, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        JLabel cola=label("Colas","Colas Dinamicas y Estaticas", Archivos.image("/recourses/image/Colas.png", 88, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        JLabel lista=label("Listas","Listas Enlazadas", Archivos.image("/recourses/image/Listas Enlazadas.png", 88, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        JLabel arboles=label("Árboles","Arboles Binarios y AVL", Archivos.image("/recourses/image/Arreglos y Arboles.png", 88, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        JLabel grafos=label("Grafos","Algoritmo del Camino más Corto", Archivos.image("/recourses/image/Grafos.png", 88, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        JLabel about=label("", "Acerca de", Archivos.image("/recourses/image/about.png",48,48), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new About().setVisible(true);
                System.gc();
            }
        });
        Constrains.addCompY(tda,this,0,0,1,4,0.1,30,57,30,18,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(modularidad, this,1,0,1,1,0.1,30,18,0,18,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(recursividad,this,1,1,1,1,0.1,13,18,13,18,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(arreglos,this,1,2,1,1,0.1,13,18,13,18,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(nodos,this,1,3,1,1,0.1,13,18,30,18,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(ordenamiento,this,2,0,1,2,0.1,30,18,13,18, GridBagConstraints.SOUTH, GridBagConstraints.NONE);
        Constrains.addCompY(busqueda,this,2,2,1,2,0.1,13,18,30,18,GridBagConstraints.NORTH,GridBagConstraints.NONE);
        Constrains.addCompY(pila,this,3,0,1,2,0.1,30,18,13,18,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(cola,this,3,1,1,2,0.1,13,18,13,13,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(lista,this,3,2,1,2,0.1,13,18,30,18,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(arboles,this,4,0,1,2,0.1,30,18,13,75,GridBagConstraints.SOUTH,GridBagConstraints.NONE);
        Constrains.addCompY(grafos,this,4,2,1,2,0.1,13,18,30,75,GridBagConstraints.NORTH,GridBagConstraints.NONE);
        Constrains.addComp(about,this,6,3,1,1,0,0,0,0,6,0,GridBagConstraints.SOUTHEAST,GridBagConstraints.NONE);
    }
    /**
     * Etiqueta con parametros predefinidos enfocados hacia el proyecto
     * @param text {@link String} text de la etiqueta
     * @param tip {@link String} tool tip de la etiqueta
     * @param icon {@link ImageIcon} icono de la etiqueta
     * @param adapter {@link MouseAdapter} evento del mouse de la etiqueta
     * @return label {@link JLabel}
     * @author Sergio Majé
     */
    private JLabel label(String text,String tip, ImageIcon icon, MouseAdapter adapter){
        JLabel label=new JLabel(text,icon,SwingConstants.CENTER);
        label.setFont(Fuentes.PURISA18.getFont());
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.setToolTipText(tip);
        label.addMouseListener(adapter);
        return label;
    }
    /**
     * Tapiz del panel
     * @param g {@link Graphics}
     * @author Sergio Majé
     */
    @Override
    public void paint(Graphics g) {
        g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/recourses/image/Lienzo.jpg")),0,0,getWidth(),getHeight(),this);
        setOpaque(false);
        super.paint(g);
    }
}