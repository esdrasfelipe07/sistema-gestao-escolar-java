import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
    private List<Nota> notas;

    public Aluno(String nome, String cpf) {
        super(nome, cpf);
        this.notas = new ArrayList<>();
    }

    public void adicionarNota(Nota nota) {
        notas.add(nota);
    }

    public List<Nota> getNotas() {
        return notas;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Aluno: " + getNome() + " - CPF: " + getCpf());
    }
}