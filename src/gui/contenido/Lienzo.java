package gui.contenido;
import tools.Archivos;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;
public class Lienzo extends JPanel {
    public Lienzo(){
        super();
    }
    public Lienzo(LayoutManager manager){
        super(manager);
    }
    /**
     * Tapiz del panel
     * @param g {@link Graphics}
     * @author Sergio Majé
     */
    @Override
    public void paint(Graphics g) {
        g.drawImage(Objects.requireNonNull(Archivos.image("/recourses/image/Lienzo.jpg", -1, -1)).getImage(),0,0,getWidth(),getHeight(),this);
        setOpaque(false);
        super.paint(g);
    }
}