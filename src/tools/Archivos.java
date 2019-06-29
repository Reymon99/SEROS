package tools;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.io.IOException;
import java.net.URISyntaxException;
public abstract class Archivos {
    /**
     * Convierte y moldea una Imagen para ser utilizada en el proyecto
     * @param path String
     * @param width int
     * @param height int
     * @return ImageIcon
     */
    public static ImageIcon image(String path, int width, int height) {
        try{
            return new ImageIcon(ImageIO.read(Archivos.class.getResource(path)).getScaledInstance(width,height, Image.SCALE_DEFAULT));
        } catch (IOException e) {
            return null;
        }
    }
    /**
     * Lee los archivos de texto que contiene el código formateado para ser utilizado en el proyecto
     * @param path ruta del archivo
     * @return contenido del archivo
     */
    public static String codefiles(String path){
        StringBuilder txt=new StringBuilder();
        try{
            BufferedReader br=new BufferedReader(new FileReader(Archivos.class.getResource(path).toURI().getPath()));
            String cadena;
            while ((cadena=br.readLine())!=null) txt.append(cadena).append('\n');
            br.close();
        } catch (URISyntaxException | IOException e) {//None
        }
        return txt.toString();
    }
}