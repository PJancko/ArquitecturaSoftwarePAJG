/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial;

import java.util.Scanner;

/**
 *
 * @author janck
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Facade gestor = new Facade();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú de Gestión de Tareas ---");
            System.out.println("1. Crear tarea simple");
            System.out.println("2. Crear tarea compuesta");
            System.out.println("3. Mostrar tareas");
            System.out.println("4. Ejecutar tarea");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Descripción de la tarea simple: ");
                    String descSimple = scanner.nextLine();
                    TareaSimple tareaSimple = TareaFactory.crearTareaSimple(descSimple);
                    gestor.agregarTarea(tareaSimple);
                    break;

                case 2:
                    System.out.print("Descripción de la tarea compuesta: ");
                    String descCompuesta = scanner.nextLine();
                    TareaCompuesta tareaCompuesta = gestor.crearTareaCompuesta(descCompuesta);

                    System.out.print("¿Cuántas subtareas desea agregar?: ");
                    int n = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < n; i++) {
                        System.out.print("Descripción de subtarea " + (i + 1) + ": ");
                        String subDesc = scanner.nextLine();
                        tareaCompuesta.agregarTarea(TareaFactory.crearTareaSimple(subDesc));
                    }

                    gestor.agregarTarea(tareaCompuesta);
                    break;

                case 3:
                    gestor.mostrarTareas();
                    break;

                case 4:
                    gestor.mostrarTareas();
                    System.out.print("Número de tarea a ejecutar: ");
                    int index = scanner.nextInt() - 1;
                    gestor.ejecutarTarea(index);
                    break;

                case 5:
                    salir = true;
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
