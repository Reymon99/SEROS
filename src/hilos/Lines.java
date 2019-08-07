package hilos;
import eventos.Eventos;
import gui.contenido.Texto;
import gui.editor.Editor;
import gui.simulador.Simulador;
public abstract class Lines extends Thread {
    private Simulador simulador;
    private LineLocation[] lines;
    /**
     * Hilo recorredor de líneas en el Editor.<br>
     * Modifica el texto del componente en determinadas líneas.
     * Habilita el boton deseado a utilizar
     * @param simulador simulador correspondiente en el cual el componente {@link Texto} se ubicarán los textos de las líneas correspondientes, y el componente {@link Editor} en el cual se seleccionarán las líneas dispuestas en {@link Lines#lines}.
     * @param lines números de las líneas a seleccionar con sus respectivos texto, desde nulos a su contenido correspondiente.
     */
    protected Lines(Simulador simulador, LineLocation... lines) {
        this.simulador = simulador;
        this.lines = lines;
    }
    @Override
    public void run() {
        lines();
        actions();
    }
    /**
     * Selección de líneas en la ejecución del paso a paso
     */
    private void lines(){
        for (LineLocation line:lines){
            simulador.getCodigos().setSelectedIndex(line.getCode());
            Eventos.scroll(((Editor) simulador.getCodigos().getComponentAt(line.getCode())),line.getScroll());
            ((Editor) simulador.getCodigos().getComponentAt(line.getCode())).drawLineIn(line.getLineIndice(),line.getLineEditor());
            if (line.getTexto()!=null) simulador.setTexto(line.getTexto());
            if (line.isSleep()) Eventos.sleep(1270);
        }
    }
    /**
     * Acciones a realizar al final del hilo.<br>
     * Reescribirlo para efectuar los comandos.
     */
    protected abstract void actions();
}