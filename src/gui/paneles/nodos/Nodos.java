package gui.paneles.nodos;
import gui.contenido.Contenido;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Nodos extends Contenido {
    /**
     * Contenido del panel Nodos
     * @see Contenido
     * @author Sergio Majé
     */
    public Nodos() {
        getNext().setToolTipText("");
        getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
    }
}