/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial;

/**
 *
 * @author janck
 */
public class TareaFactory {
    public static TareaSimple crearTareaSimple(String descripcion) {
        return new TareaSimple(descripcion);
    }

    public static TareaCompuesta crearTareaCompuesta(String descripcion) {
        return new TareaCompuesta(descripcion);
    }
}
