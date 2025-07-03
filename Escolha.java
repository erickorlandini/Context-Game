public class Escolha {
    private String texto;
    private Cenario proximoCenario;
    private String tipo;

    public static final String TIPO_NUMERICO = "NUMERICO";
    public static final String TIPO_SIM_NAO = "SIM_NAO";
    public static final String TIPO_PEGAR_LARGAR = "PEGAR_LARGAR";
    public static final String TIPO_VOLTAR_SEGUIR = "VOLTAR_SEGUIR";
    

    public Escolha(String texto, Cenario proximoCenario, String tipo) {
        this.texto = texto;
        this.proximoCenario = proximoCenario;
        this.tipo = tipo;
    }

    public String getTexto() {
        return texto;
    }

    public Cenario getProximoCenario() {
        return proximoCenario;
    }

    public String getTipo() {
        return tipo;
    }
}
