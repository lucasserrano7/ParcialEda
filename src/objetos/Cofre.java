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
    String nombre;
    String descripcion;
    LLave llave;
    int cerradura = 10;
    Lupa lupa;

    public Cofre(String descripcion) {
        this.descripcion = "Un cofre que parece estar cerrado por un candado dorado";
        this.nombre = "cofre Dorado";
    }
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
    public LLave getLlave() {
        return llave;
    }

    public void setLlave(LLave llave) {
        this.llave = llave;
    }
    
    
}
