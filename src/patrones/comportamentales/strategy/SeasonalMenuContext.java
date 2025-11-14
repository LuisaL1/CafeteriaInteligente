package patrones.comportamentales.strategy;

import models.Producto;
import java.util.List;

/**
 * CONTEXTO DEL PATRÓN STRATEGY
 *
 * Esta clase mantiene una referencia a una estrategia de menú especial
 * y permite cambiarla en tiempo de ejecución.
 *
 * MEJORA: Ahora permite desactivar la temporada (setStrategy(null))
 */
public class SeasonalMenuContext {

    private SeasonalSpecialStrategy estrategiaActual;

    public SeasonalMenuContext() {
        this.estrategiaActual = null;
    }

    public SeasonalMenuContext(SeasonalSpecialStrategy estrategia) {
        this.estrategiaActual = estrategia;
    }

    /**
     * Cambia la estrategia en tiempo de ejecución
     * Permite null para desactivar la temporada especial
     */
    public void setStrategy(SeasonalSpecialStrategy estrategia) {
        this.estrategiaActual = estrategia;
        if (estrategia != null) {
            System.out.println("🔄 Estrategia cambiada a: " + estrategia.getNombreTemporada());
        } else {
            System.out.println("🔄 Temporada especial desactivada");
        }
    }

    public List<Producto> obtenerPlatosEspeciales() {
        if (estrategiaActual == null) {
            throw new IllegalStateException("No hay estrategia de temporada configurada");
        }
        return estrategiaActual.obtenerPlatosEspeciales();
    }

    public void mostrarMenuEspecial() {
        if (estrategiaActual == null) {
            System.out.println("ℹ️ No hay menú especial activo en este momento.");
            System.out.println("   Consulte el menú regular.");
            return;
        }
        estrategiaActual.mostrarMenuEspecial();
    }

    public String getTemporadaActual() {
        if (estrategiaActual == null) {
            return "Sin temporada especial";
        }
        return estrategiaActual.getNombreTemporada();
    }

    public boolean hayTemporadaActiva() {
        return estrategiaActual != null;
    }
}
