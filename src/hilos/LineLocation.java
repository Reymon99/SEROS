package hilos;
public class LineLocation {
    private int code;
    private int line;
    private String texto;
    private int scroll;
    private boolean sleep;
    /**
     * Locación de cada código en los editores con su respectivo texto a utilizar
     * @param code ubicación de código a emplear
     * @param line línea en el código a seleccionar
     * @param texto texto respectivo de la línea
     * @param sleep si es verdadero duerme la ejecución de la línea de lo contrario solo se seleccionará la línea y el proceso seguirá normalmente
     */
    public LineLocation(int code, int line, String texto, boolean sleep) {
        this(code, line, texto, 0, sleep);
    }
    /**
     * Locación de cada código en los editores con su respectivo texto a utilizar
     * @param code ubicación de código a emplear
     * @param line línea en el código a seleccionar
     * @param texto texto respectivo de la línea
     */
    public LineLocation(int code, int line, String texto) {
        this(code, line, texto, 0, true);
    }
    /**
     * Locación de cada código en los editores con su respectivo texto a utilizar
     * @param code ubicación de código a emplear
     * @param line línea en el código a seleccionar
     * @param texto texto respectivo de la línea
     * @param scroll posición del scroll del editor
     * @param sleep si es verdadero duerme la ejecución de la línea de lo contrario solo se seleccionará la línea y el proceso seguirá normalmente
     */
    public LineLocation(int code, int line, String texto, int scroll, boolean sleep) {
        this.code = code;
        this.line = line;
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
     * Da una nueva ubicación del código a emplear
     * @param code nueva ubicación del código
     */
    public void setCode(int code) {
        this.code = code;
    }
    /**
     * Obtiene la línea a seleccionar en el código empleado
     * @return línea a seleccionar del código en el editor
     */
    public int getLine() {
        return line;
    }
    /**
     * Da una nueva línea a seleccionar en el código empleado
     * @param line nueva línea a seleccionar en el código en el editor
     */
    public void setLine(int line) {
        this.line = line;
    }
    /**
     * Obtiene el texto empleado de la línea a seleccionar del código en el editor
     * @return texto empleado de la línea
     */
    public String getTexto() {
        return texto;
    }
    /**
     * Da un nuevo texto a emplear en la línea a seleccionar del código en el editor
     * @param texto nuevo texto a emplear en la línea seleccionada
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }
    /**
     * Obtiene la posición dada al scroll del editor
     * @return posición del scroll
     */
    public int getScroll() {
        return scroll;
    }
    /**
     * Da una nueva posición al scroll del editor
     * @param scroll nueva posición al scroll
     */
    public void setScroll(int scroll) {
        this.scroll = scroll;
    }
    /**
     * Obtiene el estado de sí la línea duerme ó no
     * @return estado de espera
     */
    public boolean isSleep() {
        return sleep;
    }
    /**
     * Da un nuevo estado de espera a la línea para así dormir o no
     * @param sleep nuevo estado de espera
     */
    public void setSleep(boolean sleep) {
        this.sleep = sleep;
    }
    @Override
    public String toString() {
        return texto;
    }
    @Override
    public boolean equals(Object obj) {
        return obj instanceof LineLocation && code==((LineLocation) obj).code && line==((LineLocation) obj).line;
    }
}