package gui.paneles.about;

import javax.swing.*;
import java.awt.*;

public class About extends JDialog {
    public About(){

    }
    private void init(){

    }
    @Override
    public void paint(Graphics g) {
        g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/recourses/image/Lienzo.jpg")),0,0,getWidth(),getHeight(),this);
        super.paint(g);
    }
}
