/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejericioparcial1;

/**
 *
 * @author janck
 */
public class Proxy implements ILibro {
    
    Libro libroReal;
    String usuario;

    public Proxy(Libro libroReal) {
        this.libroReal = libroReal;
        this.usuario = "";
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public boolean verificarPermisos(){
        return usuario.equals("Pablo Jancko");
    }

    @Override
    public void leer() {
        if(verificarPermisos()){
            libroReal.leer();
        }else{
            System.out.println("No tiene permisos para leer");
        }
    }
    
}
