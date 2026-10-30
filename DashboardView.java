import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class DashboardView extends JFrame {
    private final JPanel panelWidgets;

    public DashboardView(List<Widget> widgets) {
        setTitle("Dashboard empresarial");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(700, 500));
        setLayout(new BorderLayout(12, 12));

        JLabel titulo = new JLabel("Panel de control", SwingConstants.CENTER);
        titulo.setBorder(BorderFactory.createEmptyBorder(16, 10, 8, 10));
        titulo.setFont(titulo.getFont().deriveFont(22f));
        add(titulo, BorderLayout.NORTH);

        panelWidgets = new JPanel(new GridLayout(0, 2, 12, 12));
        panelWidgets.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        panelWidgets.setBackground(new Color(240, 243, 248));

        cargarWidgets(widgets);
        add(new JScrollPane(panelWidgets), BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }

    public void cargarWidgets(List<Widget> widgets) {
        panelWidgets.removeAll();

        for (Widget widget : widgets) {
            panelWidgets.add(widget.obtenerVista());
        }

        panelWidgets.revalidate();
        panelWidgets.repaint();
    }

    public static void mostrar(List<Widget> widgets) {
        SwingUtilities.invokeLater(() -> {
            DashboardView vista = new DashboardView(widgets);
            vista.setVisible(true);
        });
    }
}