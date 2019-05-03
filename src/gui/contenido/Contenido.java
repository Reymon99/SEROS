package gui.contenido;
import tools.Fuentes;
import tools.Archivos;
import tools.Constrains;
import javax.swing.*;
import java.awt.*;
public abstract class Contenido extends JPanel {
    private JPanel contenido;
    private JLabel back,next,title;
    /**
     * Esquema de los paneles de contenido del proyecto
     * @author Sergio Majé
     */
    public Contenido(){
        setLayout(new GridBagLayout());
        init();
    }
    /**
     * Instanciacion y acomodamiento de los componentes del panel
     * @author Sergio Majé
     */
    private void init() {
        title=new JLabel();
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(Fuentes.UBUNTULIGHT43.getFont());
        title.setOpaque(false);
        contenido=new JPanel(new GridBagLayout());
        contenido.setOpaque(false);
        JScrollPane pane = new JScrollPane(contenido, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        pane.setWheelScrollingEnabled(true);
        pane.getViewport().setView(this);
        pane.setBorder(null);
        pane.setOpaque(false);
        //pane.getVerticalScrollBar().setUnitIncrement(6);
        back=new Boton(Archivos.image("/recourses/image/back.png",48,48));
        next=new Boton(Archivos.image("/recourses/image/next.png",48,48));
        Constrains.addComp(title,this,0,0,3,1,1,1,15,15,10,10, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);
        Constrains.addComp(contenido,this,0,1,3,1,1,1,15,20,10,15, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        Constrains.addComp(back,this,0,2,1,1,0,0,10,7,10,2, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE);
        Constrains.addComp(next,this,2,2,1,1,0,0,10,2,10,7, GridBagConstraints.SOUTHEAST,GridBagConstraints.NONE);
    }
    /**
     * Descripcion del contenido de la temática
     * @return contenido {@link JPanel}
     * @author Sergio Majé
     */
    public JPanel getContenido() {
        return contenido;
    }
    /**
     * Boton de retoceder
     * @return back {@link JLabel}
     * @author Sergio Majé
     */
    public JLabel getBack() {
        return back;
    }
    /**
     * Boton de avanzar
     * @return next {@link JLabel}
     * @author Sergio Majé
     */
    public JLabel getNext() {
        return next;
    }
    /**
     * Titulo del contenido
     * @return title {@link JLabel}
     * @author Sergio Majé
     */
    public JLabel getTitle() {
        return title;
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