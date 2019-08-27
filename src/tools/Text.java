package tools;
public enum Text {
    VENTANA_PRINCIPAL("Ventana Principal SEROS"),
    TDA("Un TDA o tipo de dato abstrato es un tipo de dato (clase) definida por el programador, que consta de datos (los cuales pueden ser primitivos, definidos por el lenguaje de programación u otro TDA) y operaciones (lo cuales son los métodos y funciones que controlan el comportamiento del TDA) que se pueden realizar sobre ellos."),
    TDA_1("Los TDA también constan de dos especificaciones cuyas son:"),
    TDA_2("1. La descripción matemática del conjunto de datos, que hace referencia a los atributos de un dato (clase) cuyos podemos evidenciar en la línea número 2 de la clase Punto.\n2. La descripción de las operaciones definidas en ciertos elementos de ese conjunto de datos, que hacen referencia a los métodos y funciones que afectan el comportamiento de los atributos definidos en un dato (clase) como los podemos evidenciar entre las líneas número 7 y 22 de la clase Punto."),
    TDA_3("Según lo leído podríamos decir que un TDA puede definirse mediante la siguiente ecuación:"),
    FORMULA_TDA("TDA = REPRESENTACIÓN (datos) + OPERACIONES (funciones y métodos)"),
    SIMULADOR_TDA_1("Muestra las coordenadas del punto dadas."),
    SIMULADOR_TDA_2("Ingrese las coordenadas (x,y)."),
    SIMULADOR_TDA_3("Instancia el valor de la variable x."),
    SIMULADOR_TDA_4("Instancia el valor de la variable y."),
    ABOUT("Descripción explícita de cada Estructura de Datos desde lo conceptual, visión y simulación de las mismas con ejemplos cotidianos resueltos con las estructuras de datos.\n\n\nDesarrollado por\nSergio Andrés Majé Franco\n\n\nVersion 1.0"),
    LINK("https://github.com/Reymon99/SimuladorTDA"),
    MODULARIDAD("La modularidad es la estructura de un TDA, con la cuál nos permite darle un comportamiento específico y deseado al objeto que deseamos trabajar."),
    MODULARIDAD_1("La modularidad se enfoca principalmente a la agrupación de métodos que permiten realizar trabajos complejos, mediante la filosofía “divide y vencerás”; también nos permite una mejor comprensión de lo que estamos codificando, de las tareas a realizar y la reutilización de los métodos(módulos) ya utilizados.\n\nCon esto podemos concluir que la modularidad se basa en las acciones que puede realizar un objeto y cuantas veces quiera tomarlas."),
    RECURSIVIDAD("La recursividad es la simplificación de táreas mediante una función que se llama así misma, buscando un resultado explícito por medio de un resultado implícito, a través de un caso base que aproxima esta respuesta.\n\nLa recursividad se estructura por dos casos, domino(recursivo) y base, yendo desde una respuesta implícita, que nos da una solución compuesta, a una respuesta explícita, siendo ya la solución deseada.\n\nLa recursividad tiene dos tipos de implementación, las cuales son:\n•\tLa Recursividad Directa, determinada por una función que se llama a sí misma.\n•\tLa Recursividad Indirecta, determinada por una función que se llama así misma mediante otra función."),
    RECURSIVIDAD_1("Directa\tf(x) \u279c f(x) \u279c f(x) \u279c x’\nIndirecta\tf(x) \u279c g(x) \u279c f(x) \u279c x’"),
    ARREGLOS("Como sabemos un arreglo o array es una secuencia de datos dados por ítems consecutivos desde el cero hasta la longitud del arreglo."),
    ARREGLOS_1("En estructura de datos son utilizadas para dar forma a estructuras estáticas (determinado por un tamaño limite) como veremos mas adelante en las estructuras de datos lineales (pilas, colas y listas) ayudándonos mediante los índices a crear algoritmos eficientes con una determinada estructura de datos."),
    ARREGLOS_2("Además de esto los arreglos pueden ser utilizados en múltiples dimensiones, siendo mayormente utilizadas en la segunda dimensión (arreglos bidimensionales o matrices) que nos permite simular una especie de tabla en la que podemos trabajar con múltiples datos anidados al mismo tiempo, permitiendo resolver distintos problemas determinados."),
    NODOS("Un nodo es un TDA que nos permite crear estructuras de datos dinámicas lineales y no lineales. Esto debido a su estructura basada en punteros y un único dato cuya característica es agrupar homogéneamente la información donde su contenido varia en variables (primitivas) a TDA (objetos)."),
    NODOS_1("Un nodo se encuentra referenciado mediante un hash en memoria principal. A su vez, los nodos están enlazados entre ellos mismos, permitiendo avanzar y operar entre ellos para poder gestionarlos.\n\nUn hash es la serie de 40 dígitos hexadecimales que nos permite identificar una serie de información dispuesta. En la memoria principal se utilizan para gestionar la identificación de los datos gestionados en memoria, logrando así ser administrados por el sistema."),
    NODOS_2("En programación las variables son utilizadas para almacenar datos, pero en realidad solo sirven como punteros de acceso, creación y modificación a datos en la memoria principal. Estos punteros funcionan mediante la asignación de identificadores en memoria, dirigidos por variables que permiten una fácil gestión de los datos en el momento de trabajar con ellos, de esta forma un dato puede ser controlado y modificado por varias variables que lo requieran."),
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
    INDETERMINADO("Indeterminado"),
    DEMOSTRACION_MODULARIDAD("En esta demostración podremos visualizar como una persona siguiendo la filosofía de divide y vencerás, realiza varias tareas logrando obtener una concentración absoluta en esta y una rápida terminación de la misma; esto como un ejemplo llevado a la realidad sobre cómo funciona la Modularidad.");
    private String n;
    Text(String n){
        this.n=n;
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