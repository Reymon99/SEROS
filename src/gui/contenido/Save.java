package gui.contenido;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
public class Save extends JFileChooser {
    private boolean isImage;
    /**
     * Selecciona la ruta donde se va a guardar la imagen del lienzo del simulador
     * @param isImage decide si el filtro del {@link JFileChooser} es de imagenes o archivos Java
     * @param name nombre por defecto del archivo a guardar
     */
    public Save(boolean isImage, String name){
        this(isImage);
        setSelectedFile(new File(getCurrentDirectory(), name+(isImage ? ".jpg" : ".java")));
    }
    /**
     * Selecciona la ruta donde se va a guardar la imagen del lienzo del simulador
     * @param isImage decide si el filtro del {@link JFileChooser} es de imagenes o archivos Java
     */
    public Save(boolean isImage) {
        this.isImage = isImage;
        setFileSelectionMode(FILES_AND_DIRECTORIES);
        setFileFilter(new FileNameExtensionFilter(isImage ? "JPG Imagen" : "Java Archivo", isImage ? "jpg" : "java"));
        setDialogTitle("Exportando "+(isImage ? "Imagen" : "Archivo"));
    }
    /**
     * Da la ruta indicada por el usuario para guardar la imagen del lienzo del simulador
     * @return ruta convertida en un archivo
     */
    public File getFile() throws FileNotFoundException {
        int i = showSaveDialog(null);
        File file=getSelectedFile();
        if (i==APPROVE_OPTION) return file.getName().endsWith(isImage ? ".jpg" : ".java") ? file : new File(file.getAbsolutePath()+(isImage ? ".jpg" : ".java"));
        else throw new FileNotFoundException("Ruta no especificada");
    }
}