/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioparcial2;

/**
 *
 * @author janck
 */
public class DetalleVenta {
    IProducto producto;
    int cantidad;

    public DetalleVenta(IProducto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
    public double getSubtotal() {
        return producto.getPrecio() * cantidad;
    }

    public IProducto getProducto() {
        return producto;
    }

    public void setProducto(IProducto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
