package gui.simulador;
import gui.contenido.scroll.ModernScrollPane;
import tools.Colour;
import tools.Fuentes;
import tools.Archivos;
import tools.Constrains;
import javax.swing.*;
import java.awt.*;
public class Simulador extends JPanel {
    private Canvas canvas;
    private JTextArea texto;
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
        code=new JTabbedPane();
        JPanel panel1=new JPanel(new GridBagLayout());
        panel1.setBackground(Colour.GRISPANEL.getColor());
        back=new JLabel(Archivos.image("/recourses/image/back.png",48,48));
        JLabel desc=new JLabel("Descripción");
        desc.setFont(Fuentes.UBUNTULIGHT14.getFont());
        desc.setForeground(Color.WHITE);
        desc.setBackground(Colour.AZULTITLE.getColor());
        desc.setOpaque(true);
        texto=new JTextArea(4,50);
        texto.setCaretColor(Color.WHITE);
        texto.setLineWrap(true);
        texto.setEditable(true);
        texto.setFont(Fuentes.UBUNTULIGHT15.getFont());
        texto.setWrapStyleWord(true);
        texto.setForeground(Color.WHITE);
        texto.setBackground(Colour.AZULTEXT.getColor());
        texto.setMargin(new Insets(28,24,20,20));
        texto.setEditable(false);
        JLabel vari=new JLabel("Variables");
        vari.setFont(Fuentes.UBUNTULIGHT14.getFont());
        vari.setForeground(Color.WHITE);
        vari.setBackground(Colour.AZULTITLE.getColor());
        vari.setOpaque(true);
        Model model=new Model();
        model.addColumn("Varible");
        model.addColumn("Dato");
        model.addRow(new Object[]{"x",0});
        datos=new JTable(model);
        datos.setDragEnabled(false);
        ModernScrollPane scroll=new ModernScrollPane(datos);
        scroll.getViewport().setBackground(Colour.AZULTEXT.getColor());
        panel=new JPanel(new GridBagLayout());
        panel.setOpaque(false);
        Constrains.addComp(back,panel1,0,0,1,1,1,1,15,15,15,15,GridBagConstraints.WEST,GridBagConstraints.NONE);
        Constrains.addComp(panel,panel1,1,0,1,1,1,1,0,5,0,0,GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        Constrains.addComp(canvas,this,0,0,1,6,1,1,0,0,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        Constrains.addComp(panel1,this,0,6,1,1,1,1,0,0,0,0,GridBagConstraints.WEST,GridBagConstraints.BOTH);
        Constrains.addComp(desc,this,1,0,1,1,1,0,0,0,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(texto,this,1,1,1,1,0.3,0,0,0,0,0,GridBagConstraints.WEST,GridBagConstraints.BOTH);
        Constrains.addComp(vari,this,1,2,1,1,0,0,0,0,0,0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        Constrains.addComp(scroll,this,1,3,1,1,0.3,0.2,0,0,0,0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL);
        Constrains.addComp(code,this,1,4,1,3,0.3,1,0,0,0,0, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
    }
    /**
     * Notificaciones
     * @return texto {@link JTextArea}
     * @author Sergio Majé
     */
    public JTextArea getTexto() {
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
}