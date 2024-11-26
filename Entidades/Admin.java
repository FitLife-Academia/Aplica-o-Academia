package Entidades;

import static Entidades.Entradas.scanner;

public class Admin { ;


    public static void cadastrarProfessor() {
        System.out.print("Digite o nome do professor: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a modalidade do professor: ");
        String modalidade = scanner.nextLine();
        System.out.print("Digite a senha do professor: ");
        String senha = scanner.nextLine();


        Usuario.professores.add(new Professor(nome, modalidade, senha));

        System.out.println("Professor cadastrado com sucesso!");
    }



    public static void menu_Admin() {
        int gerencia;
        do {
            Menus.exibir_Menu_Admin ();
            gerencia = Entradas.lerInteiros("Escolha uma opção:");
            Menus.processar_Escolha_Admin(gerencia);

        }while (gerencia != 5);
    }

}

