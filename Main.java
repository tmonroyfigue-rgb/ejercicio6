import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Dashboard modelo = new Dashboard();
            modelo.init();

            DashboardView vista = new DashboardView();
            new DashboardController(modelo, vista);

            vista.setVisible(true);
        });
    }
}