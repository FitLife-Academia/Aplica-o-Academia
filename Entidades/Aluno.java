package Entidades;

import static Entidades.Entradas.lerInteiros;
import static Entidades.Entradas.scanner;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;

import java.io.PrintStream;
import java.util.Iterator;

public class Aluno {
    private String nome;
    private List<String> aulas;
    private List<String> treinos;
    private Map<LocalDate, String> progresso;
    private String faltas;


    public static void menu_Aluno() {
        int gerencia;
        do {
            Menus.exibir_Menu_Aluno();
            Aluno.mensagem_Falta();
            gerencia = lerInteiros("Escolha uma opção");
            Menus.processar_Escolha_Aluno(gerencia);
        } while (gerencia != 4);
    }

    public static void menu_Aluno_VIP() {
        int opcao;
        do {
            Menus.exibir_Menu_Aluno_VIP();
            Aluno.mensagem_Falta();
            opcao = Entradas.lerInteiros("Escolha uma opção:");
            Menus.processar_Escolha_VIP(opcao);
        } while (opcao != 6);
    }


    public static void inscreverAula() {
        // Verificar se há um usuário logado
        if (Usuario.usuarioLogado == null) {
            System.out.println("Nenhum usuário logado.");
            return;
        }
        Usuario usuarioLogado = Usuario.usuarioLogado;


        for (Aula aula : Usuario.aulas) {
            if (aula.getVip() && !usuarioLogado.getPlano().equals("VIP")) {
                System.out.println("Essa aula é exclusiva para alunos VIP.");
            } else {
                if (aula.getVagas() > 0) {
                    System.out.println("Aula: " + aula.getData() + " às " + aula.getHorario() + " | Vagas disponíveis: " + aula.getVagas());
                    System.out.print("Você deseja se inscrever nesta aula? (sim/não): ");
                    String resposta = scanner.nextLine();

                    if (resposta.equalsIgnoreCase("sim")) {
                        aula.reduzirVagas();
                        System.out.println("Você foi inscrito com sucesso!");
                        return;
                    } else {
                        System.out.println("Você não foi inscrito na aula.");
                    }
                } else {
                    System.out.println("Aula: " + aula.getData() + " às " + aula.getHorario() + " | Sem vagas disponíveis.");
                }
            }
        }
    }

    protected static boolean ver_Faltas() {
        boolean temFalta = false;
        int quantidade = 0;
        for (String nome : Professor.faltas) {
            if (Usuario.usuarioLogado.getNome().equals(nome)) {
                temFalta = true;
                quantidade++;
            }
        }

        if (temFalta) {
            System.out.println("Você tem " + quantidade + " falta(s).");
        } else {
            System.out.println("Nenhuma falta detectada.");
        }
        return temFalta;

    }

    protected static void mensagem_Falta() {
        if (ver_Faltas()) {
            System.out.println("ALERTA VOCÊ TEM FALTAS!!!");
        }
    }
}