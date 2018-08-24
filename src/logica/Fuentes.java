package logica;
import java.awt.*;
public enum Fuentes {
    PURISA18(new Font("Purisa",Font.PLAIN,18));
    private Font font;
    private Fuentes(Font font){
        this.font=font;
    }
    public Font getFont() {
        return font;
    }
}