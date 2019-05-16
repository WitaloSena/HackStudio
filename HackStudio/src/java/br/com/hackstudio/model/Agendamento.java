package br.com.hackstudio.model;

public class Agendamento {
    private int id;
    private String data;
    private String horario;
    private String fk_cpf_cliente;
    private int fk_id_tatuador;

    public Agendamento() {
    }

    public Agendamento(String data, String horario, String fk_cpf_cliente, int fk_id_tatuador) {
        this.data = data;
        this.horario = horario;
        this.fk_cpf_cliente = fk_cpf_cliente;
        this.fk_id_tatuador = fk_id_tatuador;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getFk_cpf_cliente() {
        return fk_cpf_cliente;
    }

    public void setFk_cpf_cliente(String fk_cpf_cliente) {
        this.fk_cpf_cliente = fk_cpf_cliente;
    }

    public int getFk_id_tatuador() {
        return fk_id_tatuador;
    }

    public void setFk_id_tatuador(int fk_id_tatuador) {
        this.fk_id_tatuador = fk_id_tatuador;
    }
}
