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
public class TareaCompuesta implements ITarea {
    private String descripcion;
    private ArrayList<ITarea> subtareas;

    public TareaCompuesta(String descripcion) {
        this.descripcion = descripcion;
        this.subtareas = new ArrayList<>();
    }

    public void agregarTarea(ITarea tarea) {
        subtareas.add(tarea);
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public void ejecutar() {
        System.out.println("Ejecutando tarea compuesta: " + descripcion);
        for (ITarea tarea : subtareas) {
            tarea.ejecutar();
        }
    }
}
