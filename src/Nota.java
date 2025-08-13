public class Nota {
    private Disciplina disciplina;
    private double valor;

    public Nota(Disciplina disciplina, double valor) {
        this.disciplina = disciplina;
        this.valor = valor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}