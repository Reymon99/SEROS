package gui.contenido;
import tools.Archivos;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
public class Tree extends JTree {
    /**
     * JTree configurado al proyecto
     * @param node nodo raíz
     * @author Sergio Majé
     */
    public Tree(DefaultMutableTreeNode node){
        super(new DefaultTreeModel(node));
        ImageIcon icon = Archivos.image("/recourses/image/variable.png",-1,-1);
        DefaultTreeCellRenderer renderer=new DefaultTreeCellRenderer();
        renderer.setOpenIcon(icon);
        renderer.setLeafIcon(icon);
        renderer.setClosedIcon(icon);
        setCellRenderer(renderer);
        setOpaque(false);
    }
}