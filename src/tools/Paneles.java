package tools;
public enum Paneles {
    /**
     * Nombre de los paneles predefinidos
     */
    PRINCIPAL("Principal"),
    TDA("TDA"),
    MODULARIDAD("Modularidad"),
    RECURSIVIDAD("Recursividad"),
    ARREGLOS("Arreglos"),
    NODOS("Nodos"),
    ORDENAMIENTO("Ordenamiento"),
    BUSQUEDA("Busqueda"),
    PILAS("Pilas"),
    COLAS("Colas"),
    LISTAS_ENLAZADAS("Listas Enlazadas"),
    ARBOLES("Arboles"),
    GRAFOS("Grafos"),
    SIMULADORTDA("Simulador TDA"),
    FACTORIAL("Simulador Factorial"),
    POTENCIA("Simulador Potencia"),
    EJERCICIOS_RECURSIVIDAD("Ejercicios Recursividad");
    private String n;
    Paneles(String n){
        this.n=n;
    }
    @Override
    public String toString() {
        return n;
    }
}