import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Dashboard {
    private List<Widget> widgets;

    public Dashboard() {
        widgets = new ArrayList<>();
    }

    public void init() {
        widgets.add(new WeatherWidget("W-01", "Guatemala", 22.5, 120));
        widgets.add(new WeatherWidget("W-02", "Antigua", 19.0, 110));
        widgets.add(new WeatherWidget("W-03", "Quetzaltenango", 14.0, 115));
        widgets.add(new TaskWidget("T-01",
                Arrays.asList("Entregar ejercicio 6", "Estudiar para el parcial", "Revisar correo"), 200));
        widgets.add(new TaskWidget("T-02",
                Arrays.asList("Reunión con el equipo", "Enviar reporte"), 180));
        widgets.add(new AlertWidget("A-01", "Servidor sin respuesta", 5, 60));
        widgets.add(new AlertWidget("A-02", "Respaldo completado", 2, 55));
        widgets.add(new AlertWidget("A-03", "Memoria casi llena", 4, 65));
        widgets.add(new ClockWidget("C-01", 30));
        widgets.add(new ClockWidget("C-02", 35));
        widgets.add(new QuoteWidget("Q-01",
                "La única forma de hacer un gran trabajo es amar lo que haces",
                "Steve Jobs", 40));
        widgets.add(new QuoteWidget("Q-02",
                "El éxito es la suma de pequeños esfuerzos repetidos día tras día",
                "Robert Collier", 45));
    }

    public List<Widget> getWidgets() {
        return Collections.unmodifiableList(widgets);
    }

    public List<Widget> buscar(String texto) {
        List<Widget> resultado = new ArrayList<>();
        String buscado = texto.trim().toLowerCase();

        for (Widget w : widgets) {
            if (w.getId().equalsIgnoreCase(buscado)
                    || w.getNombre().toLowerCase().contains(buscado)) {
                resultado.add(w);
            }
        }

        return resultado;
    }

    public void interactuar(String id) {
        for (Widget w : widgets) {
            if (w.getId().equalsIgnoreCase(id.trim())) {
                if (w instanceof WidgetInteractivo) {
                    ((WidgetInteractivo) w).interactuar();
                }
                return;
            }
        }
    }

    public void ordenarPorMemoria() {
        Collections.sort(widgets);
    }
}