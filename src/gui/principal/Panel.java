package gui.principal;
import eventos.Eventos;
import gui.paneles.arreglos.Arreglos;
import gui.paneles.modularidad.Modularidad;
import gui.paneles.recursividad.Recursividad;
import gui.paneles.tda.*;
import tools.Paneles;
import javax.swing.*;
import java.awt.*;
public class Panel extends JPanel {
    /**
     * Panel principal de proyecto
     * @author Sergio Majé
     */
    public Panel() {
        setLayout(new CardLayout());
        init();
        Eventos.setPanel(this);
    }
    /**
     * Se añaden los paneles secundarios al principal<br>
     * Se agrega el evento para circular entre los paneles
     * @see Eventos#setPanel(JPanel)
     * @author Sergio Majé
     */
    private void init() {
        add(Paneles.PRINCIPAL.toString(), new Principal());
        add(Paneles.TDA.toString(), new TDA());
        add(Paneles.SIMULADORTDA.toString(), new SimuladorTDA(new Graficador()));
        add(Paneles.MODULARIDAD.toString(), new Modularidad());
        add(Paneles.RECURSIVIDAD.toString(), new Recursividad());
        add(Paneles.ARREGLOS.toString(), new Arreglos());
    }
}