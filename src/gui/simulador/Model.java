package gui.simulador;
import javax.swing.table.DefaultTableModel;
public class Model extends DefaultTableModel {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}