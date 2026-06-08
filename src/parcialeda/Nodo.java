package parcialeda;

import parcialeda.Sala;

public class Nodo {
    private Sala sala;
    private Nodo[] siguiente;

    public Nodo(Sala sala, Nodo siguiente1) {
        this.sala = sala;
        // se crea un nodo de tamaño uno
        this.siguiente = new Nodo[0];
        this.siguiente[0] = siguiente1;
    }
    
    public Nodo(Sala sala) {
    this.sala = sala;
    this.siguiente = new Nodo[0];
}

   
    public Nodo(Sala sala, Nodo siguiente1, Nodo siguiente2) {
        this.sala = sala;
        //dos
        this.siguiente = new Nodo[2]; 
        this.siguiente[0] = siguiente1;
        this.siguiente[1] = siguiente2;
    }


    public Nodo(Sala sala, Nodo siguiente1, Nodo siguiente2, Nodo siguiente3) {
        this.sala = sala;
        //tres
        this.siguiente = new Nodo[3]; 
        this.siguiente[0] = siguiente1;
        this.siguiente[1] = siguiente2;
        this.siguiente[2] = siguiente3;
    }

    
public void opcionesDeAvanzar() {

    int salas = 0;

    for (Nodo siguiente : this.siguiente) {

        if (siguiente != null
                && siguiente.getSala() != null) {

            salas++;
        }
    }

    if (salas > 0) {

        System.out.println(
                "Tenes "
                + salas
                + " salas para avanzar:"
        );

        int opcion = 1;

        for (Nodo siguiente : this.siguiente) {

            if (siguiente != null
                    && siguiente.getSala() != null) {

                System.out.println(
                        opcion
                        + " - Sala "
                        + siguiente.getSala().getNumeroSala()
                        + " ("
                        + siguiente.getSala().getDescripcionSala()
                        + ")"
                );

                opcion++;
            }
        }

    } else {

        System.out.println(
                "No hay salas disponibles para avanzar."
        );
    }
}
        
    public Nodo avanzar(int num){
        switch (num) {
            case 0:
                System.out.println("Saliendo de avanzar");
                return this;
            case 1:
                if(this.siguiente[0] != null){
                return this.siguiente[0];
                }else{
                return this;
                }
            case 2:
                if(this.siguiente[1] != null){
                return this.siguiente[1];
                }else{
                return this;
                }
            case 3:
                if(this.siguiente[2] != null){
                return this.siguiente[2];
                }else{
                return this;
                }
                case 4:
                if(this.siguiente[3] != null){
                return this.siguiente[3];
                }else{
                return this;
    }
        }
    return this;
    }
    
    // Getters y Setters
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Nodo[] getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo[] siguiente) {
        this.siguiente = siguiente;
    }
}