package patrones.comportamentales.estados;

class EstadoEntregada implements StateOrden {
    @Override
    public void siguiente(Orden orden) {
        System.out.println("   ⚠️ La orden ya fue entregada");
    }

    @Override
    public void anterior(Orden orden) {
        orden.setEstado(new EstadoLista());
    }

    @Override
    public String getEstado() {
        return "ENTREGADA";
    }
}
