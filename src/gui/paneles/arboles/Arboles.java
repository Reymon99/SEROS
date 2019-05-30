package gui.paneles.arboles;
import gui.contenido.Contenido;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Arboles extends Contenido {
    /**
     * Contenido del panel Nodos
     * @see Contenido
     * @author Sergio Majé
     */
    public Arboles() {
        getNext().setToolTipText("");
        getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
    }
}