package eventos;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import tools.Paneles;
public class Eventos {
    /**
     * Variable estatica que contiene todos los paneles agregados al proyecto
     */
    private static JPanel panel;
    /**
     *Establece el panel principal que contiene todos los paneles de proyecto
     * @param panel {@link JPanel}
     * @author Sergio Majé
     */
    public static void setPanel(JPanel panel){
        Eventos.panel=panel;
    }
    /**
     * Mediante el nombre de los paneles definidos mediante un enum de String muestra el panel deseado en la intefaz grafica
     * @see Paneles
     * @param panel {@link String}
     * @author Sergio Majé
     */
    public static void show(String panel){
        ((CardLayout)Eventos.panel.getLayout()).show(Eventos.panel,panel);
    }
    /**
     * abre el navegador con el link fijado
     * @param url {@String} url a abrir por el usuario
     * @author Sergio Majé
     */
    public static void link(String url){
        try{
            URL url1=new URL(url);
            if (Desktop.isDesktopSupported()) Desktop.getDesktop().browse(url1.toURI());
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (URISyntaxException e) {
            System.out.println(e.getMessage());
        }
    }
}