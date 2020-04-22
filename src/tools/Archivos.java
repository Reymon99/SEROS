package tools;

import org.yaml.snakeyaml.Yaml;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Archivos {
    /**
     * Convierte y moldea una Imagen para ser utilizada en el proyecto
     * @param path   String
     * @param width  int
     * @param height int
     * @return ImageIcon
     */
    public static ImageIcon image(String path, int width, int height) {
        try {
            return new ImageIcon(ImageIO.read(Archivos.class.getResource(path)).getScaledInstance(
                    width,
                    height,
                    Image.SCALE_DEFAULT
            ));
        } catch (IOException e) {
            throw new IllegalArgumentException("Imagen " + path + " no encontrada.");
        }
    }

    /**
     * Convierte y moldea una Imagen con su tamaño original para ser utilizada en el proyecto
     * @param path ruta de la imagen
     * @return Imagen lista para ser usada en el proyecto
     */
    public static ImageIcon image(String path) {
        return image(path, -1, -1);
    }

    /**
     * Convierte y moldea una Imagen para ser utilizada en el proyecto
     * @param path ruta de la imagen
     * @param dimension tamaño a dar a la imagen en width y weight
     * @return Imagen con el tamaño deseado lista para ser usada en el proyecto
     */
    public static ImageIcon image(String path, int dimension) {
        return image(path, dimension, dimension);
    }

    /**
     * Exporta una determinada imagen tomada de un componente del proyecto a la ruta indicada
     * @param file  ruta a exportar imagen
     * @param image imagen de un componente del proyecto
     * @return informa acerca del camino favorable o no de la exportación de la imagen
     */
    public static String exportImage(File file, RenderedImage image) {
        try {
            return ImageIO.write(image, "jpg", file) ?
                    "Lienzo exportado exitosamente como imagen" : "No se pudo exportar el lienzo como imagen";
        } catch (IOException e) {
            return "No se pudo exportar el lienzo como imagen";
        }
    }

    /**
     * Exporta un determinado archivo de código Java de un determinado {@link gui.editor.Editor}
     * @param file ruta a exportar código Java
     * @param text código a fijar en el archivo Java
     * @return informa acerca del camino favorable o no de la exportación del archivo Java
     */
    public static String exportCode(File file, String text) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(text);
            bw.close();
            return "Código exportado exitosamente como archivo Java";
        } catch (IOException e) {
            return "No se pudo exportar el código del editor como archivo";
        }
    }

    public static boolean createdFolder(File file, String folder) {
        if (!file.exists() && file.isDirectory()) return new File(file.getAbsolutePath(), folder).mkdir();
        return false;
    }

    /**
     * Carga el archivo .YML especificado en la ruta /resources/
     * @param fileYaml nombre del archivo YAML a especificar
     * @return contenido del archivo YAML especificado
     */
    public static Object readYAML(String fileYaml) {
        return new Yaml().load(Archivos.class.getResourceAsStream("/resources/" + fileYaml));
    }
}