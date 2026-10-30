public class WeatherWidget implements Widget {
    private String id;
    private String ciudad;
    private double temperatura;
    private String unidad;
    private int memoria;

    public WeatherWidget(String id, String ciudad,
                         double temperatura, int memoria) {
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
        System.out.println(ciudad + ": " + temperatura + "° " + unidad);
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
}