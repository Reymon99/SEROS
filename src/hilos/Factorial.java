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
    /**
     * Ejecución del paso a paso del factorial
     * @param factorial simulador del factorial
     * @param action acción a realizar
     * @param decrementa orden de la ejecución en el caso recursivo
     * @see gui.simulador.Factorial
     */
    public Factorial(gui.simulador.Factorial factorial, String action, boolean decrementa) {
        this.factorial=factorial;
        this.action = action;
        this.decrementa = decrementa;
        valor = Integer.parseInt(factorial.getValorI().getValue().toString());
    }

    /**
     * Ejecución del pao a paso del factorial
     * @param factorial simulador del factorial
     * @param action acción a realizar
     * @see gui.simulador.Factorial
     */
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
    /**
     * Ejecución del caso base del factorial en la ejecución paso a paso
     */
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
    /**
     * Ejecución del caso recursivo en la ejecución paso a paso
     */
    private void casoRecursivo(){
        if (valor==1) {
            casoBase();
        }
    }
}