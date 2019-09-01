package gui.simulador.simuladores.recursividad;
import eventos.Eventos;
import gui.contenido.Tree;
import gui.editor.Editor;
import gui.simulador.simuladores.Recursividad;
import hilos.LineLocation;
import hilos.Lines;
import tools.Dato;
import tools.Operaciones;
import tools.Text;
import javax.swing.*;
public final class Potencia extends Recursividad {
    private JSpinner valorBase;
    private JSpinner valorExponente;
    private Tree base;
    private Tree exponente;
    /**
     * Simulador para la temática Recursividad<br>
     * Simulador para el proceso recursivo del potencia
     * @see Recursividad
     * @see gui.simulador.Simulador
     * @see tools.Acciones
     */
    public Potencia(JSpinner valorBase, JSpinner valorExponente) {
        super("Base  -  Exponente", valorBase, valorExponente);
        this.valorBase = valorBase;
        this.valorExponente = valorExponente;
        Operaciones.addFormat(Operaciones.Operacion.POTENCIA, "##,###,###,###.#");
        base = new Tree(new Dato("int", "base", ""));
        exponente = new Tree(new Dato("int", "exponente", ""));
        setDatos(base, exponente);
        setProducto(Eventos.html(Operaciones.operacion(Operaciones.exponente("b", "e"), "0")));
        setTexto(Text.POTENCIA);
        addCodes(Editor.editor("/resources/codes/recursividad/Potencia.seros", "Potencia"));
    }
    /**
     * Acción del caso base 0 lanzando una excepción aritmética
     */
    private void casoArithmetic() {
        base(Text.ARITHMETIC_1, '-', Text.INDETERMINADO.toString(), true);
    }
    @Override
    protected void casoTerminal() {
        base(Text.POTENCIA_1, Operaciones.potencia(valorBase.getValue(), valorExponente.getValue()),
                String.valueOf(Operaciones.potencia(valorBase.getValue(), valorExponente.getValue())), true);
    }
    @Override
    protected void casoDecrementativo() {
        base(Text.CASO_RECURSIVO, 0, Operaciones.productoPotenciaUp(valorBase.getValue(), getIteracion() + 1), false);
        incrementIteracion();
    }
    @Override
    protected void casoIncrementativo() {
        base(Text.POTENCIA_3, Operaciones.potencia(valorBase.getValue(), getValor()),
                Operaciones.productoPotenciaUpN(valorBase.getValue(), getIteracion(), getValor()), false);
        decrementIteracion();
    }
    @Override
    protected void casoBase(boolean found) {
        base(found ? Text.POTENCIA_1 : Text.CASO_BASE_RETURN_2, Operaciones.potencia(valorBase.getValue(), getValor()),
                found ? String.valueOf(Operaciones.potencia(valorBase.getValue(), getValor())) :
                        Operaciones.productoPotenciaUp(valorBase.getValue(), valorExponente.getValue()), found);
        if (!found){
            setDecremento(false);
            decrementIteracion();
        }
    }
    @Override
    protected Lines[] lines() {
        LineLocation[] lines = new LineLocation[]{
                new LineLocation(0, 1, null),
                new LineLocation(0, 2, Text.CASO_BASE.toString()),
                new LineLocation(0, 3, Text.POTENCIA_2.toString()),
                new LineLocation(0, 8, null),
                new LineLocation(0, 9, Text.CASO_BASE_FOUND.toString()),
                new LineLocation(0, 11, null, false)
        };
        return new Lines[]{
                new Lines(this, new LineLocation(0, 11, Text.CASO_RECURSIVO_FINISHED.toString())) {
                    @Override
                    protected void actions() {
                        accionesCasoTerminal(false);
                    }
                }, new Lines(this, lines[5]) {
                    @Override
                    protected void actions() {
                        accionesCasoIncrementativo(false);
                    }
                }, new Lines(this, lines[0], lines[1], lines[3],
                        new LineLocation(0, 10, Text.CASO_RECURSIVO.toString()), lines[5]) {
                    @Override
                    protected void actions() {
                        accionesCasoDecrementativo(false);
                    }
                }, new Lines(this, lines[0], lines[1], lines[2],
                        new LineLocation(0, 4, Text.ARITHMETIC.toString())) {
                    @Override
                    protected void actions() {
                        accionesCasoBase(false);
                    }
                }, new Lines(this, lines[0], lines[1], lines[2],
                        new LineLocation(0, 5, Text.CASO_BASE_FOUND.toString()),
                        new LineLocation(0, 6, null, false)) {
                    @Override
                    protected void actions() {
                        accionesCasoBase(false);
                    }
                }, new Lines(this, lines[0], lines[1], lines[3], lines[4],
                        new LineLocation(0, -1, Text.CASO_BASE_RETURN_1.toString())) {
                    @Override
                    protected void actions() {
                        accionesCasoBase(false);
                    }
                }, new Lines(this, lines[0], lines[1], lines[3], lines[4]) {
                    @Override
                    protected void actions() {
                        accionesCasoBase(false);
                    }
                }
        };
    }
    @Override
    protected boolean isCasoBase() {
        int basePot = Integer.parseInt(valorBase.getValue().toString());
        return getValor()==1 || getValor()==0 || basePot == 1 || basePot == 0;
    }
    @Override
    protected void accionesCasoBase(boolean code) {
        int basePot = Integer.parseInt(valorBase.getValue().toString());
        if (getValor() == 0){
            if (basePot == 0){
                if (code) lines()[3].start();
                else casoArithmetic();
            } else if (code) lines()[4].start();
            else casoBase(true);
        } else if (basePot == 1 || basePot == 0 || Integer.parseInt(valorExponente.getValue().toString()) == 1) {
            if (code) lines()[5].start();
            else casoBase(true);
        } else if (code) lines()[6].start();
        else casoBase(false);
    }
    @Override
    public void iteracion0() {
        Eventos.enable(false, valorBase, valorExponente, getNextIteracion(), getSend(), getPause(), getBack(), getClean(), getCodigo(), getHome());
        Eventos.variable(base, -1, valorBase.getValue());
        Eventos.variable(exponente, -1, valorExponente.getValue());
        if (Integer.parseInt(valorBase.getValue().toString()) == 0 && Integer.parseInt(valorExponente.getValue().toString()) == 0) casoArithmetic();
        else base(Text.FACTORIAL_1, Operaciones.potencia(valorBase.getValue(), valorExponente.getValue()),
                Operaciones.productoPotencia(Integer.parseInt(valorBase.getValue().toString()), Integer.parseInt(valorExponente.getValue().toString())), true);
    }
    @Override
    public void iteracion1() {
        Eventos.enable(false, valorBase, valorExponente);
        setValor(Integer.parseInt(valorExponente.getValue().toString()) - getIteracion());
        Eventos.variable(base, -1, valorBase.getValue());
        Eventos.variable(exponente, -1, getValor());
        super.iteracion1();
    }
    @Override
    public void clean() {
        cleanComponents();
        Eventos.enable(true, valorBase, valorExponente);
        setTexto(Text.POTENCIA);
        setNumber(String.valueOf(0));
        setProducto(Eventos.html(Operaciones.operacion(Operaciones.exponente("a", "n"), "0")));
        valorBase.setValue(0);
        valorExponente.setValue(0);
        Eventos.variable(base, -1, "");
        Eventos.variable(exponente, -1, "");
    }
    @Override
    protected void base(Text text, Object numberText, String productoText, boolean clean) {
        super.base(text, numberText, productoText, clean);
        try{
            setNumber(Operaciones.formatNumber(numberText, Operaciones.Operacion.POTENCIA));
        } catch (IllegalArgumentException e) {
            setNumber(numberText.toString());
        }
        setProducto(Text.INDETERMINADO.toString().equals(productoText) ? Text.INDETERMINADO.toString() :
                Eventos.html(Operaciones.operacion(Operaciones.exponente(valorBase.getValue(), valorExponente.getValue()), productoText)));
    }
}