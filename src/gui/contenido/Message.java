package gui.contenido;
import tools.Archivos;
import tools.Colour;
import tools.Fuentes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;
public class Message extends JDialog {
    private String message;
    /**
     * Notifica la información de la acción realizada
     * @param message información a notificar
     * @param component {@link Component} padre
     */
    public Message(String message, Component component){
        this.message = message;
        setUndecorated(true);
        setFocusable(true);
        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 50, 30));
        getContentPane().setBackground(Colour.GRIS_PANEL.getColor());
        init();
        pack();
        setLocationRelativeTo(component);
        setIconImage(Objects.requireNonNull(Archivos.image("/resources/image/icon.png", -1, -1)).getImage());
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                dispose();
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ESCAPE || e.getKeyCode()==KeyEvent.VK_ENTER || e.getKeyCode()==KeyEvent.VK_SPACE) dispose();
            }
        });
    }
    /**
     * Construcción del componente
     */
    private void init(){
        JLabel label=new JLabel(message, JLabel.CENTER);
        label.setFont(Fuentes.UBUNTU_LIGHT_20.getFont());
        label.setForeground(Colour.BLANCO_OPACO.getColor());
        getContentPane().add(label);
    }
}