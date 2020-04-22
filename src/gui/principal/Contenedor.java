package gui.principal;

import org.constrains.Constrains;
import org.constrains.View;
import org.constrains.Weight;

import acciones.Contenidos;
import acciones.Eventos;
import gui.contenido.Components;
import gui.contenido.Contenido;
import gui.contenido.Demostracion;
import gui.contenido.Ejercicios;
import gui.contenido.Lienzo;
import gui.contenido.ModernButton;
import gui.contenido.TextPane;
import gui.editor.Editor;
import gui.simulador.simuladores.tda.Punto;
import gui.simulador.simuladores.recursividad.Factorial;
import gui.simulador.simuladores.recursividad.Potencia;
import tools.Archivos;
import tools.Colour;
import tools.Fuentes;
import tools.Paneles;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedHashMap;

public final class Contenedor extends JPanel {
    public static HashMap<Paneles, Lienzo> paneles;
    public static Paneles panelActivo;

    static {
        paneles = new HashMap<>();
        panelActivo = Paneles.PRINCIPAL;
    }

    /**
     * Contenedor de los paneles del proyecto
     */
    Contenedor() {
        setLayout(new CardLayout());
        init();
        Eventos.setPanel(this);
        Eventos.show(Contenedor.panelActivo);
        Eventos.destroyers();
    }

    /**
     * Se añaden los paneles secundarios al principal<br>
     * Se agrega el evento para circular entre los paneles
     * @see Eventos#setPanel(JPanel)
     * @see tools.Paneles
     */
    private void init() {
        paneles.put(Paneles.PRINCIPAL, principal());
        paneles.put(Paneles.TDA, tda());
        paneles.put(Paneles.SIMULADOR_TDA, simuladorTda());
        paneles.put(Paneles.MODULARIDAD, modularidad());
        paneles.put(Paneles.DEMOSTRACION_MODULARIDAD, demoModularidad());
        paneles.put(Paneles.RECURSIVIDAD, recursividad());
        paneles.put(Paneles.FACTORIAL, factorial());
        paneles.put(Paneles.POTENCIA, potencia());
        paneles.put(Paneles.EJERCICIOS_RECURSIVIDAD, ejerciciosRecursivos());
        paneles.put(Paneles.ARREGLOS, arreglos());
        paneles.put(Paneles.NODOS, nodos());
        paneles.put(Paneles.ORDENAMIENTO, ordenamiento());
        paneles.put(Paneles.BUSQUEDA, busqueda());
        paneles.put(Paneles.PILAS, pilas());
        paneles.put(Paneles.COLAS, colas());
        paneles.put(Paneles.LISTAS, listas());
        paneles.put(Paneles.ARBOLES, arboles());
        paneles.put(Paneles.GRAFOS, grafos());
        // Añadir los paneles secundarios al panel principal
        paneles.forEach((k, v) -> add(k.toString(), v));
    }

    /**
     * Menu principal de la interfaz gráfica del proyecto
     * @return panel principal de SEROS
     * @see Contenedor#itemsPrincipal()
     * @see Contenedor#infoPrincipal(Lienzo)
     */
    private Lienzo principal() {
        Lienzo lienzo = new Lienzo(new GridBagLayout(), true);
        Point pointCN = new Point(GridBagConstraints.CENTER, GridBagConstraints.NONE);
        Constrains.addComp(
                new View(itemsPrincipal(), lienzo),
                new Rectangle(0, 0, 1, 1),
                new Weight(1, 1),
                new Insets(5, 5, 5, 5),
                pointCN
        );
        Constrains.addComp(
                new View(infoPrincipal(lienzo), lienzo),
                new Rectangle(0, 1, 1, 1),
                new Weight(0, 0),
                new Insets(5, 10, 20, 10),
                pointCN
        );
        return lienzo;
    }

    /**
     * Contiene los ítems de cada uno de los contenidos que tiene SEROS
     * @return ítems organizados en una grilla
     * @see ModernButton#ModernButton(Paneles, Colour, Paneles...)
     */
    private JPanel itemsPrincipal() {
        JPanel items = new JPanel(new GridLayout(3, 4, 25, 20));
        items.setOpaque(false);
        items.add(new ModernButton(Paneles.TDA, Colour.FACIL, Paneles.SIMULADOR_TDA));
        items.add(new ModernButton(Paneles.MODULARIDAD, Colour.FACIL, Paneles.DEMOSTRACION_MODULARIDAD));
        items.add(new ModernButton(
                Paneles.RECURSIVIDAD, Colour.INTERMEDIO,  // Parametros
                Paneles.EJERCICIOS_RECURSIVIDAD, Paneles.FACTORIAL, Paneles.POTENCIA  // Opciones del menu
        ));
        items.add(new ModernButton(Paneles.ARREGLOS, Colour.FACIL));
        items.add(new ModernButton(Paneles.NODOS, Colour.INTERMEDIO));
        items.add(new ModernButton(Paneles.ORDENAMIENTO, Colour.FACIL));
        items.add(new ModernButton(Paneles.BUSQUEDA, Colour.FACIL));
        items.add(new ModernButton(Paneles.PILAS, Colour.INTERMEDIO));
        items.add(new ModernButton(Paneles.COLAS, Colour.INTERMEDIO));
        items.add(new ModernButton(Paneles.LISTAS, Colour.INTERMEDIO));
        items.add(new ModernButton(Paneles.ARBOLES, Colour.DIFICIL));
        items.add(new ModernButton(Paneles.GRAFOS, Colour.DIFICIL));
        return items;
    }

    /**
     * Contiene los ítems de información de SEROS
     * @param lienzo ventana sobre la cual se abrirá los {@link javax.swing.JDialog}
     * @return ítems de información organizados horizontalmente
     * @see Eventos#about(java.awt.Component)
     */
    private JPanel infoPrincipal(Lienzo lienzo) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 20));
        panel.setOpaque(false);
        panel.add(Components.getBoton("Buscar Ejercicios", "search", e -> Eventos.about(lienzo)));
        panel.add(Components.getBoton("Documentación Pseudocódigo", "pseudo", e -> Eventos.about(lienzo)));
        panel.add(Components.getBoton("Acerca de Seros", "about", e -> Eventos.about(lienzo)));
        return panel;
    }

    /**
     * Contenido del panel TDA
     * @see Contenido
     * @see Contenedor#simuladorTda()
     */
    private Contenido tda() {
        Contenido con = new Contenido();
        con.getTitle().setText("Tipos de Datos Abstratos (tda)");
        con.next("Simulador TDA", Paneles.SIMULADOR_TDA);
        LinkedHashMap<String, String> contenido = Contenidos.getContenidos("tda");
        JLabel formula = new JLabel(contenido.get("formula"), SwingConstants.CENTER);
        formula.setFont(Fuentes.PURISA_18.getFont());
        formula.setOpaque(false);
        Weight weight11 = new Weight(1, 1);
        Point placeNH = new Point(GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);
        Point placeCN = new Point(GridBagConstraints.CENTER, GridBagConstraints.NONE);
        Constrains.addComp(
                new View(Components.getTexto(contenido.get("parrafo.1")), con.getContenido()),
                new Rectangle(0, 0, 1, 1),
                weight11,
                new Insets(10, 25, 15, 12),
                placeNH
        );
        Constrains.addComp(
                new View(Editor.editor("Punto"), con.getContenido()),
                new Rectangle(0, 1, 1, 1),
                new Weight(0, 0),
                new Insets(5, 5, 5, 5),
                placeCN
        );
        Constrains.addComp(
                new View(Components.getTexto(contenido.get("parrafo.2")), con.getContenido()),
                new Rectangle(0, 2, 1, 1),
                weight11,
                new Insets(10, 25, 3, 12),
                placeNH
        );
        Constrains.addComp(
                new View(Components.getTexto(contenido.get("parrafo.3")), con.getContenido()),
                new Rectangle(0, 3, 1, 1),
                weight11,
                new Insets(3, 40, 3, 12),
                new Point(GridBagConstraints.NORTHEAST, GridBagConstraints.HORIZONTAL)
        );
        Constrains.addComp(
                new View(Components.getTexto(contenido.get("parrafo.4")), con.getContenido()),
                new Rectangle(0, 4, 1, 1),
                weight11,
                new Insets(5, 25, 5, 12),
                placeNH
        );
        Constrains.addComp(
                new View(formula, con.getContenido()),
                new Rectangle(0, 5, 1, 1),
                weight11,
                new Insets(10, 25, 5, 25),
                placeCN
        );
        return con;
    }

    /**
     * Contenido del panel Modularidad
     * @see Contenido
     */
    private Contenido modularidad() {
        Contenido con = new Contenido();
        con.getTitle().setText("Modularidad");
        con.next("Demostración Interactiva de Modularidad", Paneles.DEMOSTRACION_MODULARIDAD);
        LinkedHashMap<String, String> contenido = Contenidos.getContenidos("modularidad");
        Weight weight11 = new Weight(1, 1);
        Point placeNH = new Point(GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);
        Constrains.addComp(
                new View(Components.getTexto(contenido.get("parrafo.1")), con.getContenido()),
                new Rectangle(0, 0, 1, 1),
                weight11,
                new Insets(10, 25, 5, 12),
                placeNH
        );
        Constrains.addComp(
                new View(
                        new JLabel(Archivos.image("/resources/image/saluda.png", -1, 290)),
                        con.getContenido()
                ),
                new Rectangle(0, 1, 1, 1),
                weight11,
                new Insets(3, 7, 7, 7),
                new Point(GridBagConstraints.CENTER, GridBagConstraints.NONE)
        );
        Constrains.addComp(
                new View(Components.getTexto(contenido.get("parrafo.2")), con.getContenido()),
                new Rectangle(0, 2, 1, 1),
                weight11,
                new Insets(10, 25, 15, 12),
                placeNH
        );
        return con;
    }

    /**
     * Contenido del panel Pilas
     * @see Contenido
     */
    private Contenido pilas() {
        Contenido con = new Contenido();
        con.getTitle().setText("Pilas");
        con.next("", null);
        return con;
    }

    /**
     * Contenido del panel Recursividad
     * @see Contenido
     */
    private Contenido recursividad() {
        Contenido con = new Contenido();
        con.getTitle().setText("Recursividad");
        TextPane editor = new TextPane(false);
        LinkedHashMap<String, String> contenido = Contenidos.getContenidos("recursividad");
        String[] recur = contenido.get("parrafo.2").split("\u279c");
        for (String n : recur) {
            editor.append(n, Fuentes.PURISA_22.getFont());
            if (!n.equals(recur[recur.length - 1])) editor.append("\u279c", Fuentes.SEGOE_UI_SYMBOL_22.getFont());
        }
        con.next("Panel de Ejercicios de Recursividad", Paneles.EJERCICIOS_RECURSIVIDAD);
        Constrains.addComp(
                new View(Components.getTexto(contenido.get("parrafo.1")), con.getContenido()),
                new Rectangle(0, 0, 1, 1),
                new Weight(1, 1),
                new Insets(10, 25, 1, 12),
                new Point(GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL)
        );
        Constrains.addComp(
                new View(editor, con.getContenido()),
                new Rectangle(0, 1, 1, 1),
                new Weight(0.2, 1),
                new Insets(7, 25, 180, 25),
                new Point(GridBagConstraints.NORTH, GridBagConstraints.NONE)
        );
        return con;
    }

    /**
     * Contenido del panel Ordenamiento
     * @see Contenido
     */
    private Contenido ordenamiento() {
        Contenido con = new Contenido();
        con.getTitle().setText("Ordenamiento");
        con.next("", null);
        return con;
    }

    /**
     * Contenido del panel Nodos
     * @see Contenido
     */
    private Contenido nodos() {
        Contenido con = new Contenido();
        con.getTitle().setText("Nodos");
        con.next("", null);
        LinkedHashMap<String, String> contenido = Contenidos.getContenidos("nodos");
        Weight weight11 = new Weight(1, 1);
        Point placeNH = new Point(GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);
        Point placeCN = new Point(GridBagConstraints.CENTER, GridBagConstraints.NONE);
        Constrains.addComp(
                new View(Components.getTexto(contenido.get("parrafo.1")), con.getContenido()),
                new Rectangle(0, 0, 1, 1),
                weight11,
                new Insets(10, 25, 1, 12),
                placeNH
        );
        Constrains.addComp(
                new View(
                        new JLabel(Archivos.image("/resources/image/nodo.png", -1, 89)),
                        con.getContenido()
                ),
                new Rectangle(0, 1, 1, 1),
                weight11,
                new Insets(1, 3, 1, 3),
                placeCN
        );
        Constrains.addComp(
                new View(Components.getTexto(contenido.get("parrafo.2")), con.getContenido()),
                new Rectangle(0, 2, 1, 1),
                weight11,
                new Insets(5, 25, 15, 12),
                placeNH
        );
        Constrains.addComp(
                new View(
                        new JLabel(Archivos.image("/resources/image/memoria.png", -1, 150)),
                        con.getContenido()),
                new Rectangle(0, 3, 1, 1),
                weight11,
                new Insets(3, 3, 3, 3),
                placeCN
        );
        Constrains.addComp(
                new View(Components.getTexto(contenido.get("parrafo.3")), con.getContenido()),
                new Rectangle(0, 4, 1, 1),
                weight11,
                new Insets(10, 25, 5, 12),
                placeNH
        );
        Constrains.addComp(
                new View(
                        new JLabel(Archivos.image("/resources/image/mateo.png", -1, 450)),
                        con.getContenido()
                ),
                new Rectangle(0, 5, 1, 1),
                weight11,
                new Insets(10, 3, 10, 3),
                placeCN
        );
        return con;
    }

    /**
     * Contenido del panel Listas
     * @see Contenido
     */
    private Contenido listas() {
        Contenido con = new Contenido();
        con.getTitle().setText("Listas Enlazadas");
        con.next("", null);
        return con;
    }

    /**
     * Contenido del panel Grafos
     * @see Contenido
     */
    private Contenido grafos() {
        Contenido con = new Contenido();
        con.getTitle().setText("Grafos");
        con.next("", null);
        return con;
    }

    /**
     * Contenido del panel Colas
     * @see Contenido
     */
    private Contenido colas() {
        Contenido con = new Contenido();
        con.getTitle().setText("Colas");
        con.next("", null);
        return con;
    }

    /**
     * Contenido del panel Busqueda
     * @see Contenido
     */
    private Contenido busqueda() {
        Contenido con = new Contenido();
        con.getTitle().setText("Busqueda");
        con.next("", null);
        return con;
    }

    /**
     * Contenido del panel Arreglos
     * @see Contenido
     */
    private Contenido arreglos() {
        Contenido con = new Contenido();
        con.getTitle().setText("Arreglos");
        con.next("", null);
        LinkedHashMap<String, String> contenido = Contenidos.getContenidos("arreglos");
        Weight weight11 = new Weight(1, 1);
        Point placeNH = new Point(GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL);
        Point placeCN = new Point(GridBagConstraints.CENTER, GridBagConstraints.NONE);
        Constrains.addComp(
                new View(Components.getTexto(contenido.get("parrafo.1")), con.getContenido()),
                new Rectangle(0, 0, 1, 1),
                weight11,
                new Insets(10, 25, 8, 12),
                placeNH
        );
        Constrains.addComp(
                new View(
                        new JLabel(Archivos.image("/resources/image/arreglo.png", -1, 170)),
                        con.getContenido()
                ),
                new Rectangle(0, 1, 1, 1),
                weight11,
                new Insets(5, 5, 5, 5),
                placeCN
        );
        Constrains.addComp(
                new View(Components.getTexto(contenido.get("parrafo.2")), con.getContenido()),
                new Rectangle(0, 2, 1, 1),
                weight11,
                new Insets(8, 25, 8, 12),
                placeNH
        );
        Constrains.addComp(
                new View(
                        new JLabel(Archivos.image("/resources/image/arregloDatos.png", -1, 130)),
                        con.getContenido()
                ),
                new Rectangle(0, 3, 1, 1),
                weight11,
                new Insets(5, 5, 5, 5),
                placeCN
        );
        Constrains.addComp(
                new View(Components.getTexto(contenido.get("parrafo.3")), con.getContenido()),
                new Rectangle(0, 4, 1, 1),
                weight11,
                new Insets(8, 25, 10, 12),
                placeNH
        );
        return con;
    }

    /**
     * Contenido del panel Arboles
     * @see Contenido
     */
    private Contenido arboles() {
        Contenido con = new Contenido();
        con.getTitle().setText("Arboles");
        con.next("", null);
        return con;
    }

    /**
     * Ejercicios simulados de recursividad
     * @return panel de simuladores en recursividad
     * @see Ejercicios
     * @see Contenedor#recursividad()
     */
    private Ejercicios ejerciciosRecursivos() {
        Ejercicios ejercicios = new Ejercicios();
        ejercicios.back("Recursividad", Paneles.RECURSIVIDAD);
        MouseAdapter mouse = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Eventos.show(switch (((JLabel) e.getSource()).getText()) {
                    case "Factorial" -> Paneles.FACTORIAL;
                    case "Potencia" -> Paneles.POTENCIA;
                    default -> Contenedor.panelActivo;
                });
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                ejercicios.setTexto(switch (((JLabel) e.getSource()).getText()) {
                    case "Factorial" -> "Simulación recursiva para Factorial";
                    case "Potencia" -> "Simulación recursiva para Potencia";
                    default -> "";
                });
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ejercicios.getTexto().setText("");
            }
        };
        ejercicios.setBotones(
                Components.getBoton(Archivos.image("/resources/image/factorial.png", -1, -1), "Factorial", mouse),
                Components.getBoton(Archivos.image("/resources/image/potencia.png", -1, -1), "Potencia", mouse)
        );
        return ejercicios;
    }

    /**
     * Simulador para la temática TDA<br>
     * Simula un punto en el eje cartesiano
     * @return simulador de un punto en el plano cartesiano para TDA
     * @see Punto
     * @see Contenedor#tda()
     */
    private Punto simuladorTda() {
        JSpinner x = new JSpinner(new SpinnerNumberModel(0, -10, 10, 1));
        JSpinner y = new JSpinner(new SpinnerNumberModel(0, -10, 10, 1));
        ((JSpinner.NumberEditor) x.getEditor()).getTextField().setEditable(false);
        ((JSpinner.NumberEditor) y.getEditor()).getTextField().setEditable(false);
        return new Punto(x, y);
    }

    /**
     * Simulador para la temática Recursividad<br>
     * Simulador para el proceso recursivo del factorial
     * @return simulador factorial
     * @see Factorial
     * @see Contenedor#recursividad()
     */
    private Factorial factorial() {
        JSpinner valorDato = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        ((JSpinner.NumberEditor) valorDato.getEditor()).getTextField().setEditable(false);
        return new Factorial(valorDato);
    }

    /**
     * Simulador para la temática Recursividad<br>
     * Simulador para el proceso recursivo del potencia
     * @return simulador potencia
     * @see Potencia
     * @see Contenedor#recursividad()
     */
    private Potencia potencia() {
        JSpinner valorBase = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        JSpinner valorExponente = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        ((JSpinner.NumberEditor) valorBase.getEditor()).getTextField().setEditable(false);
        ((JSpinner.NumberEditor) valorExponente.getEditor()).getTextField().setEditable(false);
        return new Potencia(valorBase, valorExponente);
    }

    /**
     * Demostración utilizada en Modularidad
     * @return Demostración de Modularidad
     * @see Demostracion
     * @see Contenedor#modularidad()
     */
    private Demostracion demoModularidad() {
        Demostracion demostracion = new Demostracion("/resources/image/moduDemo1.png");
        demostracion.setTexto(Contenidos.getContenidos("modularidad").get("demostracion"));
        JButton demo1 = new JButton("Inventar");
        JButton demo2 = new JButton("Programar");
        JButton demo3 = new JButton("Leer");
        JButton demo4 = new JButton("Jugar");
        demo1.addActionListener(e -> demostracion.setIcon("/resources/image/moduDemo1.png"));
        demo2.addActionListener(e -> demostracion.setIcon("/resources/image/moduDemo2.png"));
        demo3.addActionListener(e -> demostracion.setIcon("/resources/image/moduDemo3.png"));
        demo4.addActionListener(e -> demostracion.setIcon("/resources/image/moduDemo4.png"));
        demostracion.setBotones(demo1, demo2, demo3, demo4);
        return demostracion;
    }
}