package Entidades;

import java.util.ArrayList;

import static Entidades.Entradas.lerInteiros;
import static Entidades.Entradas.scanner;

public class Professor {
    private String nome;
    private String modalidade;
    private String senha;

    static ArrayList<Integer> chamada = new ArrayList<Integer>();
    static ArrayList<String> faltas = new ArrayList<String>();

    public Professor(String nome, String modalidade, String senha) {
        this.nome = nome;
        this.modalidade = modalidade;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getModalidade() {
        return modalidade;
    }

    public String getSenha() {
        return senha;
    }

    public static void menu_Professor() {
        int gerencia = 0;
        do {
            Menus.exibir_Professor();
            gerencia = Entradas.lerInteiros("Escolha uma opção:");
            Menus.processar_Escolha_Professor(gerencia);
        } while (gerencia != 4);
    }

    public static void cadastroAula() {

        System.out.println("Digiete data da aula:");
        String data = scanner.nextLine();
        System.out.println("Digite o horario da aula: ");
        String horario = scanner.nextLine();
        System.out.println("Digite a quantidade de vagas: ");
        int vagas = scanner.nextInt();


        Usuario.aulas.add(new Aula(data, horario, vagas));
        System.out.println("====================================");
        System.out.println("|  Aula cadastrada com sucesso 👍  |");
        System.out.println("====================================");
    }


    public static void fazerChamada() {
        Usuario.listarAlunos();
        int alunos = lerInteiros("Quantidade de alunos com falta: ");
        if (alunos != 0) {

            System.out.println("Digite os números correspondentes a cada aluno que faltou:");
            for (int i = 0; i < alunos; i++) {
                int index = scanner.nextInt();
                chamada.add(index);
            }

            System.out.println("Os seguintes alunos receberam falta:");
            for (int index : chamada) {
                faltas.add(Usuario.getAlunoPorIndice(index).getNome());
                System.out.println("- " + faltas.get(index));
            }

        }
    }
}
