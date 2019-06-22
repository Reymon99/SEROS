package gui.contenido;
import gui.simulador.Dato;
import tools.Archivos;
import static tools.Fuentes.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
public class Tree extends JTree {
    /**
     * JTree configurado al proyecto
     * @param node nodo raíz
     * @author Sergio Majé
     */
    public Tree(DefaultMutableTreeNode node){
        super(new DefaultTreeModel(node));
        ImageIcon icon = Archivos.image("/recourses/image/variable.png",-1,-1);
        setCellRenderer(new DefaultTreeCellRenderer(){
            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                JLabel label=new JLabel(value.toString(),icon,LEFT);
                label.setFont(UBUNTULIGHT14.getFont());
                return label;
            }
        });
        setOpaque(false);
    }
    /**
     * Obtiene un nodo hijo en una determinada posición
     * @param index posición del nodo
     * @return dato del nodo
     * @author Sergio Majé
     */
    public Dato getDato(int index){
        return ((Dato)((DefaultMutableTreeNode)getModel().getChild(getModel().getRoot(), index)).getUserObject());
    }
}