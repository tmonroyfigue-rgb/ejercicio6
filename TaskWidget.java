import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TaskWidget implements WidgetInteractivo {
    private String id;
    private List<String> tareas;
    private List<Boolean> completadas;
    private int memoria;

    public TaskWidget(String id, List<String> tareas, int memoria) {
        this.id = id;
        this.tareas = new ArrayList<>(tareas);
        this.completadas = new ArrayList<>();
        for (int i = 0; i < tareas.size(); i++) {
            completadas.add(false);
        }
        this.memoria = memoria;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return "Lista de tareas";
    }

    @Override
    public int getMemoria() {
        return memoria;
    }

    @Override
    public void renderizar() {
        System.out.println("Tareas pendientes:");
        for (int i = 0; i < tareas.size(); i++) {
            String marca = completadas.get(i) ? "[x] " : "[ ] ";
            System.out.println("   " + marca + tareas.get(i));
        }
    }

    @Override
    public void interactuar() {
        for (int i = 0; i < tareas.size(); i++) {
            if (!completadas.get(i)) {
                completadas.set(i, true);
                return;
            }
        }
    }

    private boolean hayPendientes() {
        return completadas.contains(false);
    }

    private String textoTareas() {
        StringBuilder sb = new StringBuilder("<html>");
        for (int i = 0; i < tareas.size(); i++) {
            if (completadas.get(i)) {
                sb.append("[x] <s>").append(tareas.get(i)).append("</s>");
            } else {
                sb.append("[ ] ").append(tareas.get(i));
            }
            sb.append("<br>");
        }
        sb.append("</html>");
        return sb.toString();
    }

    @Override
    public JComponent obtenerVista() {
        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(getNombre() + "  (" + id + " · " + memoria + " KB)"),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));

        JLabel lblTareas = new JLabel(textoTareas());

        JButton btnCompletar = new JButton("Completar siguiente tarea");
        btnCompletar.setEnabled(hayPendientes());
        btnCompletar.addActionListener(e -> {
            interactuar();
            lblTareas.setText(textoTareas());
            btnCompletar.setEnabled(hayPendientes());
        });

        panel.add(lblTareas, BorderLayout.CENTER);
        panel.add(btnCompletar, BorderLayout.SOUTH);
        return panel;
    }
}