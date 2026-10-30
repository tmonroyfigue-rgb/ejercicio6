public class TaskWidget implements widget {

    private String id;
    private list<String> tareas;
    private list<Boolean> completadas;
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

    public void renderizar(){

    }

    public void interactuar(){

    }

}
