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

import javax.swing.JSpinner;

public final class Factorial extends Recursividad {
    private final JSpinner valorDato;
    private final Tree variableN;

    /**
     * Simulador para la temática Recursividad<br>
     * Simulador para el proceso recursivo del factorial
     * @see Recursividad
     * @see gui.simulador.Simulador
     * @see tools.Acciones
     */
    public Factorial(JSpinner valorDato) {
        super(null, valorDato);
        this.valorDato = valorDato;
        Operaciones.addFormat(Operaciones.Operacion.FACTORIAL, "#,###,###");
        setDatos(this.variableN = new Tree(new Dato("int", "n", "")));
        addCodes(Editor.editor("Factorial"));
        setTexto(Text.FACTORIAL);
        setProducto(Operaciones.operacion("n!", "0"));
    }

    @Override
    protected void casoTerminal() {
        base(
                Text.FACTORIAL_1,
                Operaciones.formatNumber(Operaciones.factorial(getValor()), Operaciones.Operacion.FACTORIAL),
                Operaciones.productUpFactorial(Integer.parseInt(valorDato.getValue().toString()), getValor()),
                true
        );
    }

    @Override
    protected void casoDecrementativo() {
        base(
                Text.CASO_RECURSIVO,
                0,
                Operaciones.productoFactorial(Integer.parseInt(valorDato.getValue().toString()), getValor()),
                false
        );
        incrementIteracion();
    }

    @Override
    protected void casoIncrementativo() {
        base(
                Text.FACTORIAL_2,
                Operaciones.formatNumber(Operaciones.factorial(getValor()), Operaciones.Operacion.FACTORIAL),
                Operaciones.productUpFactorial(Integer.parseInt(valorDato.getValue().toString()), getValor()),
                false
        );
        decrementIteracion();
    }

    @Override
    protected void casoBase(boolean found) {
        base(
                found ? Text.FACTORIAL_1 : Text.CASO_BASE_RETURN_2,
                Operaciones.factorial(getValor()),
                Operaciones.productoFactorial(Integer.parseInt(valorDato.getValue().toString())),
                found
        );
        if (!found) {
            decrementIteracion();
            setDecremento(false);
        }
    }

    @Override
    protected Lines[] lines() {
        LineLocation[] lines = new LineLocation[]{
                new LineLocation(0, 1, null),
                new LineLocation(0, 2, Text.CASO_BASE.toString()),
                new LineLocation(0, 5, null, false)
        };
        return new Lines[]{
                new Lines(
                        this,
                        new LineLocation(0, 5, Text.CASO_RECURSIVO_FINISHED.toString(), false)
                ) {
                    @Override
                    protected void actions() {
                        accionesCasoTerminal(false);
                    }
                },
                new Lines(this, lines[2]) {
                    @Override
                    protected void actions() {
                        accionesCasoIncrementativo(false);
                    }
                },
                new Lines(
                        this,
                        lines[0],
                        lines[1],
                        new LineLocation(0, 4, Text.CASO_RECURSIVO.toString()),
                        lines[2]
                ) {
                    @Override
                    protected void actions() {
                        accionesCasoDecrementativo(false);
                    }
                },
                new Lines(
                        this,
                        lines[0],
                        lines[1],
                        new LineLocation(0, 3, Text.CASO_BASE_RETURN_1.toString())
                ) {
                    @Override
                    protected void actions() {
                        accionesCasoBase(false);
                    }
                }
        };
    }

    @Override
    protected boolean isCasoBase() {
        return getValor() == 1 || getValor() == 0;
    }

    @Override
    protected void accionesCasoBase(boolean code) {
        if (code) lines()[3].start();
        else {
            int n = Integer.parseInt(valorDato.getValue().toString());
            casoBase(n == 1 || n == 0);
        }
    }

    @Override
    public void iteracion0() {
        Eventos.enable(
                false,
                getNextIteracion(),
                getSend(),
                valorDato,
                getPause(),
                getBack(),
                getClean(),
                getCodigo(),
                getHome()
        );
        Eventos.variable(variableN, -1, valorDato.getValue());
        base(
                Text.FACTORIAL_1,
                Operaciones.formatNumber(
                        Operaciones.factorial(Integer.parseInt(valorDato.getValue().toString())),
                        Operaciones.Operacion.FACTORIAL
                ),
                Operaciones.productoFactorial(Integer.parseInt(valorDato.getValue().toString())),
                true
        );
    }

    @Override
    public void iteracion1() {
        Eventos.enable(false, valorDato);
        setValor(Integer.parseInt(valorDato.getValue().toString()) - getIteracion());
        Eventos.variable(variableN, -1, getValor());
        super.iteracion1();
    }

    @Override
    public void clean() {
        cleanComponents();
        setTexto(Text.FACTORIAL);
        Eventos.variable(variableN, -1, "");
        Eventos.enable(true, valorDato);
        valorDato.setValue(0);
        setNumber(String.valueOf(0));
        setProducto(Operaciones.operacion("n!", "0"));
    }

    @Override
    protected void base(Text text, Object numberText, String productoText, boolean clean) {
        super.base(text, numberText, productoText, clean);
        setNumber(numberText.toString());
        setProducto(Operaciones.operacion(valorDato.getValue().toString() + '!', productoText));
    }
}