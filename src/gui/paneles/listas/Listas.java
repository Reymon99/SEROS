package gui.paneles.listas;
import gui.contenido.Contenido;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Listas extends Contenido {
    /**
     * Contenido del panel Nodos
     * @see Contenido
     * @author Sergio Majé
     */
    public Listas() {
        getTitle().setText("Listas Enlazadas");
        getNext().setToolTipText("");
        getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
    }
}