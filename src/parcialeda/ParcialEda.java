/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcialeda;

import java.util.Scanner;
import objetos.Cofre;
import objetos.Escalera;
import objetos.Fosforo;
import objetos.LLave;
import objetos.Lupa;

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
        Grafo grafo = new Grafo();
       
        Cofre cofre = new Cofre();
        Escalera escalera = new Escalera();
        Fosforo fosforo = new Fosforo();
        LLave llave = new LLave();
        Lupa lupa = new Lupa();
        
        
        Sala inicio = new Sala(0,"Hall de entrada",false,null);
        Sala sala1 = new Sala(1,"Biblioteca",false,fosforo);
        Sala sala2 = new Sala(2,"Cuarto de investigaciones",false,cofre);
        Sala salaCentral = new Sala(3,"Pasadizo secreto",false,escalera);
        Sala sala4 = new Sala(4,"Torre oscura",false,llave);
        Sala sala5 = new Sala(5,"Laboratorio",false,null);
        Sala sala6Escape = new Sala(6,"Laboratorio",true,null);
        
   
    
    Nodo nInicio = new Nodo(inicio);
    Nodo nSala1 = new Nodo(sala1);
    Nodo nSala2 = new Nodo(sala2);
    Nodo nCentral = new Nodo(salaCentral);
    Nodo nSala4 = new Nodo(sala4);
    Nodo nSala5 = new Nodo(sala5);
    Nodo nSala6 = new Nodo(sala6Escape);
    
 nInicio.setSiguiente(
    new Nodo[]{nSala1, nSala2}
);

nSala1.setSiguiente(
    new Nodo[]{nSala2, nSala4}
);

nSala2.setSiguiente(
    new Nodo[]{nSala1, nSala5}
);

nCentral.setSiguiente(
    new Nodo[]{nSala1, nSala2, nSala4, nSala5}
);

nSala4.setSiguiente(
    new Nodo[]{nSala1,nSala5,nSala6}
);

nSala5.setSiguiente(
    new Nodo[]{nSala2,nCentral, nSala4}
);

nSala6.setSiguiente(
    new Nodo[]{nSala4}
);


grafo.agregarNodo(nInicio);
grafo.agregarNodo(nSala1);
grafo.agregarNodo(nSala2);
grafo.agregarNodo(nCentral);
grafo.agregarNodo(nSala4);
grafo.agregarNodo(nSala5);
grafo.agregarNodo(nSala6);

grafo.mostrarGrafo();
   
        Scanner scanner =  new Scanner(System.in);
        Nodo nActual = nInicio;
        Nodo nAnterios = null;
        int puntosTotales = 0;
        boolean yaVolvioAtras = false;
        System.out.println("-------------------");
        System.out.println("Comienza el juegoo..");
        
        while (nActual != null) {            
            System.out.println("Ubicacion Actual" + nActual.getSala().getNumeroSala());
            System.out.println("Descripcion sala Actual" + nActual.getSala().getDescripcionSala());
            System.out.println("Tu puntaje: " + puntosTotales);
            nActual.opcionesDeAvanzar();
            
            usarObjeto(nActual);
            
            if(nActual.getSala().isSalida()){
                System.out.println("Ganaste");
            }
        }
        nActual.opcionesDeAvanzar();
        
        if (nActual.getSala().getNumeroSala() == 2 && inv) {
            
        }
}
 
    public static void usarObjeto(Nodo nActual){
    if (nActual.getSala().getNumeroSala() == 1) {
    
    Fosforo fosforo = (Fosforo) nActual.getSala().getObjeto();
    fosforo.usarFosforo();
    }
   
    if (nActual.getSala().getNumeroSala() == 2) {
    
    Cofre miCofre = (Cofre) nActual.getSala().getObjeto();
    miCofre.abrirCofre();
    }
    
    if (nActual.getSala().getNumeroSala() == 4) {
    
    LLave llave = (LLave) nActual.getSala().getObjeto();
    llave.agarrarLLave();
    }
    
    }
    
}
