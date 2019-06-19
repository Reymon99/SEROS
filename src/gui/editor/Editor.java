package gui.editor;
import gui.contenido.scroll.ModernScrollPane;
import tools.Archivos;
import tools.Colour;
import javax.swing.*;
import java.io.*;
public class Editor {
    private View editor;
    private ModernScrollPane scroll;
    private Indice indice;
    /**
     * Editor sintexico de código a utilizar en la interfaz grafica del proyecto
     * @author Sergio Majé
     */
    private Editor(){
        editor=new View();
        indice=new Indice(editor);
        scroll=new ModernScrollPane(editor,indice);
    }
    /**
     * Decodifica el texto del archivo para diferenciar los diferentes colores de la sintaxis
     * @param n {@link String} cadena con texto codificado
     * @author Sergio Majé
     */
    private void text(String n) {
        for (String e:n.replaceAll("\t","       ").split("_")){
            if (e.endsWith("n")) editor.append(e.substring(0,e.length()-1), Colour.NARANJA.getColor());
            else if(e.endsWith("m")) editor.append(e.substring(0,e.length()-1), Colour.MORADO.getColor());
            else if(e.endsWith("a")) editor.append(e.substring(0,e.length()-1), Colour.AMARILLO.getColor());
            else if(e.endsWith("b")) editor.append(e.substring(0,e.length()-1), Colour.AZUL.getColor());
            else if(e.endsWith("v")) editor.append(e.substring(0,e.length()-1), Colour.VERDE.getColor());
            else if(e.endsWith("w")) editor.append(e.substring(0,e.length()-1), Colour.BLANCO.getColor());
        }
    }
    /**
     * Selecciona una linea determinada
     * @param i linea a seleccionar
     * @author Sergio Majé
     */
    public void drawLineIn(int i){
        editor.drawLineIn(i);
        indice.lineForegroundIn(i);
    }
    /**
     * Define texto al editor sin diferenciacion de sintaxis
     * @param text {@link String}
     * @author Sergio Majé
     */
    public void setText(String text){
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
    /**
     * Retorna el editor de texto
     * @return {@link View} de texto
     * @author Sergio Majé
     */
    public View getEditor() {
        return editor;
    }
    /**
     * Retorna el scroll del editor
     * @return {@link ModernScrollPane} del editor
     * @author Sergio Majé
     */
    public ModernScrollPane getScroll() {
        return scroll;
    }
    /**
     * Retorna el control de indice del editor
     * @return {@link Indice} del editor
     * @author Sergio Majé
     */
    public Indice getIndice() {
        return indice;
    }
}