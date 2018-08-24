package eventos;
import javax.swing.*;
import java.awt.*;
public class Eventos {
    private static JPanel panel;
    public static void setPanel(JPanel panel){
        Eventos.panel=panel;
    }
    public static void show(String panel){
        ((CardLayout)Eventos.panel.getLayout()).show(Eventos.panel,panel);
    }
}