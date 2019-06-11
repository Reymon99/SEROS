package gui.contenido.scroll;
import tools.Colour;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import static gui.contenido.scroll.ModernScrollPane.*;
public class ModernScrollBarUI extends BasicScrollBarUI {
    private JScrollPane sp;
    /**
     * Interfaz personalizada al JScrollBar
     * @param sp {@link JScrollPane} que va se le va a personalizar los JScrollBar´s
     */
    protected ModernScrollBarUI(ModernScrollPane sp){
        this.sp=sp;
    }
    /**
     * Se oculta el boton de decremento en el JScrollBar
     * @param orientation orientación del scroll
     * @return boton de decremento oculto
     * @author Sergio Majé
     */
    @Override
    protected JButton createDecreaseButton(int orientation) {
        return new InvisibleScrollBarButton();
    }
    /**
     * Se oculta el boton de incremento en el JScrollBar
     * @param orientation orientación del scroll
     * @return boton de incremento oculto
     * @author Sergio Majé
     */
    @Override
    protected JButton createIncreaseButton(int orientation) {
        return new InvisibleScrollBarButton();
    }
    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) { }
    /**
     * Se le da una nueva interfaz al JScrollBar
     * @author Sergio Majé
     */
    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        int orientation = scrollbar.getOrientation();
        int x = thumbBounds.x;
        int y = thumbBounds.y;
        int width = orientation == JScrollBar.VERTICAL ? THUMB_SIZE : thumbBounds.width;
        width = Math.max(width, THUMB_SIZE);
        int height = orientation == JScrollBar.VERTICAL ? thumbBounds.height : THUMB_SIZE;
        height = Math.max(height, THUMB_SIZE);
        Color color;
        JScrollBar sb = (JScrollBar)c;
        if(!sb.isEnabled()) return;
        else if(isDragging) color = Colour.SCROLLDRAGGING.getColor();
        else if(isThumbRollover()) color = Colour.SCROLLROLLOVER.getColor();
        else color = Colour.SCROLLPRESSED.getColor();
        Graphics2D graphics2D = (Graphics2D) g.create();
        graphics2D.setColor(color);
        graphics2D.fillRoundRect(x, y, width, height,10,10);
        graphics2D.setColor(Colour.BORDESCROLL.getColor());
        graphics2D.drawRoundRect(x,y,width,height,10,10);
        graphics2D.dispose();
    }
    @Override
    protected void setThumbBounds(int x, int y, int width, int height) {
        super.setThumbBounds(x, y, width, height);
        sp.repaint();
    }
}