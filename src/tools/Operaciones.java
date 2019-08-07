package tools;
import eventos.Eventos;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
public abstract class Operaciones {//Operaciones y demostraciones matemáticas
    private static HashMap<Operacion,DecimalFormat> format;
    static {
        Operaciones.format = new HashMap<>();
    }
    /**
     * Keys de los formatos a trabajar
     */
    public enum Operacion{
        FACTORIAL,
        POTENCIA
    }
    /**
     * Se específica el formato a dar a los números
     * @param key formato a trabajar
     * @param pattern patron a trabajar
     */
    public static void addFormat(Operacion key,String pattern) {
        Operaciones.format.put(key,new DecimalFormat(pattern));
    }
    /**
     * Formato al número dado
     * @param number número a dar formato
     * @param operacion formato a trabajar
     * @return Un {@link String} con le número formateado
     */
    public static String formatNumber(Object number, Operacion operacion){
        return Operaciones.format.get(operacion).format(number);
    }
    /**
     * Concatena la operación realizada con su respectivo resultado
     * @param operacion Operación realizada
     * @param resultado Respectivo resultado de la operación
     * @return operación y resultado en una única cadena
     */
    public static String operacion(String operacion,Object resultado){
        return operacion+"    =    "+resultado.toString();
    }
    /**
     * Genera el factorial de n
     * @param n número a dar el factorial
     * @return factorial de n
     */
    public static long factorial(int n){
        return n==1 || n==0 ? 1 : n*Operaciones.factorial(n-1);
    }
    /**
     * Genera la multiplicación de un factorial n
     * @param i número a generar la multiplicación del factorial
     * @return multiplicación recursiva del factorial n
     */
    public static String productoFactorial(int i){
        return i==1 || i==0 ? "1" : i+" * "+Operaciones.productoFactorial(i-1);
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
        return i==factorial ? Operaciones.formatNumber(Operaciones.factorial(factorial),Operacion.FACTORIAL) : i+" * "+Operaciones.productUpFactorial(i-1,factorial);
    }
    /**
     * No da una cadena exponencial convertida por medio de HTML
     * @param base base del exponente
     * @param exponente exponente de la base
     * @return cadena exponencial
     * @see Eventos#html(String)
     */
    public static String exponente(Object base, Object exponente){
        return base.toString()+"<sup>"+exponente.toString()+"</sup>";
    }
    /**
     * Resuelve una potencia con los casos dados
     * @param base base de la potencia
     * @param exponente exponente de la potencia
     * @return Resultado de la potencia según los casos dados
     */
    public static long potencia(Object base,Object exponente){
        return (long) Math.pow(Integer.parseInt(base.toString()),Integer.parseInt(exponente.toString()));
    }
    /**
     * Genera la multiplicación de una potencia dada
     * @param base caso base de la potencia
     * @param exponente caso exponente de la potencia
     * @return multiplicación recursiva de la potencia b^e
     */
    public static String productoPotencia(int base,int exponente){
        if (exponente==0) return "1";
        else if (exponente==1) return String.valueOf(base);
        else return base+" * "+productoPotencia(base, exponente-1);
    }
    public static String productoPotenciaUp(Object base,Object exponente){
        String[] ads=new String[Integer.parseInt(exponente.toString())];
        Arrays.fill(ads,base.toString());
        return String.join(" * ",ads);
    }
    public static String productoPotenciaUpN(Object base,Object exponente,int valor){
        return productoPotenciaUp(base,exponente) +" * "+ potencia(base, valor);
    }
}