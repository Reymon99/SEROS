package fuentes;
import java.awt.*;
import java.io.InputStream;
public class FuentesModificadas {
    private Font font=null;
    /**
     * Crea nuevas fuentes de texto al proyecto
     * @param url {@link String}
     */
    protected FuentesModificadas(String url){
        try{
            InputStream stream=getClass().getResourceAsStream(url);
            font=Font.createFont(Font.TRUETYPE_FONT,stream);
        }catch (Exception e){
            System.err.println("No se encontro la fuente");
            font=new Font(Font.MONOSPACED,Font.PLAIN,10);
        }
    }
    /**
     * Obtiene la fuente creada y la convierte a Font tomando en cuenta el estilo y tamaño deseado
     * @param style int
     * @param size int
     * @return Font
     */
    protected Font getFont(int style,int size) {
        return font.deriveFont(style,size);
    }
}