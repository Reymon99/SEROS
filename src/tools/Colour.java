package tools;
import java.awt.Color;
public enum Colour {
    AZUL(new Color(95,176,214)),
    AMARILLO(new Color(245,208,51)),
    BLANCO(new Color(255,255,255)),
    MORADO(new Color(176,117,174)),
    NARANJA(new Color(237,118,14)),
    VERDE(new Color(164,205,146)),
    AZUL_TITLE(new Color(12,35,154)),
    AZUL_TEXT(new Color(0,19,65)),
    GRIS(new Color(102,95,133)),
    GRIS_PANEL(new Color(142,134,134)),
    GRIS_BUTTON(new Color(182,182,182)),
    CURIOUS_BLUE(new Color(3,127,188)),
    NEGRO_EDITOR(new Color(48,47,51)),
    NEGRO_INDICE(new Color(73, 72, 76)),
    BORDE_SCROLL(new Color(144,144,144)),
    SCROLL_DRAGGING(new Color(145,151,151,200)),
    SCROLL_ROLLOVER(new Color(85,100,120,200)),
    SCROLL_PRESSED(new Color(220,220,200,200)),
    GRAY_DISABLED(new Color(131,131,131)),
    VERDE_ACTIVO(new Color(75,216,101)),
    BLANCO_DESHABILITADO(new Color(216,217,219)),
    RED_LINE_SELECTED(new Color(235,0,0,50)),
    LINE_FOREGROUND(new Color(15, 125, 162));
    private Color color;
    Colour(Color color){
        this.color=color;
    }
    /**
     * Colores RGB predefinidas para utilizar en el proyecto
     * @return {@link Color} deseado
     */
    public Color getColor() {
        return color;
    }
}