package tools;
import java.awt.*;
public enum Fuentes {
    UBUNTU_LIGHT_12(new FuentesModificadas("/resources/fonts/UbuntuLight.ttf").getFont(Font.PLAIN, 12)),
    UBUNTU_LIGHT_14(new FuentesModificadas("/resources/fonts/UbuntuLight.ttf").getFont(Font.BOLD, 14)),
    UBUNTU_LIGHT_15(new FuentesModificadas("/resources/fonts/UbuntuLight.ttf").getFont(Font.PLAIN, 15)),
    UBUNTU_LIGHT_50(new FuentesModificadas("/resources/fonts/UbuntuLight.ttf").getFont(Font.BOLD, 50)),
    UBUNTU_LIGHT_20(new FuentesModificadas("/resources/fonts/UbuntuLight.ttf").getFont(Font.PLAIN, 20)),
    UBUNTU_LIGHT_30(new FuentesModificadas("/resources/fonts/UbuntuLight.ttf").getFont(Font.PLAIN, 30)),
    UBUNTU_LIGHT_B_30(new FuentesModificadas("/resources/fonts/UbuntuLight.ttf").getFont(Font.BOLD, 30)),
    UBUNTU_LIGHT_40(new FuentesModificadas("/resources/fonts/UbuntuLight.ttf").getFont(Font.PLAIN, 40)),
    UBUNTU_LIGHT_B_118(new FuentesModificadas("/resources/fonts/UbuntuLight.ttf").getFont(Font.BOLD, 118)),
    PURISA_18(new FuentesModificadas("/resources/fonts/Purisa-Bold.ttf").getFont(Font.PLAIN, 18)),
    PURISA_22(new FuentesModificadas("/resources/fonts/Purisa-Bold.ttf").getFont(Font.PLAIN, 22)),
    DIALOG_35(new Font(Font.DIALOG, Font.BOLD, 35)),
    SEGOE_UI_SYMBOL_22(new FuentesModificadas("/resources/fonts/Segoe UI Symbol.ttf").getFont(Font.PLAIN,  22)),
    UBUNTU_MONO_15(new FuentesModificadas("/resources/fonts/UbuntuMono-R.ttf").getFont(Font.PLAIN, 14));
    private Font font;
    Fuentes(Font font){
        this.font = font;
    }
    /**
     * Fuentes de texto predefinidas para utilizar en el proyecto
     * @return {@link Font} deseada
     */
    public Font getFont() {
        return font;
    }
}