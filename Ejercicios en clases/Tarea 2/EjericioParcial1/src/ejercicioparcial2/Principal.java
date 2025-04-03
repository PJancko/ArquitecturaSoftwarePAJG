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
public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VentaFacade facade = new VentaFacade();

        while (true) {
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("1. Nueva Venta");
            System.out.println("2. Agregar Producto");
            System.out.println("3. Finalizar Venta");
            System.out.println("4. Salir");
            System.out.print("Seleccione opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Tipo documento: ");
                    String tipoDoc = scanner.nextLine();
                    System.out.print("Número documento: ");
                    String numDoc = scanner.nextLine();
                    facade.iniciarNuevaVenta(nombre, tipoDoc, numDoc);
                    break;
                case 2:
                    facade.agregarProducto();
                    break;
                case 3:
                    facade.finalizarVenta();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }

    }

}
