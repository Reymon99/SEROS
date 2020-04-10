package gui.editor;

import gui.contenido.TextPane;
import tools.Colour;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class View extends TextPane {
    private boolean line;
    private int lineaPixelSelected;

    /**
     * Vista del Editor
     */
    public View() {
        super();
        line = false;
    }

    /**
     * Fija si la línea se dibuja
     * @param line true: Se dibuja false: No se dibuja
     */
    public void setLine(boolean line) {
        this.line = line;
        repaint();
    }

    /**
     * Selecciona una línea determinada a dibujar
     * @param lineaPixelSelected línea a seleccionar
     */
    protected void drawLineIn(int lineaPixelSelected) {
        this.lineaPixelSelected = lineaPixelSelected;
        line = true;
        repaint();
    }

    /**
     * Dibuja una línea seleccionada
     * @param g2 {@link Graphics2D} pincel
     */
    private void drawLine(Graphics2D g2) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(Colour.RED_LINE_SELECTED.getColor());
        g2.fill(
                new RoundRectangle2D.Double(
                        getInsets().left - 3,
                        lineaPixelSelected - g2.getFontMetrics(getFont()).getHeight() + 3,
                        getWidth() - getInsets().left - 3,
                        g2.getFontMetrics(getFont()).getHeight() + 1,
                        16,
                        16
                )
        );
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (line) drawLine((Graphics2D) g);
    }
}