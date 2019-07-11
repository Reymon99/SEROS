package gui.contenido;
import eventos.Eventos;
import gui.contenido.scroll.ModernScrollPane;
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
        init();
    }
    @Override
    public void clean() {
        Eventos.scroll(pane,0);
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
        back(Text.VENTANAPRINCIPAL.toString(),Paneles.PRINCIPAL);
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