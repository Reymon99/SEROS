package gui.editor;
import fuentes.Fuentes;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.*;
public class Editor extends JPanel {
    private JTextPane editor;
    public JScrollPane scroll;
    /**
     * Editor sintexico de codigo utilizado en la interfaz grafica del proyecto
     */
    public Editor(){
        setPreferredSize(new Dimension(30,30));
        setMinimumSize(new Dimension(30,30));
        setMaximumSize(new Dimension(30,30));
        setBackground(new Color(73, 72, 76));
        editor=new JTextPane(){
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                Editor.this.repaint();
            }
        };
        editor.setContentType("text/plain");
        editor.setBackground(new Color(48,47,51));
        editor.setForeground(Color.WHITE);
        editor.setFont(Fuentes.UBUNTULIGHT15.getFont());
        editor.setEditable(false);
        editor.setMargin(new Insets(0,10,5,0));
        editor.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        scroll=new JScrollPane(editor);
        repaint();
    }
    /**
     * Decodifica el texto del archivo para diferenciar los diferentes colores de la sintaxis
     * @param n {@link String}
     * @throws IOException
     */
    public void text(String n) throws IOException {
        for (String e:n.replaceAll("\t","       ").split("_")){
            if (e.endsWith("n")) append(e.substring(0,e.length()-1), logica.Color.NARANJA.getColor());
            else if(e.endsWith("m")) append(e.substring(0,e.length()-1), logica.Color.MORADO.getColor());
            else if(e.endsWith("a")) append(e.substring(0,e.length()-1), logica.Color.AMARILLO.getColor());
            else if(e.endsWith("b")) append(e.substring(0,e.length()-1), logica.Color.AZUL.getColor());
            else if(e.endsWith("v")) append(e.substring(0,e.length()-1), logica.Color.VERDE.getColor());
            else if(e.endsWith("w")) append(e.substring(0,e.length()-1), logica.Color.BLANCO.getColor());
        }
    }
    /**
     * Añade texto de un determinado color al editor
     * @param n {@link String}
     * @param color {@link Color}
     */
    private void append(String n, Color color){
        editor.setEditable(true);
        StyleContext sc=StyleContext.getDefaultStyleContext();
        AttributeSet set=sc.addAttribute(SimpleAttributeSet.EMPTY,StyleConstants.Foreground,color);
        editor.setCaretPosition(editor.getStyledDocument().getLength());
        editor.setCharacterAttributes(set,false);
        editor.replaceSelection(n);
        editor.setCaretPosition(editor.getStyledDocument().getLength());
        editor.setEditable(false);
    }
    /**
     * Define texto al editor sin diferenciacion de sintaxis
     * @param text {@link String}
     */
    public void setText(String text){
        editor.setText(text);
    }
    /**
     * Dibuja una columna con los indices de las filas de texto
     * @param g {@link Graphics}
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D d=(Graphics2D)g;
        d.setPaint(Color.WHITE);
        int start=editor.viewToModel(scroll.getViewport().getViewPosition()),end=editor.viewToModel(new Point(scroll.getViewport().getViewPosition().x+editor.getWidth(),scroll.getViewport().getViewPosition().y+editor.getHeight())),startline=editor.getDocument().getDefaultRootElement().getElementIndex(start),endline=editor.getDocument().getDefaultRootElement().getElementIndex(end),fontHeight=g.getFontMetrics(editor.getFont()).getHeight(),line=startline;
        for (int y=0;line-1<=endline;y+=fontHeight,line++) d.drawString(String.valueOf(line),6,y);
    }
}