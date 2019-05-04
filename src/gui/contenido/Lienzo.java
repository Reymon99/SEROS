package gui.contenido;
import javax.swing.*;
import java.awt.*;
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
        g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/recourses/image/Lienzo.jpg")),0,0,getWidth(),getHeight(),this);
        setOpaque(false);
        super.paint(g);
    }
}