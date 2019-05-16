package br.com.hackstudio.model;

public class Estoque {
    private int id;
    private String nome;
    private String quantidade;
    private double valor_unitario;
    private int fk_id_fornecedor;

    public Estoque() {
    }

    public Estoque(String nome, String quantidade, double valor_unitario, int fk_id_fornecedor) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor_unitario = valor_unitario;
        this.fk_id_fornecedor = fk_id_fornecedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public int getFk_id_fornecedor() {
        return fk_id_fornecedor;
    }

    public void setFk_id_fornecedor(int fk_id_fornecedor) {
        this.fk_id_fornecedor = fk_id_fornecedor;
    }
}
