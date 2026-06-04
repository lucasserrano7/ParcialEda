/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

/**
 *
 * @author Ema
 */
public class LLave {
    //atributos
    String descripcion;
    String nombre;
    
    //constructor
    public LLave() {
        this.descripcion = " Una llave dorado que podria ser usada para abri una puerda, armario o otra ceradura";
        this.nombre =  "LLave Dorada";
    }
    
     //metodos
    public int abrir(){
        return 10;
    }

    public LLave agarrarLLave(){
        return this;
    }
    
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
