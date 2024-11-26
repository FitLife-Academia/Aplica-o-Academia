import Entidades.Menus;
import Entidades.Entradas;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] kaielly) {

        int opcao;
        do {
            Menus.exibir_Login_Cadastro();
            opcao = Entradas.lerInteiros("Escolha uma opção:");
            Menus.processar_Escolha_Login_Cadastro(opcao);

        } while (opcao != 3);

    }
}


