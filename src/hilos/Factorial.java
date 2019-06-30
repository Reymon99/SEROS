package hilos;
import eventos.Eventos;
import static tools.Text.*;
public class Factorial extends Thread {
    private int intervalo;
    private gui.simulador.Factorial factorial;
    /**
     * Ejecución del paso a paso del factorial
     * @param factorial simulador del factorial
     * @see gui.simulador.Factorial
     */
    public Factorial(gui.simulador.Factorial factorial) {
        this.factorial=factorial;
        intervalo=1130;
    }
    @Override
    public void run() {
        Eventos.enable(false,factorial.getValorI(),factorial.getClean(),factorial.getNext(),factorial.getSend(),factorial.getPause(),factorial.getBack());
        Eventos.variable(factorial.getVariaI(),-1,factorial.getIteraccion());
        if (isBase()){
            factorial.getTexto().setText(FACTORIAL3.toString());
            casoBase();
            factorial.getProducto().setText(factorial.getValorI().getValue().toString()+"!    =    "+factorial.producto(factorial.getIteraccion()));
            factorial.getNumber().setText(Eventos.formatNumber(factorial.fac(factorial.getIteraccion()),"#,###,###"));
            if (factorial.getIteraccion()==Integer.parseInt(factorial.getValorI().getValue().toString())){
                factorial.getTexto().setText(FACTORIAL1.toString());
                Eventos.enable(true,factorial.getClean());
            } else {
                factorial.getTexto().setText(FACTORIAL4.toString());
                factorial.incrementIteraccion();
                Eventos.enable(true,factorial.getNext());
            }
        }
    }
    private boolean isBase(){
        return factorial.getIteraccion()==1 || factorial.getIteraccion()==0;
    }
    /**
     * Ejecución del caso base del factorial en la ejecución paso a paso
     */
    private void casoBase(){
        for (int i = 0; i < 3; i++) {
            factorial.getCode().drawLineIn(i+1);
            if (i+1!=3) Eventos.sleep(intervalo);
        }
    }
    /**
     * Ejecución del caso recursivo en la ejecución paso a paso
     */
    private void casoRecursivo(){
        for (int i:new int[]{1,2,4,5}){
            factorial.getCode().drawLineIn(i);
            if (i!=5) Eventos.sleep(intervalo);
        }
    }
}