package gui.contenido;
import eventos.Eventos;
import tools.Acciones;
import tools.Archivos;
import tools.Paneles;
import tools.Text;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;
public class Lienzo extends JPanel {
    private boolean lienzo;
    private Acciones acciones;
    private Boton back;
    private Boton home;
    private Boton next;
    /**
     * Esquema de los paneles del simulador
     */
    public Lienzo(){
        this(false);
    }
    /**
     * Esquema de los paneles del simulador
     * @param lienzo decide si se pinta el lienzo o no
     */
    public Lienzo(boolean lienzo){
        super();
        init(lienzo);
    }
    /**
     * Esquema de los paneles del simulador
     * @param manager {@link LayoutManager} a utilizar
     * @param lienzo decide si se pinta el lienzo o no
     */
    public Lienzo(LayoutManager manager,boolean lienzo){
        super(manager);
        init(lienzo);
    }
    /**
     * Inicializador de componente
     * @param lienzo decide si se pinta el lienzo o no
     */
    private void init(boolean lienzo){
        this.lienzo=lienzo;
        back=new Boton(Archivos.image("/recourses/image/back.png",-1,-1));
        home=new Boton(Text.VENTANAPRINCIPAL.toString(), Archivos.image("/recourses/image/home.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                acciones.clean();
                Eventos.show(Paneles.PRINCIPAL);
            }
        });
        next=new Boton(Archivos.image("/recourses/image/next.png",-1,-1));
    }
    /**
     * Atributos del botón retroceder
     * @param toolTipText mensaje de ayuda
     * @param paneles panel a retroceder
     */
    public void back(String toolTipText,Paneles paneles){
        back.setToolTipText(toolTipText);
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                acciones.clean();
                Eventos.show(paneles);
            }
        });
    }
    /**
     * Atributos del botón avanzar
     * @param toolTipText mensaje de ayuda
     * @param paneles panel a avanzar
     */
    public void next(String toolTipText,Paneles paneles){
        next.setToolTipText(toolTipText);
        next.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                acciones.clean();
                Eventos.show(paneles);
            }
        });
    }
    /**
     * Obtiene el componente retorno al panel anterior
     * @return Retorna al panel anterior
     */
    public Boton getBack() {
        return back;
    }
    /**
     * Obtiene el componente de retorno al panel principal
     * @return Retorna al panel principal de Seros
     */
    public Boton getHome() {
        return home;
    }
    /**
     * Obtiene el componente retorno al panel siguiente
     * @return Retorna al panel siguiente
     */
    public Boton getNext() {
        return next;
    }
    /**
     * Obtiene las acciones a realizar en el panel
     * @return acciones del panel
     */
    protected Acciones getAcciones() {
        return acciones;
    }
    /**
     * Da nuevas acciones al panel
     * @param acciones nuevas acciones
     */
    public void setAcciones(Acciones acciones) {
        this.acciones = acciones;
    }
    /**
     * Tapiz del panel
     * @param g {@link Graphics}
     */
    @Override
    public void paint(Graphics g) {
        if (lienzo) {
            g.drawImage(Objects.requireNonNull(Archivos.image("/recourses/image/Lienzo.jpg", -1, -1)).getImage(),0,0,getWidth(),getHeight(),this);
            setOpaque(false);
        }
        super.paint(g);
    }
}