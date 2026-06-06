/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DAIAN
 */
package parcialeda;

import java.util.ArrayList;

public class Grafo {

    private ArrayList<Nodo> nodos;

    public Grafo() {
        nodos = new ArrayList<>();
    }

    public void agregarNodo(Nodo nodo) {
        nodos.add(nodo);
    }

    public ArrayList<Nodo> getNodos() {
        return nodos;
    }

    
    
    public void mostrarGrafo() {

    for (Nodo nodo : nodos) {

        System.out.println(
            "Sala "
            + nodo.getSala().getNumeroSala()
            + " - "
            + nodo.getSala().getDescripcionSala()
        );

        for (Nodo sig : nodo.getSiguiente()) {

            if (sig != null) {

                System.out.println(
                    " -> Sala "
                    + sig.getSala().getNumeroSala()
                    + " - "
                    + sig.getSala().getDescripcionSala()
                );

            }
        }

        System.out.println();
    }
    }
}

