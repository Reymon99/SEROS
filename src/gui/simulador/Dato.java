package gui.simulador;
public class Dato {
    private String tipoDato;
    private String variable;
    private String valor;
    private boolean hash;
    public Dato(String tipoDato, String variable, String valor) {
        this(tipoDato,variable,valor,false);
    }
    public Dato(String tipoDato, String variable, String valor, boolean hash) {
        this.tipoDato = tipoDato;
        this.variable = variable;
        this.valor = valor;
        this.hash = hash;
    }
    /**
     * Obtiene el tipo de dato utilizado
     * @return tipo de dato
     * @author Sergio Majé
     */
    public String getTipoDato() {
        return tipoDato;
    }
    /**
     * Modifica el tipo de dato
     * @param tipoDato nuevo tipo de dato
     * @author Sergio Majé
     */
    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }
    /**
     * Obtiene la variable
     * @return variable
     * @author Sergio Majé
     */
    public String getVariable() {
        return variable;
    }
    /**
     * Modifica la variable
     * @param variable nueva variable
     * @author Sergio Majé
     */
    public void setVariable(String variable) {
        this.variable = variable;
    }
    /**
     * Obtiene el valor dado a la variable
     * @return valor de la variable
     * @author Sergio Majé
     */
    public String getValor() {
        return valor;
    }
    /**
     * Modifica el valor de la variable
     * @param valor nuevo valor para la variable
     * @author Sergio Majé
     */
    public void setValor(String valor) {
        this.valor = valor;
    }
    /**
     * Obtiene si se utiliza el hash
     * @return true: se utiliza el hash | false: no se utiliza el hash
     */
    public boolean isHash() {
        return hash;
    }
    /**
     * Modifica si se utiliza el hash
     * @param hash nuevo hash a utilizar
     * @author Sergio Majé
     */
    public void setHash(boolean hash) {
        this.hash = hash;
    }
    /**
     * hash a utilizar en el dato
     * @return hash del dato
     * @author Sergio Majé
     */
    public String hashGenerator(){
        return tipoDato+'@'+hashHex();
    }
    /**
     * hash de la clase
     * @return hash
     * @author Sergio Majé
     */
    public String hashHex(){
        return valor.isEmpty() || valor.equals("null") ? "null" : Integer.toHexString(hashCode());
    }
    @Override
    public String toString() {
        return variable+(valor.isEmpty() ? "" : " = "+valor+(hash ? hashGenerator() : ""));
    }
}