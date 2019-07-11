package gui.simulador.liezos;

import eventos.Eventos;
import gui.contenido.Boton;
import gui.contenido.ButtonSimulador;
import gui.contenido.Switch;
import gui.contenido.Texto;
import gui.contenido.scroll.ModernScrollPane;
import tools.Archivos;
import tools.Colour;
import tools.Constrains;
import tools.Fuentes;
import tools.Paneles;
import tools.Text;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class Simulador extends JPanel {
    private Integer iteracion;
    private Component component;
    private JPanel datos;
    private JPanel panel;
    private JTabbedPane codigos;
    private Boton back;
    private Boton home;
    private ButtonSimulador clean;
    private ButtonSimulador next;
    private ButtonSimulador send;
    private Switch codigo;
    private Switch pause;
    private Texto texto;
    public static final Dimension canvasSize;
    static {
        canvasSize = new Dimension((int) (Toolkit.getDefaultToolkit().getScreenSize().width*0.73),(int) (Toolkit.getDefaultToolkit().getScreenSize().height*0.8));
    }
    /**
     * Esquema de los simuladores del proyecto
     */
    public Simulador(){
        this(new JPanel(new GridBagLayout()));
        component.setPreferredSize(canvasSize);
        component.setSize(canvasSize);
        component.setMinimumSize(canvasSize);
    }
    /**
     * Esquema de los simuladores del proyecto
     * @param component {@link Component} a mostrar el objeto simulado
     */
    public Simulador(Component component){
        this.component = component;
        iteracion = 0;
        setLayout(new GridBagLayout());
        init();
    }
    /**
     * Instanciacion y acomodamiento de los componentes del panel
     */
    private void init() {
        codigo=new Switch("Visualización del Código",false);
        pause=new Switch("Paso a Paso",false);
        send=new ButtonSimulador("Enviar",true,e -> {
            if (pause.isOnOff()) iteracion1();
            else iteracion0();
        });
        clean=new ButtonSimulador("Limpiar",false,e -> clean());
        next=new ButtonSimulador("Siguiente",false, e -> iteracion1());
        panel=new JPanel(new GridBagLayout());
        panel.setBackground(Colour.GRISPANEL.getColor());
        JLabel desc=new JLabel("Descripción");
        desc.setFont(Fuentes.UBUNTULIGHT14.getFont());
        desc.setForeground(Colour.BLANCO.getColor());
        desc.setBackground(Colour.AZULTITLE.getColor());
        desc.setOpaque(true);
        codigo.setModificable(false);
        pause.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                codigo.setModificable(pause.isOnOff());
                if (!pause.isOnOff() && codigo.isOnOff()) codigo.setOnOff(pause.isOnOff());
            }
        });
        Insets insets=new Insets(0,0,0,0);
        Constrains.addComp(component,this,new Rectangle(0,0,1,4),0,0,insets,GridBagConstraints.NORTHWEST,GridBagConstraints.NONE);
        Constrains.addComp(back=new Boton(Archivos.image("/recourses/image/back.png",-1,-1)),panel,new Rectangle(0,0,1,2),0,0,new Insets(15,15,15,5),GridBagConstraints.WEST,GridBagConstraints.NONE);
        Constrains.addComp(home=new Boton(Text.VENTANAPRINCIPAL.toString(), Archivos.image("/recourses/image/home.png", -1, -1), new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clean();
                Eventos.show(Paneles.PRINCIPAL);
            }
        }),panel,new Rectangle(1,0,1,2),0,0,new Insets(20,5,20,15),GridBagConstraints.WEST,GridBagConstraints.NONE);
        Constrains.addComp(panel,this,new Rectangle(0,4,1,1),1,1,insets,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        Constrains.addCompX(desc,this,new Rectangle(1,0,1,1),1,insets,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompIy(texto=new Texto(4,55),this,new Rectangle(1,1,1,1),1,0,insets,35,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        Constrains.addCompIy(new ModernScrollPane(datos=new JPanel(new GridBagLayout())),this,new Rectangle(1,2,1,1),1,0,insets,200, GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        Constrains.addComp((codigos=new JTabbedPane(JTabbedPane.TOP)),this,new Rectangle(1,3,1,2),1,1,insets,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
    }
    public abstract void iteracion0();
    public abstract void iteracion1();
    public abstract void clean();
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
                clean();
                Eventos.show(paneles);
            }
        });
    }
}