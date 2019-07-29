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
    private boolean onOff;//Estado del interruptor
    private Color backgroundColor;//Color del fondo del interruptor
    private Color buttonColor;//Color del boton circular del interruptor
    private final Color DISABLED_COMPONENT_COLOR;//Color del interruptor cuando está deshabilitado
    {
        DISABLED_COMPONENT_COLOR = Colour.GRAYDISABLED.getColor();
    }
    /**
     * Componente de estados Switch
     * @param text texto del componente
     * @param onOff estado del Switch
     */
    public Switch(String text,boolean onOff){
        super();
        this.onOff=onOff;
        this.text=text;
        modificable=true;
        setSize(new Dimension(35+1+getFontMetrics(Fuentes.UBUNTULIGHT14.getFont()).stringWidth(text),20));
        setPreferredSize(new Dimension(35+1+getFontMetrics(Fuentes.UBUNTULIGHT14.getFont()).stringWidth(text),20));
        setMinimumSize(new Dimension(35+1+getFontMetrics(Fuentes.UBUNTULIGHT14.getFont()).stringWidth(text),20));
        setMaximumSize(new Dimension(35+1+getFontMetrics(Fuentes.UBUNTULIGHT14.getFont()).stringWidth(text),20));
        setVisible(true);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setOpaque(false);
        backgroundColor=Colour.VERDEACTIVO.getColor();
        buttonColor=Colour.BLANCO.getColor();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isEnabled() && modificable){
                    Switch.this.onOff=!Switch.this.onOff;
                    repaint();
                }
            }
        });
    }
    /**
     * Retorna el estado del interruptor
     * @return boolean true: On false: OFF
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
    private void opaque1(Graphics2D g2){
        if (isOpaque()) {//Pinta el fondo del componente
            g2.setColor(getBackground());
            g2.fill(new Rectangle2D.Double(0, 0, getWidth()+g2.getFontMetrics(Fuentes.UBUNTULIGHT14.getFont()).stringWidth(text), getHeight()));
        }
    }
    /**
     * Según el estado del enable este se pintará
     * @param g2 pincel
     */
    private void enable1(Graphics2D g2){
        g2.setColor(isEnabled() ? onOff ? backgroundColor : Colour.BLANCODESHABILITADO.getColor() : DISABLED_COMPONENT_COLOR);
        if(isEnabled()) g2.fill(new RoundRectangle2D.Double(2, 2, 31, 16, 16, 16));//componente habilitado
        else g2.draw(new RoundRectangle2D.Double(2, 2, 31, 16, 16, 16));//componente deshabilitado
    }
    /**
     * Según el estado del {@link Switch} este se pintará
     * @param g2 pincel
     */
    private void estado(Graphics2D g2){
        g2.setColor((isEnabled()) ? buttonColor : DISABLED_COMPONENT_COLOR);
        if (onOff) g2.fillOval(4, 4, 11, 11);//ON a la izquierda
        else g2.fillOval(19, 4, 11, 11);//OFF a la derecha
    }
    /**
     * Pintará el texto del componente
     * @param g2 pincel
     */
    private void texto(Graphics2D g2){
        g2.setFont(Fuentes.UBUNTULIGHT14.getFont());
        g2.drawString(text,36, 15);
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