package gui.contenido;

import tools.Archivos;
import tools.Dato;
import tools.Fuentes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import java.awt.Component;

public class Tree extends JTree {
    private final DefaultMutableTreeNode node;

    /**
     * JTree configurado al proyecto
     * @param node nodo raíz
     */
    public Tree(DefaultMutableTreeNode node) {
        super(new DefaultTreeModel(node));
        this.node = node;
        ImageIcon icon = Archivos.image("/resources/image/variable.png", -1, -1);
        setCellRenderer(new DefaultTreeCellRenderer() {
            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
                                                          boolean leaf, int row, boolean hasFocus) {
                JLabel label = new JLabel(value.toString(), icon, LEFT);
                label.setFont(Fuentes.UBUNTU_LIGHT_14.getFont());
                return label;
            }
        });
        setOpaque(false);
    }

    /**
     * JTree configurado al proyecto
     * @param dato dato en el nodo raíz
     */
    public Tree(Dato dato) {
        this(new DefaultMutableTreeNode(dato));
    }

    /**
     * Obtiene un nodo hijo en una determinada posición
     * @param index posición del nodo
     * @return dato del nodo
     */
    public Dato getDato(int index) {
        return index == -1 ?
                (Dato) node.getUserObject() : (Dato) ((DefaultMutableTreeNode) node.getChildAt(index)).getUserObject();
    }

    /**
     * Añade nodos al nodo raíz
     * @param node {@link DefaultMutableTreeNode} a agregar
     */
    public void addNode(DefaultMutableTreeNode node) {
        this.node.add(node);
    }

    /**
     * Expande un nodo indicado del árbol
     * @param row fila en el que está el nodo a expandir
     */
    public void expandNode(int row) {
        fireTreeExpanded(getPathForRow(row));
    }
}