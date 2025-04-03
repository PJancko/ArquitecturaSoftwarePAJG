/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioparcial2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author janck
 */
public class ProductoCompuesto implements IProducto {
    
    String descripcion;
    List<IProducto> componentes;
    List<Integer> cantidades;
    
    public ProductoCompuesto(String descripcion) {
        this.descripcion = descripcion;
        this.componentes = new ArrayList<>();
        this.cantidades = new ArrayList<>();
    }
    
    public void agregarComponente(IProducto producto, int cantidad){
        componentes.add(producto);
        cantidades.add(cantidad);
    }
    
    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public double getPrecio() {
        double total = 0;
        for (int i = 0; i < componentes.size(); i++) {
            total += componentes.get(i).getPrecio() * cantidades.get(i);
        }
        return total;
    }
    
}
