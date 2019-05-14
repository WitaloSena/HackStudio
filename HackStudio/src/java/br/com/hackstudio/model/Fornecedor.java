package br.com.hackstudio.model;

public class Fornecedor {
    private int id;
    private String nome;
    private String endereço;
    private String cnpj;

    public Fornecedor() {
        
    }
    public Fornecedor(int id, String nome, String endereço, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.endereço = endereço;
        this.cnpj = cnpj;
    }

    public Fornecedor(String nome, String endereço, String cnpj) {
        this.nome = nome;
        this.endereço = endereço;
        this.cnpj = cnpj;
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

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
