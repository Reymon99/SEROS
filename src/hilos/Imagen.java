package hilos;
import java.awt.*;
public class Imagen extends Thread {
    private boolean stop;
    private boolean pause;
    private int sleep;
    private Image[] images;
    public Imagen(Image... images){
        this(350,images);
    }
    public Imagen(int sleep,Image... images){
        stop=pause=false;
        this.sleep=sleep;
        this.images=images;
    }
    public void pausar(){
        pause=true;
    }
    public void reiniciar(){
        pause=false;
    }
    public void parar(){
        stop=true;
    }
    @Override
    public void run() {
        while (!stop){
            while (!pause){

            }
        }
    }
}