package parcialeda;

import parcialeda.Sala;

public class Nodo {
    private Sala sala;
    private Nodo[] siguiente;

    public Nodo(Sala sala, Nodo siguiente1) {
        this.sala = sala;
        // se crea un nodo de tamaño uno
        this.siguiente = new Nodo[1];
        this.siguiente[0] = siguiente1;
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
            // se verifica que no sea nulo tanto el sig como la sala
            if (siguiente != null && siguiente.getSala()!= null) {
                salas++;
            }
        }

        // cartel para avanzar
        if (salas > 0) {
            System.out.println("Tenes " + salas + " salas para avanzar:");
            
            for (Nodo siguiente : this.siguiente) {
                if (siguiente != null && siguiente.getSala() != null) {
                    System.out.println("- Sala: " + siguiente.getSala().getNumeroSala());
                }
            }
        } else {
            System.out.println("No hay salas disponibles para avanzar (¡Llegaste al final!).");
        }
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