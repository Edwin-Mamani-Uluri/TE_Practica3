package com.emergentes.dao;

import com.emergentes.utiles.ConexionDB3;
import com.emergentes.modelo.Producto3;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
        
public class ProductoDAOimpl3 extends ConexionDB3 implements ProductoDAO3{

    @Override
    public void insert(Producto3 producto3) throws Exception {
        try{
            this.conectar3();
            PreparedStatement ps = this.conn.prepareStatement ("INSERT into productos (nombre_producto, precio, stock) values (?, ?, ?)");
            ps.setString(1, producto3.getNombre_producto());
            ps.setFloat(2, producto3.getPrecio());
            ps.setInt(3, producto3.getStock());
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar3();
        }  
    }

    @Override
    public void update(Producto3 producto3) throws Exception {
        
        try{
            this.conectar3();
            PreparedStatement ps = this.conn.prepareStatement ("UPDATE productos set nombre_producto = ?, precio = ?, stock = ? where id = ?");
            ps.setString(1, producto3.getNombre_producto());
            ps.setFloat(2, producto3.getPrecio());
            ps.setInt(3, producto3.getStock());
            ps.setInt(4, producto3.getId());
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar3();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try{
            this.conectar3();
            PreparedStatement ps = this.conn.prepareStatement ("DELETE FROM productos WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar3();
        }
    }
    
    @Override
    public Producto3 getById(int id) throws Exception {
        Producto3 pro = new Producto3();
        try{
            this.conectar3();
            PreparedStatement ps = this.conn.prepareStatement ("SELECT * FROM productos WHERE id = ? ");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pro.setId(rs.getInt("id"));
                pro.setNombre_producto(rs.getString("nombre_producto"));
                pro.setPrecio(rs.getFloat("precio"));
                pro.setStock(rs.getInt("stock"));
            }
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar3();
        }
        return pro;
    }

    @Override
    public List<Producto3> getAll() throws Exception {
        List<Producto3> lista = null;
        try{
            this.conectar3();
            PreparedStatement ps = this.conn.prepareStatement ("SELECT * FROM productos");
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Producto3>();
            while(rs.next()){
                Producto3 pro = new Producto3();
                pro.setId(rs.getInt("id"));
                pro.setNombre_producto(rs.getString("nombre_producto"));
                pro.setPrecio(rs.getFloat("precio"));
                pro.setStock(rs.getInt("stock"));
                lista.add(pro);
            }
            rs.close();
            ps.close();
        }catch(Exception e){
            throw e;
        }finally{
            this.desconectar3();
        }
        return lista;
    }
}

