package gui.simulador;
import fuentes.Fuentes;
import gui.tda.Graficador;
import logica.Archivos;
import logica.Constrains;
import javax.swing.*;
import java.awt.*;
public class Simulador extends JPanel {
    private Canvas canvas;
    private JTextArea texto;
    private JTable datos;
    private JTabbedPane code;
    private JPanel panel;
    private JLabel back;
    public Simulador(Canvas canvas) {
        this.canvas = canvas;
        setLayout(new GridBagLayout());
        init();
    }
    public void init(){
        code=new JTabbedPane();
        panel=new JPanel(new GridBagLayout());
        panel.setBackground(logica.Color.GRISPANEL.getColor());
        back=new JLabel(Archivos.image("/image/back.png",48,48));
        JLabel desc=new JLabel("Descripción");
        desc.setFont(Fuentes.UBUNTULIGHT14.getFont());
        desc.setForeground(Color.WHITE);
        desc.setBackground(logica.Color.AZULTITLE.getColor());
        desc.setOpaque(true);
        texto=new JTextArea(3,15);
        texto.setCaretColor(Color.WHITE);
        texto.setLineWrap(true);
        texto.setEditable(true);
        texto.setFont(Fuentes.UBUNTULIGHT18.getFont());
        texto.setWrapStyleWord(true);
        texto.setForeground(Color.WHITE);
        texto.setBackground(logica.Color.AZULTEXT.getColor());
        texto.setMargin(new Insets(28,24,20,20));
        JLabel vari=new JLabel("Variables");
        vari.setFont(Fuentes.UBUNTULIGHT14.getFont());
        vari.setForeground(Color.WHITE);
        vari.setBackground(logica.Color.AZULTITLE.getColor());
        vari.setOpaque(true);
        datos=new JTable(3,2);
        datos.setDragEnabled(false);
        datos.setPreferredScrollableViewportSize(new Dimension(120,120));
        JScrollPane scroll=new JScrollPane(datos);
        scroll.getViewport().setBackground(logica.Color.AZULTEXT.getColor());
        Constrains.addComp(back,panel,0,0,1,1,1,1,15,15,15,15,GridBagConstraints.WEST,GridBagConstraints.NONE);
        Constrains.addComp(canvas,this,0,0,1,6,0,0,0,0,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        Constrains.addComp(panel,this,0,6,1,1,0,0,0,0,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(desc,this,1,0,1,1,0,0,0,0,0,0,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(texto,this,1,1,1,1,0,0,0,0,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
        Constrains.addComp(vari,this,1,2,1,1,0,0,0,0,0,0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL);
        Constrains.addComp(scroll,this,1,3,1,1,0,0,0,0,0,0, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        Constrains.addComp(code,this,1,4,1,3,0,0,0,0,0,0, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
    }
    public JTextArea getTexto() {
        return texto;
    }
    public void setTexto(JTextArea texto) {
        this.texto = texto;
    }
    public JTable getDatos() {
        return datos;
    }
    public void setDatos(JTable datos) {
        this.datos = datos;
    }
    public JPanel getPanel() {
        return panel;
    }
    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
    public JLabel getBack() {
        return back;
    }
    public void setBack(JLabel back) {
        this.back = back;
    }
    public void addCodes(JPanel code){
        this.code.add("Punto",code);
    }
}