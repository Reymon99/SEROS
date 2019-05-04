package gui.paneles.tda;
import eventos.Eventos;
import gui.editor.Editor;
import gui.simulador.Simulador;
import tools.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
public class SimuladorTDA extends Simulador {
    /**
     * Simulador enfocado a explicar los TDA
     * @see Simulador#Simulador(Canvas)
     * @param canvas {@link Canvas}
     * @author Sergio Majé
     */
    public SimuladorTDA(Canvas canvas) {
        super(canvas);
        getTexto().setText(Text.SIMULADORTDA2.toString());
        JPanel panel=new JPanel(new BorderLayout()),panel1=new JPanel(new BorderLayout());
        Editor editorMain=new Editor(), editorPunto=new Editor();
        panel.add(editorMain,BorderLayout.WEST);
        panel.add(editorMain.scroll,BorderLayout.CENTER);
        panel.setPreferredSize(new Dimension(200,450));
        panel1.add(editorPunto,BorderLayout.WEST);
        panel1.add(editorPunto.scroll,BorderLayout.CENTER);
        panel1.setPreferredSize(new Dimension(200,450));
        try {
            editorMain.text(Archivos.codefiles("/recourses/codes/tda/MainPunto.txt"));
            editorPunto.text(Archivos.codefiles("/recourses/codes/tda/Punto.txt"));
        } catch (IOException e) {
            getTexto().setText(e.getMessage());
        }
        getBack().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(Paneles.TDA.toString());
            }
        });
        addCodes(new JScrollPane(panel));
        addCodes(new JScrollPane(panel1));
    }
}