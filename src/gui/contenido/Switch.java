package gui.contenido;
import tools.Colour;
import tools.Fuentes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
public class Switch extends JComponent {
    private boolean modificable;
    private String text;
    /**
     * Estado del interruptor
     */
    private boolean onOff;
    /**
     * Color del fondo del interruptor
     */
    private Color backgroundColor;
    /**
     * Color del boton circular del interruptor
     */
    private Color buttonColor;
    /**
     * Color del interruptor cuando está deshabilitado
     */
    private final Color DISABLED_COMPONENT_COLOR = Colour.GRAY_DISABLED.getColor();
    /**
     * Componente de estados Switch
     * @param text texto del componente
     * @param onOff estado del Switch
     */
    public Switch(String text,boolean onOff) {
        super();
        this.onOff = onOff;
        this.text=text;
        modificable=true;
        Dimension dim = new Dimension(
                35 + 1 + getFontMetrics(Fuentes.UBUNTU_LIGHT_14.getFont()).stringWidth(text),
                20
        );
        setSize(dim);
        setPreferredSize(dim);
        setMinimumSize(dim);
        setMaximumSize(dim);
        setVisible(true);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setOpaque(false);
        backgroundColor = Colour.VERDE_ACTIVO.getColor();
        buttonColor = Colour.BLANCO.getColor();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isEnabled() && modificable) {
                    Switch.this.onOff = !Switch.this.onOff;
                    repaint();
                }
            }
        });
    }
    /**
     * Retorna el estado del interruptor
     * @return boolean true: On | false: OFF
     */
    public boolean isOnOff() {
        return onOff;
    }
    /**
     * Modifica el estado del Switch
     * @param onOff nuevo estado del Switch
     */
    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
        repaint();
    }
    /**
     * Retorna el color de fondo del componente
     * @return color de fondo del componente
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }
    /**
     * Modifica el color de fondo del componente
     * @param backgroundColor nuevo color de fondo del componente
     */
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        repaint();
    }
    /**
     * Retorna el color de estado del Switch
     * @return color de estado del Switch
     */
    public Color getButtonColor() {
        return buttonColor;
    }
    /**
     * Modifica el color de estado del Switch
     * @param buttonColor nuevo color de estado del Switch
     */
    public void setButtonColor(Color buttonColor) {
        this.buttonColor = buttonColor;
        repaint();
    }
    /**
     * Retorna si el estado del Switch puede ser modificado
     * @return true: modificable false: no modificable
     */
    public boolean isModificable() {
        return modificable;
    }
    /**
     * Modifica si el estado del Switch puede ser modificado
     * @param modificable nuevo estado de modificación
     */
    public void setModificable(boolean modificable) {
        this.modificable = modificable;
    }
    /**
     * Retorna el texto del componente
     * @return texto del componente
     */
    public String getText() {
        return text;
    }
    /**
     * Según el estado del opaque este se pintará
     * @param g2 pincel
     */
    private void opaque1(Graphics2D g2) {
        // Pinta el fondo del componente
        if (isOpaque()) {
            g2.setColor(getBackground());
            g2.fill(
                    new Rectangle2D.Double(
                            0,
                            0,
                            getWidth() + g2.getFontMetrics(Fuentes.UBUNTU_LIGHT_14.getFont()).stringWidth(text),
                            getHeight()
                    )
            );
        }
    }
    /**
     * Según el estado del enable este se pintará
     * @param g2 pincel
     */
    private void enable1(Graphics2D g2) {
        g2.setColor(isEnabled() ? onOff ?
                backgroundColor : Colour.BLANCO_DESHABILITADO.getColor() : DISABLED_COMPONENT_COLOR);
        // componente habilitado
        if (isEnabled()) g2.fill(new RoundRectangle2D.Double(2, 2, 31, 16, 16, 16));
        // componente deshabilitado
        else g2.draw(new RoundRectangle2D.Double(2, 2, 31, 16, 16, 16));
    }
    /**
     * Según el estado del {@link Switch} este se pintará
     * @param g2 pincel
     */
    private void estado(Graphics2D g2) {
        g2.setColor(isEnabled() ? buttonColor : DISABLED_COMPONENT_COLOR);
        // ON a la izquierda
        if (onOff) g2.fillOval(4, 4, 11, 11);
        //OFF a la derecha
        else g2.fillOval(19, 4, 11, 11);
    }
    /**
     * Pintará el texto del componente
     * @param g2 pincel
     */
    private void texto(Graphics2D g2) {
        g2.setFont(Fuentes.UBUNTU_LIGHT_14.getFont());
        g2.drawString(text, 36, 15);
    }
    /**
     * Modifica el texto del componente
     * @param text nuevo texto
     */
    public void setText(String text) {
        this.text = text;
        repaint();
    }
    /**
     * Construcción del componente Switch
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        opaque1(g2);
        enable1(g2);
        estado(g2);
        texto(g2);
    }
}