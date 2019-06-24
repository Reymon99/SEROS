package gui.simulador;
import gui.contenido.Boton;
import gui.contenido.Texto;
import gui.contenido.Tree;
import gui.contenido.scroll.ModernScrollPane;
import gui.editor.Editor;
import tools.Colour;
import tools.Fuentes;
import tools.Archivos;
import tools.Constrains;
import javax.swing.*;
import java.awt.*;
public abstract class Simulador extends JPanel {
    private Canvas canvas;
    private Texto texto;
    private JPanel datos;
    private JTabbedPane code;
    private JPanel panel;
    private Boton back;
    public static Dimension canvasSize=new Dimension((int) (Toolkit.getDefaultToolkit().getScreenSize().width*0.73),(int) (Toolkit.getDefaultToolkit().getScreenSize().height*0.8  ));
    /**
     * Esquema de los simuladores del proyecto
     * @param canvas {@link Canvas}
     * @author Sergio Majé
     */
    public Simulador(Canvas canvas) {
        this.canvas = canvas;
        setLayout(new GridBagLayout());
        init();
    }
    /**
     * Instanciacion y acomodamiento de los componentes del panel
     * @author Sergio Majé
     */
    private void init(){
        back=new Boton(Archivos.image("/recourses/image/back.png",48,48));
        panel=new JPanel(new GridBagLayout());
        panel.setBackground(Colour.GRISPANEL.getColor());
        JLabel desc=new JLabel("Descripción");
        desc.setFont(Fuentes.UBUNTULIGHT14.getFont());
        desc.setForeground(Color.WHITE);
        desc.setBackground(Colour.AZULTITLE.getColor());
        desc.setOpaque(true);
        Constrains.addComp(canvas,this,0,0,1,4,0,0,0,0,0,0,GridBagConstraints.NORTHWEST,GridBagConstraints.NONE);
        Constrains.addComp(back,panel,0,0,1,2,1,1,15,15,15,15,GridBagConstraints.WEST,GridBagConstraints.NONE);
        Constrains.addComp(panel,this,0,4,1,1,1,1,0,0,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        Constrains.addCompX(desc,this,1,0,1,1,1,0,0,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addCompIy((texto=new Texto(4,55)),this,1,1,1,1,1,0,0,0,0,0,35,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        Constrains.addCompIy(new ModernScrollPane(datos=new JPanel(new GridBagLayout())),this,1,2,1,1,1,0,0,0,0,0,200, GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        Constrains.addComp((code=new JTabbedPane(JTabbedPane.TOP)),this,1,3,1,2,1,1,0,0,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
    }
    /**
     * Notificaciones
     * @return texto {@link JTextArea}
     * @author Sergio Majé
     */
    public Texto getTexto() {
        return texto;
    }
    /**
     * Variables que se van a agregar
     * @param trees {@link Tree} a agregar
     * @author Sergio Majé
     */
    public void setDatos(Tree... trees){
        for (int i = 0; i < trees.length; i++) Constrains.addComp(trees[i],datos,0,i,1,1,1,1,i==0 ? 7:2,10,1,5,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
    }
    /**
     * panel de comandos del simulador
     * @return {@link JPanel} de gestión
     * @author Sergio Majé
     */
    public JPanel getPanel() {
        return panel;
    }
    /**
     * Retornar al panel anterior
     * @return JLabel
     * @author Sergio Majé
     */
    public Boton getBack() {
        return back;
    }
    /**
     * Añade los codigos que necesita el simulador
     * @param code {@link JScrollPane}
     * @author Sergio Majé
     */
    public void addCodes(Editor code, String title){
        this.code.add(title,code);
    }
    /**
     * Fijar texto en el campo de descripción
     * @param texto {@link String} a fijar
     * @author Sergio Majé
     */
    public void setTexto(String texto){
        this.texto.setEditable(true);
        this.texto.setText(texto);
        this.texto.setEditable(false);
    }
    /**
     * Retorna el cavas del simulador
     * @return canvas del simulador
     * @author Sergio Majé
     */
    public Canvas getCanvas() {
        return canvas;
    }
    /**
     * Modifica el camvas del simulador
     * @param canvas nuevo canvas del simulador
     * @author Sergio Majé
     */
    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
    /**
     * Iteración del simulador cuando no se ejecuta el paso a paso
     * @author Sergio Majé
     */
    abstract protected void iteracion0();
    /**
     * Primera iteración del simulador con paso a paso
     * @author Sergio Majé
     */
    abstract protected void iteracion1();
    /**
     * Restaura los componente al origen
     * @author Sergio Majé
     */
    abstract protected void clean();
}