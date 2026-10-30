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
        System.out.println("Unidad cambiada a " + unidad);
    }
}