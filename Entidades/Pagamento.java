package Entidades;


import static Entidades.Entradas.scanner;
import java.time.LocalDate;

public class Pagamento {

    private static boolean pagamentoAntecipado;

    public Pagamento() {
        this.pagamentoAntecipado = false;
    }

    public void verificarPagamentoAntecipado(int diaCadastro) {
        LocalDate hoje = LocalDate.now();
        int diaAtual = hoje.getDayOfMonth();
        System.out.println("Hoje é dia: " + diaAtual);

        if (diaAtual == diaCadastro) {
            this.pagamentoAntecipado = false;
            System.out.println("Pagamento no dia do cadastro, sem desconto.");
        } else {
            this.pagamentoAntecipado = true;
            System.out.println("Pagamento antecipado, desconto aplicado!");
        }
    }

    public static void relatorios(String opcao){
            switch (opcao) {
                case "Mensal" -> relatorioMensal();
                case "Anual" -> relatorioAnual();
                case "VIP" -> relatorioVip();
                default -> System.out.println("Esse número não pertence à tabela. Tente novamente!");
            }
    }

    public static void relatorioMensal() {
        double valor = 2000.00;
        if (pagamentoAntecipado) {
            valor = valor * 0.10; // Aplicar desconto de 10%
        }

        System.out.println("|--------------------------------------------------------|");
        System.out.println("|                      Plano Mensal                      |");
        System.out.println("|--------------------------------------------------------|");
        System.out.printf("|Detalhes Financeiros: R$ %.2f                            |\n", valor);
        System.out.println("|--------------------------------------------------------|");
        System.out.println("|Benefícios Incluídos:                                   |");
        System.out.println("|Sessões com personal Trainers;                          |");
        System.out.println("|Acesso às aulas fitness, como yoga e zumba              |");
        System.out.println("|--------------------------------------------------------|");
        System.out.println("|                  Pagamentos e Descontos                |");
        System.out.println("|Forma de Pagamento: Mensal                              |");
        if (pagamentoAntecipado) {
            System.out.println("|Desconto aplicado: de 10% na primeira mensalidade   |");
        } else {
            System.out.println("|Desconto aplicado: Nenhum                           |");
        }
        System.out.println("|--------------------------------------------------------|");
        System.out.println("|                        Contato                         |");
        System.out.println("|E-mail: Academia@gmail.com                              |");
        System.out.println("|Telefone: (99)999999999                                 |");
        System.out.println("|--------------------------------------------------------|");
    }

    public static void relatorioAnual() {
        double valor = 24000.00;
        if (pagamentoAntecipado) {
            valor = valor * 0.90; // Aplicar desconto de 10%
        }

        System.out.println("|--------------------------------------------------------|");
        System.out.println("|                      Plano Anual                       |");
        System.out.printf("|Detalhes Financeiros: R$ %.2f                            |\n", valor);
        System.out.println("|--------------------------------------------------------|");
        System.out.println("|Benefícios Incluídos:                                   |");
        System.out.println("|Sessões com personal Trainers;                          |");
        System.out.println("|Acesso às aulas fitness, como yoga e zumba;             |");
        System.out.println("|Desconto em produtos vendidos na Academia;              |");
        System.out.println("|Acesso exclusivo a eventos e workshops;                 |");
        System.out.println("|--------------------------------------------------------|");
        System.out.println("|                  Pagamentos e Descontos                |");
        System.out.println("|Forma de Pagamento: Anual                               |");
        if (pagamentoAntecipado) {
            System.out.println("|Desconto aplicado: de 10% para pagamento antecipado |");
        } else {
            System.out.println("|Desconto aplicado: Nenhum                           |");
        }
        System.out.println("|--------------------------------------------------------|");
        System.out.println("|                        Contato                         |");
        System.out.println("|E-mail: Academia@gmail.com                              |");
        System.out.println("|Telefone: (99)999999999                                 |");
        System.out.println("|--------------------------------------------------------|");
    }

    public static void relatorioVip() {
        double valor = 30000.00;
        if (pagamentoAntecipado) {
            valor = valor * 0.85; // Aplicar desconto de 15%
        }

        System.out.println("|--------------------------------------------------------|");
        System.out.println("|                      Plano VIP                         |");
        System.out.printf("|Detalhes Financeiros: R$ %.2f                            |\n", valor);
        System.out.println("|--------------------------------------------------------|");
        System.out.println("|Benefícios Incluídos:                                   |");
        System.out.println("|Sessões com personal Trainers;                          |");
        System.out.println("|Acesso às aulas fitness, como yoga e zumba;             |");
        System.out.println("|Desconto em produtos vendidos na Academia;              |");
        System.out.println("|Acesso exclusivo a eventos e workshops;                 |");
        System.out.println("|Consultas mensais com nutricionista;                    |");
        System.out.println("|Podem realizar reservas de equipamentos;                |");
        System.out.println("|--------------------------------------------------------|");
        System.out.println("|                  Pagamentos e Descontos                |");
        System.out.println("|Forma de Pagamento: VIP                                 |");
        if (pagamentoAntecipado) {
            System.out.println("|Desconto aplicado: de 15% para pagamento antecipado |");
        } else {
            System.out.println("|Desconto aplicado: Nenhum                           |");
        }
        System.out.println("|--------------------------------------------------------|");
        System.out.println("|                        Contato                         |");
        System.out.println("|E-mail: Academia@gmail.com                              |");
        System.out.println("|Telefone: (99)999999999                                 |");
        System.out.println("|--------------------------------------------------------|");
    }
}
