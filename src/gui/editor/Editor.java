package gui.editor;
import eventos.Eventos;
import gui.contenido.Components;
import gui.contenido.scroll.ModernScrollPane;
import tools.Archivos;
import tools.Colour;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.io.FileNotFoundException;
public class Editor extends ModernScrollPane{
    private String name;
    /**
     * Editor sintexico de código a utilizar en la interfaz gráfica del proyecto
     */
    private Editor(View view, Indice indice) {
        super(view, indice);
        setComponentPopupMenu(menuCode());
        ((View) getView()).setComponentPopupMenu(menuCode());
    }
    /**
     * Decodifica el texto del archivo .seros
     * para poder desfragmentar el código contenido,
     * y así poder asignar los colores respectivos de la sintaxis
     * @param n código a emplear mediante texto codificado
     */
    private void text(String n) {
        for (String e: n.replaceAll("\t", "   ").split("_")){
            if (e.endsWith("n")) append(e,Colour.NARANJA);
            else if(e.endsWith("m")) append(e,Colour.MORADO);
            else if(e.endsWith("a")) append(e, Colour.AMARILLO);
            else if(e.endsWith("b")) append(e, Colour.AZUL);
            else if(e.endsWith("v")) append(e,Colour.VERDE);
            else if(e.endsWith("w")) append(e,Colour.BLANCO);
        }
    }
    /**
     * Añade fragmentos de código al Editor,
     * respectivamente según su color
     * @param code fragmento del código a añadir al {@link Editor}
     * @param colour color respectivo del fragmento del código
     */
    private void append(String code, Colour colour) {
        ((View) getView()).append(
                code.substring(0, code.length() - 1),
                colour.getColor()
        );
    }
    /**
     * Selecciona una linea determinada
     * @param line linea a seleccionar
     */
    public void drawLineIn(int line){
        ((Indice) getIndice()).lineForegroundIn(line);
        ((View) getView()).drawLineIn(((Indice) getIndice()).getLineNumber().get(String.valueOf(line)));
    }
    /**
     * Fija si la linea se dibuja
     * @param line true: Se dibuja | false: No se dibuja
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
        ((View) getView()).setText(text);
    }
    /**
     * Opciones para el Editor</br>
     * <ul>
     *     <li>Exportar el texto del editor como Archivo Java</li>
     * </ul>
     * @return menú para las opciones del Editor
     */
    private JPopupMenu menuCode(){
        JPopupMenu menu = new JPopupMenu();
        JMenuItem save = new JMenuItem("Exportar Código");
        save.addActionListener(e -> {
            try{
                Components.getMessage(
                        Archivos.exportCode(
                                Eventos.saveFile(false, getName()),
                                Eventos.code(((View) getView()).getText(), getName())
                        ),
                        null
                ).setVisible(true);
            }catch (FileNotFoundException ex){//None
            }
        });
        menu.add(save);
        return menu;
    }
    /**
     * Da el nombre del código
     * @return nombre del código
     */
    public String getName(){
        return name;
    }
    /**
     * Fija un nuevo nombre para el código
     * @param name nombre para el código
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Creación de un nuevo Editor
     * @param path {@link String} ruta del archivo a mostrar
     * @param name nombre del código a añadir
     * @return editor con contenido integrado
     * @see Archivos#codefiles(String)
     */
    public static Editor editor(String path, String name){
        View view = new View();
        Editor editor = new Editor(view, new Indice(view));
        editor.text(Archivos.codefiles(path));
        editor.setName(name);
        return editor;
    }
}