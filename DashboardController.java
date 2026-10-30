import java.util.List;

public class DashboardController {
    private final Dashboard modelo;
    private final DashboardView vista;

    public DashboardController(Dashboard modelo, DashboardView vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.setBuscarListener(e -> buscar());
        vista.setMostrarTodosListener(e -> mostrarTodos());
        vista.setOrdenarListener(e -> ordenarPorMemoria());

        mostrarTodos();
    }

    private void mostrarTodos() {
        vista.limpiarBusqueda();
        List<Widget> todos = modelo.getWidgets();
        vista.mostrarWidgets(todos);
        vista.mostrarEstado("Mostrando " + todos.size() + " widgets.");
    }

    private void buscar() {
        String texto = vista.getTextoBusqueda();
        if (texto.isEmpty()) {
            mostrarTodos();
            return;
        }
        List<Widget> resultado = modelo.buscar(texto);
        vista.mostrarWidgets(resultado);
        if (resultado.isEmpty()) {
            vista.mostrarEstado("No se encontró ningún widget con: " + texto);
        } else {
            vista.mostrarEstado(resultado.size() + " widget(s) encontrado(s) para: " + texto);
        }
    }

    private void ordenarPorMemoria() {
        modelo.ordenarPorMemoria();
        vista.limpiarBusqueda();
        vista.mostrarWidgets(modelo.getWidgets());
        vista.mostrarEstado("Widgets ordenados por memoria (menor a mayor).");
    }
}