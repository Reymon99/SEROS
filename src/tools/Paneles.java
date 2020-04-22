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
    LISTAS("Listas Enlazadas"),
    ARBOLES("Árboles"),
    GRAFOS("Grafos"),
    DEMOSTRACION_MODULARIDAD("Demostración Modularidad"),
    EJERCICIOS_RECURSIVIDAD("Ejercicios Recursividad"),
    SIMULADOR_TDA("Simulador TDA"),
    FACTORIAL("Simulador Factorial"),
    POTENCIA("Simulador Potencia");
    private final String n;

    Paneles(String n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return n;
    }
}