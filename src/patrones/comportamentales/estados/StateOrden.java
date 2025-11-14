package patrones.comportamentales.estados;

public interface StateOrden {
    void siguiente(Orden orden);
    void anterior(Orden orden);
    String getEstado();
}

