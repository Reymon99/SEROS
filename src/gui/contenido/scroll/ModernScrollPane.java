package gui.contenido.scroll;
import javax.swing.*;
import java.awt.*;
public class ModernScrollPane extends JScrollPane {
    protected static final int THUMB_SIZE = 8;
    protected static final int SB_SIZE = 10;
    /**
     * JScrollPane con interfaz personalizada
     * @param view componente a integrar el scroll
     */
    public ModernScrollPane(Component view){
        this(view,VERTICAL_SCROLLBAR_AS_NEEDED,HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }
    /**
     * JScrollPane con interfaz personalizada
     * @param view componente a integrar el scroll
     * @param area componente a agregar al header
     */
    public ModernScrollPane(Component view,JPanel area){
        this(view);
        setRowHeaderView(area);
    }
    /**
     * JScrollPane con interfaz personalizada
     * @param view componente a integrar el scroll
     * @param vsb acción del scroll vertical
     * @param hsb acción del scroll horizontal
     */
    public ModernScrollPane(Component view,int vsb,int hsb){
        super(vsb,hsb);
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
                Rectangle availR = parent.getBounds();
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
    public Component getView(){
        return viewport.getView();
    }
    /**
     * Obtiene el componente de Indice en el scroll
     * @return indice
     */
    public Component getIndice(){
        return rowHeader.getView();
    }
}