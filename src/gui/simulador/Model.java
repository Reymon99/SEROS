package gui.simulador;
import javax.swing.table.DefaultTableModel;
public class Model extends DefaultTableModel {
    /**
     * Modelo de tabla por defecto con parametros predefinidos enfocados hacia el proyecto
     * @author Sergio Majé
     */
    public Model(){
        super();
    }
    /**
     * Se bloquea la edición de todas las celdas de la tabla
     * @return bloqueo de edición de las celdas
     * @author Sergio Majé
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}