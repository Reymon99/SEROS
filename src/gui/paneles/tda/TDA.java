package gui.paneles.tda;
import eventos.Eventos;
import gui.contenido.*;
import gui.editor.Editor;
import tools.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
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
        JLabel formula=new JLabel(Text.FORMULATDA.toString(),SwingConstants.CENTER);
        formula.setFont(Fuentes.PURISA18.getFont());
        formula.setOpaque(false);
        formula.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Constrains.addComp(new Texto(Text.TDA.toString()), getContenido(), 0, 0, 1, 1, 1,1, 10, 25, 15, 12, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);
        Constrains.addComp(Editor.editor("/recourses/codes/tda/Punto.txt"),getContenido(),0,1,1,1,0,0,5,5,5,5,GridBagConstraints.CENTER, GridBagConstraints.NONE);
        Constrains.addComp(new Texto(Text.TDA1.toString()), getContenido(),0,2,1,1,1,1,10,25,3,12, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new Texto(Text.TDA2.toString()), getContenido(),0,3,1,1,1,1,3,40,3,12, GridBagConstraints.NORTHEAST,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(new Texto(Text.TDA3.toString()), getContenido(),0,4,1,1,1,1,3,25,5,12, GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(formula, getContenido(),0,5,1,1,1,1,10,25,20,25, GridBagConstraints.CENTER,GridBagConstraints.NONE);
    }
}