package gui.tda;
import fuentes.Fuentes;
import gui.editor.Editor;
import logica.Constrains;
import logica.TXT;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

public class TDA extends JPanel {
    public TDA(){
        setLayout(new GridBagLayout());
        init();
    }
    private void init(){
        JLabel title=new JLabel("Tipos de Datos Abstratos (TDA)",SwingConstants.CENTER);
        title.setFont(Fuentes.PURISA30.getFont());
        JTextPane area=new JTextPane();
        area.setFont(Fuentes.MYHAPPYENDING30.getFont());
        area.setMargin(new Insets(5,5,7,7));
        area.setEditable(false);
        area.setOpaque(false);
        area.setPreferredSize(new Dimension(150,40));
        try {
            SimpleAttributeSet set1=new SimpleAttributeSet();
            int pos=area.getStyledDocument().getLength();
            area.getStyledDocument().setParagraphAttributes(pos,area.getStyledDocument().getLength(),set1,false);
            StyleConstants.setAlignment(set1,StyleConstants.ALIGN_LEFT);
            area.getStyledDocument().insertString(pos,TXT.TDA.toString(),set1);
        } catch (BadLocationException e) {

        }
        Editor editor=new Editor();
        JPanel panel=new JPanel(new BorderLayout());
        panel.add(editor,BorderLayout.WEST);
        panel.add(editor.scroll,BorderLayout.CENTER);
        try {
            editor.text(getClass().getResource("/codes/Punto.txt").toURI().getPath());
        } catch (IOException e) {
            System.err.println("Joder");
        } catch (URISyntaxException e) {
            System.err.println("Joder");
        }
        JTextPane area1=new JTextPane();
        area1.setFont(Fuentes.MYHAPPYENDING30.getFont());
        area1.setMargin(new Insets(5,5,7,7));
        area1.setEditable(false);
        area1.setOpaque(false);
        area1.setPreferredSize(new Dimension(150,40));
        try {
            SimpleAttributeSet set1=new SimpleAttributeSet();
            int pos=area1.getStyledDocument().getLength();
            area1.getStyledDocument().setParagraphAttributes(pos,area1.getStyledDocument().getLength(),set1,false);
            StyleConstants.setAlignment(set1,StyleConstants.ALIGN_LEFT);
            area1.getStyledDocument().insertString(pos,TXT.TDA1.toString(),set1);
        } catch (BadLocationException e) {

        }
        Constrains.addCompX(title,this,0,0,1,1,1,20,5,15,5,GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        Constrains.addCompI(area,this,0,1,1,1,1,1,28,27,5,30,90,30,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(panel,this,0,2,1,1,1,1,5,50,15,50, GridBagConstraints.NORTH,GridBagConstraints.VERTICAL);
        Constrains.addCompI(area1,this,0,3,1,1,1,1,20,27,15,30,90,30,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL);
    }
    @Override
    public void paint(Graphics g) {
        g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/Lienzo.jpg")),0,0,getWidth(),getHeight(),this);
        setOpaque(false);
        super.paint(g);
    }
}