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
     * Se bloquea la edicion de todas las celdas de la tabla
     * @param row
     * @param column
     * @return boolean
     * @author Sergio Majé
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}