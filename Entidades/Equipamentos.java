package Entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Equipamentos {
    private List<String> equipamentos;
    private Map<String, String> reservas;

    public static void menu_Equipamentos(){
        int gerencia;
        do {
            Menus.exibir_Menu_Equipamentos ();
            gerencia = Entradas.lerInteiros("Escolha uma opção:");
            Menus.processarEscolha(gerencia);

        }while (gerencia != 4);
    }

    public Equipamentos() {
        this.equipamentos = new ArrayList<>();
        this.reservas = new HashMap<>();
    }

    public void cadastrarEquipamentos(String nome) {
        nome = nome.toUpperCase();
        equipamentos.add(nome);
        System.out.println("Equipamento " + nome + " cadastrado!");
    }

    public void removerEquipamento(String nome) {
        nome = nome.toUpperCase();
        if (equipamentos.remove(nome)) {
            reservas.remove(nome);
            System.out.println("Equipamento " + nome + " removido!");
        } else {
            System.out.println("Equipamento " + nome + " fora do sistema!");
        }
    }

    public void listarEquipamento() {
        System.out.println("---------- Equipamentos ----------");
        for (String equipamento : equipamentos) {
            String status = reservas.containsKey(equipamento) ?
                    " (Reservado para " + reservas.get(equipamento) + ")" : "";
            System.out.println(equipamento + status);
        }
        System.out.println();
    }

    public void reservarEquipamento(String reserva, String data) {
        reserva = reserva.toUpperCase();
        if (!equipamentos.contains(reserva)) {
            System.out.println("Equipamento " + reserva + " não encontrado na lista!");
        } else if (reservas.containsKey(reserva) && reservas.get(reserva).equals(data)) {
            System.out.println("Nessa data " + data + " o equipamento já está reservado!");
        } else {
            reservas.put(reserva, data);
            System.out.println("Equipamento " + reserva + " reservado para " + data + "!");
        }
    }
}

