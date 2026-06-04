
import parcialeda.Sala;

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
    //comentario
    
    
}