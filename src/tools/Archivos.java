package tools;
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
     * @author Sergio Majé
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
     * @param path {@link String} ruta del archivo
     * @return {@link String} texto convertido en cadena
     * @throws {@link IOException}
     * @author Sergio Majé
     */
    public static String codefiles(String path) throws IOException {
        try {
            BufferedReader br=new BufferedReader(new FileReader(Archivos.class.getResource(path).toURI().getPath()));
            String cadena;
            StringBuilder txt= new StringBuilder();
            while ((cadena=br.readLine())!=null) txt.append(cadena).append("\n");
            br.close();
            return txt.toString();
        } catch (URISyntaxException | IOException e) {
            throw new IOException(e.getMessage());
        }
    }
}