package gui.editor;
import tools.Colour;
import java.awt.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
public class Indice extends JPanel {
    private final static int HEIGHT;
    private JTextComponent component;
    private int minimumDisplayDigits;
    private int lineForeground;
    private int lastDigits;
    private int lastHeight;
    private Insets insets;
    private HashMap<String, Integer> lineNumber;
    private HashMap<String, FontMetrics> fonts;
    static {
        HEIGHT = Integer.MAX_VALUE - 1000000;
    }
    /**
     * Indice de lineas de un componente de Texto
     * @param component componente de texto
     */
    Indice(JTextComponent component) {
        this(component, 1);
    }
    /**
     * Indice de lineas de un componente de Texto
     * @param component componente de texto
     * @param minimumDisplayDigits mínimo de los dígitos que se va a trabajar
     */
    private Indice(JTextComponent component, int minimumDisplayDigits) {
        this.component = component;
        insets = new Insets(0,15,0,7);
        lineNumber = new HashMap<>();
        setFont(component.getFont());
        setBackground(Colour.NEGRO_INDICE.getColor());
        setForeground(Colour.BLANCO.getColor());
        setBorder(BorderFactory.createEmptyBorder(1,1,1,0));
        lastDigits = 0;
        setPreferredWidth();
        setMinimumDisplayDigits(minimumDisplayDigits);
        component.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                documentChanged();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                documentChanged();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                documentChanged();
            }
        });
    }
    /**
     * Linea a pintar
     * @param i linea
     */
    protected void lineForegroundIn(int i){
        lineForeground=i;
        repaint();
    }
    /**
     * Acción del evento de Document
     * Modifica el ancho del panel según el número de dígitos del indice
     */
    private void documentChanged(){
        SwingUtilities.invokeLater(() -> {
            try{
                Rectangle rectangle = (Rectangle)component.modelToView2D(component.getDocument().getLength());
                if (rectangle!=null && rectangle.y!=lastHeight){
                    setPreferredWidth();
                    repaint();
                    lastHeight=rectangle.y;
                }
            } catch (BadLocationException e) {//None
            }
        });
    }
    /**
     * Modifica el número mínimo de dígitos
     * @param minimumDisplayDigits nuevo número mínimo de dígitos
     */
    private void setMinimumDisplayDigits(int minimumDisplayDigits) {
        this.minimumDisplayDigits = minimumDisplayDigits;
        setPreferredWidth();
    }
    /**
     * Fija el tamaño determinado del Indice
     */
    private void setPreferredWidth() {
        Element root=component.getDocument().getDefaultRootElement();
        int digits=Math.max(String.valueOf(root.getElementCount()).length(),minimumDisplayDigits);
        if (lastDigits!=digits){
            lastDigits=digits;
            Dimension d=getPreferredSize();
            d.setSize(insets.left+insets.right+getFontMetrics(getFont()).charWidth('0')*digits,HEIGHT);
            setPreferredSize(d);
            setMinimumSize(d);
            setSize(d);
        }
    }
    /**
     * Obtiene el número de la fila del texto
     * @param rowStartOffset posición de la fila
     * @return número de fila
     */
    private String getTextLineNumber(int rowStartOffset) {
        Element root=component.getDocument().getDefaultRootElement();
        int index=root.getElementIndex(rowStartOffset);
        return root.getElement(index).getStartOffset() == rowStartOffset ? String.valueOf(index+1) : "";
    }
    /**
     * Obtiene posición en X
     * @param stringWidth ancho del texto
     * @return posición en X
     */
    private int getOffsetX(int stringWidth) {
        return getSize().width - insets.right - stringWidth;
    }
    /**
     * Obtiene posición en Y
     * @param rowStartOffset posición de la fila
     * @param metrics {@link FontMetrics} del componente de Texto
     * @return posición en Y
     */
    private int getOffsetY(int rowStartOffset, FontMetrics metrics) throws BadLocationException {
        Rectangle r=(Rectangle)component.modelToView2D(rowStartOffset);
        int lineHeight=metrics.getHeight();
        int y=r.y+r.height;
        int descent=0;
        if (r.height==lineHeight) descent=metrics.getDescent();
        else{
            if (fonts==null) fonts= new HashMap<>();
            Element root=component.getDocument().getDefaultRootElement();
            int index=root.getElementIndex(rowStartOffset);
            Element line=root.getElement(index);
            for (int i = 0; i < line.getElementCount(); i++) {
                Element child=line.getElement(i);
                AttributeSet as = child.getAttributes();
                String fontFamily=(String) as.getAttribute(StyleConstants.FontFamily);
                Integer fontSize=(Integer) as.getAttribute(StyleConstants.FontSize);
                String key=fontFamily+fontSize;
                FontMetrics fm=fonts.get(key);
                if (fm==null) fonts.put(key, (fm=component.getFontMetrics(new Font(fontFamily,Font.PLAIN,fontSize))));
                descent=Math.max(descent,fm.getDescent());
            }
        }
        return y-descent;
    }
    /**
     * Indica la posición de los números en los indices a mostrar
     * @return posiciones de los indices
     */
    protected HashMap<String, Integer> getLineNumber(){
        return lineNumber;
    }
    /**
     * Dibuja los números de los indices
     * @param rowStartOffset inicio del indice
     * @param endOffset fin del indice
     * @param g pincel
     * @param metrics medidas del indice
     */
    private void paintNumbers(int rowStartOffset, int endOffset, Graphics g, FontMetrics metrics){
        while (rowStartOffset <= endOffset){
            try{
                String n = getTextLineNumber(rowStartOffset);
                g.setColor(Integer.parseInt(n.isBlank() ? "-1" : n) == lineForeground ? Colour.LINE_FOREGROUND.getColor() : Colour.BLANCO.getColor());
                Integer y = getOffsetY(rowStartOffset, metrics);
                lineNumber.put(n, y);
                g.drawString(n, getOffsetX(metrics.stringWidth(n)), lineNumber.get(n));
                rowStartOffset = Utilities.getRowEnd(component, rowStartOffset) + 1;
            } catch (BadLocationException e) {
                break;
            }
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Colour.SCROLL_ROLLOVER.getColor());
        g.drawLine(getWidth()-1,getY(),getWidth()-1,getHeight());
        Rectangle clip = g.getClipBounds();
        paintNumbers(component.viewToModel2D(new Point(0,clip.y)), component.viewToModel2D(new Point(0,clip.y+clip.height)), g, component.getFontMetrics(component.getFont()));
    }
}