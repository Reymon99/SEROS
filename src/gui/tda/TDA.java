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
        setBackground(new Color(238,238,238));
    }
    private void init(){
        JTextPane pane=new JTextPane();
        pane.setPreferredSize(new Dimension(900,300));
        pane.setEditable(false);
        pane.setFont(Fuentes.PURISA18.getFont());
        pane.setBackground(new Color(238,238,238));
        JScrollPane s=new JScrollPane(pane);
        s.setBorder(BorderFactory.createEmptyBorder());
        Constrains.addComp(s,this,0,0,1,1,1,1,10,30,10,20,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        text(pane);
    }
    private void text(JTextPane pane) {
        try {
            int pos=0;
            SimpleAttributeSet set=new SimpleAttributeSet();
            pane.getStyledDocument().insertString(pos,"Tipos de Datos Abstratos (TDA)",set);
            StyleConstants.setFontSize(set,27);
            StyleConstants.setBold(set,true);
            StyleConstants.setAlignment(set,StyleConstants.ALIGN_CENTER);
            pane.getStyledDocument().setParagraphAttributes(pos,pane.getStyledDocument().getLength(),set,false);
            insertaNuevaLinea(pane);
            insertaNuevaLinea(pane);
            pos=pane.getStyledDocument().getLength();
            SimpleAttributeSet set1=new SimpleAttributeSet();
            pane.getStyledDocument().insertString(pos,TXT.TDA.toString(),set1);
            StyleConstants.setAlignment(set1,StyleConstants.ALIGN_JUSTIFIED);
            StyleConstants.setFontSize(set1,15);
            pane.getStyledDocument().setParagraphAttributes(pos,pane.getStyledDocument().getLength(),set1,false);
            insertaNuevaLinea(pane);
            insertaNuevaLinea(pane);
            pos=pane.getStyledDocument().getLength();
            pane.setCaretPosition(pos);
            Editor editor=new Editor();
            JPanel panel=new JPanel(new BorderLayout());
            panel.add(editor,BorderLayout.WEST);
            panel.add(editor.scroll,BorderLayout.CENTER);
            pane.insertComponent(panel);
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
            editor.append(logica.Color.BLANCO.getColor(),"y) {\n");
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
        } catch (BadLocationException e) {

        }
    }
    private void insertaNuevaLinea(JTextPane editor) throws BadLocationException {
        editor.getStyledDocument().insertString(editor.getStyledDocument().getLength(),System.getProperty("line.separator"),null);
    }
}