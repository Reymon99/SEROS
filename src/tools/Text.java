package tools;
public enum Text {
    TDA("Un TDA o tipo de dato abstrato es un tipo de dato (clase) definida por el programador, que consta de datos (los cuales pueden ser primitivos, definidos por el lenguaje de programación u otro TDA) y operaciones (lo cuales son los metodos y funciones que controlan el comportamiento del TDA) que se pueden realizar sobre ellos."),
    TDA1("<html><n>Los tda también constan de dos especificaciones cuyas son:</n><ol><li>La descripción matemática del conjunto de datos, que hace referencia a los atributos de un dato (clase) cuyos podemos evidenciar en la línea número 2 de la clase Punto.</li><li>La descripción de las operaciones definidas en ciertos elementos de ese conjunto de datos, que hacen referancia a los metodos y funciones que afectan el comportamiento de los atributos definidos en un dato (clase) como los podemos evidenciar entre las líneas número 7 y 22 de la clase Punto.</li></ol><p>Según lo leído podríamos decir que un tda puede definirse mediante la siguiente ecuación:</p>"),
    FORMULATDA("tda = REPRESENTACION(datos) + OPERACIONES(funciones y metodos)"),
    SIMULADORTDA("Instancia el objeto punto asignando sus respectivos parametros X,Y"),
    SIMULADORTDA1("Muestra las coordenadas X,Y dadas"),
    SIMULADORTDA2("Ingrese las coordenadas (x,y)"),
    ABOUT("Descripción explicita de cada Estructura de Datos desde lo conceptual, visión y simulación de las mismas con ejemplos cotidianos resueltos con las escrutura de datos.\n\n\nDesarrollado por\nSergio Andrés Majé Franco\n\n\nVersion 1.0");
    private String n;
    private Text(String n){
        this.n=n;
    }
    /**
     * Contiene todos los textos utilizados en títulos, enunciado, contenidos, y notificaciones de proyecto
     * @return String
     * @author Sergio Majé
     */
    @Override
    public String toString() {
        return n;
    }
}