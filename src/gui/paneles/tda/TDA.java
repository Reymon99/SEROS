package gui.paneles.tda;
import eventos.Eventos;
import fuentes.Fuentes;
import gui.contenido.Contenido;
import gui.editor.Editor;
import logica.Archivos;
import logica.Constrains;
import logica.Paneles;
import logica.TXT;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
public class TDA extends Contenido {
    /**
     * Contenido del panel TDA
     * @see Contenido
     * @see SimuladorTDA
     * @see Graficador
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
    }
    /*private void init(){
        JTextArea area= new JTextArea(TXT.TDA.toString());
        area.setFont(Fuentes.UBUNTULIGHT20.getFont());
        area.setTabSize(4);
        area.setEditable(false);
        area.setOpaque(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        Editor editor=new Editor();
        JPanel panel=new JPanel(new BorderLayout());
        panel.add(editor,BorderLayout.WEST);
        panel.add(editor.scroll,BorderLayout.CENTER);
        try {
            editor.text(Archivos.codefiles("/codes/tda/Punto.txt"));
        } catch (IOException e) {
            editor.setText(e.getMessage());
        }
        JTextArea area1=new JTextArea(TXT.TDA1.toString());
        area1.setEditable(false);
        area1.setLineWrap(true);
        area1.setFont(Fuentes.UBUNTULIGHT20.getFont());
        area1.setWrapStyleWord(true);
        area1.setTabSize(4);
        area1.setOpaque(false);
        JLabel formula=new JLabel(TXT.FORMULATDA.toString(),SwingConstants.CENTER);
        formula.setFont(Fuentes.PURISA15.getFont());
        formula.setOpaque(false);
        formula.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabel next=new JLabel(Archivos.image("/image/next.png",48,48));
        next.setCursor(new Cursor(Cursor.HAND_CURSOR));
        next.setOpaque(false);
        next.setToolTipText("Simulador");
        next.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.SIMULADORTDA.toString());
            }
        });
        Constrains.addComp(title,this,0,0,3,1,1,1,15,15,10,10,GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);
        Constrains.addCompX(area,this,0,1,3,1,1,10,10,5,7, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);
        Constrains.addComp(panel,this,1,2,1,1,0,0,5,5,5,5,GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addCompX(area1,this,0,3,3,1,1,10,10,8,7, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);
        Constrains.addComp(formula,this,1,4,1,1,1,0,0,10,15,10, GridBagConstraints.NORTH,GridBagConstraints.NONE);
        Constrains.addComp(back,this,0,5,1,1,0,0,10,2,2,2,GridBagConstraints.SOUTHWEST,GridBagConstraints.NONE);
        Constrains.addComp(next,this,2,5,1,1,0,0,10,2,2,2, GridBagConstraints.SOUTHEAST,GridBagConstraints.NONE);
    }*/
}