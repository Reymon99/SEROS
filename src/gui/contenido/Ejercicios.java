package gui.contenido;

import org.constrains.Constrains;
import org.constrains.View;
import org.constrains.Weight;

import acciones.Acciones;
import acciones.Eventos;
import acciones.Contenidos;
import gui.contenido.scroll.ModernScrollPane;
import tools.Archivos;
import tools.Colour;
import tools.Ejercicio;
import tools.Fuentes;
import tools.Paneles;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.LinkedHashMap;

public final class Ejercicios extends Lienzo {
    private final Paneles name;
    private ModernButton exercise;
    private ModernScrollPane scroll;
    private JTextArea description;
    private JList<Ejercicio> list;
    private DefaultListModel<Ejercicio> listExercises;
    private final LinkedHashMap<String, String> descriptions;

    {
        descriptions = Contenidos.getToolTips("ejercicios");
    }

    /**
     * Plantilla para listar y detallar los {@link Ejercicio} disponibles de una temática
     * @param name nombre del panel
     * @param ejercicios listado de {@link Ejercicio} disponible
     */
    public Ejercicios (Paneles name, Ejercicio... ejercicios) {
        super(new GridBagLayout(), true);
        this.name = name;
        setAcciones(new Acciones() {
            @Override
            public void iteracion0() {  // None
            }

            @Override
            public void iteracion1() {  // None
            }

            @Override
            public void clean() {
                cleanComponents();
            }
        });
        init(ejercicios);
    }

    /**
     * Inicializador de componentes
     * @param ejercicios listado de {@link Ejercicio} disponibles
     */
    private void init(Ejercicio[] ejercicios) {
        description = Components.getTexto("", 8, 35);
        exercise = new ModernButton('E', name.toString(), Colour.FACIL);
        Dimension dim = exercise.getPreferredSize();
        dim.height = 230;
        exercise.setPreferredSize(dim);
        listExercises = new DefaultListModel<>();
        Arrays.stream(ejercicios).forEach(e -> listExercises.addElement(e));
        list = new JList<>(listExercises);
        list.setBorder(BorderFactory.createSoftBevelBorder(1));
        list.setOpaque(false);
        list.setCellRenderer(new StyleListCellRenderer());
        list.addListSelectionListener(e -> selectionExercise(list.getSelectedValue()));
        scroll = new ModernScrollPane(list);
        scroll.getViewport().setOpaque(false);
        scroll.setOpaque(false);
        JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
        separator.setBorder(BorderFactory.createLineBorder(Colour.SCROLL_PRESSED.getColor()));
        Point pointSWN = new Point(GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE);
        Point pointCN = new Point(GridBagConstraints.CENTER, GridBagConstraints.NONE);
        Weight weight00 = new Weight(0, 0);
        Weight weight11 = new Weight(1, 1);
        Constrains.addComp(
                new View(scroll, this),
                new Rectangle(0, 0, 2, 2),
                weight11,
                new Insets(20, 10, 15, 10),
                pointCN
        );
        Constrains.addCompY(
                new View(separator, this),
                new Rectangle(2, 0, 1, 2),
                2.5,
                new Insets(30, 5, 10, 30),
                new Point(GridBagConstraints.WEST, GridBagConstraints.VERTICAL)
        );
        Constrains.addComp(
                new View(exercise, this),
                new Rectangle(3, 0, 1, 1),
                weight11,
                new Insets(30, 30, 5, 25),
                pointCN
        );
        Constrains.addComp(
                new View(description, this),
                new Rectangle(3, 1, 1, 1),
                weight11,
                new Insets(5, 30, 30, 20),
                pointCN
        );
        Constrains.addComp(
                new View(getBack(), this),
                new Rectangle(0, 2, 1, 1),
                weight00,
                new Insets(10,7, 10, 5),
                pointSWN
        );
        Constrains.addComp(
                new View(getHome(), this),
                new Rectangle(1, 2, 1, 1),
                weight00,
                new Insets(10, 5, 25, 5),
                pointSWN
        );
    }

    /**
     * Reinicia los componentes a su estado inicial
     */
    private void cleanComponents() {
        description.setText("");
        scroll.getVerticalScrollBar().setValue(0);
        scroll.updateUI();
        list.setSelectedIndex(-1);
        list.updateUI();
        exercise.setIcon(new ImageIcon());
        exercise.setEvento(e -> {});
        exercise.setLetra('E');
        exercise.setTexto(name.toString());
        exercise.setNivelDificultad(Colour.FACIL);
        updateUI();
    }

    /**
     * Se visualiza los detalles del {@link Ejercicio} seleccionado
     * @param ejercicio {@link Ejercicio} especificado
     */
    private void selectionExercise(Ejercicio ejercicio) {
        description.setText(descriptions.get(ejercicio.panel().toString()));
        exercise.setNivelDificultad(ejercicio.dificultad());
        exercise.setTexto(ejercicio.panel().toString());
        exercise.setLetra("");
        exercise.setIcon(Archivos.image(ejercicio.panel().getPathIcon()));
        exercise.setEvento(e -> {
            getAcciones().clean();
            Eventos.show(ejercicio.panel());
        });
        updateUI();
    }

    /**
     * Estilo de las celdas usadas en el {@link JList}
     */
    private static class StyleListCellRenderer implements ListCellRenderer {
        private final DefaultListCellRenderer defaultRenderer;

        {
            defaultRenderer = new DefaultListCellRenderer();
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
                                                      boolean cellHasFocus) {
            JLabel label = (JLabel) defaultRenderer.getListCellRendererComponent(
                    list,
                    value,
                    index,
                    isSelected,
                    cellHasFocus
            );
            label.setOpaque(true);
            label.setIcon(Archivos.image(((Ejercicio) value).panel().getPathIcon(), 28));
            label.setBackground(cellHasFocus && isSelected ?
                    Colour.GRIS_BUTTON.getColor() : Colour.SCROLL_PRESSED.getColor());
            label.setPreferredSize(new Dimension(370, 45));
            label.setCursor(new Cursor(Cursor.HAND_CURSOR));
            label.setFont(Fuentes.UBUNTU_LIGHT_15.getFont());
            label.setBorder(BorderFactory.createRaisedSoftBevelBorder());
            return label;
        }
    }
}