/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;


/**
 *
 * @author Ema
 */
public class Cofre {
    //atributos
    String nombre;
    String descripcion;
    LLave llave;
    int cerradura = 10;
    Lupa lupa;

    //constructor
    public Cofre() {
        this.descripcion = "Un cofre que parece estar cerrado por un candado dorado";
        this.nombre = "cofre Dorado";
    }
    
    //metodos
    public Lupa abrirCofre(){
        if(this.llave == null){
            System.out.println("No se ha insertado una llave");
        }else{
          if(cerradura == llave.abrir()){
          return lupa;
          }  
        }
    return null;
    }
    
    public void insertarLLave(LLave llave) {
        this.llave = llave;
    }
    
    public LLave getLlave() {
        return llave;
    }
    
}
