package gui.editor;
import gui.contenido.TextPane;
import gui.contenido.Texto;
import gui.contenido.scroll.ModernScrollPane;
import tools.Archivos;
import tools.Color;
import javax.swing.*;
import java.awt.*;
import java.io.*;
public class Editor {
    private TextPane editor;
    private ModernScrollPane scroll;
    private Texto area;
    /**
     * Editor sintexico de codigo a utilizar en la interfaz grafica del proyecto
     * @author Sergio Majé
     */
    private Editor(){
        editor=new TextPane();
        area=new Texto(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.SCROLLROLLOVER.getColor());
                g.drawLine(getWidth()-1,getY(),getWidth()-1,getHeight());
            }
        };
        area.setEditable(false);
        area.setBackground(Color.NEGROINDICE.getColor());
        area.setForeground(Color.BLANCO.getColor());
        area.setMargin(new Insets(3,5,0,7));
        area.setFont(editor.getFont());
        scroll=new ModernScrollPane(editor,area);
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
        for (int i = 1; i <= n.split("\n").length; i++) area.append(String.valueOf(i)+'\n');
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
    public static ModernScrollPane editor(String path){
        Editor editor=new Editor();
        try{
            editor.text(Archivos.codefiles(path));
        } catch (IOException e) {
            editor.setText(e.getMessage());
        }
        return editor.scroll;
    }
}