package tools;

public record Ejercicio(
        Paneles panel,
        Colour dificultad
) {
    @Override
    public String toString() {
        return panel.toString();
    }
}
