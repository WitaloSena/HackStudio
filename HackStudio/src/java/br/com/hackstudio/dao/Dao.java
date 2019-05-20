package br.com.hackstudio.dao;

import br.com.hackstudio.model.Usuario;
import java.util.List;

public interface Dao {
    public String save(Usuario usuario);
    public boolean update(Object object);
    public boolean delete(int id);
    public Object get(int id);
    public List<Object> get();
    
}
