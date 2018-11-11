package logica;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.net.URISyntaxException;
public abstract class Archivos {
    public static ImageIcon image(String path,int width,int height) {
        try{
            return new ImageIcon(ImageIO.read(Archivos.class.getResource(path)).getScaledInstance(width,height,java.awt.Image.SCALE_DEFAULT));
        } catch (IOException e) {
            return null;
        }
    }
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