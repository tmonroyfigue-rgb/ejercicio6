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
}