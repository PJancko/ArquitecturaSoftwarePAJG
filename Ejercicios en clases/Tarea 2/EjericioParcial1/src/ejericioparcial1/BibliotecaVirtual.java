package ejericioparcial1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author janck
 */
public class BibliotecaVirtual {

    public static void main(String[] args) {
        Libro l1 = new Libro("Principito", "Anthony", 1943, "Habia una vez un pequenio principe...");
        Proxy proxy = new Proxy(l1);
        proxy.leer();
        proxy.setUsuario("Pablo Jancko");
        proxy.leer();
    }
}
