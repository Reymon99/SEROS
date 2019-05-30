package gui.paneles.busqueda;
import gui.contenido.Contenido;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Busqueda extends Contenido {
    /**
     * Contenido del panel Busqueda
     * @see Contenido
     * @author Sergio Majé
     */
    public Busqueda() {
        getNext().setToolTipText("");
        getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
    }
}