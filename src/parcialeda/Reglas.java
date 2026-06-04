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
    
    static String RESET = "\u001B[0m";
    static String VERDE = "\u001B[32m";
    public static void reglas(){
        System.out.println( VERDE + "Reglas del juego:\n" + VERDE
                + "Bienvenidos a nuestro EscapeRoom, \n" + VERDE + "primero que nada queremos dejar las reglas en claro.\n"
                +  VERDE +"El objetivo principal es escapar encontrando el camino corecto y sus pistas\n"
                + "El juego cuenta con puntos que al ir avanzando iras sumando," + VERDE +"\n" + VERDE + "Cuantos podes lograr?\n"
                +  VERDE +"Solo vas a poder retroceder de sala una sola vez asi que cuidado con tus elecciones\n"
                +  VERDE +"Estas listo para el reto?? \nComenzemos..." + RESET);
    } 
}


