package modelo;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
    }

    private String textoAlerta() {
        return "<html><div style='text-align:center'>"
                + "<b>Prioridad " + prioridad + "</b><br>" + mensaje + "<br><br>"
                + (leida ? "Leída" : "Sin leer")
                + "</div></html>";
    }

    private Color colorPrioridad() {
        if (leida) {
            return new Color(230, 230, 230);
        }
        if (prioridad >= 4) {
            return new Color(255, 205, 205);
        }
        if (prioridad == 3) {
            return new Color(255, 236, 190);
        }
        return new Color(205, 235, 210);
    }

    @Override
    public JComponent obtenerVista() {
        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(getNombre() + "  (" + id + " · " + memoria + " KB)"),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));
        panel.setBackground(colorPrioridad());

        JLabel lblAlerta = new JLabel(textoAlerta(), SwingConstants.CENTER);

        JButton btnLeida = new JButton("Marcar como leída");
        btnLeida.setEnabled(!leida);
        btnLeida.addActionListener(e -> {
            interactuar();
            lblAlerta.setText(textoAlerta());
            panel.setBackground(colorPrioridad());
            btnLeida.setEnabled(false);
        });

        panel.add(lblAlerta, BorderLayout.CENTER);
        panel.add(btnLeida, BorderLayout.SOUTH);
        return panel;
    }
}