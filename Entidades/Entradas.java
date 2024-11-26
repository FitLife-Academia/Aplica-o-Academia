package Entidades;

import java.util.Scanner;

public class Entradas {
    public static Scanner scanner = new Scanner(System.in);
    public static int lerInteiros(String mensagem) {
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensagem + " ");
                numero = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                valido = true;
            } catch (Exception e) {
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.nextLine(); // Limpa o buffer em caso de erro
            }
        }
        return numero;
    }

    public static String lerMensagens(String mensagem) {
        String texto = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.println(mensagem);
            texto = scanner.nextLine();
            if (!texto.trim().isEmpty()) {
                isValid = true;
            } else {
                System.out.println("Entrada inválida. Por favor, digite uma mensagem.");
            }
        }
        return texto;
    }
}
