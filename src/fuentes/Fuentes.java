package fuentes;
import java.awt.*;
public enum Fuentes {
    UBUNTULIGHT15(new UbuntuLightFont().getFont(Font.PLAIN,15)),
    PURISA18(new Font("Purisa",Font.PLAIN,18));
    private Font font;
    private Fuentes(Font font){
        this.font=font;
    }
    public Font getFont() {
        return font;
    }
}