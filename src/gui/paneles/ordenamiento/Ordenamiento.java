package gui.paneles.ordenamiento;
import gui.contenido.Contenido;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Ordenamiento extends Contenido {
    /**
     * Contenido del panel Ordenamiento
     * @see Contenido
     * @author Sergio Majé
     */
    public Ordenamiento() {
        getNext().setToolTipText("");
        getNext().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
    }
}