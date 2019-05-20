package br.com.hackstudio.model;

public class Usuario {
    private int id;
    private String username;
    private String password;
    private String password2;
    private String fk_id_funcionario;
  

    public Usuario() {
    }

    public int getId() {
        return id;
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

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getFk_id_funcionario() {
        return fk_id_funcionario;
    }

    public void setFk_id_funcionario(String fk_id_funcionario) {
        this.fk_id_funcionario = fk_id_funcionario;
    }    
    
}
