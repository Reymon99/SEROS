package tools;
public enum Text {
    VENTANA_PRINCIPAL("Ventana Principal SEROS"),
    SIMULADOR_TDA_1("Muestra las coordenadas del punto dadas."),
    SIMULADOR_TDA_2("Ingrese las coordenadas (x,y)."),
    INSTANCIA_X("Instancia el valor de la variable x."),
    INSTANCIA_Y("Instancia el valor de la variable y."),
    FACTORIAL("Ingrese número para dar el Factorial de n."),
    FACTORIAL_1("Resultado del Factorial."),
    FACTORIAL_2("Multiplica n con los demás casos."),
    POTENCIA("Ingrese la base y el exponente para dar la Potencia."),
    POTENCIA_1("Resultado de la Potencia."),
    POTENCIA_2("Comprobando si la base es 0."),
    POTENCIA_3("Multiplicando la base con los demás casos."),
    CASO_BASE("Comprobando si se cumple con el caso base."),
    CASO_BASE_FOUND("Caso base encontrado."),
    CASO_BASE_RETURN_1("Retorna caso base."),
    CASO_BASE_RETURN_2("Retorna el caso base para así terminar los casos recursivos."),
    CASO_RECURSIVO("Buscando caso base mediante el recursivo"),
    CASO_RECURSIVO_FINISHED("Casos recursivos finalizados."),
    ARITHMETIC("Se encontró un error aritmético"),
    ARITHMETIC_1("Se lanza error aritmético."),
    INDETERMINADO("Indeterminado");
    private String n;
    Text(String n){
        this.n = n;
    }
    /**
     * Contiene todos los textos utilizados en títulos, enunciado, contenidos, y notificaciones de proyecto
     * @return enunciado deseado
     */
    @Override
    public String toString() {
        return n;
    }
}