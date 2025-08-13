classDiagram
    class Pessoa {
        - String nome
        - String cpf
        + getNome()
        + setNome()
        + getCpf()
        + setCpf()
        + exibirInformacoes()
    }

    class Aluno {
        - List~Nota~ notas
        + adicionarNota()
        + getNotas()
        + exibirInformacoes()
    }

    class Professor {
        - String especialidade
        + getEspecialidade()
        + setEspecialidade()
        + exibirInformacoes()
    }

    class Disciplina {
        - String nome
        - String codigo
        + getNome()
        + setNome()
        + getCodigo()
        + setCodigo()
        + exibirInformacoes()
    }

    class Nota {
        - Disciplina disciplina
        - double valor
        + getDisciplina()
        + setDisciplina()
        + getValor()
        + setValor()
    }

    class Turma {
        - String codigo
        - Disciplina disciplina
        - Professor professor
        - List~Aluno~ alunos
        + adicionarAluno()
        + getAlunos()
        + getDisciplina()
        + getProfessor()
    }

    class Matricula {
        - Aluno aluno
        - Turma turma
        + getAluno()
        + getTurma()
    }

    class Menu {
        - Scanner scanner
        - List~Aluno~, Professor, Disciplina, Turma, Matricula
        + exibirMenu()
    }

    class Main {
        + main()
    }

    Pessoa <|-- Aluno
    Pessoa <|-- Professor

    Aluno --> Nota
    Nota --> Disciplina

    Turma --> Disciplina
    Turma --> Professor
    Turma --> Aluno

    Matricula --> Aluno
    Matricula --> Turma

    Menu --> Aluno
    Menu --> Professor
    Menu --> Disciplina
    Menu --> Turma
    Menu --> Matricula

    Main --> Menu
