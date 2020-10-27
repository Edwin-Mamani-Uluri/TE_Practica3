package com.emergentes.utiles;
import java.sql.*;

public class ConexionDB3 {

    static String url = "jdbc:mysql://localhost:3306/bd_almacen";
    static String usuario = "root";
    static String password = "";
    
    protected Connection conn = null;
    
    public ConexionDB3(){
        try {
            conn = DriverManager.getConnection(url, usuario, password);
            if(conn != null){
                System.out.println("Conexion Ok: " + conn);
            }
        }catch(SQLException ex){
            System.out.println("Error de SQL: " + ex.getMessage());
        }
    }
    
    public Connection conectar3(){
        return conn;
    }
    
    public void desconectar3(){
        System.out.println("Cerrando la BD:" + conn);
        try{
            conn.close();
        }catch(SQLException ex){
            System.out.println("Error de SQL: " + ex.getMessage());
        }
    }
}
