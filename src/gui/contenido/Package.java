package gui.contenido;
import javax.swing.*;
public class Package extends JTabbedPane {
    private String packageName;
    /**
     * Organiza los diferentes {@link gui.editor.Editor}es de código utilizados en un simulador,</br>
     * Además de exportar los códigos empleados como un paquete Java
     * @param packageName nombre del paquete de los códigos
     */
    public Package(String packageName) {
        super();
        this.packageName = packageName;
        setComponentPopupMenu(menu());
    }
    /**
     * Opciones dadas para exportar el paquete de códigos
     * @return menu visual de las opciones dadas
     */
    private JPopupMenu menu(){
        JPopupMenu menu =  new JPopupMenu();
        JMenu export = new JMenu("Exportar paquete de códigos");
        menu.add(export);
        return menu;
    }
    /**
     * Nombre empleado del paquete de códigos
     * @return nombre del paquete
     */
    public String getPackageName() {
        return packageName;
    }
    /**
     * Da un nuevo nombre al paquete de códigos
     * @param packageName nombre del paquete
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}