import gui.principal.Desktop;
public class Main { //2410 lines
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start...");
        Desktop desktop=new Desktop();
        Thread.sleep(150);//Se pone a dormir el programa para que los componentes cargen perfectamente y se muestren adecuadamente
        System.out.println("showing");
        desktop.setVisible(true);
    }
}