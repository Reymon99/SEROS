package gui.editor;
import fuentes.Fuentes;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
public class Editor extends JPanel {
    private JTextPane editor;
    public JScrollPane scroll;
    public Editor(){
        setPreferredSize(new Dimension(30,30));
        setMinimumSize(new Dimension(30,30));
        setMaximumSize(new Dimension(30,30));
        setBackground(new Color(73, 72, 76));
        editor=new JTextPane(){
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                Editor.this.repaint();
            }
        };
        editor.setBackground(new Color(48,47,51));
        editor.setForeground(Color.WHITE);
        editor.setFont(Fuentes.UBUNTULIGHT15.getFont());
        //editor.setPreferredSize(new Dimension(300,300));
        //editor.setMaximumSize(new Dimension(150,300));
        editor.setEditable(false);
        editor.setMargin(new Insets(0,10,5,0));
        editor.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        scroll=new JScrollPane(editor);
        repaint();
    }
    public void append(Color color,String n){
        editor.setEditable(true);
        StyleContext sc=StyleContext.getDefaultStyleContext();
        AttributeSet set=sc.addAttribute(SimpleAttributeSet.EMPTY,StyleConstants.Foreground,color);
        editor.setCaretPosition(editor.getStyledDocument().getLength());
        editor.setCharacterAttributes(set,false);
        editor.replaceSelection(n);
        editor.setCaretPosition(editor.getStyledDocument().getLength());
        editor.setEditable(false);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D d=(Graphics2D)g;
        d.setPaint(Color.WHITE);
        int start=editor.viewToModel(scroll.getViewport().getViewPosition()),end=editor.viewToModel(new Point(scroll.getViewport().getViewPosition().x+editor.getWidth(),scroll.getViewport().getViewPosition().y+editor.getHeight())),startline=editor.getDocument().getDefaultRootElement().getElementIndex(start),endline=editor.getDocument().getDefaultRootElement().getElementIndex(end),fontHeight=g.getFontMetrics(editor.getFont()).getHeight(),line=startline;
        for (int y=0;line-1<=endline;y+=fontHeight,line++) d.drawString(String.valueOf(line),6,y);
    }
}