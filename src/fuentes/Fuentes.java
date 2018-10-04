package fuentes;
import java.awt.*;
public enum Fuentes {
    UBUNTULIGHT15(new FuentesModificadas("/fuentes/UbuntuLight.ttf").getFont(Font.PLAIN,15)),
    PURISA18(new FuentesModificadas("/fuentes/Purisa-Bold.ttf").getFont(Font.PLAIN,18)),
    MYHAPPYENDING30(new FuentesModificadas("/fuentes/My Happy Ending.ttf").getFont(Font.PLAIN,30)),
    PURISA30(new FuentesModificadas("/fuentes/Purisa-Bold.ttf").getFont(Font.PLAIN,30));
    private Font font;
    private Fuentes(Font font){
        this.font=font;
    }
    public Font getFont() {
        return font;
    }
}