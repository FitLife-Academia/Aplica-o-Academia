package Entidades;

import java.util.ArrayList;
import java.util.Scanner;

import static Entidades.Plano.*;

public class Usuario {
    private String nome;
    private String senha;
    private String plano;
    public static Usuario usuarioLogado;


    static ArrayList<Aula> aulas = new ArrayList<>();
    static ArrayList<Usuario> usuario = new ArrayList<>();
    static ArrayList<Professor> professores = new ArrayList<>();


    public Usuario(String nome, String senha, String plano) {
        this.nome = nome;
        this.senha = senha;
        this.plano = plano;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public  String getPlano() {
        return plano;
    }

    static Scanner sc = new Scanner(System.in);

    public static void cadastroAluno() {

        System.out.println("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite sua senha:");
        String senha = sc.nextLine();
        int opcao;
        String plano = "";
        do {
            System.out.println("Escolha o plano:");
            plano_Mensal();
            plano_Anual();
            plano_Vip();
            System.out.println("1 - Mensal\n2 - Anual\n3 - VIP");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.println("Plano mensal escolhido");
                    plano = "Mensal";
                }
                case 2 -> {
                    System.out.println("Plano Anual escolhido");
                    plano = "Anual";
                }
                case 3 -> {
                    System.out.println("Plano VIP escolhido");
                    plano = "VIP";
                }
                default -> System.out.println("Esse número não pertence à tabela. Tente novamente!");
            }
        } while (opcao < 1 || opcao > 3);


        usuario.add((new Usuario(nome, senha, plano)));
        System.out.println("🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩");
        System.out.println("🟩                                      🟩");
        System.out.println("🟩 Cadastro realizado com sucesso!✅    🟩");
        System.out.println("🟩                                      🟩");
        System.out.println("🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩");
    }


    public static boolean fazerLogin() {
        System.out.print("Digite nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = sc.nextLine();

        if (nome.equals("admin") && senha.equals("admin")) {
            System.out.println("Bem-vindo, admin!");
            Admin.menu_Admin();
            return true;
        }
        for (Professor p : professores) {
            if (p.getNome().equals(nome) && p.getSenha().equals(senha)) {
                System.out.println("Login de professor bem-sucedido!");
                Professor.menu_Professor();
                return true;
            }
        }
        for (Usuario usuario : usuario) {
            if (usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)) {
                if (usuario.getPlano().equals("VIP")) {
                    int opcao;
                    System.out.println("Bem vindo " + nome + ":");
                    usuarioLogado = usuario;
                    Aluno.menu_Aluno_VIP();
                    return true;
                }
                System.out.println("Bem vindo " + nome + ":");
                usuarioLogado = usuario;
                Aluno.menu_Aluno();
                return true;
            }
        }
        System.out.println("🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥");
        System.out.println("🟥      Acesso  inválido ❌      🟥");
        System.out.println("🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥🟥");
        return false;
    }


    public static void listarAlunos() {
        if (usuario.isEmpty()) {
            System.out.println("Nenhum usuario encontrado");
        } else {
            System.out.println("===== Lista de Alunos ======");
            for (Usuario aluno : usuario) {
                System.out.println("Numero: " + usuario.indexOf(aluno) + ", Nome: " + aluno.getNome() + ", Plano: " + aluno.getPlano());
            }
        }
    }

    public static Usuario getAlunoPorIndice(int indice) {
        if (indice < 0 || indice >= usuario.size()) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
        return usuario.get(indice);
    }

    public static void listarProfessor() {
        if (professores.isEmpty()) {
            System.out.println("Nenhum usuario encontrado");
        } else {
            System.out.println("===== Lista de Professores ======");
            for (Professor professores : professores) {
                System.out.println("= Nome: " + professores.getNome() + ", Modalidade: " + professores.getModalidade());
            }
        }
    }


}