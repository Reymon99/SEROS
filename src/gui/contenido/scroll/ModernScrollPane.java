package gui.contenido.scroll;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;

public class ModernScrollPane extends JScrollPane {
    protected static final int THUMB_SIZE;
    private static final int SB_SIZE;

    static {
        THUMB_SIZE = 8;
        SB_SIZE = 10;
    }

    /**
     * JScrollPane con interfaz personalizada
     * @param view componente a integrar el scroll
     */
    public ModernScrollPane(Component view) {
        this(view, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }

    /**
     * JScrollPane con interfaz personalizada
     * @param view componente a integrar el scroll
     * @param area componente a agregar al header
     */
    public ModernScrollPane(Component view, JPanel area) {
        this(view);
        setRowHeaderView(area);
    }

    /**
     * JScrollPane con interfaz personalizada
     * @param view componente a integrar el scroll
     * @param vsb  acción del scroll vertical
     * @param hsb  acción del scroll horizontal
     */
    public ModernScrollPane(Component view, int vsb, int hsb) {
        super(vsb, hsb);
        setBorder(BorderFactory.createEmptyBorder());
        JScrollBar vertical = getVerticalScrollBar();
        vertical.setOpaque(false);
        vertical.setUI(new ModernScrollBarUI(this));
        JScrollBar horizontal = getHorizontalScrollBar();
        horizontal.setOpaque(false);
        horizontal.setUI(new ModernScrollBarUI(this));
        setLayout(modernLayout());
        setComponentZOrder(getVerticalScrollBar(), 0);
        setComponentZOrder(getHorizontalScrollBar(), 1);
        setComponentZOrder(getViewport(), 2);
        viewport.setView(view);
    }

    private ScrollPaneLayout modernLayout() {
        return new ScrollPaneLayout() {
            @Override
            public void layoutContainer(Container parent) {
                super.layoutContainer(parent);
                Rectangle availR = availR(parent);
                if (vsb != null) vsb.setBounds(scrollBar(availR, isVerticalScrollBarfNecessary(), false));
                if (hsb != null) hsb.setBounds(scrollBar(availR, isHorizontalScrollBarNecessary(), true));
            }
        };
    }

    /**
     * Nos da a saber si el scroll trabajado es vertical
     * @return verdadero si el scroll es vertical
     */
    private boolean isVerticalScrollBarfNecessary() {
        Rectangle viewRect = viewport.getViewRect();
        Dimension viewSize = viewport.getViewSize();
        return viewSize.getHeight() > viewRect.getHeight();
    }

    /**
     * Nos da a saber si el scroll trabajado es horizontal
     * @return verdadero si el scroll es horizontal
     */
    private boolean isHorizontalScrollBarNecessary() {
        Rectangle viewRect = viewport.getViewRect();
        Dimension viewSize = viewport.getViewSize();
        return viewSize.getWidth() > viewRect.getWidth();
    }

    /**
     * Obtiene el componente añadido al scroll
     * @return componente en el scroll
     */
    protected Component getView() {
        return viewport.getView();
    }

    /**
     * Obtiene el componente de Indice en el scroll
     * @return indice
     */
    protected Component getIndice() {
        return rowHeader.getView();
    }

    private Rectangle availR(Container parent) {
        Rectangle availR = parent.getBounds();
        availR.x = availR.y = 0;
        Insets insets = parent.getInsets(); // viewport, no se toca
        availR.x = insets.left;
        availR.y = insets.top;
        availR.width -= insets.left + insets.right;
        availR.height -= insets.top + insets.bottom;
        return availR;
    }

    private Rectangle scrollBar(Rectangle availR, boolean needed, boolean horizontal) {
        Rectangle rectangle = new Rectangle();
        if (horizontal) {
            rectangle.height = SB_SIZE;
            rectangle.width = availR.width - (needed ? rectangle.height : 0);
            rectangle.x = availR.x;
            rectangle.y = availR.y + availR.height - rectangle.height;
        } else {
            rectangle.width = SB_SIZE;
            rectangle.height = availR.height - (needed ? rectangle.width : 0);
            rectangle.x = availR.x + availR.width - rectangle.width;
            rectangle.y = availR.y;
        }
        return rectangle;
    }

    /**
     * Modifica el valor de posición del {@link javax.swing.JScrollPane.ScrollBar} horizontal
     * @param value valor de posición horizontal
     */
    public void setHorizontalValue(int value) {
        getHorizontalScrollBar().setValue(value);
    }

    /**
     * Modifica el valor de posición del {@link javax.swing.JScrollPane.ScrollBar} vertical
     * @param value valor de posición vertical
     */
    public void setVerticalValue(int value) {
        getVerticalScrollBar().setValue(value);
    }
}