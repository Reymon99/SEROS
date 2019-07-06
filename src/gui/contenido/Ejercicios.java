package gui.contenido;
import tools.Archivos;
import tools.Constrains;
import javax.swing.*;
import java.awt.*;
public class Ejercicios extends Lienzo {
    private Boton[] botones;
    private Boton back;
    private Texto texto;
    private JPanel panel;
    /**
     * Planilla de los paneles de Ejercicios del Simulador
     */
    public Ejercicios(){
        setLayout(new GridBagLayout());
        init();
    }
    /**
     * Inicialización y acomodamiento de los componentes en el panel
      */
    private void init() {
        back=new Boton(Archivos.image("/recourses/image/back.png",48,48));
        texto=new Texto("",8,55);
        panel=new JPanel(new FlowLayout(FlowLayout.CENTER,50,20));
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(1000,150));
        Constrains.addComp(panel,this,0,0,1,1,0.8,1,70,40,15,40,GridBagConstraints.CENTER,GridBagConstraints.HORIZONTAL);
        Constrains.addComp(texto,this,0,1,1,1,1,1,10,20,25,20,GridBagConstraints.SOUTH,GridBagConstraints.NONE);
        Constrains.addComp(back,this,0,2,1,1,0,0,10,7,10,2, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE);
    }
    /**
     * Se añaden los items al panel si no está vacia la lista de botones
     */
    private void items(){
        if (botones.length!=0) for (Boton boton:botones) panel.add(boton);
    }
    /**
     * Listado de los Botones de los ejercicios
     * @return botones
     */
    public Boton[] getBotones() {
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
     * @param botones listado de {@link Boton} listo para añadir al panel
     */
    public void setBotones(Boton... botones) {
        this.botones = botones;
        items();
    }
    /**
     * Boton de retroceder
     * @return back
     */
    public Boton getBack() {
        return back;
    }
    /**
     * Componente de Texto
     * @return texto
     */
    public Texto getTexto() {
        return texto;
    }
}