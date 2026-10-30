public class AlertWidget implements WidgetInteractivo {
    private String id;
    private String mensaje;
    private int prioridad;
    private boolean leida;
    private int memoria;

    public AlertWidget(String id, String mensaje, int prioridad, int memoria) {
        this.id = id;
        this.mensaje = mensaje;
        this.prioridad = prioridad;
        this.memoria = memoria;
        this.leida = false;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return "Alerta";
    }

    @Override
    public int getMemoria() {
        return memoria;
    }

    @Override
    public void renderizar() {
        System.out.println(
            "Alerta (prioridad " + prioridad + "): " + mensaje
            + (leida ? " [Leída]" : " [Sin leer]")
        );
    }

    @Override
    public void interactuar() {
        leida = true;
        System.out.println("Alerta marcada como leída.");
    }
}