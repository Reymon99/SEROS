package tools;
import java.awt.*;
public abstract class Constrains {
    /**
     * Añade y distribuye el componente dentro del eje X y Y de la interfaz gráfica
     * @param component {@link Component} a añadir dentro del {@link Container}
     * @param container {@link Container} al cual se añadirá el {@link Component}
     * @param x posición en x
     * @param y posición en y
     * @param width anchor entre los espacios del grid
     * @param height altura entre los espacios del grid
     * @param weightx dispersión al eje X
     * @param weighty dispersión al eje Y
     * @param insets margen del componente
     * @param place ubicación dentro del espacio del grid
     * @param stretch llenado dentro del espacio del grid
     */
    public static void addComp(Component component,Container container,int x,int y,int width,int height,double weightx,double weighty,Insets insets,int place,int stretch){
        GridBagConstraints grid=grid(x, y, width, height, insets, place, stretch);
        grid.weightx=weightx;
        grid.weighty=weighty;
        container.add(component,grid);
    }
    /**
     * Añade y distribuye el componente dentro del eje X de la interfaz gráfica
     * @param component {@link Component} a añadir dentro del {@link Container}
     * @param container {@link Container} al cual se añadirá el {@link Component}
     * @param x posición en x
     * @param y posición en y
     * @param width anchor entre los espacios del grid
     * @param height altura entre los espacios del grid
     * @param weightx dispersión al eje X
     * @param insets margen del componente
     * @param place ubicación dentro del espacio del grid
     * @param stretch llenado dentro del espacio del grid
     */
    public static void addCompX(Component component,Container container,int x,int y,int width,int height,double weightx,Insets insets,int place,int stretch){
        GridBagConstraints grid=grid(x, y, width, height, insets, place, stretch);
        grid.weightx=weightx;
        container.add(component,grid);
    }
    /**
     * Añade y distribuye el componente dentro del eje Y de la interfaz gráfica
     * @param component {@link Component} a añadir dentro del {@link Container}
     * @param container {@link Container} al cual se añadirá el {@link Component}
     * @param x posición en x
     * @param y posición en y
     * @param width anchor entre los espacios del grid
     * @param height altura entre los espacios del grid
     * @param weighty dispersión al eje Y
     * @param insets margen del componente
     * @param place ubicación dentro del espacio del grid
     * @param stretch llenado dentro del espacio del grid
     */
    public static void addCompY(Component component,Container container,int x,int y,int width,int height, double weighty,Insets insets,int place,int stretch){
        GridBagConstraints grid=grid(x, y, width, height, insets, place, stretch);
        grid.weighty=weighty;
        container.add(component,grid);
    }
    /**
     * Añade y distribuye el componente dentro del eje X y Y de la interfaz gráfica con un tamaño fijo hacia el eje X y Y
     * @param component {@link Component} a añadir dentro del {@link Container}
     * @param container {@link Container} al cual se añadirá el {@link Component}
     * @param x posición en x
     * @param y posición en y
     * @param width anchor entre los espacios del grid
     * @param height altura entre los espacios del grid
     * @param weightx dispersión al eje X
     * @param weighty dispersión al eje Y
     * @param insets margen del componente
     * @param ipadx tamaño fijo hacia el eje X
     * @param ipady tamaño fijo hacia el eje Y
     * @param place ubicación dentro del espacio del grid
     * @param stretch llenado dentro del espacio del grid
     */
    public static void addCompI(Component component,Container container,int x,int y,int width,int height,double weightx,double weighty,Insets insets,int ipadx,int ipady,int place,int stretch){
        GridBagConstraints grid=grid(x, y, width, height, insets, place, stretch);
        grid.weightx=weightx;
        grid.weighty=weighty;
        grid.ipadx=ipadx;
        grid.ipady=ipady;
        container.add(component,grid);
    }
    /**
     * Añade y distribuye el componente dentro del eje X y Y de la interfaz gráfica con un tamaño fijo hacia el eje X
     * @param component {@link Component} a añadir dentro del {@link Container}
     * @param container {@link Container} al cual se añadirá el {@link Component}
     * @param x posición en x
     * @param y posición en y
     * @param width anchor entre los espacios del grid
     * @param height altura entre los espacios del grid
     * @param weightx dispersión al eje X
     * @param weighty dispersión al eje Y
     * @param insets margen del componente
     * @param ipadx tamaño fijo hacia el eje X
     * @param place ubicación dentro del espacio del grid
     * @param stretch llenado dentro del espacio del grid
     */
    public static void addCompIx(Component component,Container container,int x,int y,int width,int height,double weightx,double weighty,Insets insets,int ipadx,int place,int stretch){
        GridBagConstraints grid=grid(x, y, width, height, insets, place, stretch);
        grid.weightx=weightx;
        grid.weighty=weighty;
        grid.ipadx=ipadx;
        container.add(component,grid);
    }
    /**
     * Añade y distribuye el componente dentro del eje X y Y de la interfaz gráfica con un tamaño fijo hacia el eje Y
     * @param component {@link Component} a añadir dentro del {@link Container}
     * @param container {@link Container} al cual se añadirá el {@link Component}
     * @param x posición en x
     * @param y posición en y
     * @param width anchor entre los espacios del grid
     * @param height altura entre los espacios del grid
     * @param weightx dispersión al eje X
     * @param weighty dispersión al eje Y
     * @param insets margen del componente
     * @param ipady tamaño fijo hacia el eje Y
     * @param place ubicación dentro del espacio del grid
     * @param stretch llenado dentro del espacio del grid
     */
    public static void addCompIy(Component component,Container container,int x,int y,int width,int height,double weightx,double weighty,Insets insets,int ipady,int place,int stretch){
        GridBagConstraints grid=grid(x, y, width, height, insets, place, stretch);
        grid.weightx=weightx;
        grid.weighty=weighty;
        grid.ipady=ipady;
        container.add(component,grid);
    }
    /**
     * Añade y distribuye el componente dentro del eje X de la interfaz gráfica con un tamaño fijo hacia el eje X
     * @param component {@link Component} a añadir dentro del {@link Container}
     * @param container {@link Container} al cual se añadirá el {@link Component}
     * @param x posición en x
     * @param y posición en y
     * @param width anchor entre los espacios del grid
     * @param height altura entre los espacios del grid
     * @param weightx dispersión al eje X
     * @param insets margen del componente
     * @param ipadx tamaño fijo hacia el eje X
     * @param place ubicación dentro del espacio del grid
     * @param stretch llenado dentro del espacio del grid
     */
    public static void addCompXIx(Component component,Container container,int x,int y,int width,int height,double weightx,Insets insets,int ipadx,int place,int stretch){
        GridBagConstraints grid=grid(x, y, width, height, insets, place, stretch);
        grid.weightx=weightx;
        grid.ipadx=ipadx;
        container.add(component,grid);
    }
    /**
     * Añade y distribuye el componente dentro del eje X de la interfaz gráfica con un tamaño fijo hacia el eje Y
     * @param component {@link Component} a añadir dentro del {@link Container}
     * @param container {@link Container} al cual se añadirá el {@link Component}
     * @param x posición en x
     * @param y posición en y
     * @param width anchor entre los espacios del grid
     * @param height altura entre los espacios del grid
     * @param weightx dispersión al eje X
     * @param insets margen del componente
     * @param ipady tamaño fijo hacia el eje Y
     * @param place ubicación dentro del espacio del grid
     * @param stretch llenado dentro del espacio del grid
     */
    public static void addCompXIy(Component component,Container container,int x,int y,int width,int height,double weightx,Insets insets,int ipady,int place,int stretch){
        GridBagConstraints grid=grid(x, y, width, height, insets, place, stretch);
        grid.weightx=weightx;
        grid.ipady=ipady;
        container.add(component,grid);
    }
    /**
     * Añade y distribuye el componente dentro del eje Y de la interfaz gráfica con un tamaño fijo hacia el eje X
     * @param component {@link Component} a añadir dentro del {@link Container}
     * @param container {@link Container} al cual se añadirá el {@link Component}
     * @param x posición en x
     * @param y posición en y
     * @param width anchor entre los espacios del grid
     * @param height altura entre los espacios del grid
     * @param weighty dispersión al eje Y
     * @param insets margen del componente
     * @param ipadx tamaño fijo hacia el eje X
     * @param place ubicación dentro del espacio del grid
     * @param stretch llenado dentro del espacio del grid
     */
    public static void addCompYIx(Component component,Container container,int x,int y,int width,int height,double weighty,Insets insets,int ipadx,int place,int stretch){
        GridBagConstraints grid=grid(x, y, width, height, insets, place, stretch);
        grid.weightx=weighty;
        grid.ipadx=ipadx;
        container.add(component,grid);
    }
    /**
     * Añade y distribuye el componente dentro del eje Y de la interfaz gráfica con un tamaño fijo hacia el eje Y
     * @param component {@link Component} a añadir dentro del {@link Container}
     * @param container {@link Container} al cual se añadirá el {@link Component}
     * @param x posición en x
     * @param y posición en y
     * @param width anchor entre los espacios del grid
     * @param height altura entre los espacios del grid
     * @param weighty dispersión al eje Y
     * @param insets margen del componente
     * @param ipady tamaño fijo hacia el eje Y
     * @param place ubicación dentro del espacio del grid
     * @param stretch llenado dentro del espacio del grid
     */
    public static void addCompYIy(Component component,Container container,int x,int y,int width,int height,double weighty,Insets insets,int ipady,int place,int stretch){
        GridBagConstraints grid=grid(x, y, width, height, insets, place, stretch);
        grid.weighty=weighty;
        grid.ipady=ipady;
        container.add(component,grid);
    }
    /**
     * Distribución por defecto del grid
     * @param x posición en x
     * @param y posición en y
     * @param width anchor entre los espacios del grid
     * @param height altura entre los espacios del grid
     * @param insets margen dentro del espacio del grid
     * @param place ubicación dentro del espacio del grid
     * @param stretch llenado dentro del espacio del grid
     * @return grid configurado por defecto
     */
    private static GridBagConstraints grid(int x, int y, int width, int height, Insets insets, int place, int stretch){
        GridBagConstraints grid = new GridBagConstraints();
        grid.gridx=x;
        grid.gridy=y;
        grid.gridwidth=width;
        grid.gridheight=height;
        grid.insets=insets;
        grid.anchor=place;
        grid.fill=stretch;
        return grid;
    }
}