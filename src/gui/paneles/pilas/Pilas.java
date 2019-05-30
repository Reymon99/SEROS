package gui.paneles.pilas;
import gui.contenido.Contenido;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Pilas extends Contenido {
    /**
     * Contenido del panel Pilas
     * @see Contenido
     * @author Sergio Majé
     */
    public Pilas() {
        getNext().setToolTipText("");
        getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
    }
}
