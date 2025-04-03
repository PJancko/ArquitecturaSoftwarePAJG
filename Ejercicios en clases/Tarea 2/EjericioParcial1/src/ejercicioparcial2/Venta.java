/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioparcial2;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author janck
 */
public class Venta {
    String nombreCliente;
    Date fecha;
    String tipoDocumento;
    String numeroDocumento;
    ArrayList<DetalleVenta> detalles;
    TipoPago tipoPago;

    public Venta(String nombreCliente, String tipoDocumento, String numeroDocumento) {
        this.nombreCliente = nombreCliente;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.fecha = new Date();
        this.detalles = new ArrayList<>();
    }
    
    public void agregarDetalle(DetalleVenta detalle) {
        detalles.add(detalle);
    }

    public double calcularTotal() {
        return detalles.stream().mapToDouble(DetalleVenta::getSubtotal).sum();
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public ArrayList<DetalleVenta> getDetalles() {
        return detalles;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }
    
}
