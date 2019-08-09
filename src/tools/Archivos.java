package tools;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.RenderedImage;
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
    /**
     * Exporta una determinada imagen tomada de un componente del proyecto a la ruta indicada
     * @param file ruta a exportar imagen
     * @param image imagen de un componente del proyecto
     * @return informa acerca del camino favorable o no de la exportación de la imagen
     */
    public static String exportImage(File file, RenderedImage image){
        try {
            return ImageIO.write(image, "jpg", file) ? "Lienzo exportado exitosamente como imagen" : "No se pudo exportar el lienzo como imagen";
        } catch (IOException e) {
            return "No se pudo exportar el lienzo como imagen";
        }
    }
}