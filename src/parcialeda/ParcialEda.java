/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcialeda;

/**
 *
 * @author user
 */
public class ParcialEda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Reglas.reglas();
       
        Sala inicio = new Sala(0,"Hall de entrada",false);

        Sala sala1 = new Sala(1,"Biblioteca",false);

        Sala sala2 = new Sala(2,"Cuarto de investigaciones",false);

        Sala salaCentral = new Sala(3,"Pasadizo secreto",false);

        Sala sala3 = new Sala(4,"Torre oscura",true); // es la salida, por eso esta en true

        Sala sala4 = new Sala(5,"Laboratorio",false);
        
   
    
    Nodo nInicio = new Nodo(inicio);
    Nodo nSala1 = new Nodo(sala1);
    Nodo nSala2 = new Nodo(sala2);
    Nodo nCentral = new Nodo(salaCentral);
    Nodo nSala3 = new Nodo(sala3);
    Nodo nSala4 = new Nodo(sala4);
    
    
    nInicio.setSiguiente(
    new Nodo[]{nSala1, nSala2}
);

nSala1.setSiguiente(
    new Nodo[]{nSala2, nSala3}
);

nSala2.setSiguiente(
    new Nodo[]{nSala1, nSala4}
);

nCentral.setSiguiente(
    new Nodo[]{nSala1, nSala2, nSala3, nSala4}
);

nSala3.setSiguiente(
    new Nodo[]{nSala4}
);

nSala4.setSiguiente(
    new Nodo[]{nSala3,nSala2, nCentral}
);

Grafo grafo = new Grafo();

grafo.agregarNodo(nInicio);
grafo.agregarNodo(nSala1);
grafo.agregarNodo(nSala2);
grafo.agregarNodo(nCentral);
grafo.agregarNodo(nSala3);
grafo.agregarNodo(nSala4);

}
}
