package tools;
import eventos.Eventos;
import java.text.DecimalFormat;
public abstract class Operaciones {
    private static DecimalFormat format;
    static {
        Operaciones.format = new DecimalFormat();
    }
    /**
     * Se específica el formato a dar a los números
     * @param pattern patron a trabajar
     */
    public static void setFormat(String pattern) {
        Operaciones.format.applyPattern(pattern);
    }
    /**
     * Formato al número dado
     * @param number número a dar formato
     * @return Un {@link String} cone le número formateado
     */
    public static String formatNumber(Object number){
        return Operaciones.format.format(number);
    }
    /**
     * Concatena la operación realizada con su respectivo resultado
     * @param operacion Operación realizada
     * @param resultado Respectivo resultado de la operación
     * @return operación y resultado en una única cadena
     */
    public static String operacion(String operacion,String resultado){
        return operacion+"    =    "+resultado;
    }
    /**
     * Genera el factorial de n
     * @param n número a dar el factorial
     * @return factorial de n
     */
    public static long factorial(int n){
        return (Eventos.contains(n,0,1) ? 1 : n*Operaciones.factorial(n-1));
    }
    /**
     * Genera la multiplicación de un factorial n
     * @param i número a generar la multiplicación del factorial
     * @return multiplicación recursiva del factorial n
     */
    public static String productoFactorial(int i){
        return (i==0 || i==1) ? "1" : i+" * "+Operaciones.productoFactorial(i-1);
    }
    /**
     * Genera la multiplicación de un número n hasta el establecido
     * @param i valor inicial
     * @param valor valor final
     * @return multiplicación recursiva de un valor inicial al valor final
     */
    public static String productoFactorial(int i,int valor){
        return i==valor ? String.valueOf(valor) : i+" * "+Operaciones.productoFactorial(i-1,valor);
    }
    /**
     * Genera la multiplicación de un número n hasta el factorial del valor limite
     * @param i valor inicial
     * @param factorial valor a dar factorial
     * @return multiplicación recursiva de un valor inicial al factorial del valor final
     */
    public static String productUpFactorial(int i,int factorial){
        return i==factorial ? Operaciones.formatNumber(Operaciones.factorial(factorial)) : i+" * "+Operaciones.productUpFactorial(i-1,factorial);
    }
}