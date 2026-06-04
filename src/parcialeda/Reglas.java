/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialeda;

/**
 *
 * @author user
 */

public class Reglas {
    public static void reglas(){
        System.out.println("Reglas del juego: ");
    } 

public class Nodo {
    Sala sala;
    
    Nodo Siguiente;
    Nodo Siguiente2;
    Nodo Siguiente3;

    //constructor solo para un nodo siguiente
    public Nodo(Sala sala, Nodo Siguiente) {
        this.sala = sala;
        this.Siguiente = Siguiente;
    }
    //constructor para dos nodos siguientes
    public Nodo(Sala sala, Nodo Siguiente, Nodo Siguiente2) {
        this.sala = sala;
        this.Siguiente = Siguiente;
        this.Siguiente2 = Siguiente2;
    }
    //constructor para 3 nodos siguientes
    public Nodo(Sala sala, Nodo Siguiente, Nodo Siguiente2, Nodo Siguiente3) {
        this.sala = sala;
        this.Siguiente = Siguiente;
        this.Siguiente2 = Siguiente2;
        this.Siguiente3 = Siguiente3;
    }
    
    
    
}
