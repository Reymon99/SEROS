package tools;
import java.awt.*;
public enum Fuentes {
    UBUNTULIGHT12(new FuentesModificadas("/resources/fonts/UbuntuLight.ttf").getFont(Font.PLAIN,12)),
    UBUNTULIGHT14(new FuentesModificadas("/resources/fonts/UbuntuLight.ttf").getFont(Font.BOLD,14)),
    UBUNTULIGHT15(new FuentesModificadas("/resources/fonts/UbuntuLight.ttf").getFont(Font.PLAIN,15)),
    UBUNTULIGHT50(new FuentesModificadas("/resources/fonts/UbuntuLight.ttf").getFont(Font.BOLD,50)),
    UBUNTULIGHT20(new FuentesModificadas("/resources/fonts/UbuntuLight.ttf").getFont(Font.PLAIN,20)),
    UBUNTULIGHT30(new FuentesModificadas("/resources/fonts/UbuntuLight.ttf").getFont(Font.PLAIN,30)),
    UBUNTULIGHTB30(new FuentesModificadas("/resources/fonts/UbuntuLight.ttf").getFont(Font.BOLD,30)),
    UBUNTULIGHT40(new FuentesModificadas("/resources/fonts/UbuntuLight.ttf").getFont(Font.PLAIN,40)),
    UBUNTULIGHTB120(new FuentesModificadas("/resources/fonts/UbuntuLight.ttf").getFont(Font.BOLD,120)),
    UBUNTULIGHTB118(new FuentesModificadas("/resources/fonts/UbuntuLight.ttf").getFont(Font.BOLD,118)),
    PURISA18(new FuentesModificadas("/resources/fonts/Purisa-Bold.ttf").getFont(Font.PLAIN,18)),
    PURISA22(new FuentesModificadas("/resources/fonts/Purisa-Bold.ttf").getFont(Font.PLAIN,22)),
    DIALOG35(new Font(Font.DIALOG,Font.BOLD,35)),
    SEGOEUISYMBOL22(new FuentesModificadas("/resources/fonts/Segoe UI Symbol.ttf").getFont(Font.PLAIN,22)),
    UBUNTUMONO15(new FuentesModificadas("/resources/fonts/UbuntuMono-R.ttf").getFont(Font.PLAIN,14));
    private Font font;
    Fuentes(Font font){
        this.font=font;
    }
    /**
     * Fuentes de texto predefinidas para utilizar en el proyecto
     * @return {@link Font} deseada
     */
    public Font getFont() {
        return font;
    }
}