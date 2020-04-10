package hilos;

import eventos.Eventos;

import javax.swing.*;

public class Imagen extends Thread {
    private boolean stop;
    private boolean pause;
    private int sleep;
    private ImageIcon[] images;
    private JLabel label;

    /**
     * Muestra imágenes determinadas en un lapso de tiempo indicado, sucesivamente
     * @param label  componente en el cual se establecen la imagenes
     * @param images imagenes a mostrar
     */
    public Imagen(JLabel label, ImageIcon... images) {
        this(label, 400, images);
    }

    /**
     * Muestra imágenes determinadas en un lapso de tiempo indicado, sucesivamente
     * @param label  componente en el cual se establecen la imagenes
     * @param sleep  tiempo en milisigundos a dormir cada imagen
     * @param images imágenes a mostrar
     */
    public Imagen(JLabel label, int sleep, ImageIcon... images) {
        stop = pause = false;
        this.sleep = sleep;
        this.images = images;
        this.label = label;
    }

    /**
     * Pausa el hilo sucesivo de las imágenes que se están mostrando
     */
    public void pausar() {
        pause = true;
    }

    /**
     * Reinicia el hilo sucesivo después de haber sido pausado
     */
    public void reiniciar() {
        pause = false;
    }

    /**
     * Detiene el hilo sucesivo de las imágenes que se están mostrando
     */
    public void parar() {
        stop = pause = true;
    }

    /**
     * Hilo sucesivo de las imágenes a ser mostradas
     */
    @Override
    public void run() {
        while (!stop) {
            for (int i = 0; !pause; i++) {
                label.setIcon(images[i]);
                Eventos.sleep(sleep);
            }
        }
    }
}