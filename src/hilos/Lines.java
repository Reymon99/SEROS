package hilos;

import acciones.Eventos;
import gui.editor.Editor;
import gui.simulador.Simulador;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class Lines extends Thread {
    private final Simulador simulador;
    private final List<LineLocation> lines;

    /**
     * Hilo recorredor de líneas en el Editor.<br>
     * Modifica el texto del componente en determinadas líneas.
     * Habilita el boton deseado a utilizar
     * @param simulador simulador correspondiente en el cual el componente {@link gui.contenido.Components#getBoton}
     *                  se ubicarán los textos de las líneas correspondientes, y el componente {@link Editor} en el
     *                  cual se seleccionarán las líneas dispuestas en {@link Lines#lines}.
     * @param lines     números de las líneas a seleccionar con sus respectivos texto, desde nulos a su contenido
     *                  correspondiente.
     */
    protected Lines(Simulador simulador, LineLocation... lines) {
        this.simulador = simulador;
        this.lines = Arrays.asList(lines);
    }

    @Override
    public void run() {
        lines();
        actions();
    }

    /**
     * Selección de líneas en la ejecución del paso a paso
     */
    private void lines() {
        lines.forEach(this::lineAction);
    }

    /**
     * Ejecuta cada una de las acciones de la línea empleada
     * @param line línea del Editor a emplear
     */
    private void lineAction(LineLocation line) {
        simulador.getCodigos().setSelectedIndex(line.code());
        Eventos.scroll(((Editor) simulador.getCodigos().getComponentAt(line.code())), line.scroll());
        if (line.line() > 0) ((Editor) simulador.getCodigos().getComponentAt(line.code())).drawLineIn(line.line());
        if (Optional.ofNullable(line.texto()).isPresent()) simulador.setTexto(line.texto());
        if (line.sleep()) Eventos.sleep(1270);
    }

    /**
     * Acciones a realizar al final del hilo.<br>
     * Reescribirlo para efectuar los comandos.
     */
    protected abstract void actions();
}