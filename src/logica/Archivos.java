package logica;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.net.URISyntaxException;
public abstract class Archivos {
    /**
     * Convierte y moldea una Imagen para ser utilizada en el proyecto
     * @param path String
     * @param width int
     * @param height int
     * @return ImageIcon
     */
    public static ImageIcon image(String path,int width,int height) {
        try{
            return new ImageIcon(ImageIO.read(Archivos.class.getResource(path)).getScaledInstance(width,height,java.awt.Image.SCALE_DEFAULT));
        } catch (IOException e) {
            return null;
        }
    }
    /**
     * Lee los archivos de texto que contiene el codigo formateado para ser utilizado en el proyecto
     * @param path {@link String}
     * @return String
     */
    public static String codefiles(String path){
        try {
            BufferedReader br=new BufferedReader(new FileReader(Archivos.class.getResource(path).toURI().getPath()));
            String cadena,txt="";
            while ((cadena=br.readLine())!=null) txt+=cadena+"\t\n";
            br.close();
            return txt;
        } catch (URISyntaxException | IOException e) {
            return null;
        }
    }
}