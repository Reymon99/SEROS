package fuentes;
import java.awt.*;
public enum Fuentes {
    UBUNTULIGHT10(new UbuntuLightFont().getFont(Font.PLAIN,10)),
    PURISA18(new Font("Purisa",Font.PLAIN,18));
    private Font font;
    private Fuentes(Font font){
        this.font=font;
    }
    public Font getFont() {
        return font;
    }
}