package modelo;

import javax.swing.JComponent;

public interface Widget extends Comparable<Widget> {
    String getId();
    String getNombre();
    int getMemoria();
    void renderizar();

    JComponent obtenerVista();

    @Override
    default int compareTo(Widget otro) {
        return Integer.compare(this.getMemoria(), otro.getMemoria());
    }
}