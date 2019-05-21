/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.hackstudio.dao;

import br.com.hackstudio.model.Tatuador;
import java.util.List;

/**
 *
 * @author witalo.sena
 */
public interface TatuadorDAO {

    public String save(Tatuador t);

    public boolean update(Object object);

    public boolean delete(int id);

    public Object get(int id);

    public List<Tatuador> listar();
}
