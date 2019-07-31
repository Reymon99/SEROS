package gui.simulador.lienzos;
import gui.simulador.Simulador;
import tools.Fuentes;
import java.awt.*;
import java.awt.geom.Line2D;
public class Graficador extends Canvas {
    private boolean graficar;
    private int x;
    private int y;
    /**
     * Grafica un punto en una coordenada dada
     */
    public Graficador(){
        setPreferredSize(Simulador.canvasSize);
        setMaximumSize(Simulador.canvasSize);
        setMinimumSize(Simulador.canvasSize);
        setFont(Fuentes.UBUNTULIGHT12.getFont());
        graficar=false;
        x=y=0;
    }
    /**
     * Grafica un punto con las coordenadas dadas
     * @param x int coordenada en x
     * @param y int coordenada en y
     */
    public void graficar(int x,int y){
        this.x=x;
        this.y=y;
        graficar=true;
        repaint();
    }
    /**
     * Coordenadas dadas del punto
     * @return coordenadas formateadas
     */
    public String coordenadas(){
        return "("+this.x+","+this.y+")";
    }
    /**
     * Limpia la grafica de las coordenadas que han sido graficadas
     */
    public void limpiar(){
        x=y=0;
        graficar=false;
        repaint();
    }
    /**
     * Estado de graficación
     * @return true: existe grafica | false: no existe grafica
     */
    public boolean isGraficar() {
        return graficar;
    }
    /**
     * Modifica el estado de graficación
     * @param graficar boolean
     */
    public void setGraficar(boolean graficar) {
        this.graficar = graficar;
    }
    /**
     * Divide el ancho de la dimensión del Canvas
     * @return mitad del ancho del Canvas
     */
    private int halfScreenWidth(){
        return Simulador.canvasSize.width/2;
    }
    /**
     * Divide el alto de la dimensión del Canvas
     * @return mitad del alto del Canvas
     */
    private int halfScreenHeight(){
        return Simulador.canvasSize.height/2;
    }
    /**
     * Inicio o fin de la linea X
     * @param cuadrante true: + | false: -
     */
    private int positionX(boolean cuadrante){
        return cuadrante ? halfScreenWidth()+280 : halfScreenWidth()-280;
    }
    /**
     * Inicio o fin de la linea Y
     * @param cuadrante true: + | false: -
     */
    private int positionY(boolean cuadrante){
        return cuadrante ? halfScreenHeight()-280 : halfScreenHeight()+280;
    }
    /**
     * Grafica las coordenadas dadas según el estado de graficación
     * @param g2 pincel
     * @param point punto de graficación de coordenadas
     */
    private void graficarCoordenada(Graphics2D g2, Point point){
        if (graficar){
            if (this.x>0 && this.y>0) g2.drawString(coordenadas(),point.x+7,point.y);//Cuandrante positivo
            else if (this.x<0 && this.y>0) g2.drawString(coordenadas(),point.x-22,point.y-7);//Cuadrante negativo - positivo
            else if (this.x<0 && this.y<0) g2.drawString(coordenadas(),point.x-22,point.y+17);//Cuadrante negativo
            else if (this.x>0 && this.y<0) g2.drawString(coordenadas(),point.x-17,point.y+17);//Cuadrante positivo - negativo
            else if (this.x==0 && this.y==0) g2.drawString(coordenadas(),point.x-29,point.y-9);//Punto medio
            else if (this.x==0) g2.drawString(coordenadas(),point.x-45,point.y-2);
            else g2.drawString(coordenadas(),point.x-17,point.y+19);//y==0
            g2.setPaint(Color.GRAY);//lineas
            g2.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,5.0f,new float[]{10},0.0f));
            g2.draw(new Line2D.Double(halfScreenWidth(),point.y,point.x,point.y));
            g2.draw(new Line2D.Double(point.x,halfScreenHeight(),point.x,point.y));
            g2.setFont(Fuentes.DIALOG35.getFont());
            g2.setPaint(Color.RED);//punto
            g2.drawString(".",point.x-5,point.y+4);
        }
    }
    /**
     * Grafica las líneas de eje X y Y
     * @param g2 pincel
     */
    private void eje(Graphics2D g2) {
        g2.draw(new Line2D.Double(positionX(false), halfScreenHeight(), positionX(true), halfScreenHeight()));//horizontal
        g2.draw(new Line2D.Double(halfScreenWidth(), positionY(true), halfScreenWidth(), positionY(false)));//vertical
    }
    /**
     * Guarda la posición en pantalla de la coordenada X
     * @param point Si x = 0 toma la mitad de la pantalla de lo contrario tomará la coodernada de j
     * @param x valor Axis X
     * @param j posición en pantalla
     */
    private void puntoCoordenadaX(Point point,int x,int j){
        if (this.x==x && graficar) point.x = this.x==0 ? halfScreenWidth() : j;
    }
    /**
     * Guarda la posición en pantalla de la coordenada Y
     * @param point Si y = 0 toma la mitad de la pantalla de lo contrario tomará la coodernada de i
     * @param y valor Axis Y
     * @param i posición en pantalla
     */
    private void puntoCoordenadaY(Point point,int y,int i){
        if (this.y==y && graficar) point.y = this.y==0 ? halfScreenHeight() : i;
    }
    /**
     * Guarda la posición en pantalla de las coordenadas X y Y
     * @param point puntos de las posiciones a guardar
     * @param x valor Axis X
     * @param y valor Axis Y
     * @param i posición en pantalla vertical
     * @param j posición en pantalla horizontal
     */
    private void puntoCoordenadas(Point point,int x,int y,int i,int j){
        puntoCoordenadaX(point, x, j);
        puntoCoordenadaY(point, y, i);
    }
    /**
     * Grafica los valores del axis X y el axis Y
     * @param g2 pincel
     * @param point punto a guardar las coordenas
     */
    private void valoresAxisXY(Graphics2D g2, Point point){
        int x = -10;
        int y = 10;
        int i = positionY(true)+y;
        int j = positionX(false)+y;
        while (i <= positionY(false)){
            puntoCoordenadas(point,x,y,i,j);
            if (i!=290 && j!=halfScreenWidth()){
                g2.draw(new Line2D.Double(halfScreenWidth()-2,i,halfScreenWidth()+2,i));//y
                g2.draw(new Line2D.Double(j,halfScreenHeight()-2,j,halfScreenHeight()+2));//x
                if (x==0 && y==0) puntoCoordenadas(point,x=1,y=-1,i,j);
                g2.drawString(String.valueOf(y),x<0 ? halfScreenWidth()+5 : Math.abs(x)==10 ? halfScreenWidth()-22 : halfScreenWidth()-16,i+4);//y
                g2.drawString(String.valueOf(x),x>0 ? j-4 : j-8,x>0 ? halfScreenHeight()-6 : halfScreenHeight()+15);//x
                x++;
                y--;
            }
            i+=27;
            j+=27;
        }
    }
    /**
     * Dibuja y grafica el punto en las coordenadas dadas
     * @param g {@link Graphics}
     */
    @Override
    public void paint(Graphics g) {
        Graphics2D g2=(Graphics2D)g;
        Point point=new Point();
        eje(g2);
        valoresAxisXY(g2,point);
        graficarCoordenada(g2,point);
    }
}