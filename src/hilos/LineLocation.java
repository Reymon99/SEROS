package hilos;

public record LineLocation(
        int code,
        int line,
        String texto,
        int scroll,
        boolean sleep
) {
    /**
     * Locación de cada código en los editores con su respectivo texto a utilizar
     * @param code   ubicación de código a emplear
     * @param line   línea en el código a seleccionar
     * @param texto  texto respectivo de la línea
     * @param scroll posición del scroll del editor
     */
    public LineLocation(int code, int line, String texto, int scroll) {
        this(code, line, texto, scroll, true);
    }

    /**
     * Locación de cada código en los editores con su respectivo texto a utilizar
     * @param code  ubicación de código a emplear
     * @param line  línea en el código a seleccionar
     * @param texto texto respectivo de la línea
     * @param sleep si es verdadero duerme la ejecución de la línea de lo contrario solo se seleccionará la línea y
     *              el proceso seguirá normalmente
     */
    public LineLocation(int code, int line, String texto, boolean sleep) {
        this(code, line, texto, 0, sleep);
    }

    /**
     * Locación de cada código en los editores con su respectivo texto a utilizar
     * @param code  ubicación de código a emplear
     * @param line  línea en el código a seleccionar
     * @param texto texto respectivo de la línea
     */
    public LineLocation(int code, int line, String texto) {
        this(code, line, texto, 0, true);
    }

    @Override
    public String toString() {
        return texto;
    }
}