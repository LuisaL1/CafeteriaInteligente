package patrones.comportamentales.estados;

class EstadoEnPreparacion implements StateOrden {
    @Override
    public void siguiente(Orden orden) {
        orden.setEstado(new EstadoLista());
        System.out.println("   ✅ Orden lista para entregar");
    }

    @Override
    public void anterior(Orden orden) {
        orden.setEstado(new EstadoPendiente());
    }

    @Override
    public String getEstado() {
        return "EN_PREPARACION";
    }
}
