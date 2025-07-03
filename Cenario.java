import java.util.List;
import java.util.ArrayList;

public class Cenario {
    private String descricao;
    private List<Escolha> escolhas;
    
    public Cenario(String descricao) {
        this.descricao = descricao;
        this.escolhas = new ArrayList<>();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Escolha> getEscolhas() {
        return escolhas;
    }

    public void adicionarEscolha(String textoEscolha, Cenario proximoCenario, String tipo) {
        this.escolhas.add(new Escolha(textoEscolha, proximoCenario, tipo));
    }
}