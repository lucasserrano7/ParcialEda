
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;


public class Lupa {
    //atributos
    private String nombre ;
    private String descripcion; 
    
    //constructor
    public Lupa() {
        this.nombre = "Lupa Usada";
        this.descripcion = "Una lupa muy usada, puede ser muy util";
    }
    
    //metodos
    public Lupa agarrarLupa(){
        return this;
    }
    
    public static String usarLupa(){
        return "Miras atentamente con la lupa... Que es eso? un fosforo quizas nos sirva para escapar";
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
