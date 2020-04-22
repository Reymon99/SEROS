package gui.editor;

import acciones.Contenidos;
import acciones.Eventos;
import gui.contenido.Components;
import gui.contenido.scroll.ModernScrollPane;
import tools.Archivos;
import tools.Colour;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Editor extends ModernScrollPane {
    /**
     * Pseudocódigo a emplear en el {@link Editor}
     */
    private final String code;

    /**
     * Editor sintexico de código a utilizar en la interfaz gráfica del proyecto
     * @param view   área del pseudocódigo del {@link Editor}
     * @param indice indices del {@link Editor}
     * @param code   pseudocódigo a implementar
     */
    private Editor(View view, Indice indice, String code) {
        super(view, indice);
        this.code = code;
        setComponentPopupMenu(menuCode());
        ((View) getView()).setComponentPopupMenu(menuCode());
        fragmentador();
    }

    /**
     * Obtiene el pseudocódigo a emplear del archivo YAML,
     * y lo va fragmentando con sus colores de identación respectivos
     */
    private void fragmentador() {
        try {
            Contenidos.getCodes().get(code).forEach(this::identacion);
        } catch (NullPointerException e) {
            setText("No Code");
        }
    }

    /**
     * Identa la sintaxis respectiva con su {@link Colour}
     * @param split sintaxis y color a identar
     */
    private void identacion(ArrayList<String> split) {
        append(
                split.get(0).replaceAll("\t", "   "),
                Colour.valueOf(split.get(1))
        );
    }

    /**
     * Añade fragmentos de código al Editor,
     * respectivamente según su color
     * @param code   fragmento del código a añadir al {@link Editor}
     * @param colour color respectivo del fragmento del código
     */
    private void append(String code, Colour colour) {
        ((View) getView()).append(code, colour.getColor());
    }

    /**
     * Selecciona una linea determinada
     * @param line linea a seleccionar
     */
    public void drawLineIn(int line) {
        ((Indice) getIndice()).lineForegroundIn(line);
        ((View) getView()).drawLineIn(((Indice) getIndice()).getLineNumber().get(String.valueOf(line)));
    }

    /**
     * Fija si la linea se dibuja
     * @param line true: Se dibuja | false: No se dibuja
     */
    public void setLine(boolean line) {
        ((View) getView()).setLine(line);
        ((Indice) getIndice()).lineForegroundIn(-1);
    }

    /**
     * Define texto al view sin diferenciación de sintaxis
     * @param text {@link String}
     */
    public void setText(String text) {
        append(text, Colour.BLANCO);
    }

    /**
     * Opciones para el Editor</br>
     * <ul>
     *     <li>Exportar el texto del editor como Archivo Java</li>
     * </ul>
     * @return menú para las opciones del Editor
     */
    private JPopupMenu menuCode() {
        JPopupMenu menu = new JPopupMenu();
        JMenuItem save = new JMenuItem("Exportar Código");
        save.addActionListener(e -> {
            try {
                Components.getMessage(
                        Archivos.exportCode(
                                Eventos.saveFile(false, getCode()),
                                Eventos.code(((View) getView()).getText(), getCode())
                        ),
                        null
                ).setVisible(true);
            } catch (FileNotFoundException ex) {//None
            }
        });
        menu.add(save);
        return menu;
    }

    /**
     * Da el nombre del código
     * @return nombre del código
     */
    public String getCode() {
        return code;
    }

    /**
     * Creación de un nuevo Editor
     * @param code pseudocódigo a implementar en el {@link Editor}
     * @return editor con contenido integrado
     */
    public static Editor editor(String code) {
        View view = new View();
        return new Editor(view, new Indice(view), code);
    }
}