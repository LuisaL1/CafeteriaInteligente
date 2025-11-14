package patrones.estructurales.proxy;

import models.Producto;
import patrones.creacionales.MenuSingleton;

import java.util.List;

/**
 * Implementación real del servicio de menú.
 * Esta clase hace el trabajo "pesado" de consultar el menú desde el Singleton.
 *
 * El patrón Proxy se encargará de cachear los resultados de esta clase
 * para optimizar consultas frecuentes.
 *
 * ADAPTADO: Funciona con MenuSingleton que usa Map<String, List<Producto>>
 */
public class MenuServiceImpl implements MenuService {

    private MenuSingleton menu;

    public MenuServiceImpl() {
        this.menu = MenuSingleton.getInstancia();
        System.out.println("🔧 [MenuServiceImpl] Inicializando servicio real de menú...");
    }

    @Override
    public List<Producto> obtenerBebidas() {
        System.out.println("📡 [MenuServiceImpl] Consultando bebidas desde el origen...");
        return menu.obtenerCategoria("BEBIDA");
    }

    @Override
    public List<Producto> obtenerComidas() {
        System.out.println("📡 [MenuServiceImpl] Consultando comidas desde el origen...");
        return menu.obtenerCategoria("COMIDA");
    }

    @Override
    public List<Producto> obtenerPostres() {
        System.out.println("📡 [MenuServiceImpl] Consultando postres desde el origen...");
        return menu.obtenerCategoria("POSTRE");
    }

    @Override
    public void mostrarMenu() {
        System.out.println("📡 [MenuServiceImpl] Generando menú completo desde el origen...");
        menu.mostrarMenu();
    }

    @Override
    public void invalidarCache() {
        // En la implementación real no hace nada,
        // pero la interfaz lo requiere para el Proxy
    }
}
