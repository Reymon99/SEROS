package acciones;

import tools.Archivos;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Optional;

public abstract class Contenidos {
    /**
     * Contiene cada uno de los pseudocódigos usados en el proyecto SEROS
     */
    private static LinkedHashMap<String, ArrayList<ArrayList<String>>> codes;
    /**
     * Contiene cada uno de los contenidos temáticos de las Estructuras de Datos empleados en el proyecto
     */
    private static LinkedHashMap<String, LinkedHashMap<String, String>> contenidos;
    /**
     * Contiene cada uno de los mensajes de tool tip de los componentes en el proyecto SEROS
     */
    private static LinkedHashMap<String, LinkedHashMap<String, String>> toolTips;

    /**
     * Carga el archivo .yml que contiene los diversos pseudocódigos del proyecto, en el caso de haber
     * sidos cargados con anterioridad, de lo contrario a esto solo retornará los pseudocódigos
     * preestablecidos y cargados con anterioridad
     * @return pseudocódigos del proyecto SEROS
     */
    public static LinkedHashMap<String, ArrayList<ArrayList<String>>> getCodes() {
        if (Optional.ofNullable(codes).isEmpty())
            codes = (LinkedHashMap<String, ArrayList<ArrayList<String>>>) Archivos.readYAML("codes/codes.yml");
        return codes;
    }

    /**
     * Carga el contenido del archivo contenido.yml que contiene los diversos contenidos temáticos del proyecto,
     * de lo contrario a esto solo retornará el contenido temático especificado
     * @param tema contenido temático a retornar
     * @return contenido temático especifico
     */
    public static LinkedHashMap<String, String> getContenidos(String tema) {
        if (Optional.ofNullable(contenidos).isEmpty())
            contenidos = (LinkedHashMap<String, LinkedHashMap<String, String>>) Archivos.readYAML("texts/contenidos.yml");
        return contenidos.get(tema);
    }

    /**
     * Carga el contenido del archivo tooltip.yml que contiene los diversos tool tips de los componentes del proyecto
     * SEROS, en el caso de haber sido ya cargado el archivo solo retornará los diferentes tool tips
     * @param key llave de la sesión de tool tips
     * @return tool tips de una sesión especifica
     */
    public static LinkedHashMap<String, String> getToolTips(String key) {
        if (Optional.ofNullable(toolTips).isEmpty())
            toolTips = (LinkedHashMap<String, LinkedHashMap<String, String>>) Archivos.readYAML("texts/tooltip.yml");
        return toolTips.get(key);
    }

    /**
     * Destruye todos los pseudocódigos cargados en el proyecto
     */
    private static void destroyCodes() {
        if (Optional.ofNullable(codes).isPresent()) codes = null;
    }

    /**
     * Destruye todos los contenidos temáticos cargados en el proyecto
     */
    private static void destroyContenidos() {
        if (Optional.ofNullable(contenidos).isPresent()) contenidos = null;
    }

    /**
     * Destruye todos los contenidos tool tip cargados en el proyecto
     */
    private static void destroyToolTips() {
        if (Optional.ofNullable(toolTips).isPresent()) toolTips = null;
    }

    public static void destroyers() {
        destroyCodes();
        destroyContenidos();
        destroyToolTips();
    }
}
