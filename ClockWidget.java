import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.HierarchyEvent;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class ClockWidget implements Widget {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("HH:mm:ss");

    private String id;
    private int memoria;

    public ClockWidget(String id, int memoria) {
        this.id = id;
        this.memoria = memoria;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return "Reloj digital";
    }

    @Override
    public int getMemoria() {
        return memoria;
    }

    private String horaActual() {
        return LocalTime.now().format(FORMATO);
    }

    @Override
    public void renderizar() {
        System.out.println("Hora actual: " + horaActual());
    }

    @Override
    public JComponent obtenerVista() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(getNombre() + "  (" + id + " · " + memoria + " KB)"),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));

        JLabel lblHora = new JLabel(horaActual(), SwingConstants.CENTER);
        lblHora.setFont(lblHora.getFont().deriveFont(Font.BOLD, 32f));
        panel.add(lblHora, BorderLayout.CENTER);

        // Actualiza la hora cada segundo mientras el panel esté visible
        Timer timer = new Timer(1000, e -> lblHora.setText(horaActual()));
        panel.addHierarchyListener(e -> {
            if ((e.getChangeFlags() & HierarchyEvent.SHOWING_CHANGED) != 0) {
                if (panel.isShowing()) {
                    timer.start();
                } else {
                    timer.stop();
                }
            }
        });
        return panel;
    }
}