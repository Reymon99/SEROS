import gui.principal.Desktop;
public class Main { //1380 lines 952 code lines
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("start...");
            Desktop desktop=new Desktop();
            try {//Se pone a dormir el programa para que los componentes cargen perfectamente y se muestren adecuadamente
                Thread.sleep(150);
                System.out.println("showing");
            } catch (InterruptedException e) {

            }finally {
                desktop.setVisible(true);
            }
        }).start();
    }
}