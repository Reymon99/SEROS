package gui.paneles.grafos;
import gui.contenido.Contenido;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Grafos extends Contenido {
    /**
     * Contenido del panel Nodos
     * @see Contenido
     * @author Sergio Majé
     */
    public Grafos() {
        getNext().setToolTipText("");
        getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
    }
}