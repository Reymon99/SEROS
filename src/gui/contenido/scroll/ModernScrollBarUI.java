package gui.contenido.scroll;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import static gui.contenido.scroll.ModernScrollPane.*;
public class ModernScrollBarUI extends BasicScrollBarUI {
    private JScrollPane sp;
    protected ModernScrollBarUI(ModernScrollPane sp){
        this.sp=sp;
    }
    @Override
    protected JButton createDecreaseButton(int orientation) {
        return new InvisibleScrollBarButton();
    }
    @Override
    protected JButton createIncreaseButton(int orientation) {
        return new InvisibleScrollBarButton();
    }
    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) { }
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
        else if(isDragging) color = tools.Color.SCROLLDRAGGING.getColor();
        else if(isThumbRollover()) color = tools.Color.SCROLLROLLOVER.getColor();
        else color = tools.Color.SCROLLPRESSED.getColor();
        Graphics2D graphics2D = (Graphics2D) g.create();
        graphics2D.setColor(color);
        graphics2D.fillRoundRect(x, y, width, height,10,10);
        graphics2D.setColor(tools.Color.BORDESCROLL.getColor());
        graphics2D.drawRoundRect(x,y,width,height,10,10);
        graphics2D.dispose();
    }
    @Override
    protected void setThumbBounds(int x, int y, int width, int height) {
        super.setThumbBounds(x, y, width, height);
        sp.repaint();
    }
}