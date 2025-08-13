import java.util.*;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private List<Aluno> alunos = new ArrayList<>();
    private List<Professor> professores = new ArrayList<>();
    private List<Disciplina> disciplinas = new ArrayList<>();
    private List<Turma> turmas = new ArrayList<>();
    private List<Matricula> matriculas = new ArrayList<>();

    public void exibirMenu() {
        int opcao = -1;
        do {
            try {
                System.out.println("\nSISTEMA DE GESTÃO ESCOLAR");
                System.out.println("1 - Aluno");
                System.out.println("2 - Professor");
                System.out.println("3 - Disciplina");
                System.out.println("4 - Turma");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1 -> submenuAluno();
                    case 2 -> submenuProfessor();
                    case 3 -> submenuDisciplina();
                    case 4 -> submenuTurma();
                    case 0 -> System.out.println("Encerrando o sistema.");
                    default -> System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite apenas números.");
            }
        } while (opcao != 0);
    }

    private void submenuAluno() {
        int opcao = -1;
        do {
            try {
                System.out.println("\nMENU ALUNO");
                System.out.println("1 - Cadastrar");
                System.out.println("2 - Listar");
                System.out.println("3 - Atualizar");
                System.out.println("4 - Remover");
                System.out.println("5 - Matricular em Turma");
                System.out.println("6 - Lançar Nota");
                System.out.println("7 - Ver Notas");
                System.out.println("0 - Voltar");
                System.out.print("Escolha uma opção: ");
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1 -> cadastrarAluno();
                    case 2 -> alunos.forEach(Aluno::exibirInformacoes);
                    case 3 -> atualizarAluno();
                    case 4 -> removerAluno();
                    case 5 -> matricularAluno();
                    case 6 -> lancarNota();
                    case 7 -> listarNotasAluno();
                    case 0 -> {}
                    default -> System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite apenas números.");
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        } while (opcao != 0);
    }
    
    private void submenuProfessor() {
        int opcao = -1;
        do {
            try {
                System.out.println("\nMENU PROFESSOR");
                System.out.println("1 - Cadastrar");
                System.out.println("2 - Listar");
                System.out.println("3 - Atualizar");
                System.out.println("4 - Remover");
                System.out.println("0 - Voltar");
                System.out.print("Escolha uma opção: ");
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1 -> cadastrarProfessor();
                    case 2 -> professores.forEach(Professor::exibirInformacoes);
                    case 3 -> atualizarProfessor();
                    case 4 -> removerProfessor();
                    case 0 -> {}
                    default -> System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite apenas números.");
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        } while (opcao != 0);
    }

    private void submenuDisciplina() {
        int opcao = -1;
        do {
            try {
                System.out.println("\nMENU DISCIPLINA");
                System.out.println("1 - Cadastrar");
                System.out.println("2 - Listar");
                System.out.println("3 - Atualizar");
                System.out.println("4 - Remover");
                System.out.println("0 - Voltar");
                System.out.print("Escolha uma opção: ");
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1 -> criarDisciplina();
                    case 2 -> disciplinas.forEach(Disciplina::exibirInformacoes);
                    case 3 -> atualizarDisciplina();
                    case 4 -> removerDisciplina();
                    case 0 -> {}
                    default -> System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite apenas números.");
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        } while (opcao != 0);
    }

    private void submenuTurma() {
        int opcao = -1;
        do {
            try {
                System.out.println("\nMENU TURMA");
                System.out.println("1 - Cadastrar");
                System.out.println("2 - Listar");
                System.out.println("3 - Remover");
                System.out.println("0 - Voltar");
                System.out.print("Escolha uma opção: ");
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1 -> criarTurma();
                    case 2 -> turmas.forEach(t -> System.out.println("Turma: " + t.getCodigo() + ", Disciplina: " + t.getDisciplina().getNome() + ", Professor: " + t.getProfessor().getNome()));
                    case 3 -> removerTurma();
                    case 0 -> {}
                    default -> System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite apenas números.");
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        } while (opcao != 0);
    }

    private void cadastrarAluno() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        alunos.add(new Aluno(nome, cpf));
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private void cadastrarProfessor() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();
        professores.add(new Professor(nome, cpf, especialidade));
        System.out.println("Professor cadastrado com sucesso!");
    }

    private void criarDisciplina() {
        System.out.print("Nome da disciplina: ");
        String nome = scanner.nextLine();
        System.out.print("Código da disciplina: ");
        String codigo = scanner.nextLine();
        disciplinas.add(new Disciplina(nome, codigo));
        System.out.println("Disciplina criada com sucesso!");
    }

    private void criarTurma() {
        System.out.print("Código da turma: ");
        String codigo = scanner.nextLine();
        System.out.print("Código da disciplina: ");
        String codDisc = scanner.nextLine();
        System.out.print("CPF do professor: ");
        String cpfProf = scanner.nextLine();

        Disciplina d = encontrarDisciplina(codDisc);
        Professor p = encontrarProfessor(cpfProf);

        if (d != null && p != null) {
            turmas.add(new Turma(codigo, d, p));
            System.out.println("Turma criada com sucesso!");
        } else {
            System.out.println("Disciplina ou professor não encontrado.");
        }
    }

    private void matricularAluno() {
        System.out.print("CPF do aluno: ");
        String cpf = scanner.nextLine();
        System.out.print("Código da turma: ");
        String codTurma = scanner.nextLine();

        Aluno a = encontrarAluno(cpf);
        Turma t = turmas.stream().filter(tu -> tu.getCodigo().equals(codTurma)).findFirst().orElse(null);

        if (a != null && t != null) {
            t.adicionarAluno(a);
            matriculas.add(new Matricula(a, t));
            System.out.println("Aluno matriculado com sucesso!");
        } else {
            System.out.println("Aluno ou turma não encontrado.");
        }
    }

    private Aluno encontrarAluno(String cpf) {
        return alunos.stream().filter(a -> a.getCpf().equals(cpf)).findFirst().orElse(null);
    }

    private Professor encontrarProfessor(String cpf) {
        return professores.stream().filter(p -> p.getCpf().equals(cpf)).findFirst().orElse(null);
    }

    private Disciplina encontrarDisciplina(String codigo) {
        return disciplinas.stream().filter(d -> d.getCodigo().equals(codigo)).findFirst().orElse(null);
    }
    private void lancarNota() {
        System.out.print("CPF do aluno: ");
        String cpf = scanner.nextLine();
        Aluno aluno = encontrarAluno(cpf);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.print("Código da disciplina: ");
        String cod = scanner.nextLine();
        Disciplina disciplina = encontrarDisciplina(cod);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }

        System.out.print("Valor da nota: ");
        double valor = Double.parseDouble(scanner.nextLine());

        Nota nota = new Nota(disciplina, valor);
        aluno.adicionarNota(nota);
        System.out.println("Nota lançada com sucesso!");
    }

    private void listarNotasAluno() {
        System.out.print("CPF do aluno: ");
        String cpf = scanner.nextLine();
        Aluno aluno = encontrarAluno(cpf);
        if (aluno != null) {
            System.out.println("Notas do aluno " + aluno.getNome() + ":");
            for (Nota nota : aluno.getNotas()) {
                System.out.println("Disciplina: " + nota.getDisciplina().getNome() + " - Nota: " + nota.getValor());
            }
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private void atualizarAluno() {
        System.out.print("CPF do aluno a atualizar: ");
        String cpf = scanner.nextLine();
        Aluno aluno = encontrarAluno(cpf);
        if (aluno != null) {
            System.out.print("Novo nome: ");
            String nome = scanner.nextLine();
            aluno.setNome(nome);
            System.out.println("Aluno atualizado!");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private void removerAluno() {
        System.out.print("CPF do aluno a remover: ");
        String cpf = scanner.nextLine();
        Aluno aluno = encontrarAluno(cpf);
        if (aluno != null) {
            alunos.remove(aluno);
            System.out.println("Aluno removido!");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private void atualizarProfessor() {
        System.out.print("CPF do professor a atualizar: ");
        String cpf = scanner.nextLine();
        Professor professor = encontrarProfessor(cpf);
        if (professor != null) {
            System.out.print("Novo nome: ");
            String nome = scanner.nextLine();
            professor.setNome(nome);
            System.out.println("Professor atualizado!");
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    private void removerProfessor() {
        System.out.print("CPF do professor a remover: ");
        String cpf = scanner.nextLine();
        Professor professor = encontrarProfessor(cpf);
        if (professor != null) {
            professores.remove(professor);
            System.out.println("Professor removido!");
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    private void atualizarDisciplina() {
        System.out.print("Código da disciplina a atualizar: ");
        String codigo = scanner.nextLine();
        Disciplina disciplina = encontrarDisciplina(codigo);
        if (disciplina != null) {
            System.out.print("Novo nome: ");
            String nome = scanner.nextLine();
            disciplina.setNome(nome);
            System.out.println("Disciplina atualizada!");
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    private void removerDisciplina() {
        System.out.print("Código da disciplina a remover: ");
        String codigo = scanner.nextLine();
        Disciplina disciplina = encontrarDisciplina(codigo);
        if (disciplina != null) {
            disciplinas.remove(disciplina);
            System.out.println("Disciplina removida!");
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    private void removerTurma() {
        System.out.print("Código da turma a remover: ");
        String codigo = scanner.nextLine();
        Turma turma = turmas.stream().filter(t -> t.getCodigo().equals(codigo)).findFirst().orElse(null);
        if (turma != null) {
            turmas.remove(turma);
            System.out.println("Turma removida!");
        } else {
            System.out.println("Turma não encontrada.");
        }
    }
}