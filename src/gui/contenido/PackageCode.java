package gui.contenido;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTabbedPane;

public class PackageCode extends JTabbedPane {
    private String packageName;

    /**
     * Organiza los diferentes {@link gui.editor.Editor}es de código utilizados en un simulador, </br>
     * Además de exportar los códigos empleados como un paquete Java
     */
    public PackageCode() {
        super(JTabbedPane.TOP);
        setComponentPopupMenu(menu());
    }

    /**
     * Opciones dadas para exportar el paquete de códigos
     * @return menu visual de las opciones dadas
     */
    private JPopupMenu menu() {
        JPopupMenu menu = new JPopupMenu();
        JMenuItem export = new JMenuItem("Exportar paquete de códigos");
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