import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class QuoteWidget implements Widget {
    private String id;
    private String cita;
    private String autor;
    private int memoria;

    public QuoteWidget(String id, String cita, String autor, int memoria) {
        this.id = id;
        this.cita = cita;
        this.autor = autor;
        this.memoria = memoria;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return "Frase del día";
    }

    @Override
    public int getMemoria() {
        return memoria;
    }

    @Override
    public void renderizar() {
        System.out.println("\"" + cita + "\" — " + autor);
    }

    @Override
    public JComponent obtenerVista() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(getNombre() + "  (" + id + " · " + memoria + " KB)"),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));

        JLabel lblCita = new JLabel(
                "<html><div style='width:220px; text-align:center'><i>\"" + cita + "\"</i>"
                + "<br><br>— " + autor + "</div></html>",
                SwingConstants.CENTER);
        panel.add(lblCita, BorderLayout.CENTER);
        return panel;
    }
}