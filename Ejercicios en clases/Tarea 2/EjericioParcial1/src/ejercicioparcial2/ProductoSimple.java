/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioparcial2;

/**
 *
 * @author janck
 */
public class ProductoSimple implements IProducto {
    
    String descripcion;
    double precio;

    public ProductoSimple(String descripcion, double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public double getPrecio() {
        return precio;
    }
    
}
