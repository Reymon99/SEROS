package hilos;
import eventos.Eventos;
public class Factorial extends Thread {
    private gui.simulador.Factorial factorial;
    private final String action;
    public static final String CASO_BASE = "caso base";
    public Factorial(gui.simulador.Factorial factorial, String action) {
        this.factorial=factorial;
        this.action = action;
    }
    @Override
    public void run() {
        switch (action) {
            case Factorial.CASO_BASE:
                casoBase();
                break;
        }
    }
    private void casoBase(){
        Eventos.variable(factorial.getVariaI(),-1,factorial.getValorI().getValue());
        factorial.getCode().drawLineIn(1);
        Eventos.sleep(600);
        factorial.getCode().drawLineIn(2);
        Eventos.sleep(600);
        factorial.getCode().drawLineIn(3);
        factorial.getProducto().setText(factorial.getValorI().getValue().toString()+"!    =    "+factorial.producto(Integer.parseInt(factorial.getValorI().getValue().toString())));
        factorial.getNumber().setText(Eventos.formatNumber(factorial.fac(Integer.parseInt(factorial.getValorI().getValue().toString())),"#,###,###"));
    }
}