/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialeda;

import java.util.ArrayList;

/**
 *
 * @author DAIAN
 */
public class Grafo {
     private ArrayList<Sala> salas;
    private int[][] matriz;
    
    
    
    public Grafo(int cantidadSalas) {
        salas = new ArrayList<>();

        matriz = new int[cantidadSalas] [cantidadSalas];
    }

    
    public void agregarSala(Sala sala) {
        salas.add(sala);
    }

    public void agregarConexion(int origen, int destino) {
        matriz[origen][destino] = 1;
    }

    public boolean existeConexion(int origen, int destino) {
        return matriz[origen][destino] == 1;
    }

    public void mostrarGrafo() {

   // me falta armar un for

   
}
}

