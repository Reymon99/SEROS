package logica;
public enum Color {
    AMARILLO(245,208,51),
    BLANCO(java.awt.Color.WHITE),
    MORADO(176,117,174),
    NARANJA(237,118,14),
    VERDE(164,205,146);
    private java.awt.Color color;
    private Color(int r,int g,int b){
        this(new java.awt.Color(r,g,b));
    }
    private Color(java.awt.Color color){
        this.color=color;
    }
    public java.awt.Color getColor() {
        return color;
    }
}