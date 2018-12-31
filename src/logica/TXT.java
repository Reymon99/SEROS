package logica;
public enum TXT {
    TDA("Un tda o tipo de dato abstrato es un tipo de dato (clase) definida por el programador, que consta de datos (los cuales pueden ser primitivos, definidos por el lenguaje de programación u otro tda) y operaciones (lo cuales son los metodos y funciones que controlan el comportamiento del tda) que se pueden realizar sobre ellos."),
    TDA1("Los tda también constan de dos especificaciones cuyas son:\n\t1. La descripción matemática del conjunto de datos, que hace referencia a los atributos de un dato (clase) cuyos podemos evidenciar en la línea número 2 de la clase Punto.\n\t2. La descripción de las operaciones definidas en ciertos elementos de ese conjunto de datos, que hacen referancia a los metodos y funciones que afectan el comportamiento de los atributos definidos en un dato (clase) como los podemos evidenciar entre las líneas número 7 y 22 de la clase Punto.\n\nSegún lo leído podríamos decir que un tda puede definirse mediante la siguiente ecuación:"),
    FORMULATDA("tda = REPRESENTACION(datos) + OPERACIONES(funciones y metodos)"),
    SIMULADORTDA("Instancia el objeto punto asignando sus respectivos parametros X,Y"),
    SIMULADORTDA1("Muestra las coordenadas X,Y dadas"),
    SIMULADORTDA2("Ingrese las coordenadas (x,y)");
    private String n;
    private TXT(String n){
        this.n=n;
    }
    /**
     * Contiene todos los textos utilizados en títulos, enunciado, contenidos, y notificaciones de proyecto
     * @return String
     */
    @Override
    public String toString() {
        return n;
    }
}