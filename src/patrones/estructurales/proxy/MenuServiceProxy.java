package patrones.estructurales.proxy;

import models.Producto;

import java.util.List;
import java.util.ArrayList;

/**
 * PATRÓN PROXY - Memoria Interna / Caché
 *
 * Este Proxy actúa como una memoria interna que cachea los resultados
 * del MenuService real para optimizar el acceso a datos frecuentemente consultados.
 *
 * Beneficios:
 * - Reduce la carga computacional al evitar consultas repetitivas
 * - Implementa una caché simple pero efectiva
 * - Permite invalidar la caché cuando el menú cambie
 * - Mantiene la misma interfaz que el servicio real (transparencia)
 *
 * Contexto de la Cafetería:
 * El menú es consultado frecuentemente por clientes y meseros, pero rara vez cambia.
 * El Proxy evita reconstruir la lista de productos en cada consulta.
 *
 * ADAPTADO: Funciona con MenuSingleton que usa Map<String, List<Producto>>
 */
public class MenuServiceProxy implements MenuService {

    // Servicio real al que delegar cuando no hay caché
    private MenuService servicioReal;

    // Caché interna (memoria interna)
    private List<Producto> cacheBebidas;
    private List<Producto> cacheComidas;
    private List<Producto> cachePostres;

    // Flag para saber si la caché está inicializada
    private boolean cacheInicializada = false;

    public MenuServiceProxy() {
        // Lazy initialization: el servicio real solo se crea cuando se necesita
        System.out.println("💾 [MenuServiceProxy] Proxy de menú inicializado (con caché interna)");
    }

    /**
     * Inicializa el servicio real solo cuando se necesita (Lazy Loading)
     */
    private MenuService obtenerServicioReal() {
        if (servicioReal == null) {
            servicioReal = new MenuServiceImpl();
        }
        return servicioReal;
    }

    /**
     * Carga la caché desde el servicio real
     */
    private void cargarCache() {
        System.out.println("💾 [MenuServiceProxy] Cargando caché de menú...");
        MenuService servicio = obtenerServicioReal();

        // Copiar las listas para evitar modificaciones externas
        this.cacheBebidas = new ArrayList<>(servicio.obtenerBebidas());
        this.cacheComidas = new ArrayList<>(servicio.obtenerComidas());
        this.cachePostres = new ArrayList<>(servicio.obtenerPostres());
        this.cacheInicializada = true;

        System.out.println("✅ [MenuServiceProxy] Caché cargada exitosamente");
    }

    @Override
    public List<Producto> obtenerBebidas() {
        if (!cacheInicializada) {
            cargarCache();
        }
        System.out.println("⚡ [MenuServiceProxy] Sirviendo bebidas desde CACHÉ");
        return new ArrayList<>(cacheBebidas); // Retorna copia defensiva
    }

    @Override
    public List<Producto> obtenerComidas() {
        if (!cacheInicializada) {
            cargarCache();
        }
        System.out.println("⚡ [MenuServiceProxy] Sirviendo comidas desde CACHÉ");
        return new ArrayList<>(cacheComidas); // Retorna copia defensiva
    }

    @Override
    public List<Producto> obtenerPostres() {
        if (!cacheInicializada) {
            cargarCache();
        }
        System.out.println("⚡ [MenuServiceProxy] Sirviendo postres desde CACHÉ");
        return new ArrayList<>(cachePostres); // Retorna copia defensiva
    }

    @Override
    public void mostrarMenu() {
        if (!cacheInicializada) {
            cargarCache();
        }

        System.out.println("⚡ [MenuServiceProxy] Mostrando menú desde CACHÉ");
        System.out.println("\n========== MENÚ ==========");

        System.out.println("\n☕ BEBIDAS:");
        cacheBebidas.forEach(b -> System.out.println("  - " + b));

        System.out.println("\n🍴 COMIDAS:");
        cacheComidas.forEach(c -> System.out.println("  - " + c));

        System.out.println("\n🍰 POSTRES:");
        cachePostres.forEach(p -> System.out.println("  - " + p));

        System.out.println("\n==========================\n");
    }

    @Override
    public void invalidarCache() {
        System.out.println("🔄 [MenuServiceProxy] Invalidando caché de menú...");
        this.cacheBebidas = null;
        this.cacheComidas = null;
        this.cachePostres = null;
        this.cacheInicializada = false;
        System.out.println("✅ [MenuServiceProxy] Caché invalidada. Próxima consulta recargará desde el origen.");
    }
}