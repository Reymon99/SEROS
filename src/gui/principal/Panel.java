package gui.principal;
import eventos.Eventos;
import gui.paneles.arboles.Arboles;
import gui.paneles.arreglos.Arreglos;
import gui.paneles.busqueda.Busqueda;
import gui.paneles.colas.Colas;
import gui.paneles.grafos.Grafos;
import gui.paneles.listas.Listas;
import gui.paneles.modularidad.Modularidad;
import gui.paneles.nodos.Nodos;
import gui.paneles.ordenamiento.Ordenamiento;
import gui.paneles.pilas.Pilas;
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
        add(Paneles.NODOS.toString(), new Nodos());
        add(Paneles.ORDENAMIENTO.toString(), new Ordenamiento());
        add(Paneles.BUSQUEDA.toString(), new Busqueda());
        add(Paneles.PILAS.toString(), new Pilas());
        add(Paneles.COLAS.toString(), new Colas());
        add(Paneles.LISTAS_ENLAZADAS.toString(), new Listas());
        add(Paneles.ARBOLES.toString(), new Arboles());
        add(Paneles.GRAFOS.toString(), new Grafos());
    }
}