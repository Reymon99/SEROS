package gui.contenido;
import tools.Acciones;
import tools.Archivos;
import tools.Constrains;
import javax.swing.*;
import java.awt.*;
public class Demostracion extends Lienzo {
    private JLabel image;
    private Texto texto;
    private JPanel botones;
    public Demostracion(String path){
        super(new GridBagLayout(),true);
        setAcciones(new Acciones() {
            @Override
            public void iteracion0() {//none
            }
            @Override
            public void iteracion1() {//none
            }
            @Override
            public void clean() {
                setIcon(path);
            }
        });
        init(Archivos.image(path,-1,-1));
    }
    private void init(ImageIcon icon) {
        Constrains.addComp(image=new JLabel(icon),this,new Rectangle(0,0,3,1),1,1,new Insets(20,30,8,15),GridBagConstraints.CENTER,GridBagConstraints.NONE);
        Constrains.addComp(botones=new JPanel(new FlowLayout(FlowLayout.CENTER,10,10)),this,new Rectangle(0,1,3,1),1,1,new Insets(5,30,3,20),GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(texto=new Texto("",10,55),this,new Rectangle(0,2,3,1),1,1,new Insets(5,90,10,80),GridBagConstraints.SOUTH,GridBagConstraints.BOTH);
        Constrains.addComp(getBack(),this,new Rectangle(0,3,1,1),0,0,new Insets(10,7,10,5), GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE);
        Constrains.addComp(getHome(),this,new Rectangle(1,3,1,1),0,0,new Insets(10,5,25,5),GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE);
        botones.setOpaque(false);
    }
    public void nextPanel(){
        Constrains.addComp(getNext(),this,new Rectangle(2,3,1,1),0,0,new Insets(10,50,10,7), GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE);
    }
    public void setBotones(JButton... buttons){
        for (JButton button : buttons) botones.add(button);
    }
    public void setTexto(String text){
        texto.setText(text);
    }
    public void setIcon(String path){
        image.setIcon(Archivos.image(path,-1,-1));
    }
}