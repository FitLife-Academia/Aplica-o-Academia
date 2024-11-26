package Entidades;

public class Aula {
    private String data;
    private String horario;
    private static int vagas;
    private boolean vip;

    public Aula(String data, String horario, int vagas) {
        this.horario = horario;
        this.data = data;
        Aula.vagas = vagas;
        this.vip = vip;
    }

    public String getHorario() {
        return this.horario;
    }

    public String getData() {
        return this.data;
    }

    public int getVagas() {
        return vagas;
    }

    public boolean getVip() {
        return this.vip;
    }

    public static void reduzirVagas() {
        if (vagas > 0) {
            --vagas;
        } else {
            System.out.println("Não há mais vagas disponiveis");
        }

    }
}

