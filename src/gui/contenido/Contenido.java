package gui.contenido;
import eventos.Eventos;
import gui.contenido.scroll.ModernScrollPane;
import tools.Acciones;
import tools.Constrains;
import tools.Fuentes;
import tools.Paneles;
import tools.Text;
import javax.swing.*;
import java.awt.*;
public final class Contenido extends Lienzo {
    private JPanel contenido;
    private JLabel title;
    private ModernScrollPane pane;
    /**
     * Esquema de los paneles de contenido del proyecto
     */
    public Contenido(){
        super(new GridBagLayout(),true);
        setAcciones(new Acciones() {
            @Override
            public void iteracion0() {//None
            }
            @Override
            public void iteracion1() {//None
            }
            @Override
            public void clean() {
                Eventos.scroll(pane,0);
            }
        });
        init();
    }
    /**
     * Instanciación y acomodamiento de los componentes del panel
     */
    private void init() {
        title=new JLabel();
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(Fuentes.UBUNTU_LIGHT_50.getFont());
        title.setOpaque(false);
        contenido=new JPanel(new GridBagLayout());
        contenido.setOpaque(false);
        pane = new ModernScrollPane(contenido);
        pane.setWheelScrollingEnabled(true);
        pane.getViewport().setView(contenido);
        pane.setOpaque(false);
        pane.getViewport().setOpaque(false);
        pane.setBorder(BorderFactory.createEmptyBorder());
        pane.getVerticalScrollBar().setUnitIncrement(50);
        pane.setFocusable(true);
        back(Text.VENTANAPRINCIPAL.toString(), Paneles.PRINCIPAL);
        Constrains.addComp(title,this,new Rectangle(0,0,3,1), 1,1,new Insets(15,15,8,10), GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);
        Constrains.addComp(pane,this,new Rectangle(0,1,3,1), 1,25,new Insets(5,20,10,15), GridBagConstraints.NORTH, GridBagConstraints.BOTH);
        Constrains.addComp(getBack(),this,new Rectangle(0,2,1,1), 0,0,new Insets(10,7,10,2), GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE);
        Constrains.addComp(getNext(),this,new Rectangle(2,2,1,1), 0,0,new Insets(10,2,10,7), GridBagConstraints.SOUTHEAST,GridBagConstraints.NONE);
    }
    /**
     * Descripción del contenido de la temática
     * @return contenido {@link JPanel}
     */
    public JPanel getContenido() {
        return contenido;
    }
    /**
     * Título del contenido
     * @return title {@link JLabel}
     */
    public JLabel getTitle() {
        return title;
    }
}