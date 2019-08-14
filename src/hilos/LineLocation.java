package hilos;
public class LineLocation {
    private int code;
    private int lineIndice;
    private int lineEditor;
    private String texto;
    private int scroll;
    private boolean sleep;
    /**
     * Locación de cada código en los editores con su respectivo texto a utilizar
     * @param code ubicación de código a emplear
     * @param lineIndice línea en el código a seleccionar en el Indice
     * @param lineEditor línea en el código a seleccionar en el View
     * @param texto texto respectivo de la línea
     */
    public LineLocation(int code, int lineIndice, int lineEditor, String texto){
        this(code, lineIndice, lineEditor, texto, 0, true);
    }
    /**
     * Locación de cada código en los editores con su respectivo texto a utilizar
     * @param code ubicación de código a emplear
     * @param lineIndice línea en el código a seleccionar en el Indice
     * @param lineEditor línea en el código a seleccionar en el View
     * @param texto texto respectivo de la línea
     * @param sleep si es verdadero duerme la ejecución de la línea de lo contrario solo se seleccionará la línea y el proceso seguirá normalmente
     */
    public LineLocation(int code, int lineIndice, int lineEditor, String texto, boolean sleep){
        this(code, lineIndice, lineEditor, texto, 0, sleep);
    }
    /**
     * Locación de cada código en los editores con su respectivo texto a utilizar
     * @param code ubicación de código a emplear
     * @param line línea en el código a seleccionar
     * @param texto texto respectivo de la línea
     * @param sleep si es verdadero duerme la ejecución de la línea de lo contrario solo se seleccionará la línea y el proceso seguirá normalmente
     */
    public LineLocation(int code, int line, String texto, boolean sleep) {
        this(code, line, line, texto, 0, sleep);
    }
    /**
     * Locación de cada código en los editores con su respectivo texto a utilizar
     * @param code ubicación de código a emplear
     * @param line línea en el código a seleccionar
     * @param texto texto respectivo de la línea
     */
    public LineLocation(int code, int line, String texto) {
        this(code, line, line, texto, 0, true);
    }
    /**
     * Locación de cada código en los editores con su respectivo texto a utilizar
     * @param code ubicación de código a emplear
     * @param lineIndice línea en el código a seleccionar en el Indice
     * @param lineEditor línea en el código a seleccionar en el View
     * @param texto texto respectivo de la línea
     * @param scroll posición del scroll del editor
     * @param sleep si es verdadero duerme la ejecución de la línea de lo contrario solo se seleccionará la línea y el proceso seguirá normalmente
     */
    private LineLocation(int code, int lineIndice, int lineEditor, String texto, int scroll, boolean sleep) {
        this.code = code;
        this.lineIndice = lineIndice;
        this.lineEditor = lineEditor;
        this.texto = texto;
        this.scroll = scroll;
        this.sleep = sleep;
    }
    /**
     * Obtiene la ubicación del código a emplear
     * @return ubicación del código
     */
    public int getCode() {
        return code;
    }
    /**
     * Obtiene la línea a seleccionar en el código empleado
     * @return línea a seleccionar del código en el Indice
     */
    public int getLineIndice() {
        return lineIndice;
    }
    /**
     * Obtiene la línea a seleccionar en el código empleado
     * @return línea a seleccionar del código en el View
     */
    public int getLineEditor() {
        return lineEditor;
    }
    /**
     * Obtiene el texto empleado de la línea a seleccionar del código en el editor
     * @return texto empleado de la línea
     */
    public String getTexto() {
        return texto;
    }
    /**
     * Obtiene la posición dada al scroll del editor
     * @return posición del scroll
     */
    public int getScroll() {
        return scroll;
    }
    /**
     * Obtiene el estado de sí la línea duerme ó no
     * @return estado de espera
     */
    public boolean isSleep() {
        return sleep;
    }
    @Override
    public String toString() {
        return texto;
    }
}