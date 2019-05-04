package gui.paneles.tda;
import eventos.Eventos;
import gui.contenido.*;
import gui.editor.Editor;
import tools.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class TDA extends Contenido {
    /**
     * Contenido del panel TDA
     * @see Contenido
     * @see SimuladorTDA
     * @author Sergio Majé
     */
    public TDA(){
        getTitle().setText("Tipos de Datos Abstratos (tda)");
        getBack().setToolTipText("Ventana Principal");
        getBack().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.PRINCIPAL.toString());
            }
        });
        getNext().setToolTipText("Simulador TDA");
        getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        //pane con ipadx
        JTextArea area=new Texto(Text.TDA.toString());
        Constrains.addCompX(area, getContenido(), 0, 0, 1, 1, 1, 10, 25, 15, 12, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);
        Constrains.addComp(Editor.editor("/recourses/codes/tda/Punto.txt"),getContenido(),0,1,1,1,0,0,5,5,5,5,GridBagConstraints.CENTER, GridBagConstraints.NONE);
        //Constrains.addComp(,getContenido(),0,2,1,1,0.3,0.3,10,25,8,12,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
    }
}