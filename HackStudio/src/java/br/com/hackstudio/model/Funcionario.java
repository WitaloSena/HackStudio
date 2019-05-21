package br.com.hackstudio.model;

public class Funcionario {
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String username;
    private String passwd;

    private String salt;
    private String estado;
    private String admin_level;

    public Funcionario() {
    }

    public Funcionario(String nome, String email, String cpf, String telefone, String username, String passwd, String estado, String admin_level) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.username = username;
        this.passwd = passwd;
        this.estado = estado;
        this.admin_level = admin_level;
    }
    
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAdmin_level() {
        return admin_level;
    }

    public void setAdmin_level(String admin_level) {
        this.admin_level = admin_level;
    }
 
}
