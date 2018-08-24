package gui.principal;
import logica.*;
import logica.Image;
import javax.swing.*;
import java.awt.*;
public class Principal extends JPanel {
    public Principal(){
        setLayout(new GridBagLayout());
        init();
    }
    private void init() {
        JLabel tda=label("TDA",Image.image("/image/TDA.png",88,-1));
        JLabel modularidad=label("Modularidad", Image.image("/image/Modularidad y Mapas.png",88,-1));
        JLabel recursividad=label("Recursividad",Image.image("/image/Recursividad.png",88,-1));
        JLabel arreglos=label("Arreglos",Image.image("/image/Arreglos y Arboles.png",88,-1));
        JLabel nodos=label("Nodos",Image.image("/image/Nodos.png",88,-1));
        JLabel ordenamiento=label("Ordenamiento",Image.image("/image/Ordenamiento.png",88,-1));
        JLabel busqueda=label("Busqueda",Image.image("/image/Busqueda.png",88,-1));
        JLabel pila=label("Pilas",Image.image("/image/Pilas.png",88,-1));
        JLabel cola=label("Colas",Image.image("/image/Colas.png",88,-1));
        JLabel lista=label("Listas",Image.image("/image/Listas Enlazadas.png",88,-1));
        JLabel arboles=label("Árboles",Image.image("/image/Arreglos y Arboles.png",88,-1));
        JLabel grafos=label("Grafos",Image.image("/image/Grafos.png",88,-1));
        JLabel mapas=label("Mapas",Image.image("/image/Modularidad y Mapas.png",88,-1));
        JLabel hash=label("Tablas Hash",Image.image("/image/Hash.png",88,-1));
        Constrains.addCompY(tda,this,0,0,1,4,1,30,35,30,13,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(modularidad, this,1,0,1,1,1,30,13,0,13,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(recursividad,this,1,1,1,1,1,13,13,13,13,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(arreglos,this,1,2,1,1,1,13,13,13,13,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(nodos,this,1,3,1,1,1,13,13,30,13,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(ordenamiento,this,2,0,1,2,1,30,13,13,13, GridBagConstraints.SOUTH, GridBagConstraints.NONE);
        Constrains.addCompY(busqueda,this,2,2,1,2,1,13,13,30,13,GridBagConstraints.NORTH,GridBagConstraints.NONE);
        Constrains.addCompY(pila,this,3,0,1,2,1,30,13,13,13,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(cola,this,3,1,1,2,1,13,13,13,13,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(lista,this,3,2,1,2,1,13,13,30,13,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompY(arboles,this,4,0,1,2,1,30,13,13,13,GridBagConstraints.SOUTH,GridBagConstraints.NONE);
        Constrains.addCompY(grafos,this,4,2,1,2,1,13,13,30,13,GridBagConstraints.NORTH,GridBagConstraints.NONE);
        Constrains.addCompY(mapas,this,5,0,1,2,1,30,13,13,35,GridBagConstraints.SOUTH,GridBagConstraints.NONE);
        Constrains.addCompY(hash,this,5,2,1,2,1,13,13,30,35,GridBagConstraints.NORTH,GridBagConstraints.NONE);
    }
    private JLabel label(String text,ImageIcon icon){
        JLabel label=new JLabel(text,icon,SwingConstants.CENTER);
        label.setFont(Fuentes.purisa18);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return label;
    }
}