package gui.paneles.tda;
import fuentes.Fuentes;
import java.awt.*;
import java.awt.geom.Line2D;
public class Graficador extends Canvas {
    private boolean graficar;
    protected int x,y;
    /**
     * Grafica un punto en una coordenada dada
     */
    public Graficador(){
        graficar=false;
        x=y=0;
        setMaximumSize(new Dimension(750,580));
        setMinimumSize(new Dimension(750,580));
        setPreferredSize(new Dimension(750,580));
    }
    /**
     * Grafica un punto con las coordenadas dadas
     * @param x int
     * @param y int
     */
    public void graficar(int x,int y){
        this.x=x;
        this.y=y;
        graficar=true;
        repaint();
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
     * Estado de graficacion
     * @return
     */
    public boolean isGraficar() {
        return graficar;
    }
    /**
     * Modifica el estado de graficacion
     * @param graficar boolean
     */
    public void setGraficar(boolean graficar) {
        this.graficar = graficar;
    }
    /**
     * Dibuja y grafica el punto en las coordenadas dadas
     * @param g {@link Graphics}
     */
    @Override
    public void paint(Graphics g) {
        Graphics2D g2=(Graphics2D)g;
        g2.draw(new Line2D.Double(95,290,655,290));
        g2.draw(new Line2D.Double(375,10,375,570));
        int x=-10,y=10;
        Point point=new Point();
        for (int i = 20,j = 105; i <= 570; i+=27, j+=27) {
            if (this.x==x && graficar) {
                point.x=(this.x==0)?375:j;
            }
            if (this.y==y && graficar) {
                point.y=(this.y==0)?290:i;
            }
            if (i!=290 && j!=375){
                g2.draw(new Line2D.Double(373,i,377,i));
                g2.draw(new Line2D.Double(j,288,j,292));
                if (x==0 && y==0) {
                    x = 1;
                    y = -1;
                    if (this.x==1) point.x=j;
                    if (this.y==-1) point.y=i;
                }
                g2.drawString(String.valueOf(y),383,i+4);
                g2.drawString(String.valueOf(x),j-4,282);
                x++;
                y--;
            }
        }
        if (graficar){
            if (this.x>0 && this.y>0) g2.drawString("("+this.x+","+this.y+")",point.x+7,point.y);
            else if (this.x<0 && this.y>0) g2.drawString("("+this.x+","+this.y+")",point.x-22,point.y-7);
            else if (this.x<0 && this.y<0) g2.drawString("("+this.x+","+this.y+")",point.x-22,point.y+17);
            else if (this.x>0 && this.y<0) g2.drawString("("+this.x+","+this.y+")",point.x-17,point.y+17);
            else if (this.x==0 && this.y==0) g2.drawString("("+this.x+","+this.y+")",point.x-35,point.y+22);
            else if (this.x==0) g2.drawString("("+this.x+","+this.y+")",point.x-45,point.y-2);
            else if (this.y==0) g2.drawString("("+this.x+","+this.y+")",point.x-17,point.y+19);
            g2.setFont(Fuentes.DIALOG30.getFont());
            g2.setPaint(Color.RED);
            g2.drawString(".",point.x-5,point.y+4);
            graficar=false;
            g2.setPaint(Color.gray);
            g2.setStroke(new BasicStroke(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_MITER,5.0f,new float[]{10},0.0f));
            g2.draw(new Line2D.Double(375,point.y,point.x,point.y));
            g2.draw(new Line2D.Double(point.x,290,point.x,point.y));
        }
    }
}