package patrones.comportamentales.strategy;

import models.Producto;
import models.Bebida;
import models.Postre;
import models.Comida;
import java.util.List;
import java.util.ArrayList;

/**
 * ESTRATEGIA CONCRETA: Platos Especiales de Halloween
 *
 * Define los platos especiales disponibles durante la temporada de Halloween.
 * Esta estrategia se puede activar durante el mes de octubre.
 *
 * Responsabilidad:
 * - Definir el conjunto de productos temáticos de Halloween
 * - Generar precios especiales para la temporada
 * - Presentar el menú con temática terrorífica
 */
public class HalloweenSpecialStrategy implements SeasonalSpecialStrategy {

    private List<Producto> platosEspeciales;

    public HalloweenSpecialStrategy() {
        inicializarPlatosHalloween();
    }

    /**
     * Inicializa los platos especiales de Halloween
     */
    private void inicializarPlatosHalloween() {
        platosEspeciales = new ArrayList<>();

        // Bebidas temáticas de Halloween
        platosEspeciales.add(new Bebida("Café Calabaza Terrorífica", 8.00, "Grande"));
        platosEspeciales.add(new Bebida("Chocolate Fantasmal", 7.50, "Mediano"));
        platosEspeciales.add(new Bebida("Jugo de Sangre (Granada)", 6.00, "Grande"));

        // Comidas temáticas de Halloween
        platosEspeciales.add(new Comida("Pizza Monstruosa", 12.00, false));
        platosEspeciales.add(new Comida("Sandwich del Vampiro", 9.50, false));
        platosEspeciales.add(new Comida("Wrap de la Bruja", 10.00, true));

        // Postres temáticos de Halloween
        platosEspeciales.add(new Postre("Brownie de Murciélago", 7.00, false));
        platosEspeciales.add(new Postre("Cupcake de Calabaza", 6.50, false));
        platosEspeciales.add(new Postre("Galletas de Fantasma", 5.00, true));
    }

    @Override
    public List<Producto> obtenerPlatosEspeciales() {
        return new ArrayList<>(platosEspeciales); // Retorna copia para evitar modificaciones
    }

    @Override
    public String getNombreTemporada() {
        return "Halloween";
    }

    @Override
    public void mostrarMenuEspecial() {
        System.out.println("\n🎃========================================🎃");
        System.out.println("       👻 MENÚ ESPECIAL DE HALLOWEEN 👻");
        System.out.println("🎃========================================🎃");
        System.out.println("   ¡Platos terroríficamente deliciosos!");
        System.out.println("------------------------------------------");

        System.out.println("\n☕ BEBIDAS ESCALOFRIANTES:");
        platosEspeciales.stream()
                .filter(p -> p.getCategoria().equals("Bebida"))
                .forEach(p -> System.out.println("  🦇 " + p));

        System.out.println("\n🍴 COMIDAS MONSTRUOSAS:");
        platosEspeciales.stream()
                .filter(p -> p.getCategoria().equals("Comida"))
                .forEach(p -> System.out.println("  🕷️ " + p));

        System.out.println("\n🍰 POSTRES EMBRUJADOS:");
        platosEspeciales.stream()
                .filter(p -> p.getCategoria().equals("Postre"))
                .forEach(p -> System.out.println("  👻 " + p));

        System.out.println("\n🎃========================================🎃\n");
    }
}
