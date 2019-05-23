package br.com.hackstudio.model;

public class Autenticacao {
    private String senha;
    private String email;
    private String salt;
    private Encriptador encriptador;
        
    public Autenticacao() {
    }

    public Autenticacao(String senha, String email, String salt) {
        this.senha = senha;
        this.email = email;
        this.salt = salt;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    
    
}
