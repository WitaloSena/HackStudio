package br.com.hackstudio.model;

public class Tatuador {

    private int id;
    private String nome;
    private String email;
    private String cpf;
    private String endereco;
    private String telefone;
    private String facebook;
    private String instagram;
    private String especialidade;

    public Tatuador() {
    }

    public Tatuador(String nome, String email, String cpf, String endereco, String telefone, String facebook, String instagram, String especialidade) {
        this.nome = nome;
        this.nome = email;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;  
        this.facebook = facebook;
        this.instagram = instagram;
        this.especialidade = especialidade;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereço) {
        this.endereco = endereço;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

}
