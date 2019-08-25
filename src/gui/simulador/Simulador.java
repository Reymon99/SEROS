package gui.simulador;
import eventos.Eventos;
import gui.contenido.ButtonSimulador;
import gui.contenido.Lienzo;
import gui.contenido.Message;
import gui.contenido.Switch;
import gui.contenido.Texto;
import gui.contenido.Tree;
import gui.contenido.scroll.ModernScrollPane;
import gui.editor.Editor;
import tools.Archivos;
import tools.Colour;
import tools.Constrains;
import tools.Fuentes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.Optional;
public abstract class Simulador extends Lienzo {
    private Integer iteracion;
    private JComponent lienzo;
    private JPanel datos;
    private JPanel control;
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
     * @param title título de los componentes de registro de datos
     * @param components {@link JComponent}s de registro de datos
     */
    public Simulador(String title, JComponent... components){
        this(new JPanel(new GridBagLayout()), title, components);
    }
    /**
     * Esquema de los simuladores del proyecto
     * @param lienzo {@link JComponent} a mostrar el objeto simulado
     * @param title título de los componentes de registro de datos
     * @param components {@link JComponent}s de registro de datos
     */
    public Simulador(JComponent lienzo, String title, JComponent... components){
        super(new GridBagLayout(),false);
        this.lienzo = lienzo;
        this.lienzo.setPreferredSize(canvasSize);
        this.lienzo.setSize(canvasSize);
        this.lienzo.setMinimumSize(canvasSize);
        this.lienzo.setComponentPopupMenu(menuLienzo());
        this.lienzo.setBorder(BorderFactory.createEtchedBorder(0));
        this.lienzo.setBackground(Colour.BLANCO_OPACO.getColor());
        iteracion = 0;
        init();
        acomodamientoPanelControl(title, components);
    }
    /**
     * Instanciación y acomodamiento de los componentes del panel
     */
    private void init() {
        codigo=new Switch("Visualización del Código",false);
        pause=new Switch("Paso a Paso",false);
        send=new ButtonSimulador("Enviar",true,e -> {
            if (pause.isOnOff()) getAcciones().iteracion1();
            else getAcciones().iteracion0();
        });
        clean=new ButtonSimulador("Limpiar",false,e -> getAcciones().clean());
        nextIteracion=new ButtonSimulador("Siguiente",false, e -> getAcciones().iteracion1());
        control =new JPanel(new GridBagLayout());
        control.setBackground(Colour.GRIS_PANEL.getColor());
        JLabel desc=new JLabel("Descripción");
        desc.setFont(Fuentes.UBUNTU_LIGHT_14.getFont());
        desc.setForeground(Colour.BLANCO.getColor());
        desc.setBackground(Colour.AZUL_TITLE.getColor());
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
        Constrains.addComp(lienzo,this,new Rectangle(0,0,1,4),0,0,insets,GridBagConstraints.NORTHWEST,GridBagConstraints.NONE);
        Constrains.addComp(getBack(), control,new Rectangle(0,0,1,2),0,0,new Insets(15,15,15,5),GridBagConstraints.WEST,GridBagConstraints.NONE);
        Constrains.addComp(getHome(), control,new Rectangle(1,0,1,2),0,0,new Insets(20,5,20,15),GridBagConstraints.WEST,GridBagConstraints.NONE);
        Constrains.addComp(control,this,new Rectangle(0,4,1,1),1,1,insets,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        Constrains.addCompX(desc,this,new Rectangle(1,0,1,1),1,insets,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompIy(texto=new Texto(4,55),this,new Rectangle(1,1,1,1),1,0,insets,40,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompIy(new ModernScrollPane(datos=new JPanel(new GridBagLayout())),this,new Rectangle(1,2,1,1),1,0,insets,200, GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        Constrains.addComp(codigos=new JTabbedPane(JTabbedPane.TOP),this,new Rectangle(1,3,1,2),1,1,insets,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
    }
    /**
     * Plantilla por defecto para reiniciar el simulador
     */
    public void cleanComponents(){
        Eventos.enable(true,send,pause,getBack(),getHome());
        Eventos.enable(false,nextIteracion,clean,codigo);
        pause.setOnOff(false);
        codigo.setOnOff(false);
        setIteracion(0);
        Eventos.scroll((Editor)codigos.getComponentAt(0),0);
        ((Editor)codigos.getComponentAt(0)).setLine(false);
    }
    /**
     * Plantilla por defecto de acomodamiento para el panel de control
     * @param title título de los componentes de registro de datos
     * @param components {@link JComponent}s de registro de datos
     */
    protected abstract void acomodamientoPanelControl(String title, JComponent... components);
    /**
     * Componentes de registro de datos
     * @param title título del borde
     * @param components {@link JComponent}s de registro
     */
    protected Box componentRegistro(String title, JComponent... components){
        Box box = Box.createHorizontalBox();
        for (JComponent component : components) {
            box.add(component);
            if (component != components[components.length-1]) box.add(Box.createHorizontalStrut(1));
        }
        if (Optional.ofNullable(title).isPresent()) box.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), title));
        return box;
    }
    /**
     * Añade los codigos que necesita el simulador
     * @param editor {@link Editor} con el código correspondiente
     */
    public void addCodes(Editor editor){
        codigos.add(editor.getName(), editor);
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
        for (int i = 0; i < trees.length; i++) Constrains.addComp(trees[i],datos,new Rectangle(0,i,1,1),1,1,new Insets(i==0 ? 7:1,10,i==trees.length-1 ? sizeTree(trees.length) : 1,5),GridBagConstraints.CENTER,GridBagConstraints.BOTH);
    }
    /**
     * Da el tamaño del espacio libre en el panel datos
     * @param length {@link Tree} en el panel
     * @return espacio libre en el panel
     */
    private int sizeTree(int length){
        int size=200-(10*length);
        return size > 0 ? size : 8;
    }
    /**
     * Opciones para el lienzo</br>
     * <ul>
     *     <li>Exportar el Lienzo como Imagen JPG</li>
     * </ul>
     * @return menú para las opciones del Lienzo
     */
    private JPopupMenu menuLienzo(){
        JPopupMenu menu=new JPopupMenu();
        JMenuItem save=new JMenuItem("Exportar Lienzo");
        save.addActionListener(e -> {
            try {
                new Message(Archivos.exportImage(Eventos.saveFile(true), Eventos.createImageOf(lienzo)), lienzo).setVisible(true);
            } catch (FileNotFoundException ex) {//None
            }
        });
        menu.add(save);
        return menu;
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
    protected JPanel getControl() {
        return control;
    }
    /**
     * Obtiene el área gráfica del simulador
     * @return área gráfica del simulador
     */
    public JComponent getLienzo() {
        return lienzo;
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
    public int getIteracion() {
        return iteracion;
    }
    /**
     * Fija un nuevo valor a la iteración de pulsaciones del simulador
     * @param iteracion nuevo valor de iteración
     */
    private void setIteracion(Integer iteracion) {
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
    protected void decrementIteracion(){
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