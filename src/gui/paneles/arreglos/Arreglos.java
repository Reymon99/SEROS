package gui.paneles.arreglos;
import gui.contenido.Contenido;
import gui.contenido.Texto;
import tools.Constrains;
import tools.Text;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Arreglos extends Contenido {
    public Arreglos() {
        getTitle().setText("Arreglos");
        getNext().setToolTipText("");
        getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        Constrains.addComp(new Texto(Text.ARREGLOS.toString()),getContenido(),0,0,1,1,1,1,10, 25, 15, 12, GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new Texto(Text.ARREGLOS1.toString()),getContenido(),0,2,1,1,1,1,10, 25, 15, 12, GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new Texto(Text.ARREGLOS2.toString()),getContenido(),0,4,1,1,1,1,10, 25, 15, 12, GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
    }
}