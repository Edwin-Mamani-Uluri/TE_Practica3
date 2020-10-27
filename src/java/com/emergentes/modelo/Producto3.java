package com.emergentes.modelo;

public class Producto3 {
private int id;
private String nombre_producto;
private float precio;
private int stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

@Override
    public String toString(){
        return "Productos{" + "id=" + id + ",nombre_producto=" + nombre_producto + ", precio=" + precio + ", stock=" + stock + "}";
    }
}
