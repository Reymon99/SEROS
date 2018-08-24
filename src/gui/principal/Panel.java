package gui.principal;
import eventos.Eventos;
import logica.Paneles;
import javax.swing.*;
import java.awt.*;
public class Panel extends JPanel {
    public Panel(){
        setLayout(new CardLayout());
        init();
        Eventos.setPanel(this);
    }
    private void init() {
        add(Paneles.PRINCIPAL.toString(),new Principal());
    }
}