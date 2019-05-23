package tools;
import java.awt.*;
import java.io.InputStream;
public class FuentesModificadas {
    private Font font=null;
    /**
     * Crea nuevas fuentes de texto al proyecto,<br/>
     * y las registra en el GraphicsEnvironment,<br/>
     * para poder ser utilizada desde el
     * @param url {@link String}
     * @author Sergio Majé
     */
    protected FuentesModificadas(String url){
        try{
            InputStream stream=getClass().getResourceAsStream(url);
            font=Font.createFont(Font.TRUETYPE_FONT,stream);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
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
     * @author Sergio Majé
     */
    protected Font getFont(int style,int size) {
        return font.deriveFont(style,size);
    }
}