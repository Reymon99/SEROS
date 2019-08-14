package gui.editor;
import eventos.Eventos;
import gui.contenido.Message;
import gui.contenido.scroll.ModernScrollPane;
import gui.simulador.Simulador;
import tools.Archivos;
import tools.Colour;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.io.FileNotFoundException;
public class Editor extends ModernScrollPane{
    /**
     * Editor sintexico de código a utilizar en la interfaz gráfica del proyecto
     */
    private Editor(View view, Indice indice) {
        super(view, indice);
        setComponentPopupMenu(menuCode());
        ((View) getView()).setComponentPopupMenu(menuCode());
    }
    /**
     * Decodifica el texto del archivo para diferenciar los diferentes colores de la sintaxis
     * @param n {@link String} cadena con texto codificado
     */
    private void text(String n) {
        for (String e:n.replaceAll("\t","   ").split("_")){
            if (e.endsWith("n")) ((View)getView()).append(e.substring(0,e.length()-1), Colour.NARANJA.getColor());
            else if(e.endsWith("m")) ((View)getView()).append(e.substring(0,e.length()-1), Colour.MORADO.getColor());
            else if(e.endsWith("a")) ((View)getView()).append(e.substring(0,e.length()-1), Colour.AMARILLO.getColor());
            else if(e.endsWith("b")) ((View)getView()).append(e.substring(0,e.length()-1), Colour.AZUL.getColor());
            else if(e.endsWith("v")) ((View)getView()).append(e.substring(0,e.length()-1), Colour.VERDE.getColor());
            else if(e.endsWith("w")) ((View)getView()).append(e.substring(0,e.length()-1), Colour.BLANCO.getColor());
        }
    }
    /**
     * Selecciona una linea determinada
     * @param i linea a seleccionar
     */
    public void drawLineIn(int i){
        drawLineIn(i,i);
    }
    /**
     * Selecciona una linea determinada
     * @param lineIndice línea a seleccionar en el Indice
     * @param lineEditor línea a seleccionar en el View
     */
    public void drawLineIn(int lineIndice, int lineEditor){
        ((View)getView()).drawLineIn(lineEditor);
        ((Indice)getIndice()).lineForegroundIn(lineIndice);
    }
    /**
     * Fija si la linea se dibuja
     * @param line true: Se dibuja false: No se dibuja
     */
    public void setLine(boolean line){
        ((View)getView()).setLine(line);
        ((Indice)getIndice()).lineForegroundIn(-1);
    }
    /**
     * Define texto al view sin diferenciación de sintaxis
     * @param text {@link String}
     */
    public void setText(String text){
        ((View)getView()).setText(text);
    }
    /**
     * Creación de un nuevo Editor
     * @param path {@link String} ruta del archivo a mostrar
     * @return editor con contenido integrado
     * @see Archivos#codefiles(String)
     */
    public static Editor editor(String path){
        View view=new View();
        Editor editor=new Editor(view,new Indice(view));
        editor.text(Archivos.codefiles(path));
        return editor;
    }
    /**
     * Opciones para el Editor</br>
     * <ul>
     *     <li>Exportar el texto del editor como Archivo Java</li>
     * </ul>
     * @return menú para las opciones del Editor
     */
    private JPopupMenu menuCode(){
        JPopupMenu menu=new JPopupMenu();
        JMenuItem save=new JMenuItem("Exportar Código");
        save.addActionListener(e -> {
            try{
                new Message(Archivos.exportCode(Eventos.saveFile(false), ""), Simulador.lienzo).setVisible(true);
            }catch (FileNotFoundException ex){//None
            }
        });
        menu.add(save);
        return menu;
    }
}