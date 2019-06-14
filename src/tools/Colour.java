package tools;
import java.awt.*;
public enum Colour {
    AZUL(95,176,214),
    AMARILLO(245,208,51),
    BLANCO(Color.WHITE),
    MORADO(176,117,174),
    NARANJA(237,118,14),
    VERDE(164,205,146),
    AZULTITLE(12,35,154),
    AZULTEXT(0,19,65),
    GRIS(102,95,133),
    GRISPANEL(142,134,134),
    GRISBUTTON(182,182,182),
    CURIOUSBLUE(3,127,188),
    NEGROEDITOR(48,47,51),
    NEGROINDICE(73, 72, 76),
    BORDESCROLL(144,144,144),
    SCROLLDRAGGING(145,151,151,200),
    SCROLLROLLOVER(85,100,120,200),
    SCROLLPRESSED(220,220,200,200),
    GRAYDISABLED(131,131,131),
    VERDEACTIVO(75,216,101),
    BLANCODESHABILITADO(216,217,219);
    private Color color;
    private Colour(int r, int g, int b){
        this(new java.awt.Color(r,g,b));
    }
    private Colour(int r, int g, int b, int a){
        this(new java.awt.Color(r,g,b,a));
    }
    private Colour(java.awt.Color color){
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