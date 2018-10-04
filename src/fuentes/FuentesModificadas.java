package fuentes;
import java.awt.*;
import java.io.InputStream;
public class FuentesModificadas {
    private Font font=null;
    public FuentesModificadas(String url){
        try{
            InputStream stream=getClass().getResourceAsStream(url);
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