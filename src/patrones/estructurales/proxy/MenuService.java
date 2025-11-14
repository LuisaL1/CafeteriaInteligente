package patrones.estructurales.proxy;

import models.Producto;
import java.util.List;

/**
 * Interfaz para el servicio de menú.
 * Permite implementar el patrón Proxy para cachear datos del menú.
 */
public interface MenuService {

    /**
     * Obtiene todas las bebidas del menú
     */
    List<Producto> obtenerBebidas();

    /**
     * Obtiene todas las comidas del menú
     */
    List<Producto> obtenerComidas();

    /**
     * Obtiene todos los postres del menú
     */
    List<Producto> obtenerPostres();

    /**
     * Muestra el menú completo
     */
    void mostrarMenu();

    /**
     * Invalida la caché (útil cuando el menú cambia)
     */
    void invalidarCache();
}
