/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial;

import java.util.ArrayList;

/**
 *
 * @author janck
 */
public class Facade {
    private ArrayList<ITarea> tareas;

    public Facade() {
        tareas = new ArrayList<>();
    }

    public void agregarTarea(ITarea tarea) {
        tareas.add(tarea);
    }

    public void mostrarTareas() {
        System.out.println("Listado de tareas:");
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println((i + 1) + ". " + tareas.get(i).getDescripcion());
        }
    }

    public void ejecutarTarea(int index) {
        if (index >= 0 && index < tareas.size()) {
            tareas.get(index).ejecutar();
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public TareaCompuesta crearTareaCompuesta(String descripcion) {
        return TareaFactory.crearTareaCompuesta(descripcion);
    }
}
