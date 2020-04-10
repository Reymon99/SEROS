package tools;

import java.awt.*;
import java.io.IOException;
import java.util.Optional;
import java.util.TreeMap;

public enum Fuentes {
    UBUNTU_LIGHT_12(Fonts.getFont("UbuntuLight", Font.PLAIN, 12)),
    UBUNTU_LIGHT_14(Fonts.getFont("UbuntuLight", Font.BOLD, 14)),
    UBUNTU_LIGHT_15(Fonts.getFont("UbuntuLight", Font.PLAIN, 15)),
    UBUNTU_LIGHT_50(Fonts.getFont("UbuntuLight", Font.BOLD, 50)),
    UBUNTU_LIGHT_20(Fonts.getFont("UbuntuLight", Font.PLAIN, 20)),
    UBUNTU_LIGHT_30(Fonts.getFont("UbuntuLight", Font.PLAIN, 30)),
    UBUNTU_LIGHT_B_30(Fonts.getFont("UbuntuLight", Font.BOLD, 30)),
    UBUNTU_LIGHT_40(Fonts.getFont("UbuntuLight", Font.PLAIN, 40)),
    UBUNTU_LIGHT_B_118(Fonts.getFont("UbuntuLight", Font.BOLD, 118)),
    PURISA_18(Fonts.getFont("Purisa-Bold", Font.PLAIN, 18)),
    PURISA_22(Fonts.getFont("Purisa-Bold", Font.PLAIN, 22)),
    DIALOG_35(new Font(Font.DIALOG, Font.BOLD, 35)),
    SEGOE_UI_SYMBOL_22(Fonts.getFont("Segoe UI Symbol", Font.PLAIN, 22)),
    UBUNTU_MONO_14(Fonts.getFont("UbuntuMono-R", Font.PLAIN, 14));
    private final Font font;

    Fuentes(Font font) {
        this.font = font;
    }

    /**
     * Fuentes de texto predefinidas para utilizar en el proyecto
     * @return {@link Font} deseada
     */
    public Font getFont() {
        return font;
    }

    /**
     * Crea fuentes tipográficas en el proyecto a partir de archivos tipográficos TrueTypeFont
     */
    private static class CreateFonts {
        /**
         * Fuente a ser creada
         */
        private final Font font;

        /**
         * Crea nuevas fuentes tipográficas en el proyecto,<br/>
         * y las registra en {@link GraphicsEnvironment#getLocalGraphicsEnvironment()},<br/>
         * para poder ser utilizada desde en el mismo proyecto
         * @param path ruta de la fuente a crear
         */
        protected CreateFonts(String path) {
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font = createFont(path));
        }

        /**
         * Crea la {@link Font} a partir del archivo tipográfico TrueTypeFont indicado.<br>
         * En el caso de no encontrar o no poder crear la fuente indicada, devolverá una fuente por definida de Java
         * @param path ruta de la tipografía TrueTypeFont
         * @return {@link Font} creada
         */
        private Font createFont(String path) {
            try {
                return Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(path));
            } catch (FontFormatException | IOException e) {
                return new Font(Font.MONOSPACED, Font.PLAIN, 10);
            }
        }

        /**
         * Obtiene la Fuente creada y la convierte a {@link Font} con el estilo y tamaño deseado
         * @param style estilo deseado según los indicados en {@link Font}
         *              <ul>
         *               <li>{@link Font#PLAIN}</li>
         *               <li>{@link Font#BOLD}</li>
         *               <li>{@link Font#ITALIC}</li>
         *               <li>La suma de cualquiera de las anteriores</li>
         *              </ul>
         * @param size  tamaño deseado de la fuente
         * @return {@link Font} con el estilo y tamaño deseado
         */
        protected Font getFont(int style, int size) {
            return font.deriveFont(style, size);
        }
    }

    /**
     * Registro de las fuentes tipográficas cargadas en el proyecto
     */
    public abstract static class Fonts {
        /**
         * Fuentes creadas y cargadas en el proyecto
         */
        private static TreeMap<String, CreateFonts> fonts;

        static {
            fonts = new TreeMap<>();
        }

        /**
         * Si la fuente indicada se encuentra cargada en el proyecto la devolverá con el estilo y tamaño deseado,
         * de lo contrario la creará y cargará en el proyecto para así poder devolverla con el estilo y tamaño deseado.
         * @param name  Fuente a utilizar
         * @param style estilo deseado
         * @param size  tamaño deseado
         * @return {@link Font} indicada con el estilo y tamaño deseados
         */
        protected static Font getFont(String name, int style, int size) {
            if (!fonts.containsKey(name)) fonts.put(name, new CreateFonts("/resources/fonts/" + name + ".ttf"));
            return fonts.get(name).getFont(style, size);
        }

        /**
         * Destruye todas las Fuentes tipográficas cargadas en el proyecto, para liberar memoria
         */
        public static void destroyFonts() {
            if (Optional.ofNullable(fonts).isPresent()) fonts = null;
        }
    }
}