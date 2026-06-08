
package parcialeda;

import parcialeda.Sala;

public class Nodo {
    private Sala sala;
    private Nodo[] siguiente;

    public Nodo(Sala sala, Nodo siguiente1) {
        this.sala = sala;
        this.siguiente = new Nodo[1];
        this.siguiente[0] = siguiente1;
    }
    
    //para un nodo
    public Nodo(Sala sala) {
        this.sala = sala;
        this.siguiente = new Nodo[0];
    }

    //para 2 nodos
    public Nodo(Sala sala, Nodo siguiente1, Nodo siguiente2) {
        this.sala = sala;
        this.siguiente = new Nodo[2]; 
        this.siguiente[0] = siguiente1;
        this.siguiente[1] = siguiente2;
    }

    //para 3 nodos
    public Nodo(Sala sala, Nodo siguiente1, Nodo siguiente2, Nodo siguiente3) {
        this.sala = sala;
        this.siguiente = new Nodo[3]; 
        this.siguiente[0] = siguiente1;
        this.siguiente[1] = siguiente2;
        this.siguiente[2] = siguiente3;
    }
    
    //para 4 nodos
    public Nodo(Sala sala, Nodo siguiente1, Nodo siguiente2, Nodo siguiente3, Nodo siguiente4) {
        this.sala = sala;
        this.siguiente = new Nodo[4]; 
        this.siguiente[0] = siguiente1;
        this.siguiente[1] = siguiente2;
        this.siguiente[2] = siguiente3;
        this.siguiente[3] = siguiente4;
    }

    
    public void opcionesDeAvanzar() {
        int salas = 0;

        for (Nodo siguiente : this.siguiente) {
            if (siguiente != null && siguiente.getSala() != null) {
                salas++;
            }
        }

        if (salas > 0) {
            System.out.println("Tenes " + salas + " salas para avanzar:");
            int opcion = 1;

            for (Nodo siguiente : this.siguiente) {
                if (siguiente != null && siguiente.getSala() != null) {
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
            System.out.println("No hay salas disponibles para avanzar.");
        }
    }
        
    public Nodo avanzar(int num) {
        switch (num) {
            case 0:
                System.out.println("Saliendo de avanzar");
                return this;
            case 1:
                if (this.siguiente.length > 0 && this.siguiente[0] != null) {
                    return this.siguiente[0];
                } else {
                    return this;
                }
            case 2:
                if (this.siguiente.length > 1 && this.siguiente[1] != null) {
                    return this.siguiente[1];
                } else {
                    return this;
                }
            case 3:
                if (this.siguiente.length > 2 && this.siguiente[2] != null) {
                    return this.siguiente[2];
                } else {
                    return this;
                }
            case 4:
                if (this.siguiente.length > 3 && this.siguiente[3] != null) {
                    return this.siguiente[3];
                } else {
                    return this;
                }
            default:
                System.out.println("Saliendo de avanzar");
                return this;
        }
    }
    
    // Getters y Setters
    public Sala getSala() {
        return this.sala;
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