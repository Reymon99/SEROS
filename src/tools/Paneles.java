package tools;

public enum Paneles {
    /**
     * Nombre de los paneles predefinidos
     */
    PRINCIPAL("Principal"),
    TDA("TDA"),
    MODULARIDAD("Modularidad", "Modularidad y Mapas"),
    RECURSIVIDAD("Recursividad"),
    ARREGLOS("Arreglos", "Arreglos y Arboles"),
    NODOS("Nodos"),
    ORDENAMIENTO("Ordenamiento"),
    BUSQUEDA("Busqueda"),
    PILAS("Pilas"),
    COLAS("Colas"),
    LISTAS("Listas Enlazadas", "Listas"),
    ARBOLES("Árboles", "Arreglos y Arboles"),
    GRAFOS("Grafos"),
    DEMOSTRACION_MODULARIDAD("Demostración Modularidad"),
    EJERCICIOS_RECURSIVIDAD("Ejercicios Recursividad"),
    SIMULADOR_TDA("Simulador TDA"),
    FACTORIAL("Simulador Factorial", "factorial"),
    POTENCIA("Simulador Potencia", "potencia");
    private final String n;
    private final String pathIcon;

    Paneles(String n, String pathIcon) {
        this.n = n;
        this.pathIcon = "/resources/image/" + pathIcon + ".png";
    }

    Paneles(String n) {
        this(n, n);
    }

    /**
     * Ruta del icono representativo del panel
     * @return ruta del icono
     */
    public String getPathIcon() {
        return pathIcon;
    }

    @Override
    public String toString() {
        return n;
    }
}