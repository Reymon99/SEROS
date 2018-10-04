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
        text(editor);
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
    private void text(Editor editor) {
        editor.append(logica.Color.NARANJA.getColor(),"public class ");
        editor.append(logica.Color.BLANCO.getColor(),"Punto {\n");
        editor.append(logica.Color.NARANJA.getColor(),"      private int ");
        editor.append(logica.Color.MORADO.getColor(),"x");
        editor.append(logica.Color.NARANJA.getColor(),", ");
        editor.append(logica.Color.MORADO.getColor(),"y");
        editor.append(logica.Color.NARANJA.getColor(),";\n      public ");
        editor.append(logica.Color.AMARILLO.getColor(),"Punto");
        editor.append(logica.Color.BLANCO.getColor(),"(");
        editor.append(logica.Color.NARANJA.getColor(),"int ");
        editor.append(logica.Color.BLANCO.getColor(),"x");
        editor.append(logica.Color.NARANJA.getColor(),", int ");
        editor.append(logica.Color.BLANCO.getColor(),"y) {\t\n");
        editor.append(logica.Color.NARANJA.getColor(),"            this");
        editor.append(logica.Color.BLANCO.getColor(),".");
        editor.append(logica.Color.MORADO.getColor(),"x");
        editor.append(logica.Color.BLANCO.getColor()," = x");
        editor.append(logica.Color.NARANJA.getColor(),";\n");
        editor.append(logica.Color.NARANJA.getColor(),"            this");
        editor.append(logica.Color.BLANCO.getColor(),".");
        editor.append(logica.Color.MORADO.getColor(),"y");
        editor.append(logica.Color.BLANCO.getColor()," = y");
        editor.append(logica.Color.NARANJA.getColor(),";\n");
        editor.append(logica.Color.BLANCO.getColor(),"      }\n");
        editor.append(logica.Color.NARANJA.getColor(),"      public int ");
        editor.append(logica.Color.AMARILLO.getColor(),"getX");
        editor.append(logica.Color.BLANCO.getColor(),"() {\n");
        editor.append(logica.Color.NARANJA.getColor(),"            return ");
        editor.append(logica.Color.MORADO.getColor(),"x");
        editor.append(logica.Color.NARANJA.getColor(),";\n");
        editor.append(logica.Color.BLANCO.getColor(),"      }\n");
        editor.append(logica.Color.NARANJA.getColor(),"      public int ");
        editor.append(logica.Color.AMARILLO.getColor(),"getY");
        editor.append(logica.Color.BLANCO.getColor(),"() {\n");
        editor.append(logica.Color.NARANJA.getColor(),"            return ");
        editor.append(logica.Color.MORADO.getColor(),"y");
        editor.append(logica.Color.NARANJA.getColor(),";\n");
        editor.append(logica.Color.BLANCO.getColor(),"      }\n");
        editor.append(logica.Color.NARANJA.getColor(),"      public int ");
        editor.append(logica.Color.AMARILLO.getColor(),"setX");
        editor.append(logica.Color.BLANCO.getColor(),"(");
        editor.append(logica.Color.NARANJA.getColor(),"int ");
        editor.append(logica.Color.BLANCO.getColor(),"x) {\n");
        editor.append(logica.Color.NARANJA.getColor(),"            this");
        editor.append(logica.Color.BLANCO.getColor(),".");
        editor.append(logica.Color.MORADO.getColor(),"x");
        editor.append(logica.Color.BLANCO.getColor()," = x");
        editor.append(logica.Color.NARANJA.getColor(),";\n");
        editor.append(logica.Color.BLANCO.getColor(),"      }\n");
        editor.append(logica.Color.NARANJA.getColor(),"      public int ");
        editor.append(logica.Color.AMARILLO.getColor(),"setY");
        editor.append(logica.Color.BLANCO.getColor(),"(");
        editor.append(logica.Color.NARANJA.getColor(),"int ");
        editor.append(logica.Color.BLANCO.getColor(),"y) {\n");
        editor.append(logica.Color.NARANJA.getColor(),"            this");
        editor.append(logica.Color.BLANCO.getColor(),".");
        editor.append(logica.Color.MORADO.getColor(),"y");
        editor.append(logica.Color.BLANCO.getColor()," = y");
        editor.append(logica.Color.NARANJA.getColor(),";\n");
        editor.append(logica.Color.BLANCO.getColor(),"      }\n");
        editor.append(logica.Color.AMARILLO.getColor(),"      @Override\n");
        editor.append(logica.Color.NARANJA.getColor(),"      public ");
        editor.append(logica.Color.BLANCO.getColor(),"String ");
        editor.append(logica.Color.AMARILLO.getColor(),"toString");
        editor.append(logica.Color.BLANCO.getColor(),"() {\n");
        editor.append(logica.Color.NARANJA.getColor(),"            return ");
        editor.append(logica.Color.VERDE.getColor(),"\"[\"");
        editor.append(logica.Color.BLANCO.getColor(),"+");
        editor.append(logica.Color.MORADO.getColor(),"x");
        editor.append(logica.Color.BLANCO.getColor(),"+");
        editor.append(logica.Color.VERDE.getColor(),"\",\"");
        editor.append(logica.Color.BLANCO.getColor(),"+");
        editor.append(logica.Color.MORADO.getColor(),"y");
        editor.append(logica.Color.BLANCO.getColor(),"+");
        editor.append(logica.Color.VERDE.getColor(),"\"]\"");
        editor.append(logica.Color.NARANJA.getColor(),";\n");
        editor.append(logica.Color.BLANCO.getColor(),"      }\n}");
    }
    private void insertaNuevaLinea(JTextPane editor) throws BadLocationException {
        editor.getStyledDocument().insertString(editor.getStyledDocument().getLength(),System.getProperty("line.separator"),null);
    }
    @Override
    public void paint(Graphics g) {
        g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/Lienzo.jpg")),0,0,getWidth(),getHeight(),this);
        setOpaque(false);
        super.paint(g);
    }
}