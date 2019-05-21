package br.com.hackstudio.dao;


import br.com.hackstudio.model.Funcionario;


public interface Dao {   
    public String save(Funcionario funcionario);
    public boolean update(Object object);
    public boolean delete(int id);
    public Object get(int id); 
    
}
