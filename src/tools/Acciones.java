package tools;
public interface Acciones {
    /**
     * Iteración del simulador cuando no se ejecuta el paso a paso
     */
    void iteracion0();
    /**
     * Iteración del simulador con paso a paso
     */
    void iteracion1();
    /**
     * Restaura los componente al origen
     */
    void clean();
}