package gui.principal;
import eventos.Eventos;
import gui.tda.Graficador;
import gui.tda.SimuladorTDA;
import gui.tda.TDA;
import logica.Paneles;
import javax.swing.*;
import java.awt.*;
public class Panel extends JPanel {
    public Panel() {
        setLayout(new CardLayout());
        init();
        Eventos.setPanel(this);
    }
    private void init() {
        add(Paneles.PRINCIPAL.toString(), new Principal());
        add(Paneles.TDA.toString(), new TDA().scroll());
        add(Paneles.SIMULADORTDA.toString(), new SimuladorTDA(new Graficador()));
        Eventos.setPanel(this);
    }
}