public interface Widget extends Comparable<Widget> {
    String getId();
    String getNombre();
    int getMemoria(); // en KB
    void renderizar();

    @Override
    default int compareTo(Widget otro) {
        return Integer.compare(this.getMemoria(), otro.getMemoria());
    }
}