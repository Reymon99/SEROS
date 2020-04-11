package gui.contenido;

import org.constrains.Constrains;
import org.constrains.Weight;

import tools.Colour;
import tools.Fuentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

public class ModernButton extends JPanel {
    /**
     * Letra en el centro del boton
     */
    private JLabel letra;
    /**
     * Texto descriptivo del boton
     */
    private JLabel texto;
    /**
     * Indicador del nivel de dificultad representa el boton
     */
    private JProgressBar nivelDificultad;
    /**
     * Evento del boton
     */
    private Consumer<MouseEvent> evento;

    /**
     * Boton moderno
     * @param letra           letra central en el boton
     * @param texto           texto descriptivo en el boton
     * @param nivelDificultad color significativo al nivel de dificultad que representa el boton
     */
    public ModernButton(char letra, String texto, Colour nivelDificultad) {
        this(letra, texto, nivelDificultad, texto, null);
    }

    /**
     * Boton moderno
     * @param letra           letra central en el boton
     * @param texto           texto descriptivo en el boton
     * @param nivelDificultad color significativo al nivel de dificultad que representa el boton
     * @param toolTipText     mensaje toolTipText del boton
     * @param evento          acción para el evento del boton
     */
    public ModernButton(char letra, String texto, Colour nivelDificultad, String toolTipText,
                        Consumer<MouseEvent> evento) {
        super(new GridBagLayout());
        this.evento = evento;
        setBackground(Colour.LAVANDA.getColor());
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        init(letra, texto, nivelDificultad.getColor());
        setToolTipText(toolTipText);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                evento.accept(e);
            }
        });
    }

    private void init(char letra, String texto, Color nivelDificultad) {
        this.letra = new JLabel(String.valueOf(letra), SwingConstants.CENTER);
        this.letra.setFont(Fuentes.UBUNTU_MONO_B_82.getFont());
        this.letra.setCursor(getCursor());
        this.letra.addMouseListener(getMouseListeners()[0]);
        this.texto = new JLabel(texto, SwingConstants.CENTER);
        this.texto.setFont(Fuentes.UBUNTU_LIGHT_14.getFont());
        this.texto.setCursor(getCursor());
        this.texto.addMouseListener(getMouseListeners()[0]);
        this.nivelDificultad = new JProgressBar();
        this.nivelDificultad.setValue(0);
        this.nivelDificultad.setBackground(nivelDificultad);
        this.nivelDificultad.setBorderPainted(false);
        this.nivelDificultad.setCursor(getCursor());
        this.nivelDificultad.addMouseListener(getMouseListeners()[0]);
        Constrains.addComp(
                this.letra,
                this,
                new Rectangle(0, 0, 1, 1),
                new Weight(1, 1),
                new Insets(15, 5, 5, 5),
                new Point(GridBagConstraints.CENTER, GridBagConstraints.BOTH)
        );
        Constrains.addCompX(
                this.texto,
                this,
                new Rectangle(0, 1, 1, 1),
                0.5,
                new Insets(8, 5, 5, 5),
                new Point(GridBagConstraints.NORTH, GridBagConstraints.NONE)
        );
        Constrains.addCompX(
                this.nivelDificultad,
                this,
                new Rectangle(0, 2, 1, 1),
                1,
                new Insets(10, 0, 0, 0),
                new Point(GridBagConstraints.SOUTH, GridBagConstraints.BOTH)
        );
    }

    /**
     * Fija una nueva acción para el evento del boton
     * @param evento nueva acción para el evento
     */
    public void setEvento(Consumer<MouseEvent> evento) {
        this.evento = evento;
    }

    /**
     * Fija una nueva letra central en el boton
     * @param letra nueva letra central
     */
    public void setLetra(char letra) {
        this.letra.setText(String.valueOf(letra));
        this.letra.updateUI();
        updateUI();
    }

    /**
     * Fija un nuevo texto descriptivo en el boton
     * @param texto nuevo texto descriptivo
     */
    public void setTexto(String texto) {
        this.texto.setText(texto);
        this.texto.updateUI();
        updateUI();
    }

    /**
     * Fija un nuevo color significativo al nivel de dificultad que representa el boton
     * @param nivelDificultad nuevo color de nivel de dificultad
     */
    public void setNivelDificultad(Colour nivelDificultad) {
        this.nivelDificultad.setBackground(nivelDificultad.getColor());
        this.nivelDificultad.updateUI();
        updateUI();
    }

    /**
     * Modifica el mensaje toolTipText del boton
     * @param toolTipText mensaje
     */
    @Override
    public void setToolTipText(String toolTipText) {
        super.setToolTipText(toolTipText);
        this.texto.setToolTipText(toolTipText);
        letra.setToolTipText(toolTipText);
        nivelDificultad.setToolTipText(toolTipText);
    }
}
