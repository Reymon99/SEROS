package gui.simulador.lienzos;

import gui.simulador.Simulador;
import tools.Fuentes;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Graficador extends JLabel {
    private boolean graficar;
    private final Point punto;
    private final Point axis;

    /**
     * Grafica un punto en una coordenada dada
     */
    public Graficador() {
        setFont(Fuentes.UBUNTU_LIGHT_12.getFont());
        graficar = false;
        punto = new Point();
        axis = new Point();
    }

    /**
     * Grafica un punto con las coordenadas dadas
     * @param x int coordenada en x
     * @param y int coordenada en y
     */
    public void graficar(int x, int y) {
        punto.move(x, y);
        graficar = true;
        repaint();
    }

    /**
     * Coordenadas dadas del punto
     * @return coordenadas formateadas
     */
    private String coordenadas() {
        return "(" + punto.x + "," + punto.y + ")";
    }

    /**
     * Limpia la grafica de las coordenadas que han sido graficadas
     */
    public void limpiar() {
        punto.move(0, 0);
        graficar = false;
        repaint();
    }

    /**
     * Divide el ancho de la dimensión del Canvas
     * @return mitad del ancho del Canvas
     */
    private int halfScreenWidth() {
        return Simulador.canvasSize().width / 2;
    }

    /**
     * Divide el alto de la dimensión del Canvas
     * @return mitad del alto del Canvas
     */
    private int halfScreenHeight() {
        return Simulador.canvasSize().height / 2;
    }

    /**
     * Inicio o fin de la linea X
     * @param cuadrante true: + | false: -
     */
    private int positionX(boolean cuadrante) {
        return cuadrante ? halfScreenWidth() + 280 : halfScreenWidth() - 280;
    }

    /**
     * Inicio o fin de la linea Y
     * @param cuadrante true: + | false: -
     */
    private int positionY(boolean cuadrante) {
        return cuadrante ? halfScreenHeight() - 280 : halfScreenHeight() + 280;
    }

    /**
     * Grafica las coordenadas dadas según el estado de graficación
     * @param g2    pincel
     * @param point punto de graficación de coordenadas
     */
    private void graficarCoordenada(Graphics2D g2, Point point) {
        if (graficar) {
            // cuadrante (x,y)
            Point pointAux = cuadrantes(point);
            g2.drawString(coordenadas(), pointAux.x, pointAux.y);
            // lineas
            g2.setPaint(Color.GRAY);
            g2.setStroke(new BasicStroke(
                    1,
                    BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER,
                    5.0f,
                    new float[]{10},
                    0.0f
            ));
            g2.draw(new Line2D.Double(halfScreenWidth(), point.y, point.x, point.y));
            g2.draw(new Line2D.Double(point.x, halfScreenHeight(), point.x, point.y));
            g2.setFont(Fuentes.DIALOG_35.getFont());
            // punto
            g2.setPaint(Color.RED);
            g2.drawString(".", point.x - 5, point.y + 4);
        }
    }

    /**
     * Establece las coordenadas de dibujo del (x, y), según el cuadrante donde se encuentre
     * @param point coordenadas (x, y) del punto
     * @return coordenadas de dibujo (x, y) según el cuadrante
     */
    private Point cuadrantes(Point point) {
        if (punto.x > 0 && punto.y > 0) return cuadrante(Cuadrante.POSITIVO, point);
        else if (punto.x < 0 && punto.y > 0) return cuadrante(Cuadrante.NEGATIVO_POSITIVO, point);
        else if (punto.x < 0 && punto.y < 0) return cuadrante(Cuadrante.NEGATIVO, point);
        else if (punto.x > 0 && punto.y < 0) return cuadrante(Cuadrante.POSITIVO_NEGATIVO, point);
        else if (punto.x == 0 && punto.y == 0) return cuadrante(Cuadrante.MEDIO, point);
        else if (punto.x == 0 && punto.y > 0) return cuadrante(Cuadrante.EJE_Y_POSITIVO, point);
        else if (punto.x == 0) return cuadrante(Cuadrante.EJE_Y_NEGATIVO, point);
        else if (punto.x > 0) return cuadrante(Cuadrante.EJE_X_POSITIVO, point);
        return cuadrante(Cuadrante.EJE_X_NEGATIVO, point);
    }

    /**
     * Establece el punto donde se escribirá el (x, y) según el cuadrante.
     * @param posicion posición del cuadrante a trabajar
     * @param point    punto actual (x, y)
     * @return punto (x, y)
     */
    private Point cuadrante(Cuadrante posicion, Point point) {
        int coordenadas = (getFontMetrics(getFont()).stringWidth(coordenadas()) + 4);
        int puntoMedio = coordenadas / 2;
        int ascent = getFontMetrics(getFont()).getAscent();
        int halfAscent = ascent / 2;
        return switch (posicion) {
            case POSITIVO -> new Point(point.x + 7, point.y);
            case NEGATIVO, EJE_X_POSITIVO, POSITIVO_NEGATIVO -> new Point(point.x - puntoMedio, point.y + ascent + 5);
            case NEGATIVO_POSITIVO, EJE_X_NEGATIVO -> new Point(point.x - puntoMedio, point.y - 7);
            case MEDIO -> new Point(point.x - coordenadas, point.y - ascent + 4);
            case EJE_Y_POSITIVO -> new Point(point.x - coordenadas - 3, point.y + halfAscent);
            case EJE_Y_NEGATIVO -> new Point(point.x + 7, point.y + halfAscent - 1);
        };
    }

    /**
     * Cuadrantes disponibles en el plano cartesiano
     */
    private enum Cuadrante {
        POSITIVO,
        NEGATIVO,
        POSITIVO_NEGATIVO,
        NEGATIVO_POSITIVO,
        MEDIO,
        EJE_X_POSITIVO,
        EJE_X_NEGATIVO,
        EJE_Y_POSITIVO,
        EJE_Y_NEGATIVO
    }

    /**
     * Grafica las líneas de eje (x, y)
     * @param g2 pincel
     */
    private void eje(Graphics2D g2) {
        // horizontal
        g2.draw(new Line2D.Double(
                positionX(false),
                halfScreenHeight(),
                positionX(true),
                halfScreenHeight()
        ));
        //vertical
        g2.draw(new Line2D.Double(
                halfScreenWidth(),
                positionY(true),
                halfScreenWidth(),
                positionY(false)
        ));
    }

    /**
     * Guarda la posición en pantalla de la coordenada X
     * @param point Si x = 0 toma la mitad de la pantalla de lo contrario tomará la coodernada de j
     * @param j     pixel X
     */
    private void puntoCoordenadaX(Point point, int j) {
        if (punto.x == axis.x && graficar) point.x = punto.x == 0 ? halfScreenWidth() : j;
    }

    /**
     * Guarda la posición en pantalla de la coordenada Y
     * @param point Si y = 0 toma la mitad de la pantalla de lo contrario tomará la coodernada de i
     * @param i     pixel X
     */
    private void puntoCoordenadaY(Point point, int i) {
        if (punto.y == axis.y && graficar) point.y = punto.y == 0 ? halfScreenHeight() : i;
    }

    /**
     * Guarda la posición en pantalla de las coordenadas (x, y)
     * @param point puntos de las posiciones a guardar
     * @param i     posición en pantalla vertical
     * @param j     posición en pantalla horizontal
     */
    private void puntoCoordenadas(Point point, int i, int j) {
        puntoCoordenadaX(point, j);
        puntoCoordenadaY(point, i);
    }

    /**
     * Grafica los valores del axis X y el axis Y
     * @param g2    pincel
     * @param point punto a guardar las coordenas
     */
    private void valoresAxisXY(Graphics2D g2, Point point) {
        axis.move(-10, 10);
        int i = positionY(true) + axis.y;
        int j = positionX(false) + axis.y;
        while (i <= positionY(false)) {
            // Coordenas en pixeles del punto a graficar
            puntoCoordenadas(point, i, j);
            // axis corelativo de (x,y)
            axisXY(g2, point, i, j);
            i += 27;
            j += 27;
        }
    }

    /**
     * Grafica la posición (x, y) indicada en el axis (x, y) del plano cartesiano
     * @param g2    pincel
     * @param point punto de coordenadas
     * @param i     pixel en Y
     * @param j     pixel en X
     */
    private void axisXY(Graphics2D g2, Point point, int i, int j) {
        if (i != 290 && j != halfScreenWidth()) {
            axis(g2, i, j);
            if (axis.x == 0 && axis.y == 0) axisZero(point, i, j);
            number(g2, i, j);
            axis.move(axis.x + 1, axis.y - 1);
        }
    }

    /**
     * Dibuja el número correspondiente en el axis (x, y)
     * @param g2 pincel
     * @param i  pixel en Y
     * @param j  pixel en X
     */
    private void number(Graphics2D g2, int i, int j) {
        g2.drawString(
                String.valueOf(axis.y),
                posicion(
                        axis.x < 0,
                        halfScreenWidth() + 5,
                        posicion(Math.abs(axis.x) == 10, halfScreenWidth() - 22, halfScreenWidth() - 16)
                ),
                i + 4
        );
        g2.drawString(
                String.valueOf(axis.x),
                posicion(axis.x > 0, j - 4, j - 8),
                posicion(axis.x > 0, halfScreenHeight() - 6, halfScreenHeight() + 15)
        );
    }

    /**
     * Posición doble a pocesionar
     * @param expr expresión de posecionamiento a evaluar
     * @param a    valor 'a' a retornar
     * @param b    valor 'b' a retornar
     * @return si la expresión es verdadera devolverá a 'a' de lo contrario devolverá a 'b'
     */
    private int posicion(boolean expr, int a, int b) {
        return expr ? a : b;
    }

    /**
     * Pinta el axis (x, y) en el plano cartesiano
     * @param g2 pincel
     * @param i  pixel en Y
     * @param j  pixel en X
     */
    private void axis(Graphics2D g2, int i, int j) {
        // y
        g2.draw(new Line2D.Double(halfScreenWidth() - 2, i, halfScreenWidth() + 2, i));
        // x
        g2.draw(new Line2D.Double(j, halfScreenHeight() - 2, j, halfScreenHeight() + 2));
    }

    /**
     * Cuando (x, y) equivalen cero se pasan al siguiente axis a dibujar
     * @param point punto de coordenadas
     * @param i     pixel en Y
     * @param j     pixel en X
     */
    private void axisZero(Point point, int i, int j) {
        axis.move(1, -1);
        puntoCoordenadas(point, i, j);
    }

    /**
     * Dibuja y grafica el punto en las coordenadas dadas
     * @param g {@link Graphics}
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Point point = new Point();
        eje(g2);
        valoresAxisXY(g2, point);
        graficarCoordenada(g2, point);
        g2.dispose();
    }
}