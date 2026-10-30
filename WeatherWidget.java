import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// Ciudad se guarda como String y la temperatura como double porque es lo más
// simple: la ciudad solo se muestra (no necesita comportamiento propio) y la
// temperatura necesita decimales para la conversión Celsius/Fahrenheit.
public class WeatherWidget implements WidgetInteractivo {
    private String id;
    private String ciudad;
    private double temperatura;
    private String unidad;
    private int memoria;

    public WeatherWidget(String id, String ciudad, double temperatura, int memoria) {
        this.id = id;
        this.ciudad = ciudad;
        this.temperatura = temperatura;
        this.unidad = "Celsius";
        this.memoria = memoria;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return "Clima de " + ciudad;
    }

    @Override
    public int getMemoria() {
        return memoria;
    }

    @Override
    public void renderizar() {
        System.out.printf("%s: %.1f° %s%n", ciudad, temperatura, unidad);
    }

    @Override
    public void interactuar() {
        if (unidad.equals("Celsius")) {
            unidad = "Fahrenheit";
            temperatura = (temperatura * 9 / 5) + 32;
        } else {
            unidad = "Celsius";
            temperatura = (temperatura - 32) * 5 / 9;
        }
    }

    private String textoTemperatura() {
        String simbolo = unidad.equals("Celsius") ? "C" : "F";
        return String.format("%.1f° %s", temperatura, simbolo);
    }

    private String textoBoton() {
        return unidad.equals("Celsius") ? "Cambiar a °F" : "Cambiar a °C";
    }

    @Override
    public JComponent obtenerVista() {
        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(getNombre() + "  (" + id + " · " + memoria + " KB)"),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));

        JLabel lblTemperatura = new JLabel(textoTemperatura(), SwingConstants.CENTER);
        lblTemperatura.setFont(lblTemperatura.getFont().deriveFont(Font.BOLD, 28f));

        JLabel lblCiudad = new JLabel(ciudad, SwingConstants.CENTER);

        JButton btnUnidad = new JButton(textoBoton());
        btnUnidad.addActionListener(e -> {
            interactuar();
            lblTemperatura.setText(textoTemperatura());
            btnUnidad.setText(textoBoton());
        });

        panel.add(lblCiudad, BorderLayout.NORTH);
        panel.add(lblTemperatura, BorderLayout.CENTER);
        panel.add(btnUnidad, BorderLayout.SOUTH);
        return panel;
    }
}