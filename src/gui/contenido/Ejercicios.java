package gui.contenido;
import tools.Acciones;
import tools.Constrains;
import javax.swing.*;
import java.awt.*;
public final class Ejercicios extends Lienzo {
    private JLabel[] botones;
    private JTextArea texto;
    private JPanel panel;
    /**
     * Planilla de los paneles de Ejercicios del Simulador
     */
    public Ejercicios(){
        super(new GridBagLayout(), true);
        setAcciones(new Acciones() {
            @Override
            public void iteracion0() {//None
            }
            @Override
            public void iteracion1() {//None
            }
            @Override
            public void clean() {
                texto.setText("");
            }
        });
        init();
    }
    /**
     * Inicialización y acomodamiento de los componentes en el panel
     */
    private void init() {
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 20));
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(1000, 150));
        Constrains.addComp(
                panel,
                this,
                new Rectangle(0, 0, 2, 1),
                0.8,
                1,
                new Insets(70, 40, 15, 40),
                GridBagConstraints.CENTER,
                GridBagConstraints.HORIZONTAL
        );
        Constrains.addComp(
                texto = Components.getTexto("", 8, 55),
                this,
                new Rectangle(0, 1, 2, 1),
                1,
                1,
                new Insets(10, 20, 25, 20),
                GridBagConstraints.SOUTH,
                GridBagConstraints.NONE
        );
        Constrains.addComp(
                getBack(),
                this,
                new Rectangle(0, 2, 1, 1),
                0,
                0,
                new Insets(10, 7, 10, 5),
                GridBagConstraints.SOUTHWEST,
                GridBagConstraints.NONE
        );
        Constrains.addComp(
                getHome(),
                this,
                new Rectangle(1, 2, 1, 1),
                0,
                0,
                new Insets(10, 5, 25, 5),
                GridBagConstraints.SOUTHWEST,
                GridBagConstraints.NONE
        );
    }
    /**
     * Se añaden los items al panel si no está vacia la lista de botones
     */
    private void items(){
        if (botones.length!=0) for (JLabel boton:botones) panel.add(boton);
    }
    /**
     * Listado de los Botones de los ejercicios
     * @return botones
     */
    public JLabel[] getBotones() {
        return botones;
    }
    /**
     * Botones de los ejercicios de las temáticas a simuladores<br>
     * Agregar los botones con iconos de 100px de ancho
     * Eventos de Mouse a trabajar:<br>
     * <ul>
     *     <li>mouseEntered - información cuando el mouse pase por el componente</li>
     *     <li>mouseExited - información cuando el mouse salga del componente</li>
     *     <li>mouseClicked - acción a realizar cuando hallá un click en el componente</li>
     * </ul>
     * @param botones listado de Botones listos para añadir al panel
     */
    public void setBotones(JLabel... botones) {
        this.botones = botones;
        items();
    }
    /**
     * Componente de Texto
     * @return texto
     */
    public JTextArea getTexto() {
        return texto;
    }
    /**
     * Da un nuevo mensaje al componente
     * @param texto nuevo mensaje
     */
    public void setTexto(String texto){
        this.texto.setText(texto);
    }
}