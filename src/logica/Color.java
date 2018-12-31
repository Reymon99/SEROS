package logica;
public enum Color {
    AZUL(95,176,214),
    AMARILLO(245,208,51),
    BLANCO(java.awt.Color.WHITE),
    MORADO(176,117,174),
    NARANJA(237,118,14),
    VERDE(164,205,146),
    AZULTITLE(12,35,154),
    AZULTEXT(0,19,65),
    GRIS(102,95,133),
    GRISPANEL(142,134,134),
    GRISBUTTON(182,182,182);
    private java.awt.Color color;
    private Color(int r,int g,int b){
        this(new java.awt.Color(r,g,b));
    }
    private Color(java.awt.Color color){
        this.color=color;
    }
    /**
     *Colores RGB predefinidas para utilizar en el proyecto
     * @return java.awt.Color
     */
    public java.awt.Color getColor() {
        return color;
    }
}