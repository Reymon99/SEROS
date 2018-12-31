package logica;
import javax.swing.*;
import java.awt.*;
public abstract class Constrains {
    /**
     * Añade y distribuye el componente hacia eje x de la interfaz grafica
     * @param component {@link JComponent}
     * @param container {@link Container}
     * @param x int
     * @param y int
     * @param width int
     * @param height int
     * @param weightx double
     * @param top int
     * @param left int
     * @param bottom int
     * @param right int
     * @param place int
     * @param stretch int
     */
    public static void addCompX(JComponent component,Container container, int x, int y, int width, int height, double weightx, int top, int left, int bottom, int right, int place, int stretch){
        GridBagConstraints grid=new GridBagConstraints();
        grid.gridx=x;
        grid.gridy=y;
        grid.gridwidth=width;
        grid.gridheight=height;
        grid.weightx=weightx;
        grid.insets=new Insets(top,left,bottom,right);
        grid.anchor=place;
        grid.fill=stretch;
        container.add(component,grid);
    }
    /**
     * Añade y distribuye el componente hacia eje Y de la interfaz grafica
     * @param component {@link JComponent}
     * @param container {@link Container}
     * @param x int
     * @param y int
     * @param width int
     * @param height int
     * @param weighty double
     * @param top int
     * @param left int
     * @param bottom int
     * @param right int
     * @param place int
     * @param stretch int
     */
    public static void addCompY(JComponent component,Container container,int x,int y,int width,int height,double weighty,int top,int left,int bottom,int right,int place,int stretch){
        GridBagConstraints grid=new GridBagConstraints();
        grid.gridx=x;
        grid.gridy=y;
        grid.gridwidth=width;
        grid.gridheight=height;
        grid.weighty=weighty;
        grid.insets=new Insets(top,left,bottom,right);
        grid.anchor=place;
        grid.fill=stretch;
        container.add(component,grid);
    }
    /**
     * Añade y distribuye el componente hacia eje X y Y de la interfaz grafica
     * @param component {@link JComponent}
     * @param container {@link Container}
     * @param x int
     * @param y int
     * @param width int
     * @param height int
     * @param weightx double
     * @param weighty double
     * @param top int
     * @param left int
     * @param bottom int
     * @param right int
     * @param place int
     * @param stretch int
     */
    public static void addComp(JComponent component,Container container,int x,int y,int width,int height,double weightx,double weighty,int top,int left,int bottom,int right,int place,int stretch){
        GridBagConstraints grid=new GridBagConstraints();
        grid.gridx=x;
        grid.gridy=y;
        grid.gridwidth=width;
        grid.gridheight=height;
        grid.weightx=weightx;
        grid.weighty=weighty;
        grid.insets=new Insets(top,left,bottom,right);
        grid.anchor=place;
        grid.fill=stretch;
        container.add(component,grid);
    }
    /**
     * Añade y distribuye el componente hacia eje X y Y de la interfaz grafica con un tamaño fijado hacia el eje X
     * @param component {@link JComponent}
     * @param container {@link Container}
     * @param x int
     * @param y int
     * @param width int
     * @param height int
     * @param weightx double
     * @param weighty double
     * @param top int
     * @param left int
     * @param bottom int
     * @param right int
     * @param ipadx int
     * @param place int
     * @param stretch int
     */
    public static void addCompIx(JComponent component,Container container,int x,int y,int width,int height,double weightx,double weighty,int top,int left,int bottom,int right,int ipadx,int place,int stretch) {
        GridBagConstraints grid=new GridBagConstraints();
        grid.gridx=x;
        grid.gridy=y;
        grid.gridwidth=width;
        grid.gridheight=height;
        grid.weightx=weightx;
        grid.weighty=weighty;
        grid.insets=new Insets(top,left,bottom,right);
        grid.ipadx=ipadx;
        grid.anchor=place;
        grid.fill=stretch;
        container.add(component,grid);
    }
    /**
     * Añade y distribuye el componente hacia eje X y Y de la interfaz grafica con un tamaño fijado hacia el eje Y
     * @param component {@link JComponent}
     * @param container {@link Container}
     * @param x int
     * @param y int
     * @param width int
     * @param height int
     * @param weightx double
     * @param weighty double
     * @param top int
     * @param left int
     * @param bottom int
     * @param right int
     * @param ipady int
     * @param place int
     * @param stretch int
     */
    public static void addCompIy(JComponent component,Container container,int x,int y,int width,int height,double weightx,double weighty,int top,int left,int bottom,int right,int ipady,int place,int stretch) {
        GridBagConstraints grid=new GridBagConstraints();
        grid.gridx=x;
        grid.gridy=y;
        grid.gridwidth=width;
        grid.gridheight=height;
        grid.weightx=weightx;
        grid.weighty=weighty;
        grid.insets=new Insets(top,left,bottom,right);
        grid.ipady=ipady;
        grid.anchor=place;
        grid.fill=stretch;
        container.add(component,grid);
    }
    /**
     * Añade y distribuye el componente hacia eje X de la interfaz grafica con un tamaño fijado hacia el eje X
     * @param component {@link JComponent}
     * @param container {@link Container}
     * @param x int
     * @param y int
     * @param width int
     * @param height int
     * @param weightx double
     * @param top int
     * @param left int
     * @param bottom int
     * @param right int
     * @param ipadx int
     * @param place int
     * @param stretch int
     */
    public static void addCompXIx(JComponent component,Container container,int x,int y,int width,int height,double weightx,int top,int left,int bottom,int right,int ipadx,int place,int stretch) {
        GridBagConstraints grid=new GridBagConstraints();
        grid.gridx=x;
        grid.gridy=y;
        grid.gridwidth=width;
        grid.gridheight=height;
        grid.weightx=weightx;
        grid.insets=new Insets(top,left,bottom,right);
        grid.ipadx=ipadx;
        grid.anchor=place;
        grid.fill=stretch;
        container.add(component,grid);
    }
    /**
     * Añade y distribuye el componente hacia eje X de la interfaz grafica con un tamaño fijado hacia el eje Y
     * @param component {@link JComponent}
     * @param container {@link Container}
     * @param x int
     * @param y int
     * @param width int
     * @param height int
     * @param weightx double
     * @param top int
     * @param left int
     * @param bottom int
     * @param right int
     * @param ipady int
     * @param place int
     * @param street int
     */
    public static void addCompXIy(JComponent component,Container container,int x,int y,int width,int height,double weightx,int top,int left,int bottom,int right,int ipady,int place,int street){
        GridBagConstraints grid=new GridBagConstraints();
        grid.gridx=x;
        grid.gridy=y;
        grid.gridwidth=width;
        grid.gridheight=height;
        grid.weightx=weightx;
        grid.insets=new Insets(top,left,bottom,right);
        grid.ipady=ipady;
        grid.anchor=place;
        grid.fill=street;
        container.add(component,grid);
    }
    /**
     * Añade y distribuye el componente hacia eje X y X de la interfaz grafica con un tamaño fijado hacia el eje X y Y
     * @param component {@link JComponent}
     * @param container {@link Container}
     * @param x int
     * @param y int
     * @param width int
     * @param height int
     * @param weightx double
     * @param weighty double
     * @param top int
     * @param left int
     * @param bottom int
     * @param right int
     * @param ipadx int
     * @param ipady int
     * @param place int
     * @param street int
     */
    public static void addCompI(JComponent component,Container container,int x,int y, int width,int height,double weightx,double weighty,int top,int left,int bottom,int right,int ipadx,int ipady,int place,int street){
        GridBagConstraints grid=new GridBagConstraints();
        grid.gridx=x;
        grid.gridy=y;
        grid.gridwidth=width;
        grid.gridheight=height;
        grid.weightx=weightx;
        grid.weighty=weighty;
        grid.insets=new Insets(top,left,bottom,right);
        grid.ipadx=ipadx;
        grid.ipady=ipady;
        grid.anchor=place;
        grid.fill=street;
        container.add(component,grid);
    }
    /**
     * Añade y distribuye el componente hacia eje X y Y de la interfaz grafica
     * @param component {@link Component}
     * @param container {@link Container}
     * @param x int
     * @param y int
     * @param width int
     * @param height int
     * @param weightx double
     * @param weighty double
     * @param top int
     * @param left int
     * @param bottom int
     * @param right int
     * @param place int
     * @param stretch int
     */
    public static void addComp(Component component,Container container,int x,int y,int width,int height,double weightx,double weighty,int top,int left,int bottom,int right,int place,int stretch){
        GridBagConstraints grid=new GridBagConstraints();
        grid.gridx=x;
        grid.gridy=y;
        grid.gridwidth=width;
        grid.gridheight=height;
        grid.weightx=weightx;
        grid.weighty=weighty;
        grid.insets=new Insets(top,left,bottom,right);
        grid.anchor=place;
        grid.fill=stretch;
        container.add(component,grid);
    }
}