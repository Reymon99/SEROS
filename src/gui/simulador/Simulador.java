package gui.simulador;
import gui.contenido.Boton;
import gui.contenido.Texto;
import gui.contenido.scroll.ModernScrollPane;
import tools.Colour;
import tools.Fuentes;
import tools.Archivos;
import tools.Constrains;
import javax.swing.*;
import java.awt.*;
public class Simulador extends JPanel {
    private Canvas canvas;
    private Texto texto;
    private JTable datos;
    private JTabbedPane code;
    private JPanel panel;
    private JLabel back;
    public static Dimension cavasSize=new Dimension((int) (Toolkit.getDefaultToolkit().getScreenSize().width*0.73),(int) (Toolkit.getDefaultToolkit().getScreenSize().height*0.756));
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
    public void init(){
        back=new Boton(Archivos.image("/recourses/image/back.png",48,48));
        JPanel panel1=new JPanel(new GridBagLayout());
        panel1.setBackground(Colour.GRISPANEL.getColor());
        panel=new JPanel(new GridBagLayout());
        panel.setOpaque(false);
        JLabel desc=new JLabel("Descripción");
        desc.setFont(Fuentes.UBUNTULIGHT14.getFont());
        desc.setForeground(Color.WHITE);
        desc.setBackground(Colour.AZULTITLE.getColor());
        desc.setOpaque(true);
        Constrains.addComp(canvas,this,0,0,1,3,0,0,0,0,0,0,GridBagConstraints.NORTHEAST,GridBagConstraints.NONE);
        Constrains.addComp(back,panel1,0,0,1,1,1,1,15,15,15,15,GridBagConstraints.WEST,GridBagConstraints.NONE);
        Constrains.addComp(panel,panel1,1,0,1,1,1,1,0,5,0,0,GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        Constrains.addComp(panel1,this,0,3,1,1,1,1,0,0,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        Constrains.addCompX(desc,this,1,0,1,1,1,0,0,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addComp((texto=new Texto(4,55)),this,1,1,1,1,1,0,0,0,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        Constrains.addComp((code=new JTabbedPane(JTabbedPane.TOP)),this,1,2,1,2,1,1,0,0,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
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
     * Valor de las variables
     * @return JTable
     * @author Sergio Majé
     */
    public JTable getDatos() {
        return datos;
    }
    /**
     * panel de comandos del simulador
     * @return Jpanel
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
    public JLabel getBack() {
        return back;
    }
    /**
     * Añade los codigos que necesita el simulador
     * @param code {@link JScrollPane}
     * @author Sergio Majé
     */
    public void addCodes(ModernScrollPane code, String title){
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
}