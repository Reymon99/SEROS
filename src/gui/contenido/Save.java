package gui.contenido;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
public class Save extends JFileChooser {
    /**
     * Selecciona la ruta donde se va a guardar la imagen del lienzo del simulador
     */
    public Save() {
        setFileSelectionMode(FILES_AND_DIRECTORIES);
        setFileFilter(new FileNameExtensionFilter("PNG Imagen", "png"));
        setDialogTitle("Exportando Imagen");
    }
    /**
     * Da la ruta indicada por el usuario para guardar la imagen del lienzo del simulador
     * @return ruta convertida en un archivo
     */
    public File getFile(){
        int i = showSaveDialog(null);
        File file=getSelectedFile();
        return i==APPROVE_OPTION ? file.getName().endsWith(".png") ? file : new File(file.getAbsolutePath()+".png") : new File("");
    }
}