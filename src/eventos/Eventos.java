package eventos;
import javax.swing.*;
import java.awt.*;
import tools.Paneles;
public class Eventos {
    /**
     * Variable estatica que contiene todos los paneles agregados al proyecto
     */
    private static JPanel panel;
    /**
     *Establece el panel pricipal que contiene todos los paneles de proyecto
     * @param panel {@link JPanel}
     * @author Sergio Majé
     */
    public static void setPanel(JPanel panel){
        Eventos.panel=panel;
    }
    /**
     * Mediante el nombre de los paneneles definidos mediante un enum de String muestra el panel deseado en la intefaz grafica
     * @see Paneles
     * @param panel {@link String}
     * @author Sergio Majé
     */
    public static void show(String panel){
        ((CardLayout)Eventos.panel.getLayout()).show(Eventos.panel,panel);
    }
}