package fuentes;
import java.awt.*;
import java.io.InputStream;
public class UbuntuLightFont {
    private Font font=null;
    public UbuntuLightFont(){
        try{
            InputStream stream=getClass().getResourceAsStream("/fuentes/UbuntuLight.ttf");
            font=Font.createFont(Font.TRUETYPE_FONT,stream);
        }catch (Exception e){
            System.err.println("No se encontro la fuente");
            font=new Font(Font.MONOSPACED,Font.PLAIN,10);
        }
    }
    protected Font getFont(int style,int size) {
        return font.deriveFont(style,size);
    }
}