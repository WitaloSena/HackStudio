package br.com.hackstudio.dao;


import br.com.hackstudio.model.Funcionario;
import java.util.List;

public interface Dao {   
    public String save(Funcionario funcionario);
    public boolean update(Object object);
    public boolean delete(int id);
    public Object get(int id);
    public List<Object> get();
    public List<Object> listar();
    
}
