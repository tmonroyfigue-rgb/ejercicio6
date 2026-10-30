import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ClockWidget implements Widget {
    private String id;
    private int memoria;

    public ClockWidget(String id, int memoria) {
        this.id = id;
        this.memoria = memoria;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return "Reloj digital";
    }

    @Override
    public int getMemoria() {
        return memoria;
    }

    @Override
    public void renderizar() {
        LocalTime horaActual = LocalTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("Hora actual: " + horaActual.format(formato));
    }
}