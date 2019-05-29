package tools;
import java.awt.Font;
public enum Fuentes {
    UBUNTULIGHT14(new FuentesModificadas("/recourses/fonts/UbuntuLight.ttf").getFont(Font.BOLD,14)),
    UBUNTULIGHT15(new FuentesModificadas("/recourses/fonts/UbuntuLight.ttf").getFont(Font.PLAIN,15)),
    UBUNTULIGHT50(new FuentesModificadas("/recourses/fonts/UbuntuLight.ttf").getFont(Font.BOLD,47)),
    UBUNTULIGHT18(new FuentesModificadas("/recourses/fonts/UbuntuLight.ttf").getFont(Font.PLAIN,18)),
    UBUNTULIGHT20(new FuentesModificadas("/recourses/fonts/UbuntuLight.ttf").getFont(Font.PLAIN,20)),
    UBUNTULIGHT30(new FuentesModificadas("/recourses/fonts/UbuntuLight.ttf").getFont(Font.PLAIN,30)),
    UBUNTULIGHTB30(new FuentesModificadas("/recourses/fonts/UbuntuLight.ttf").getFont(Font.BOLD,30)),
    PURISA18(new FuentesModificadas("/recourses/fonts/Purisa-Bold.ttf").getFont(Font.PLAIN,18)),
    PURISA22(new FuentesModificadas("/recourses/fonts/Purisa-Bold.ttf").getFont(Font.PLAIN,22)),
    MYHAPPYENDING30(new FuentesModificadas("/recourses/fonts/My Happy Ending.ttf").getFont(Font.PLAIN,150)),
    PURISA15(new FuentesModificadas("/recourses/fonts/Purisa-Bold.ttf").getFont(Font.PLAIN,15)),
    DIALOG30(new Font(Font.DIALOG,Font.BOLD,30)),
    SEGOEUISYMBOL22(new FuentesModificadas("/recourses/fonts/Segoe UI Symbol.ttf").getFont(Font.PLAIN,22));
    private Font font;
    private Fuentes(Font font){
        this.font=font;
    }
    /**
     *Fuentes de texto predefinidas para utilizar en el proyecto
     * @return Font
     * @author Sergio Majé
     */
    public Font getFont() {
        return font;
    }
}