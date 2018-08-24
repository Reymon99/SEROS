package logica;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
public abstract class Image {
    public static ImageIcon image(String path,int width,int height) {
        try{
            return new ImageIcon(ImageIO.read(Image.class.getResource(path)).getScaledInstance(width,height,java.awt.Image.SCALE_DEFAULT));
        } catch (IOException e) {
            return null;
        }
    }
}