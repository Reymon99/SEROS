package hilos;
import eventos.Eventos;
import static tools.Text.*;
public class Factorial extends Thread {
    private boolean decrementa;
    private int valor;
    private gui.simulador.Factorial factorial;
    private final String action;
    public static final String CASO_BASE = "caso base";
    public static final String CASO_RECURSIVO = "caso recursivo";
    public Factorial(gui.simulador.Factorial factorial, String action, boolean decrementa) {
        this.factorial=factorial;
        this.action = action;
        this.decrementa = decrementa;
        valor = Integer.parseInt(factorial.getValorI().getValue().toString());
    }
    public Factorial(gui.simulador.Factorial factorial, String action) {
        this(factorial, action, false);
    }
    @Override
    public void run() {
        switch (action) {
            case Factorial.CASO_BASE -> casoBase();
            case Factorial.CASO_RECURSIVO -> casoRecursivo();
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
        if (!decrementa) factorial.getTexto().setText(FACTORIAL1.toString());
    }
    private void casoRecursivo(){
        if (valor==1) {
            casoBase();
        }
    }
}