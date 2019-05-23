package br.com.hackstudio.dao;
import java.util.List;


public interface Dao {   
    public boolean save(Object object);
    public boolean update(Object object);
    public boolean delete(Long id);
    public Object get(Long id);
    public List<Object> get();    
}
