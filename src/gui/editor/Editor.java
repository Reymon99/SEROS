package gui.editor;
import gui.contenido.TextPane;
import tools.Archivos;
import tools.Color;
import javax.swing.*;
import java.awt.*;
import java.io.*;
public class Editor extends JPanel {
    private TextPane editor;
    private JScrollPane scroll;
    /**
     * Editor sintexico de codigo a utilizar en la interfaz grafica del proyecto
     * @author Sergio Majé
     */
    public Editor(){
        setPreferredSize(new Dimension(30,30));
        setMinimumSize(new Dimension(30,30));
        setMaximumSize(new Dimension(30,30));
        setBackground(Color.NEGROINDICE.getColor());
        editor=new TextPane() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                Editor.this.repaint();
            }
        };
        scroll=new JScrollPane(editor);
        repaint();
    }
    /**
     * Decodifica el texto del archivo para diferenciar los diferentes colores de la sintaxis
     * @param n {@link String} cadena con texto codificado
     * @author Sergio Majé
     */
    public void text(String n) {
        for (String e:n.replaceAll("\t","       ").split("_")){
            if (e.endsWith("n")) editor.append(e.substring(0,e.length()-1), Color.NARANJA.getColor());
            else if(e.endsWith("m")) editor.append(e.substring(0,e.length()-1), Color.MORADO.getColor());
            else if(e.endsWith("a")) editor.append(e.substring(0,e.length()-1), Color.AMARILLO.getColor());
            else if(e.endsWith("b")) editor.append(e.substring(0,e.length()-1), Color.AZUL.getColor());
            else if(e.endsWith("v")) editor.append(e.substring(0,e.length()-1), Color.VERDE.getColor());
            else if(e.endsWith("w")) editor.append(e.substring(0,e.length()-1), Color.BLANCO.getColor());
        }
    }
    /**
     * Define texto al editor sin diferenciacion de sintaxis
     * @param text {@link String}
     * @author Sergio Majé
     */
    private void setText(String text){
        editor.setText(text);
    }
    /**
     * Creacion de un nuevo Editor
     * @param path {@link String} ruta del archivo a mostrar
     * @return {@link JPanel} panel con el editor integrado
     * @see Archivos#codefiles(String)
     * @author Sergio Majé
     */
    public static JPanel editor(String path){
        Editor editor=new Editor();
        JPanel panel=new JPanel(new BorderLayout());
        panel.add(editor, BorderLayout.WEST);
        panel.add(editor.scroll, BorderLayout.CENTER);
        try{
            editor.text(Archivos.codefiles(path));
        } catch (IOException e) {
            editor.setText(e.getMessage());
        }
        return panel;
    }
    /**
     * Dibuja una columna con los indices de las filas de texto
     * @param g {@link Graphics}
     * @author Sergio Majé
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D d=(Graphics2D)g;
        d.setPaint(Color.BLANCO.getColor());
        int start=editor.viewToModel(scroll.getViewport().getViewPosition()),end=editor.viewToModel(new Point(scroll.getViewport().getViewPosition().x+editor.getWidth(),scroll.getViewport().getViewPosition().y+editor.getHeight())),startline=editor.getDocument().getDefaultRootElement().getElementIndex(start),endline=editor.getDocument().getDefaultRootElement().getElementIndex(end),fontHeight=g.getFontMetrics(editor.getFont()).getHeight(),line=startline;
        for (int y=0;line-1<=endline;y+=fontHeight,line++) d.drawString(String.valueOf(line),6,y);
    }
}