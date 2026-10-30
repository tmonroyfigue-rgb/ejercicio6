import java.util.ArrayList;
import java.util.List;

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

    // Marca como completada la primera tarea pendiente
    @Override
    public void interactuar() {
        for (int i = 0; i < tareas.size(); i++) {
            if (!completadas.get(i)) {
                completadas.set(i, true);
                System.out.println("Tarea completada: " + tareas.get(i));
                return;
            }
        }
        System.out.println("Todas las tareas ya están completadas.");
    }
}