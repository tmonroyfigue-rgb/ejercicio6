import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DashboardView extends JFrame {
    private final JPanel panelWidgets;
    private final JTextField txtBusqueda;
    private final JButton btnBuscar;
    private final JButton btnMostrarTodos;
    private final JButton btnOrdenar;
    private final JLabel lblEstado;

    public DashboardView() {
        setTitle("Dashboard empresarial");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 600));
        setLayout(new BorderLayout(12, 12));

        JLabel titulo = new JLabel("Panel de control", SwingConstants.CENTER);
        titulo.setBorder(BorderFactory.createEmptyBorder(16, 10, 8, 10));
        titulo.setFont(titulo.getFont().deriveFont(22f));

        txtBusqueda = new JTextField(16);
        btnBuscar = new JButton("Buscar (ID o nombre)");
        btnMostrarTodos = new JButton("Mostrar todos");
        btnOrdenar = new JButton("Ordenar por memoria (KB)");

        JPanel barraBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 4));
        barraBotones.add(txtBusqueda);
        barraBotones.add(btnBuscar);
        barraBotones.add(btnMostrarTodos);
        barraBotones.add(btnOrdenar);

        JPanel barraSuperior = new JPanel(new BorderLayout());
        barraSuperior.add(titulo, BorderLayout.NORTH);
        barraSuperior.add(barraBotones, BorderLayout.SOUTH);
        add(barraSuperior, BorderLayout.NORTH);

        panelWidgets = new JPanel(new GridLayout(0, 2, 12, 12));
        panelWidgets.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        panelWidgets.setBackground(new Color(240, 243, 248));

        JScrollPane scroll = new JScrollPane(panelWidgets);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll, BorderLayout.CENTER);

        lblEstado = new JLabel(" ");
        lblEstado.setBorder(BorderFactory.createEmptyBorder(4, 12, 8, 12));
        add(lblEstado, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    public void mostrarWidgets(List<Widget> widgets) {
        panelWidgets.removeAll();

        for (Widget widget : widgets) {
            panelWidgets.add(widget.obtenerVista());
        }

        panelWidgets.revalidate();
        panelWidgets.repaint();
    }

    public String getTextoBusqueda() {
        return txtBusqueda.getText().trim();
    }

    public void limpiarBusqueda() {
        txtBusqueda.setText("");
    }

    public void mostrarEstado(String mensaje) {
        lblEstado.setText(mensaje);
    }

    public void setBuscarListener(ActionListener listener) {
        btnBuscar.addActionListener(listener);
        txtBusqueda.addActionListener(listener);
    }

    public void setMostrarTodosListener(ActionListener listener) {
        btnMostrarTodos.addActionListener(listener);
    }

    public void setOrdenarListener(ActionListener listener) {
        btnOrdenar.addActionListener(listener);
    }
}