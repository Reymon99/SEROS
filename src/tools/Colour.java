package tools;
import java.awt.*;
public enum Colour {
    AZUL(new Color(95,176,214)),
    AMARILLO(new Color(245,208,51)),
    BLANCO(new Color(255,255,255)),
    MORADO(new Color(176,117,174)),
    NARANJA(new Color(237,118,14)),
    VERDE(new Color(164,205,146)),
    AZULTITLE(new Color(12,35,154)),
    AZULTEXT(new Color(0,19,65)),
    GRIS(new Color(102,95,133)),
    GRISPANEL(new Color(142,134,134)),
    GRISBUTTON(new Color(182,182,182)),
    CURIOUSBLUE(new Color(3,127,188)),
    NEGROEDITOR(new Color(48,47,51)),
    NEGROINDICE(new Color(73, 72, 76)),
    BORDESCROLL(new Color(144,144,144)),
    SCROLLDRAGGING(new Color(145,151,151,200)),
    SCROLLROLLOVER(new Color(85,100,120,200)),
    SCROLLPRESSED(new Color(220,220,200,200)),
    GRAYDISABLED(new Color(131,131,131)),
    VERDEACTIVO(new Color(75,216,101)),
    BLANCODESHABILITADO(new Color(216,217,219)),
    REDLINESELECTED(new Color(235,0,0,50)),
    LINEFOREGROUND(new Color(15, 125, 162));
    private Color color;
    Colour(java.awt.Color color){
        this.color=color;
    }
    /**
     * Colores RGB predefinidas para utilizar en el proyecto
     * @return Color
     * @author Sergio Majé
     */
    public Color getColor() {
        return color;
    }
}