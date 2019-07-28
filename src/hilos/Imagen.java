package hilos;
import javax.swing.*;
public class Imagen extends Thread {
    private boolean stop;
    private boolean pause;
    private int sleep;
    private ImageIcon[] images;
    private JLabel label;
    public Imagen(JLabel label,ImageIcon... images){
        this(label,400,images);
    }
    public Imagen(JLabel label,int sleep,ImageIcon... images){
        stop=pause=false;
        this.sleep=sleep;
        this.images=images;
        this.label=label;
    }
    public void pausar(){
        pause=true;
    }
    public void reiniciar(){
        pause=false;
    }
    public void parar(){
        stop=pause=true;
    }
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