/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

/**
 *
 * @author user
 */
public class Fosforo {
    //atributos
    private String nombre;
    private String descripcion;

    //constructor
    public Fosforo() {
        this.nombre = "Fosforo";
        this.descripcion = "Un fosforo sin usar, nos podra alumbrar el camino a la salida?";
    }
    
    //metodos
    public Fosforo agarrarFosforo(){
        return this;
    }
    
    public static String usarFosforo(){
        return "Encendes el fosforo descubriste un camino a una sala nueva... Que habra ahi?";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
