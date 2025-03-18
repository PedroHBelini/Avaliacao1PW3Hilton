import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AlunoDAO alunoDAO = new AlunoDAO();
        int opcao;

        do {
            System.out.println("\n** CADASTRO DE ALUNOS **");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Excluir aluno");
            System.out.println("3 - Alterar aluno");
            System.out.println("4 - Buscar aluno pelo nome");
            System.out.println("5 - Listar alunos (com status de aprovação)");
            System.out.println("6 - FIM");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    //cadastrar
                    System.out.println("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o RA: ");
                    String ra = scanner.nextLine();
                    System.out.println("Digite o e-mail: ");
                    String email = scanner.nextLine();
                    System.out.println("Digite a nota 1: ");
                    double nota1 = scanner.nextDouble();
                    System.out.println("Digite a nota 2: ");
                    double nota2 = scanner.nextDouble();
                    System.out.println("Digite a nota 3: ");
                    double nota3 = scanner.nextDouble();
                    alunoDAO.cadastrar(new Aluno(nome, ra, email, nota1, nota2, nota3));
                    System.out.println("Aluno cadastrado!");
                    break;
                case 2:
                    //excluir
                    System.out.print("ID do aluno a excluir: ");
                    Long idExcluir = scanner.nextLong();
                    if (alunoDAO.buscarPorId(idExcluir) != null) {
                        alunoDAO.excluir(idExcluir);
                        System.out.println("Aluno excluído!");
                    } else {
                        System.out.println("Erro: Aluno com ID " + idExcluir + " não encontrado.");
                    }
                    break;
                case 3:
                    // Alterar
                    System.out.print("ID do aluno a alterar: ");
                    Long idAlterar = scanner.nextLong();
                    scanner.nextLine();
                    Aluno alunoAlterar = alunoDAO.buscarPorId(idAlterar);
                    if (alunoAlterar != null) {
                        System.out.println("Novo Nome: ");
                        alunoAlterar.setNome(scanner.nextLine());
                        System.out.println("Novo RA: ");
                        alunoAlterar.setRa(scanner.nextLine());
                        System.out.println("Novo Email: ");
                        alunoAlterar.setEmail(scanner.nextLine());
                        System.out.println("Nova Nota 1: ");
                        alunoAlterar.setNota1(scanner.nextDouble());
                        System.out.println("Nova Nota 2: ");
                        alunoAlterar.setNota2(scanner.nextDouble());
                        System.out.println("Nova Nota 3: ");
                        alunoAlterar.setNota3(scanner.nextDouble());
                        alunoDAO.alterar(alunoAlterar);
                        System.out.println("Aluno atualizado!");
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;
                case 4:
                    //buscar
                    System.out.print("Nome do aluno: ");
                    String nomeBusca = scanner.nextLine();
                    Aluno alunoBuscado = alunoDAO.buscarPorNome(nomeBusca);
                    System.out.println(alunoBuscado != null ? alunoBuscado : "Aluno não encontrado.");
                    break;
                case 5:
                    List<Aluno> alunos = alunoDAO.listarTodos();
                    alunos.forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }
}
