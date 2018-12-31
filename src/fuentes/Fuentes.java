package fuentes;
import java.awt.Font;
public enum Fuentes {
    UBUNTULIGHT14(new FuentesModificadas("/fuentes/UbuntuLight.ttf").getFont(Font.BOLD,14)),
    UBUNTULIGHT15(new FuentesModificadas("/fuentes/UbuntuLight.ttf").getFont(Font.PLAIN,15)),
    UBUNTULIGHT43(new FuentesModificadas("/fuentes/UbuntuLight.ttf").getFont(Font.PLAIN,43)),
    UBUNTULIGHT18(new FuentesModificadas("/fuentes/UbuntuLight.ttf").getFont(Font.PLAIN,18)),
    UBUNTULIGHT20(new FuentesModificadas("/fuentes/UbuntuLight.ttf").getFont(Font.PLAIN,20)),
    PURISA18(new FuentesModificadas("/fuentes/Purisa-Bold.ttf").getFont(Font.PLAIN,18)),
    MYHAPPYENDING30(new FuentesModificadas("/fuentes/My Happy Ending.ttf").getFont(Font.PLAIN,150)),
    PURISA15(new FuentesModificadas("/fuentes/Purisa-Bold.ttf").getFont(Font.PLAIN,15)),
    DIALOG30(new Font(Font.DIALOG,Font.BOLD,30));
    private Font font;
    private Fuentes(Font font){
        this.font=font;
    }
    /**
     *Fuentes de texto predefinidas para utilizar en el proyecto
     * @return Font
     */
    public Font getFont() {
        return font;
    }
}