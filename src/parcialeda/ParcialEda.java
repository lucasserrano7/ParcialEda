/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parcialeda;

import com.sun.source.tree.BreakTree;
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

        //JUGADOR
        Jugador jugador = new Jugador();

        Sala inicio = new Sala(0, "Hall de entrada", false, null);
        Sala sala1 = new Sala(1, "Comedor", false, fosforo);
        Sala sala2 = new Sala(2, "Sotano de investigaciones", false, cofre);
        Sala salaCentral = new Sala(3, "Pasadizo secreto", false, escalera);
        Sala sala4 = new Sala(4, "Torre oscura", false, llave);
        Sala sala5 = new Sala(5, "Laboratorio", false, null);
        Sala sala6Escape = new Sala(6, "Salida", true, null);

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
                new Nodo[]{nSala1, nSala5, nSala6}
        );

        nSala5.setSiguiente(
                new Nodo[]{nSala2, nCentral, nSala4}
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

        Scanner scanner = new Scanner(System.in);
        Nodo nActual = nInicio;
        int puntosTotales = 0;
        System.out.println("-------------------");
        System.out.println("Comienza el juegoo..");

        while (nActual != null) {

            // Verificar si llego a la salida
            if (nActual.getSala().isSalida()) {

                if (jugador.getEscalera() != null) {

                    System.out.println("Colocas la escalera y alcanzas la salida.");
                    System.out.println("FELICITACIONES, ESCAPASTE DE LA MANSION!!");

                    break; // termina el juego

                } else {

                    System.out.println("La salida esta demasiado alta.");
                    System.out.println("Necesitas una escalera para escapar.");
                }
            }

            mostrarMensajeSala(nActual.getSala());

            System.out.println("Ubicacion Actual: "
                    + nActual.getSala().getNumeroSala());

            System.out.println("Descripcion sala Actual: "
                    + nActual.getSala().getDescripcionSala());

            System.out.println("Tu puntaje: "
                    + jugador.getPuntaje());

            nActual = mostrarOpciones(nActual, jugador);

        }
    }

    public static Nodo mostrarOpciones(Nodo nActual, Jugador jugador) {

        Scanner scanner = new Scanner(System.in);
        boolean t = true;
        int num = 0;
        while (t) {
            System.out.println("1: avanzar");
            System.out.println("2: analizar sala");
            if (nActual.getSala().isAnalizada()
                    && nActual.getSala().getObjeto() != null) {
                System.out.println("3: agarrar objeto");

            }
            System.out.println("4: regresar a sala anterior");

            num = scanner.nextInt();
            if (num > 0 && num < 5) {
                t = false;
            }
        }
        switch (num) {
            case 1:
                //avanzar
                System.out.println("Cuartos Para Avanzar");
                nActual.opcionesDeAvanzar();
                System.out.println("Selecione un cuarto a avanzar(o no hacer nada 0)");
                jugador.setnAnterior(nActual);
                int avanzar = scanner.nextInt();
                nActual = nActual.avanzar(avanzar);
                if (nActual.getSala().getNumeroSala() == 3
                        && jugador.getFosforo() == null) {

                    System.out.println(
                            "Esta demasiado oscuro para entrar. Necesitas un fosforo."
                    );

                    return nActual.avanzar(0);
                }
                break;
            case 2:
                //analizar sala
                System.out.println("Analizando sala");
                analizarSala(nActual);
                break;
            case 3:
                //agarrar objeto
                System.out.println("Agarrar el objeto de esta sala");
                agarrarObjeto(nActual, jugador);
                break;

            case 4:
                if (jugador.getnAnterior() != null && jugador.isYaVolvioAtras() == false) {

                    System.out.println("Retrocediendo a la sala anterior");
                    nActual = jugador.getnAnterior();
                    
                    jugador.setYaVolvioAtras(true);
                } else {
                    System.out.println("Solo puedes regresar en una sola oprtunidad");
                }

        }

        return nActual;
    }

    public static void analizarSala(Nodo nActual) {
        //SALA 1
        if (nActual.getSala().getNumeroSala() == 1) {
            System.out.println("Aqui hay muchas cosas, cigarillos, polillas, nesesitaria algo para ver mas de cerca entre tantas cosas,\n no voy a meter mano sin poder ver bien");
            nActual.getSala().setAnalizada(true);
        }

        //SALA 2
        if (nActual.getSala().getNumeroSala() == 2) {
            Cofre miCofre = (Cofre) nActual.getSala().getObjeto();
            nActual.getSala().setAnalizada(true);
        }

        //SALA 4
        if (nActual.getSala().getNumeroSala() == 4) {
            System.out.println("esta habitacion esta llena de cosas fascinantes, planetas de telgopor, pinturas, microscopios y una llave reluciente");
            nActual.getSala().setAnalizada(true);
        }

        //SALA 5
        if (nActual.getSala().getNumeroSala() == 5) {
            System.out.println("No logro ver bien en esta sala, nesesito un poco de luz para ver");
            nActual.getSala().setAnalizada(true);
        }
        //----RESTO----
        //SALA 0
        if (nActual.getSala().getNumeroSala() == 0) {
            System.out.println("No veo nada especial en este cuarto");
            nActual.getSala().setAnalizada(true);
        }
        //SALA 3
        if (nActual.getSala().getNumeroSala() == 3) {
            System.out.println("No veo nada especial en este cuarto");
            nActual.getSala().setAnalizada(true);
        }

        //SALA 6
        if (nActual.getSala().getNumeroSala() == 6) {
            System.out.println("No veo nada especial en este cuarto");
            nActual.getSala().setAnalizada(true);
        }
        //FIN
    }

    public static void agarrarObjeto(Nodo nActual, Jugador jugador) {
        // SALA 4 -> LLAVE
        if (nActual.getSala().getNumeroSala() == 4) {

            if (jugador.getLlave() == null) {

                LLave llave
                        = (LLave) nActual.getSala().getObjeto();

                jugador.setLlave(llave);
                jugador.setPuntaje(jugador.getPuntaje() + 20);
                System.out.println("¡Encontraste una llave!");
            }
        }

        // SALA 2 -> COFRE -> LUPA
        if (nActual.getSala().getNumeroSala() == 2) {

            if (jugador.getLlave() == null) {

                System.out.println(
                        "El cofre esta cerrado. Necesitas una llave."
                );

            } else {

                jugador.setLupa(new Lupa());
                jugador.setPuntaje(jugador.getPuntaje() + 30);

                System.out.println(
                        "Abriste el cofre y encontraste una lupa."
                );
            }
        }

        // SALA 1 -> FOSFORO
        if (nActual.getSala().getNumeroSala() == 1) {

            if (jugador.getLupa() == null) {

                System.out.println(
                        "Necesitas una lupa para buscar entre tantas cosas."
                );

            } else {

                Fosforo fosforo
                        = (Fosforo) nActual.getSala().getObjeto();

                jugador.setFosforo(fosforo);
                jugador.setPuntaje(jugador.getPuntaje() + 10);

                System.out.println(
                        "Usando la lupa encontraste un fosforo."
                );
            }
        }

        // SALA CENTRAL -> ESCALERA
        if (nActual.getSala().getNumeroSala() == 3) {

            if (jugador.getEscalera() == null) {

                Escalera escalera
                        = (Escalera) nActual.getSala().getObjeto();

                jugador.setEscalera(escalera);
                jugador.setPuntaje(jugador.getPuntaje() + 40);

                System.out.println(
                        "Encontraste una escalera."
                );
            }
        }
    }

    public static void mostrarMensajeSala(Sala sala) {

        switch (sala.getNumeroSala()) {

            case 0:
                System.out.println("\n=== HALL DE ENTRADA ===");

                break;

            case 1:
                System.out.println("\n=== COMEDOR ===");

                break;

            case 2:
                System.out.println("\n=== CUARTO DE INVESTIGACIONES ===");

                break;

            case 3:
                System.out.println("\n=== PASADIZO SECRETO ===");

                break;

            case 4:
                System.out.println("\n=== TORRE OSCURA ===");

                break;

            case 5:
                System.out.println("\n=== LABORATORIO ===");

                break;
        }
    }
}
