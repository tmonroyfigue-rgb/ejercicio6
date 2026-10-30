import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Dashboard {
    // Lista polimórfica: guarda cualquier tipo de Widget
    private List<Widget> widgets;

    public Dashboard() {
        widgets = new ArrayList<>();
    }

    // Carga inicial del catálogo (al menos 10 widgets).
    // Para agregar un widget nuevo basta con añadir una línea aquí.
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
        widgets.add(new QuoteWidget("Q-01", "La única forma de hacer un gran trabajo es amar lo que haces", "Steve Jobs", 40));
        widgets.add(new QuoteWidget("Q-02", "El éxito es la suma de pequeños esfuerzos repetidos día tras día", "Robert Collier", 45));
    }

    // 2. Listar todos los widgets con sus características
    public void listar() {
        if (widgets.isEmpty()) {
            System.out.println("No hay widgets cargados.");
            return;
        }
        int i = 1;
        for (Widget w : widgets) {
            mostrarWidget(i, w);
            i++;
        }
    }

    // Buscar por ID (exacto) o por nombre (coincidencia parcial)
    public void buscar(String texto) {
        boolean encontrado = false;
        for (Widget w : widgets) {
            if (w.getId().equalsIgnoreCase(texto)
                    || w.getNombre().toLowerCase().contains(texto.toLowerCase())) {
                mostrarWidget(widgets.indexOf(w) + 1, w);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún widget con: " + texto);
        }
    }

    // 3. Interactuar por índice (1..n) o por ID
    public void interactuar(String entrada) {
        Widget w = null;

        try {
            int indice = Integer.parseInt(entrada.trim());
            if (indice >= 1 && indice <= widgets.size()) {
                w = widgets.get(indice - 1);
            }
        } catch (NumberFormatException e) {
            for (Widget actual : widgets) {
                if (actual.getId().equalsIgnoreCase(entrada.trim())) {
                    w = actual;
                    break;
                }
            }
        }

        if (w == null) {
            System.out.println("No se encontró el widget indicado.");
            return;
        }

        // Solo interactúa si el widget es interactivo (sin try-catch)
        if (w instanceof WidgetInteractivo) {
            ((WidgetInteractivo) w).interactuar();
            System.out.print("Estado actual: ");
            w.renderizar();
        } else {
            System.out.println("El widget \"" + w.getNombre() + "\" es solo informativo y no soporta interacción.");
        }
    }

    // 4. Ordenar por memoria usando Comparable (menor a mayor)
    public void ordenarPorMemoria() {
        Collections.sort(widgets);
        System.out.println("Widgets ordenados por memoria (menor a mayor).");
    }

    private void mostrarWidget(int numero, Widget w) {
        System.out.println("--------------------------------------------");
        System.out.println("#" + numero + " | ID: " + w.getId()
                + " | Nombre: " + w.getNombre()
                + " | Memoria: " + w.getMemoria() + " KB");
        System.out.print("   ");
        w.renderizar();
    }
    public List<Widget> getWidgets() {
        return Collections.unmodifiableList(widgets);
    }
}