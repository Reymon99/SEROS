package gui.contenido;

import tools.Archivos;
import tools.Colour;
import tools.Fuentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public abstract class Components {
    /**
     * Etiqueta con parametros predefinidos enfocados hacia el proyecto,<br>
     * para permitirles funcionar como botones
     * @param text    {@link String} text de la etiqueta
     * @param tip     {@link String} tool tip de la etiqueta
     * @param icon    {@link ImageIcon} icono de la etiqueta
     * @param menu    opciones {@link JPopupMenu} del ítem
     * @param adapter {@link MouseAdapter} evento del mouse de la etiqueta
     */
    public static JLabel getBoton(String text, String tip, ImageIcon icon, JPopupMenu menu, MouseAdapter adapter) {
        JLabel label = getBoton(icon, text, adapter);
        label.setToolTipText(tip);
        label.setComponentPopupMenu(menu);
        return label;
    }

    /**
     * Etiqueta con parametros predefinidos enfocados hacia el proyecto,<br>
     * para permitirles funcionar como botones
     * @param tip     {@link String} tool tip de la etiqueta
     * @param icon    {@link ImageIcon} icono de la etiqueta
     * @param adapter {@link MouseAdapter} evento del mouse de la etiqueta
     */
    public static JLabel getBoton(String tip, ImageIcon icon, MouseAdapter adapter) {
        JLabel label = new JLabel(icon, SwingConstants.CENTER);
        label.setToolTipText(tip);
        return initBoton(label, adapter);
    }

    /**
     * Etiqueta con parametros predefinidos enfocados hacia el proyecto,<br>
     * para permitirles funcionar como botones
     * @param icon {@link ImageIcon} icono de la etiqueta
     */
    public static JLabel getBoton(ImageIcon icon) {
        JLabel label = new JLabel(icon, SwingConstants.CENTER);
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.setOpaque(false);
        return label;
    }

    /**
     * Etiqueta con parametros predefinidos enfocados hacia el proyecto,<br>
     * para permitirles funcionar como botones
     * @param icon {@link ImageIcon} icono de la etiqueta
     * @param menu opciones {@link JPopupMenu} del ítem
     */
    public static JLabel getBoton(ImageIcon icon, JPopupMenu menu) {
        JLabel label = getBoton(icon);
        label.setComponentPopupMenu(menu);
        return label;
    }

    /**
     * Etiqueta con parametros predefinidos enfocados hacia el proyecto,<br>
     * para permitirles funcionar como botones
     * @param icon    {@link ImageIcon} icono de la etiqueta
     * @param text    {@link String} text de la etiqueta
     * @param adapter {@link MouseAdapter} evento del mouse de la etiqueta
     */
    public static JLabel getBoton(ImageIcon icon, String text, MouseAdapter adapter) {
        JLabel label = new JLabel(text, icon, SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.BOTTOM);
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        return initBoton(label, adapter);
    }

    private static JLabel initBoton(JLabel label, MouseAdapter adapter) {
        label.setFont(Fuentes.PURISA_18.getFont());
        label.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label.setOpaque(false);
        label.addMouseListener(adapter);
        return label;
    }

    /**
     * Boton enfocado al Simulador del Proyecto
     * @param text     {@link String} en el boton
     * @param enable   estado de habilidez
     * @param listener acción del evento del botón
     */
    public static JButton getButtonSimulador(String text, boolean enable, ActionListener listener) {
        JButton button = new JButton(text);
        button.setFont(Fuentes.UBUNTU_LIGHT_14.getFont());
        button.setBackground(Colour.GRIS_BUTTON.getColor());
        button.setEnabled(enable);
        button.addActionListener(listener);
        return button;
    }

    /**
     * Notifica la información de la acción realizada
     * @param message   información a notificar
     * @param component {@link Component} padre
     */
    public static JDialog getMessage(String message, Component component) {
        JDialog dialog = new JDialog();
        dialog.setUndecorated(true);
        dialog.setFocusable(true);
        dialog.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 50, 30));
        dialog.getContentPane().setBackground(Colour.GRIS_PANEL.getColor());
        JLabel label = new JLabel(message, SwingConstants.CENTER);
        label.setFont(Fuentes.UBUNTU_LIGHT_20.getFont());
        label.setForeground(Colour.BLANCO_OPACO.getColor());
        dialog.getContentPane().add(label);
        dialog.pack();
        dialog.setLocationRelativeTo(component);
        dialog.setIconImage(Objects.requireNonNull(
                Archivos.image("/resources/image/icon.png", -1, -1)
        ).getImage());
        dialog.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                dialog.dispose();
            }
        });
        dialog.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE ||
                        e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) dialog.dispose();
            }
        });
        return dialog;
    }

    /**
     * Área de texto con parametros predefinidos enfocados hacia el proyecto
     */
    public static JTextArea getTexto() {
        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setBackground(Colour.NEGRO_INDICE.getColor());
        area.setForeground(Colour.BLANCO.getColor());
        area.setMargin(new Insets(3, 5, 0, 7));
        area.setFont(Fuentes.UBUNTU_LIGHT_15.getFont());
        return area;
    }

    /**
     * Área de texto con parametros predefinidos enfocados hacia el proyecto
     * @param text {@link String} a dar en el Texto
     */
    public static JTextArea getTexto(String text) {
        return initTexto(new JTextArea(text));
    }

    /**
     * Área de texto con parametros predefinidos enfocados hacia el proyecto
     * @param text    {@link String} a dar en el Texto
     * @param rows    filas
     * @param columns columnas
     */
    public static JTextArea getTexto(String text, int rows, int columns) {
        JTextArea area = new JTextArea(text, rows, columns);
        area.setBorder(BorderFactory.createSoftBevelBorder(1));
        return initTexto(area);
    }

    /**
     * Área de texto con parametros predefinidos enfocados hacia el proyecto
     * @param rows    filas
     * @param columns columnas
     */
    public static JTextArea getTexto(int rows, int columns) {
        JTextArea area = new JTextArea(rows, columns);
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setFont(Fuentes.UBUNTU_LIGHT_15.getFont());
        area.setCaretColor(Colour.BLANCO.getColor());
        area.setForeground(Colour.BLANCO.getColor());
        area.setBackground(Colour.AZUL_TEXT.getColor());
        area.setMargin(new Insets(28, 22, 10, 18));
        return area;
    }

    private static JTextArea initTexto(JTextArea area) {
        area.setFont(Fuentes.UBUNTU_LIGHT_20.getFont());
        area.setTabSize(2);
        area.setEditable(false);
        area.setOpaque(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        return area;
    }
}