package hilos;
import eventos.Eventos;
import gui.contenido.Texto;
import gui.editor.Editor;
import gui.simulador.Simulador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static tools.Text.*;
public class Lines extends Thread {
    private final int intervalo = 1170;
    private ArrayList<LineLocation> lines;
    private Simulador simulador;
    /**
     * Hilo recorredor de lineas en el Editor.<br>
     * Modifica el texto del componente en determinadas lineas.
     * @param lines números de las líneas a seleccionar con sus respectivos texto, desde nulos a su contenido correspondiente.
     * @param simulador simulador correspondiente en el cual el componente {@link Texto} se ubicarán los textos de las líneas correspondientes, y el componente {@link Editor} en el cual se seleccionarán las líneas dispuestas en {@link Lines#lines}.
     */
    public Lines(ArrayList<LineLocation> lines, Simulador simulador) {
        this.lines = lines;
        this.simulador = simulador;
    }
    @Override
    public void run() {
        for (LineLocation line:lines){
            simulador.getCodigos().setSelectedIndex(line.getCode());
            ((Editor)simulador.getCodigos().getComponentAt(line.getCode())).drawLineIn(line.getLine());
            if (line.getTexto()!=null) simulador.getTexto().setText(line.getTexto());
            if (!line.equals(lines.get(lines.size()-1))) Eventos.sleep(intervalo);
        }
    }
    /*private void casosFactorial(){
        System.out.println("factorial.getIteraccion() = " + factorial.getIteraccion());
        System.out.println("factorial.isDecremento() = " + factorial.isDecremento());
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
                factorial.setDecremento(false);
                Eventos.enable(true,factorial.getNext());
            }
        } else {
            factorial.getTexto().setText(FACTORIAL3.toString());
            System.out.println(factorial.getIteraccion());
            Eventos.variable(factorial.getVariaI(),-1,factorial.getIteraccion());
            casoRecursivo();
            factorial.getTexto().setText(FACTORIAL2.toString());
            if (factorial.getIteraccion()==Integer.parseInt(factorial.getValorI().getValue().toString()) && !factorial.isDecremento()){
                System.out.println("Saliendo");
                factorial.getTexto().setText(FACTORIAL1.toString());
                Eventos.enable(true,factorial.getClean());
            } else {
                if (factorial.isDecremento()){
                    System.out.println("decremento");
                    factorial.getProducto().setText(factorial.getValorI().getValue().toString()+"!    =    "+factorial.producto(factorial.getIteraccion()));
                    factorial.decrementoIteraccion();
                } else {
                    System.out.println("incremento");
                    factorial.getNumber().setText(Eventos.formatNumber(factorial.fac(factorial.getIteraccion()),"#,###,###"));
                    factorial.incrementIteraccion();
                }
                Eventos.enable(true,factorial.getNext());
            }
        }
        System.out.println("factorial.isDecremento() = " + factorial.isDecremento());
        System.out.println("factorial.getIteraccion() = " + factorial.getIteraccion());
    }
    private boolean isBase(){
        return factorial.getIteraccion()==1 || factorial.getIteraccion()==0;
    }*/
}