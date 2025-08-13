public class Professor extends Pessoa {
    private String especialidade;

    public Professor(String nome, String cpf, String especialidade) {
        super(nome, cpf);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Professor: " + getNome() + " - CPF: " + getCpf() + " - Especialidade: " + especialidade);
    }
}