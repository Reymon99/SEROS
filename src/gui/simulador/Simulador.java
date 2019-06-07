package gui.simulador;
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
        panel1.setBackground(tools.Color.GRISPANEL.getColor());
        back=new JLabel(Archivos.image("/recourses/image/back.png",48,48));
        JLabel desc=new JLabel("Descripción");
        desc.setFont(Fuentes.UBUNTULIGHT14.getFont());
        desc.setForeground(Color.WHITE);
        desc.setBackground(tools.Color.AZULTITLE.getColor());
        desc.setOpaque(true);
        texto=new JTextArea(3,15);
        texto.setCaretColor(Color.WHITE);
        texto.setLineWrap(true);
        texto.setEditable(true);
        texto.setFont(Fuentes.UBUNTULIGHT18.getFont());
        texto.setWrapStyleWord(true);
        texto.setForeground(Color.WHITE);
        texto.setBackground(tools.Color.AZULTEXT.getColor());
        texto.setMargin(new Insets(28,24,20,20));
        JLabel vari=new JLabel("Variables");
        vari.setFont(Fuentes.UBUNTULIGHT14.getFont());
        vari.setForeground(Color.WHITE);
        vari.setBackground(tools.Color.AZULTITLE.getColor());
        vari.setOpaque(true);
        datos=new JTable();
        datos.setDragEnabled(false);
        datos.setPreferredScrollableViewportSize(new Dimension(120,120));
        JScrollPane scroll=new JScrollPane(datos);
        scroll.getViewport().setBackground(tools.Color.AZULTEXT.getColor());
        panel=new JPanel(new GridBagLayout());
        panel.setOpaque(false);
        Constrains.addComp(back,panel1,0,0,1,1,1,1,15,15,15,15,GridBagConstraints.WEST,GridBagConstraints.NONE);
        Constrains.addComp(panel,panel1,1,0,1,1,1,1,5,5,5,5,GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        Constrains.addComp(canvas,this,0,0,1,6,0,0,0,0,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        Constrains.addComp(panel,this,0,6,1,1,1,1,0,0,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        Constrains.addComp(desc,this,1,0,1,1,1,0,0,0,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(texto,this,1,1,1,1,0,0.6,0,0,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        Constrains.addComp(vari,this,1,2,1,1,1,0,0,0,0,0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        Constrains.addComp(scroll,this,1,3,1,1,1,0.6,0,0,0,0, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        Constrains.addComp(code,this,1,4,1,3,1,0.6,0,0,0,0, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
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
    public void addCodes(JPanel code, String title){
        this.code.add(title,code);
    }
}