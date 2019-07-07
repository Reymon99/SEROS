package gui.contenido;
import eventos.Eventos;
import gui.contenido.scroll.ModernScrollPane;
import tools.Archivos;
import tools.Constrains;
import tools.Fuentes;
import tools.Paneles;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Contenido extends Lienzo {
    private JPanel contenido;
    private Boton back;
    private Boton next;
    private JLabel title;
    private ModernScrollPane pane;
    /**
     * Esquema de los paneles de contenido del proyecto
     */
    public Contenido(){
        setLayout(new GridBagLayout());
        init();
    }
    /**
     * Instanciación y acomodamiento de los componentes del panel
     */
    private void init() {
        title=new JLabel();
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(Fuentes.UBUNTULIGHT50.getFont());
        title.setOpaque(false);
        contenido=new JPanel(new GridBagLayout());
        contenido.setOpaque(false);
        pane = new ModernScrollPane(contenido);
        pane.setWheelScrollingEnabled(true);
        pane.getViewport().setView(contenido);
        pane.setOpaque(false);
        pane.getViewport().setOpaque(false);
        pane.setBorder(BorderFactory.createEmptyBorder());
        pane.getVerticalScrollBar().setUnitIncrement(30);
        pane.setFocusable(true);
        Constrains.addComp(title,this,0,0,3,1,1,1,new Insets(15,15,8,10), GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);
        Constrains.addComp(pane,this,0,1,3,1,1,25,new Insets(5,20,10,15), GridBagConstraints.NORTH, GridBagConstraints.BOTH);
        Constrains.addComp(back=new Boton("Ventana Principal", Archivos.image("/recourses/image/back.png",48,48),new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.PRINCIPAL);
                Eventos.scroll(pane,0);
            }
        }),this,0,2,1,1,0,0,new Insets(10,7,10,2), GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE);
        Constrains.addComp(next=new Boton(Archivos.image("/recourses/image/next.png",48,48)),this,2,2,1,1,0,0,new Insets(10,2,10,7), GridBagConstraints.SOUTHEAST,GridBagConstraints.NONE);
    }
    /**
     * Descripción del contenido de la temática
     * @return contenido {@link JPanel}
     */
    public JPanel getContenido() {
        return contenido;
    }
    /**
     * Boton de retroceder
     * @return back {@link Boton}
     */
    public Boton getBack() {
        return back;
    }
    /**
     * Boton de avanzar
     * @return next {@link Boton}
     */
    public Boton getNext() {
        return next;
    }
    /**
     * Titulo del contenido
     * @return title {@link JLabel}
     */
    public JLabel getTitle() {
        return title;
    }
    /**
     * Retorna el Scroll del Contenido
     * @return scroll del contenido
     */
    public ModernScrollPane getPane() {
        return pane;
    }
}