/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

/**
 *
 * @author Ema
 */
public class Escalera {
    //atributos
    String descripcion;
    String nombre;

    //constructor
    public Escalera() {
        this.descripcion = " Una escalera vieja y ahuecada que podria servir para recorrer largas distancias...o alturas, no seria lindo caerse de ella";
        this.nombre = "Escalera";
    }
    
    //metodos
    public Escalera agarrarEscalera(){
        return this;
    }
    public boolean usarEscalera(){
        System.out.println(" Subiendo paso a paso con cuidado");
        return true;
    }
    //getters y setters  
    
}
