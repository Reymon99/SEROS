package gui.paneles.colas;
import gui.contenido.Contenido;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Colas extends Contenido {
    /**
     * Contenido del panel Colas
     * @see Contenido
     * @author Sergio Majé
     */
    public Colas() {
        getNext().setToolTipText("");
        getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
    }
}