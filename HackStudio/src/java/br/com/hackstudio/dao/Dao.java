package br.com.hackstudio.dao;

<<<<<<< HEAD

import br.com.hackstudio.model.Funcionario;

=======
import java.util.List;
>>>>>>> 93eb372e3f10064a1737c5fce641c8f3c437cbe9

public interface Dao {   
    public boolean save(Object object);
    public boolean update(Object object);
    public boolean delete(int id);
<<<<<<< HEAD
    public Object get(int id); 
=======
    public Object get(int id);
    public List<Object> get();
>>>>>>> 93eb372e3f10064a1737c5fce641c8f3c437cbe9
    
}
