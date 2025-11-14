package patrones.comportamentales.strategy;

import models.Producto;
import java.util.List;

/**
 * PATRÓN STRATEGY - Estrategia para platos especiales por temporada
 *
 * Esta interfaz define el contrato que deben cumplir todas las estrategias
 * de menús especiales según la época del año.
 *
 * Beneficios del patrón Strategy:
 * - Evita condicionales if/else para cada temporada
 * - Permite agregar nuevas temporadas sin modificar código existente (OCP)
 * - Encapsula el comportamiento específico de cada temporada
 * - Facilita el cambio de estrategia en tiempo de ejecución
 */
public interface SeasonalSpecialStrategy {

    /**
     * Obtiene la lista de platos especiales para esta temporada
     * @return Lista de productos especiales
     */
    List<Producto> obtenerPlatosEspeciales();

    /**
     * Obtiene el nombre de la temporada
     * @return Nombre de la temporada (ej: "Halloween", "Navidad")
     */
    String getNombreTemporada();

    /**
     * Muestra el menú especial de la temporada
     */
    void mostrarMenuEspecial();
}
