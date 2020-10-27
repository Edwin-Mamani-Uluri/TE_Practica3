package com.emergentes.dao;

import com.emergentes.modelo.Producto3;
import java.util.List;

public interface ProductoDAO3 {

    public void insert(Producto3 producto3) throws Exception;
    public void update(Producto3 producto3) throws Exception;
    public void delete(int id) throws Exception;
    public Producto3 getById(int id) throws Exception;
    public List<Producto3> getAll() throws Exception;
    
}
