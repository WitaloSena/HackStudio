package br.com.hackstudio.model;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String facebook;
    private String instagram;

    public Cliente() {
    }

    public Cliente(int id, String nome, String cpf, String email, String telefone, String facebook, String instagram) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.facebook = facebook;
        this.instagram = instagram;
    }

    public Cliente(String nome, String cpf, String email, String telefone, String facebook, String instagram) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.facebook = facebook;
        this.instagram = instagram;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }
}
