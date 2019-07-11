package gui.simulador;
import gui.contenido.ButtonSimulador;
import gui.contenido.Lienzo;
import gui.contenido.Switch;
import gui.contenido.Texto;
import gui.contenido.Tree;
import gui.contenido.scroll.ModernScrollPane;
import gui.editor.Editor;
import tools.Colour;
import tools.Constrains;
import tools.Fuentes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public abstract class Simulador extends Lienzo {
    private Integer iteracion;
    private Component component;
    private JPanel datos;
    private JPanel panel;
    private JTabbedPane codigos;
    private ButtonSimulador clean;
    private ButtonSimulador nextIteracion;
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
        super(new GridBagLayout(),false);
        this.component = component;
        iteracion = 0;
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
        nextIteracion=new ButtonSimulador("Siguiente",false, e -> iteracion1());
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
        Constrains.addComp(getBack(),panel,new Rectangle(0,0,1,2),0,0,new Insets(15,15,15,5),GridBagConstraints.WEST,GridBagConstraints.NONE);
        Constrains.addComp(getHome(),panel,new Rectangle(1,0,1,2),0,0,new Insets(20,5,20,15),GridBagConstraints.WEST,GridBagConstraints.NONE);
        Constrains.addComp(panel,this,new Rectangle(0,4,1,1),1,1,insets,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        Constrains.addCompX(desc,this,new Rectangle(1,0,1,1),1,insets,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompIy(texto=new Texto(4,55),this,new Rectangle(1,1,1,1),1,0,insets,35,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        Constrains.addCompIy(new ModernScrollPane(datos=new JPanel(new GridBagLayout())),this,new Rectangle(1,2,1,1),1,0,insets,200, GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        Constrains.addComp((codigos=new JTabbedPane(JTabbedPane.TOP)),this,new Rectangle(1,3,1,2),1,1,insets,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
    }
    /**
     * Iteración del simulador cuando no se ejecuta el paso a paso
     */
    public abstract void iteracion0();
    /**
     * Iteración del simulador con paso a paso
     */
    public abstract void iteracion1();
    /**
     * Añade los codigos que necesita el simulador
     * @param editor {@link Editor} con el código correspondiente
     * @param title nombre del código a añadir
     */
    public void addCodes(Editor editor,String title){
        codigos.add(title, editor);
    }
    /**
     * Fijar un texto determinado en el área de notificaciones
     * @param texto texto a fijar determinadamente
     */
    public void setTexto(String texto){
        this.texto.setEditable(true);
        this.texto.setText(texto);
        this.texto.setEditable(false);
    }
    /**
     * Variables que se van a agregar
     * @param trees {@link Tree} a agregar
     */
    public void setDatos(Tree... trees){
        for (int i = 0; i < trees.length; i++) Constrains.addComp(trees[i],datos,new Rectangle(0,i,1,1),1,1,new Insets(i==0 ? 7:2,10,1,5),GridBagConstraints.CENTER,GridBagConstraints.BOTH);
    }
    /**
     * Componente de área de Notificaciones
     * @return área de notificaciones
     */
    public Texto getTexto() {
        return texto;
    }
    /**
     * Panel de control de comandos del simulador
     * @return panel de control
     */
    public JPanel getPanel() {
        return panel;
    }
    /**
     * Obtiene el área gráfica del simulador
     * @return área gráfica del simulador
     */
    public Component getComponent() {
        return component;
    }
    /**
     * Obtiene el contenedor de los códigos del simulador
     * @return Contenedor de los códigos del simulador
     */
    public JTabbedPane getCodigos() {
        return codigos;
    }
    /**
     * Obtiene la cantidad pulsaciones del paso a paso del simulador
     * @return cantidad de pulsaciones
     */
    public int getIteraccion() {
        return iteracion;
    }
    /**
     * Fija un nuevo valor a la iteración de pulsaciones del simulador
     * @param iteracion nuevo valor de iteración
     */
    public void setIteracion(Integer iteracion) {
        this.iteracion = iteracion;
    }
    /**
     * Incrementa a paso uno las pulsaciones del paso a paso del simulador en la ejecución
     */
    public void incrementIteracion(){
        iteracion++;
    }
    /**
     * Decrementa a paso uno las pulsaciones del paso a paso del simulador en la ejecución
     */
    public void decrementIteracion(){
        iteracion--;
    }
    /**
     * Obtiene el componente de paso a paso del simulador
     * @return elección del paso a paso del simulador
     */
    public Switch getPause() {
        return pause;
    }
    /**
     * Obtiene el componente de visualización del código en el paso a paso en el simulador
     * @return visualización del paso a paso
     */
    protected Switch getCodigo() {
        return codigo;
    }
    /**
     * Boton de envio de datos al simulador
     * @return envio de datos
     */
    public ButtonSimulador getSend() {
        return send;
    }
    /**
     * Boton de reinicio del simulador
     * @return reinicio del simulador
     */
    public ButtonSimulador getClean() {
        return clean;
    }
    /**
     * Boton de paso a paso del simulador
     * @return boton del paso a paso
     */
    public ButtonSimulador getNextIteracion() {
        return nextIteracion;
    }
}