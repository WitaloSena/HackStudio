package br.com.hackstudio.dao;

import java.util.List;

public interface Dao {   
    public boolean save(Object object);
    public boolean update(Object object);
    public boolean delete(int id);
    public Object get(int id);
    public List<Object> get();
    
}
