package hilos;
import eventos.Eventos;
import gui.contenido.Texto;
import gui.editor.Editor;
import gui.simulador.Simulador;
public abstract class Lines extends Thread {
    private final int intervalo = 1270;
    private Simulador simulador;
    private LineLocation[] lines;
    /**
     * Hilo recorredor de lineas en el Editor.<br>
     * Modifica el texto del componente en determinadas lineas.
     * Habilita el boton deseado a utilizar
     * @param simulador simulador correspondiente en el cual el componente {@link Texto} se ubicarán los textos de las líneas correspondientes, y el componente {@link Editor} en el cual se seleccionarán las líneas dispuestas en {@link Lines#lines}.
     * @param lines números de las líneas a seleccionar con sus respectivos texto, desde nulos a su contenido correspondiente.
     */
    public Lines(Simulador simulador, LineLocation... lines) {
        this.simulador = simulador;
        this.lines = lines;
    }
    @Override
    public void run() {
        try {
            lines();
            actions();
        } catch (Exception e){
            Thread.currentThread().stop();
        }
    }
    /**
     * Detiene la ejecución del hilo y los punteros de los atributos se pierden
     */
    public void detener(){
        simulador=null;
        lines=null;
        stop();
    }
    /**
     * Selección de líneas en la ejecución del paso a paso
     */
    private void lines(){
        for (LineLocation line:lines){
            simulador.getCodigos().setSelectedIndex(line.getCode());
            Eventos.scroll(((Editor) simulador.getCodigos().getComponentAt(line.getCode())),line.getScroll());
            ((Editor) simulador.getCodigos().getComponentAt(line.getCode())).drawLineIn(line.getLine());
            if (line.getTexto()!=null) simulador.getTexto().setText(line.getTexto());
            if (line.isSleep()) Eventos.sleep(intervalo);
        }
    }
    /**
     * Acciones a realizar al final del hilo.<br>
     * Reescribirlo para efectuar los comandos.
     */
    public abstract void actions();
}