import gui.principal.Desktop;
public class Main { //1120 lines
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("start...");
            Desktop desktop=new Desktop();
            try {
                //Se pone a dormir el programa para que los componentes cargen perfectamente y se muestren adecuadamente
                Thread.sleep(120);
                System.out.println("showing");
            } catch (InterruptedException e) {

            }finally {
                desktop.setVisible(true);
            }
        }).start();
    }
}