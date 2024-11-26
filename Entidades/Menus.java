package Entidades;

import java.time.LocalDate;

import static Entidades.Admin.*;
import static Entidades.Aluno.inscreverAula;
import static Entidades.Aluno.ver_Faltas;

import static Entidades.Entradas.*;
import static Entidades.Pagamento.*;
import static Entidades.Professor.*;
import static Entidades.Usuario.*;


public class Menus {
    private static Equipamentos academia = new Equipamentos();

    public static void exibir_Menu_Equipamentos() {
        System.out.println("|----------------------------------------------------|");
        System.out.println("|                 Menu Equipamentos                  |");
        System.out.println("|----------------------------------------------------|");
        System.out.println("| 1- Cadastrar Equipamento  | 2- Remover Equipamento |");
        System.out.println("| 3- Listar Equipamentos    | 4- sair                |");
        System.out.println("|----------------------------------------------------|");
    }


    public static void processarEscolha(int opcao) {
        switch (opcao) {
            case 1 -> cadastrarEquipamentos();
            case 2 -> removerEquipamentos();
            case 3 -> listarEquipamentos();
            case 4 -> System.out.println("Encerrado!");
            default -> System.out.println("Esse número não pertence à tabela. Tente novamente!");
        }
    }


    private static void cadastrarEquipamentos() {
        int quantidade = lerInteiros("Quantos equipamentos deseja cadastrar?");
        for (int i = 0; i < quantidade; i++) {
            System.out.print("Informe o equipamento para cadastro: ");
            academia.cadastrarEquipamentos(scanner.nextLine());
        }
    }


    private static void removerEquipamentos() {
        int quantidade = lerInteiros("Quantos equipamentos deseja remover?");
        for (int i = 0; i < quantidade; i++) {
            System.out.print("Informe o equipamento que deseja remover: ");
            academia.removerEquipamento(scanner.nextLine());
        }
    }


    private static void listarEquipamentos() {
        academia.listarEquipamento();
    }

    private static void reservarEquipamentos() {
        int quantidade = lerInteiros("Quantos equipamentos deseja reservar?");
        for (int i = 0; i < quantidade; i++) {
            String nome = lerMensagens("Informe o equipamento que deseja reservar: ");
            System.out.print("Informe a data da reserva: ");
            String data = scanner.nextLine();
            academia.reservarEquipamento(nome, data);
        }
    }


    public static void exibir_Menu_Aluno() {
        System.out.println("|=============================================|");
        System.out.println("|          Bem-vindo à área do Aluno          |");
        System.out.println("|=============================================|");
        System.out.println("|    1. Inscrever-se na aula                  |");
        System.out.println("|    2. Ver faltas                            |");
        System.out.println("|    3. Relatório de Boletos                  |");
        System.out.println("|    4. Sair                                  |");
        System.out.println("|=============================================|");
    }


    public static void processar_Escolha_Aluno(int opcao) {
        switch (opcao) {
            case 1 -> Aluno.inscreverAula();
            case 2 -> Aluno.ver_Faltas();
            case 3 -> relatorios(usuarioLogado.getPlano());
            case 4 -> System.out.println("Voltando ao menu principal...");
            default -> System.out.println("Esse número não pertence à tabela. Tente novamente!");
        }
    }


    public static void exibir_Professor() {
        System.out.println("|=============================================|");
        System.out.println("|        Bem-vindo à área do Professor        |");
        System.out.println("|=============================================|");
        System.out.println("|    1. Criar Aulas                           |");
        System.out.println("|    2. Fazer Chamada                         |");
        System.out.println("|    3. Lista de aluno                        |");
        System.out.println("|    4. Sair                                  |");
        System.out.println("|=============================================|");
    }


    public static void processar_Escolha_Professor(int opcao) {
        switch (opcao) {
            case 1 -> cadastroAula();
            case 2 -> fazerChamada();
            case 3 -> Usuario.listarAlunos();
            case 4 -> System.out.println("Saindo...");
            default -> System.out.println("Esse número não pertence à tabela. Tente novamente!");
        }
    }


    public static void exibir_Login_Cadastro() {
        System.out.println("____________________________________________________");
        System.out.println("|  ======      BEM VINDO A FITLIFE      ======     |");
        System.out.println("|              ___________________                 |");
        System.out.println("|              | 1. FAZER  LOGIN |                 |");
        System.out.println("|              -------------------                 |");
        System.out.println("|              __________________                  |");
        System.out.println("|              | 2. CADASTRE-SE |                  |");
        System.out.println("|              ------------------                  |");
        System.out.println("|     3.  SAIR ❌                                  |");
        System.out.println("----------------------------------------------------");
    }

    public static void processar_Escolha_Login_Cadastro(int opcao) {
        switch (opcao) {
            case 1 -> Usuario.fazerLogin();
            case 2 -> Usuario.cadastroAluno();
            case 3 -> System.out.println("Saindo...");
            default -> System.out.println("Esse número não pertence à tabela. Tente novamente!");
        }
    }

    public static void exibir_Menu_Admin(){
        System.out.println("|=============================================|");
        System.out.println("|          Bem-vindo à área do Admin          |");
        System.out.println("|=============================================|");
        System.out.println("|    1. Cadastra Professor                    |");
        System.out.println("|    2. Lista de Professores                  |");
        System.out.println("|    3. Lista Alunos                          |");
        System.out.println("|    4. Equipamentos                          |");
        System.out.println("|    5. Sair                                  |");
        System.out.println("|=============================================|");
    }

    public static void processar_Escolha_Admin(int opcao) {
        switch (opcao) {
            case 1 -> cadastrarProfessor();
            case 2 -> listarProfessor();
            case 3 -> Usuario.listarAlunos();
            case 4 -> Equipamentos.menu_Equipamentos();
            case 5 -> System.out.println("Saindo...");
            default -> System.out.println("Esse número não pertence à tabela. Tente novamente!");
        }
    }

    public static void exibir_Menu_Aluno_VIP() {
        System.out.println("|=============================================|");
        System.out.println("|          Bem-vindo à área do Aluno          |");
        System.out.println("|=============================================|");
        System.out.println("|    1. Inscrever-se na aula                  |");
        System.out.println("|    2. Ver faltas                            |");
        System.out.println("|    3. Relatório de Boletos                  |");
        System.out.println("|    4. Lista de equipamentos                 |");
        System.out.println("|    5. Reservar equipamento                  |");
        System.out.println("|    6. Sair                                  |");
        System.out.println("|=============================================|");
    }

    public static void processar_Escolha_VIP(int opcao) {
        switch (opcao) {
            case 1 -> Aluno.inscreverAula();
            case 2 -> Aluno.ver_Faltas();
            case 3 -> relatorioVip();
            case 4 -> listarEquipamentos();
            case 5 -> reservarEquipamentos();
            case 6 -> System.out.println("Voltando ao menu principal...");
            default -> System.out.println("Esse número não pertence à tabela. Tente novamente!");
        }
    }
}



