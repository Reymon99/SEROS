package gui.simulador;
import gui.contenido.*;
import gui.contenido.scroll.ModernScrollPane;
import gui.editor.Editor;
import tools.Colour;
import tools.Fuentes;
import tools.Archivos;
import tools.Constrains;
import javax.swing.*;
import java.awt.*;
public abstract class Simulador extends JPanel {
    private Component component;
    private Texto texto;
    private JPanel datos;
    private JTabbedPane codigos;
    private JPanel panel;
    private Boton back;
    public static Dimension canvasSize=new Dimension((int) (Toolkit.getDefaultToolkit().getScreenSize().width*0.73),(int) (Toolkit.getDefaultToolkit().getScreenSize().height*0.8));
    private int interaccion;
    private Switch pause;
    private ButtonSimulador send;
    private ButtonSimulador clean;
    private ButtonSimulador next;
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
     * @param component {@link Component}
     */
    public Simulador(Component component) {
        this.component = component;
        interaccion=0;
        setLayout(new GridBagLayout());
        init();
    }
    /**
     * Instanciacion y acomodamiento de los componentes del panel
     */
    private void init(){
        pause=new Switch("Paso a paso",false);
        send=new ButtonSimulador("Enviar",true);
        clean=new ButtonSimulador("Limpiar",false);
        next=new ButtonSimulador("Siguiente",false);
        back=new Boton(Archivos.image("/recourses/image/back.png",48,48));
        panel=new JPanel(new GridBagLayout());
        panel.setBackground(Colour.GRISPANEL.getColor());
        JLabel desc=new JLabel("Descripción");
        desc.setFont(Fuentes.UBUNTULIGHT14.getFont());
        desc.setForeground(Color.WHITE);
        desc.setBackground(Colour.AZULTITLE.getColor());
        desc.setOpaque(true);
        clean.addActionListener(e -> clean());
        send.addActionListener(e -> {
            if (pause.isOnOff()) iteracion1();
            else iteracion0();
        });
        next.addActionListener(e -> iteracion1());
        Constrains.addComp(component,this,0,0,1,4,0,0,0,0,0,0,GridBagConstraints.NORTHWEST,GridBagConstraints.NONE);
        Constrains.addComp(back,panel,0,0,1,2,1,1,15,15,15,15,GridBagConstraints.WEST,GridBagConstraints.NONE);
        Constrains.addComp(panel,this,0,4,1,1,1,1,0,0,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        Constrains.addCompX(desc,this,1,0,1,1,1,0,0,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompIy((texto=new Texto(4,55)),this,1,1,1,1,1,0,0,0,0,0,35,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        Constrains.addCompIy(new ModernScrollPane(datos=new JPanel(new GridBagLayout())),this,1,2,1,1,1,0,0,0,0,0,200, GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        Constrains.addComp((codigos=new JTabbedPane(JTabbedPane.TOP)),this,1,3,1,2,1,1,0,0,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
    }
    /**
     * Notificaciones
     * @return texto {@link JTextArea}
     */
    public Texto getTexto() {
        return texto;
    }
    /**
     * Variables que se van a agregar
     * @param trees {@link Tree} a agregar
     */
    public void setDatos(Tree... trees){
        for (int i = 0; i < trees.length; i++) Constrains.addComp(trees[i],datos,0,i,1,1,1,1,i==0 ? 7:2,10,1,5,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
    }
    /**
     * panel de comandos del simulador
     * @return {@link JPanel} de gestión
     */
    public JPanel getPanel() {
        return panel;
    }
    /**
     * Retornar al panel anterior
     * @return JLabel
     */
    public Boton getBack() {
        return back;
    }
    /**
     * Añade los codigos que necesita el simulador
     * @param code {@link JScrollPane}
     */
    public void addCodes(Editor code, String title){
        this.codigos.add(title,code);
    }
    /**
     * Fijar texto en el campo de descripción
     * @param texto {@link String} a fijar
     */
    public void setTexto(String texto){
        this.texto.setEditable(true);
        this.texto.setText(texto);
        this.texto.setEditable(false);
    }
    /**
     * Retorna el área grafica del simulador
     * @return área grafica del simulador
     */
    public Component getComponent() {
        return component;
    }
    /**
     * Modifica el área grafica del simulador
     * @param component nueva área grafica del simulador
     */
    public void setComponent(Component component) {
        this.component = component;
    }
    /**
     * Iteración del simulador cuando no se ejecuta el paso a paso
     */
    abstract protected void iteracion0();
    /**
     * Primera iteración del simulador con paso a paso
     */
    abstract protected void iteracion1();
    /**
     * Restaura los componente al origen
     */
    abstract protected void clean();
    public void setInteraccion(int interaccion) {
        this.interaccion = interaccion;
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
    public int getInteraccion() {
        return interaccion;
    }
    /**
     * Obtiene le componente de paso a paso del simulador
     * @return elección del paso a paso del simulador
     */
    protected Switch getPause() {
        return pause;
    }
    /**
     * Boton de envio de datos al simulador
     * @return envio de datos
     */
    protected ButtonSimulador getSend() {
        return send;
    }
    /**
     * Boton de reinicio del simulador
     * @return reinicio del simulador
     */
    protected ButtonSimulador getClean() {
        return clean;
    }
    /**
     * Boton de paso a paso del simulador
     * @return boton del paso a paso
     */
    protected ButtonSimulador getNext() {
        return next;
    }
    /**
     * Incrementa a paso uno las pulsaciones del paso a paso del simulador en la ejecución
     */
    public void incrementIteraccion(){
        interaccion++;
    }
}