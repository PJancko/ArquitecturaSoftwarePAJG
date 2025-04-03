/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejericioparcial1;

/**
 *
 * @author janck
 */
public class Libro implements ILibro {
    
    String titulo;
    String autor;
    int anio;
    String contenido;

    public Libro(String titulo, String autor, int anio, String contenido) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.contenido = contenido;
    }
    
    

    @Override
    public void leer() {
        System.out.println("Leyendo libro: "+titulo);
        System.out.println("Autor: " + autor + " | Año: " + anio);
        System.out.println("Contenido:\n" + contenido);
        
    }
    
}
