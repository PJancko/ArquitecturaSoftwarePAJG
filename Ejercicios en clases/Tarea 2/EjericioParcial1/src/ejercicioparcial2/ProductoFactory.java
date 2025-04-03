/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioparcial2;

/**
 *
 * @author janck
 */
public class ProductoFactory {
    public IProducto crearProductoSimple(String descripcion, double precio) {
        return new ProductoSimple(descripcion, precio);
    }

    public IProducto crearProductoCompuesto(String descripcion) {
        return new ProductoCompuesto(descripcion);
    }
}
