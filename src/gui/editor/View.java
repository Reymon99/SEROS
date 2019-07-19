package gui.editor;
import gui.contenido.TextPane;
import tools.Colour;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
public class  View extends TextPane {
    private boolean line;
    private int lineaSelected;
    /**
     * Vista del Editor
     */
    public View(){
        super();
        line=false;
    }
    /**
     * Fija si la linea se dibuja
     * @param line true: Se dibuja false: No se dibuja
     */
    public void setLine(boolean line) {
        this.line = line;
        repaint();
    }
    /**
     * Selecciona una linea determinada a dibujar
     * @param lineaSelected linea a seleccionar
     */
    public void drawLineIn(int lineaSelected) {
        this.lineaSelected = lineaSelected;
        line=true;
        repaint();
    }
    /**
     * Dibuja una linea seleccionada
     * @param g2 {@link Graphics2D} pincel
     */
    private void drawLine(Graphics2D g2) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(Colour.REDLINESELECTED.getColor());
        g2.fill(new RoundRectangle2D.Double(getInsets().left-3,lineaSelected==1 ? getInsets().top : getInsets().top+g2.getFontMetrics(getFont()).getHeight()*(lineaSelected-1),getWidth()-getInsets().left-3,g2.getFontMetrics(getFont()).getHeight()+1,16,16));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (line) drawLine((Graphics2D) g);
    }
}