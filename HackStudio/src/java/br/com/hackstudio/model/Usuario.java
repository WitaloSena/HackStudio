package br.com.hackstudio.model;

public class Usuario {
    private int id;
    private String username;
    private String password;
    private String fk_id_funcionario;
    private String email;

    public Usuario() {
    }

    public Usuario(String username, String password, String email, String fk_id_funcionario) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fk_id_funcionario = fk_id_funcionario;
    }
    
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFk_id_funcionario() {
        return fk_id_funcionario;
    }

    public void setFk_id_funcionario(String fk_id_funcionario) {
        this.fk_id_funcionario = fk_id_funcionario;
    }
}
