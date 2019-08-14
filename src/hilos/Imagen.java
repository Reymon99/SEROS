package hilos;
import javax.swing.*;
public class Imagen extends Thread {
    private boolean stop;
    private boolean pause;
    private int sleep;
    private ImageIcon[] images;
    private JLabel label;
    /**
     * Muestra imagenes determinadas en un lapso de tiempo indicado, sucesivamente
     * @param label componente en el cual se establecen la imagenes
     * @param images imagenes a mostrar
     */
    public Imagen(JLabel label,ImageIcon... images){
        this(label,400,images);
    }
    /**
     * Muestra imagenes determinadas en un lapso de tiempo indicado, sucesivamente
     * @param label componente en el cual se establecen la imagenes
     * @param sleep tiempo en milisigundos a dormir cada imagen
     * @param images imagenes a mostrar
     */
    public Imagen(JLabel label,int sleep,ImageIcon... images){
        stop=pause=false;
        this.sleep=sleep;
        this.images=images;
        this.label=label;
    }
    /**
     * Pausa el hilo sucesivo de las imagenes que se están mostrando
     */
    public void pausar(){
        pause=true;
    }
    /**
     * Reinicia el hilo sucesivo después de haber sido pausado
     */
    public void reiniciar(){
        pause=false;
    }
    /**
     * Detiene el hilo sucesivo de la imagenes que se están mostrando
     */
    public void parar(){
        stop=pause=true;
    }
    /**
     * Hilo sucesivo de las imagenes a ser mostradas
     */
    @Override
    public void run() {
        while (!stop){
            for (int i = 0; !pause; i++) {
                label.setIcon(images[i]);
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {//None
                }
            }
        }
    }
}