package gui.principal;
import eventos.Eventos;
import gui.contenido.Boton;
import gui.contenido.Lienzo;
import tools.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Principal extends Lienzo {
    /**
     * Menu principal de la interfaz grafica del proyecto
     */
    public Principal(){
        setLayout(new GridBagLayout());
        init();
    }
    private void init()  {
        JLabel tda=new Boton("TDA","Tipos de Datos Abstratos", Archivos.image("/recourses/image/TDA.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.TDA);
            }
        });
        JLabel modularidad=new Boton("Modularidad","Complejidad Algoritmica", Archivos.image("/recourses/image/Modularidad y Mapas.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.MODULARIDAD);
            }
        });
        JLabel recursividad=new Boton("Recursividad","Metodos Recursivos", Archivos.image("/recourses/image/Recursividad.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.RECURSIVIDAD);
            }
        });
        JLabel arreglos=new Boton("Arreglos","Vectores y Matrices", Archivos.image("/recourses/image/Arreglos y Arboles.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.ARREGLOS);
            }
        });
        JLabel nodos=new Boton("Nodos","Enlazamiento de Datos", Archivos.image("/recourses/image/Nodos.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.NODOS);
            }
        });
        JLabel ordenamiento=new Boton("Ordenamiento", "Metodos de Ordenamiento Interno", Archivos.image("/recourses/image/Ordenamiento.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.ORDENAMIENTO);
            }
        });
        JLabel busqueda=new Boton("Busqueda","Metodos de Busqueda", Archivos.image("/recourses/image/Busqueda.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.BUSQUEDA);
            }
        });
        JLabel pila=new Boton("Pilas","Pilas Dinámicas y Estáticas", Archivos.image("/recourses/image/Pilas.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.PILAS);
            }
        });
        JLabel cola=new Boton("Colas","Colas Dinámicas y Estáticas", Archivos.image("/recourses/image/Colas.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.COLAS);
            }
        });
        JLabel lista=new Boton("Listas","Listas Enlazadas", Archivos.image("/recourses/image/Listas Enlazadas.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.LISTAS_ENLAZADAS);
            }
        });
        JLabel arboles=new Boton("Árboles","Árboles Binarios y AVL", Archivos.image("/recourses/image/Arreglos y Arboles.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.ARBOLES);
            }
        });
        JLabel grafos=new Boton("Grafos","Algoritmo del Camino más Corto", Archivos.image("/recourses/image/Grafos.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.GRAFOS);
            }
        });
        JLabel about=new Boton("Acerca de Seros", Archivos.image("/recourses/image/about.png",-1,-1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.about(Principal.this);
            }
        });
        Constrains.addCompY(tda,this,0,0,1,4,0,30,57,30,18,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(modularidad, this,1,0,1,1,0,30,18,0,18,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(recursividad,this,1,1,1,1,0,13,18,13,18,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(arreglos,this,1,2,1,1,0,13,18,13,18,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(nodos,this,1,3,1,1,0,13,18,30,18,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(ordenamiento,this,2,0,1,2,0,30,18,13,18, GridBagConstraints.SOUTH, GridBagConstraints.NONE);
        Constrains.addCompY(busqueda,this,2,2,1,2,0,13,18,30,18,GridBagConstraints.NORTH,GridBagConstraints.NONE);
        Constrains.addCompY(pila,this,3,0,1,2,0,30,18,13,18,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(cola,this,3,1,1,2,0,13,18,13,13,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(lista,this,3,2,1,2,0,13,18,30,18,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(arboles,this,4,0,1,2,0,30,18,13,75,GridBagConstraints.SOUTH,GridBagConstraints.NONE);
        Constrains.addCompY(grafos,this,4,2,1,2,0,13,18,30,75,GridBagConstraints.NORTH,GridBagConstraints.NONE);
        Constrains.addComp(about,this,6,3,1,1,0,0,0,0,6,0,GridBagConstraints.SOUTHEAST,GridBagConstraints.NONE);
    }
}