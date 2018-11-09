package gui.principal;
import eventos.Eventos;
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
        add(Paneles.TDA.toString(), new JScrollPane(new TDA(),ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER));
        Eventos.setPanel(this);
    }
}