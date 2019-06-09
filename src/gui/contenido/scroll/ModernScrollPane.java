package gui.contenido.scroll;
import javax.swing.*;
import java.awt.*;
public class ModernScrollPane extends JScrollPane {
    protected static final int THUMB_SIZE = 8;
    protected static final int SB_SIZE = 10;
    public ModernScrollPane(Component view){
        this(view,VERTICAL_SCROLLBAR_AS_NEEDED,VERTICAL_SCROLLBAR_AS_NEEDED);
    }
    public ModernScrollPane(Component view,JTextArea area){
        this(view);
        setRowHeaderView(area);
    }
    public ModernScrollPane(Component view,int vsb,int hsb){
        setBorder(BorderFactory.createEmptyBorder());
        JScrollBar vertical=getVerticalScrollBar();
        vertical.setOpaque(false);
        vertical.setUI(new ModernScrollBarUI(this));
        JScrollBar horizontal=getHorizontalScrollBar();
        horizontal.setOpaque(false);
        horizontal.setUI(new ModernScrollBarUI(this));
        setLayout(new ScrollPaneLayout() {
            @Override
            public void layoutContainer(Container parent) {
                super.layoutContainer(parent);
                Rectangle availR = ((JScrollPane) parent).getBounds();
                availR.x = availR.y = 0;
                Insets insets = parent.getInsets();// viewport, no se toca
                availR.x = insets.left;
                availR.y = insets.top;
                availR.width -= insets.left + insets.right;
                availR.height -= insets.top + insets.bottom;
                boolean vsbNeeded = isVerticalScrollBarfNecessary(), hsbNeeded = isHorizontalScrollBarNecessary();
                Rectangle vsbR = new Rectangle();// vertical scroll bar
                vsbR.width = SB_SIZE;
                vsbR.height = availR.height - (hsbNeeded ? vsbR.width : 0);
                vsbR.x = availR.x + availR.width - vsbR.width;
                vsbR.y = availR.y;
                if (vsb != null) vsb.setBounds(vsbR);
                Rectangle hsbR = new Rectangle();// horizontal scroll bar
                hsbR.height = SB_SIZE;
                hsbR.width = availR.width - (vsbNeeded ? hsbR.height : 0);
                hsbR.x = availR.x;
                hsbR.y = availR.y + availR.height - hsbR.height;
                if (hsb != null) hsb.setBounds(hsbR);
            }
        });
        setComponentZOrder(getVerticalScrollBar(),0);
        setComponentZOrder(getHorizontalScrollBar(),1);
        setComponentZOrder(getViewport(),2);
        viewport.setView(view);
    }
    private boolean isVerticalScrollBarfNecessary() {
        Rectangle viewRect = viewport.getViewRect();
        Dimension viewSize = viewport.getViewSize();
        return viewSize.getHeight() > viewRect.getHeight();
    }
    private boolean isHorizontalScrollBarNecessary() {
        Rectangle viewRect = viewport.getViewRect();
        Dimension viewSize = viewport.getViewSize();
        return viewSize.getWidth() > viewRect.getWidth();
    }
}