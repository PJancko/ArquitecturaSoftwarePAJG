/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioparcial2;

import java.util.Scanner;

/**
 *
 * @author janck
 */
public class VentaFacade {
    Venta ventaActual;
    ProductoFactory productoFactory;
    Scanner scanner;
    
    public VentaFacade() {
        productoFactory = new ProductoFactory();
        scanner = new Scanner(System.in);
    }
    
    public void iniciarNuevaVenta(String nombreCliente, String tipoDocumento, String numeroDocumento) {
        ventaActual = new Venta(nombreCliente, tipoDocumento, numeroDocumento);
    }

    public void agregarProducto() {
        if (ventaActual == null) {
            System.out.println("Inicie una venta primero.");
            return;
        }

        System.out.println("Tipo de producto (1=Simple, 2=Compuesto):");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            System.out.println("Descripción:");
            String desc = scanner.nextLine();
            System.out.println("Precio:");
            double precio = scanner.nextDouble();
            System.out.println("Cantidad:");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            IProducto producto = productoFactory.crearProductoSimple(desc, precio);
            ventaActual.agregarDetalle(new DetalleVenta(producto, cantidad));
        } else if (tipo == 2) {
            System.out.println("Descripción del compuesto:");
            String desc = scanner.nextLine();
            ProductoCompuesto compuesto = (ProductoCompuesto) productoFactory.crearProductoCompuesto(desc);

            boolean agregarComponentes = true;
            while (agregarComponentes) {
                System.out.println("Agregar componente simple:");
                System.out.println("Descripción:");
                String descComp = scanner.nextLine();
                System.out.println("Precio:");
                double precioComp = scanner.nextDouble();
                System.out.println("Cantidad en el compuesto:");
                int cantComp = scanner.nextInt();
                scanner.nextLine();

                IProducto componente = productoFactory.crearProductoSimple(descComp, precioComp);
                compuesto.agregarComponente(componente, cantComp);

                System.out.println("¿Agregar otro componente? (s/n)");
                agregarComponentes = scanner.nextLine().equalsIgnoreCase("s");
            }

            System.out.println("Cantidad del compuesto en venta:");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            ventaActual.agregarDetalle(new DetalleVenta(compuesto, cantidad));
        } else {
            System.out.println("Opción inválida.");
        }
    }

    public void finalizarVenta() {
        if (ventaActual == null) {
            System.out.println("No hay venta activa.");
            return;
        }

        System.out.println("\n--- Detalle de Venta ---");
        for (DetalleVenta detalle : ventaActual.getDetalles()) {
            System.out.printf("%s x%d - $%.2f%n",
                    detalle.getProducto().getDescripcion(),
                    detalle.getCantidad(),
                    detalle.getSubtotal());
        }
        System.out.printf("Total: $%.2f%n", ventaActual.calcularTotal());

        System.out.println("Tipo de pago (1=Efectivo, 2=Tarjeta, 3=Transferencia):");
        int pago = scanner.nextInt();
        scanner.nextLine();

        switch (pago) {
            case 1:
                ventaActual.setTipoPago(TipoPago.Efectivo);
                break;
            case 2:
                ventaActual.setTipoPago(TipoPago.Tarjeta_Credito);
                break;
            case 3:
                ventaActual.setTipoPago(TipoPago.Transferencia);
                break;
            default:
                System.out.println("Opción inválida, usando Efectivo.");
                ventaActual.setTipoPago(TipoPago.Efectivo);
        }

        System.out.println("Venta finalizada con éxito.");
        ventaActual = null;
    }
}
