package tools;
import java.awt.*;
import java.io.IOException;
public class FuentesModificadas {
    private Font font;
    /**
     * Crea nuevas fuentes tipográficas al proyecto,<br/>
     * y las registra en el GraphicsEnvironment,<br/>
     * para poder ser utilizada desde en el mismo proyecto
     * @param path ruta de la fuente a crear
     */
    protected FuentesModificadas(String path){
        try{
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font=Font.createFont(Font.TRUETYPE_FONT,getClass().getResourceAsStream(path)));
        } catch (FontFormatException | IOException e) {
            font=new Font(Font.MONOSPACED,Font.PLAIN,10);
        }
    }
    /**
     * Obtiene la fuente creada y la convierte a Font tomando en cuenta el estilo y tamaño deseado
     * @param style estilo de la fuente
     * @param size tamaño de la fuente
     * @return Font fuente deseada
     */
    protected Font getFont(int style,int size){
        return font.deriveFont(style, size);
    }
}