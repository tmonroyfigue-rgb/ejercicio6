import javax.swing.JComponent;

public interface Widget extends Comparable<Widget> {
    String getId();
    String getNombre();
    int getMemoria(); // en KB
    void renderizar();

    // Cada widget construye y retorna su propio panel visual (Swing)
    JComponent obtenerVista();

    // Orden natural: por memoria consumida (menor a mayor)
    @Override
    default int compareTo(Widget otro) {
        return Integer.compare(this.getMemoria(), otro.getMemoria());
    }
}