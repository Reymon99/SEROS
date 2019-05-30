package gui.contenido;
import eventos.Eventos;
import tools.Fuentes;
import tools.Archivos;
import tools.Constrains;
import tools.Paneles;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public abstract class Contenido extends Lienzo {
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
        title=new JLabel(getClass().getSimpleName());
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(Fuentes.UBUNTULIGHT50.getFont());
        title.setOpaque(false);
        contenido=new Lienzo(new GridBagLayout());
        JScrollPane pane = new JScrollPane(contenido, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setWheelScrollingEnabled(true);
        pane.getViewport().setView(contenido);
        pane.setBorder(null);
        pane.setOpaque(false);
        pane.getVerticalScrollBar().setUnitIncrement(8);
        pane.requestFocus();
        back=new Boton(Archivos.image("/recourses/image/back.png",48,48));
        next=new Boton(Archivos.image("/recourses/image/next.png",48,48));
        back.setToolTipText("Ventana Principal");
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.PRINCIPAL.toString());
            }
        });
        Constrains.addComp(title,this,0,0,3,1,1,1,15,15,8,10, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);
        Constrains.addComp(pane,this,0,1,3,1,1,25,5,20,10,15, GridBagConstraints.NORTH, GridBagConstraints.BOTH);
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
}