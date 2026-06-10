package parcialeda;

import java.util.Scanner;
import java.util.Stack;
import objetos.Cofre;
import objetos.Escalera;
import objetos.Fosforo;
import objetos.LLave;
import objetos.Lupa;

public class ParcialEda {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean salirDelJuego = false;
        
        while (!salirDelJuego) { 
            System.out.println("Bienvenido al Escape Room");
            System.out.println("1. Jugar a mapa ya creado");
            System.out.println("2. Crear tu propio mapa");
            System.out.println("3. Salir");
            System.out.println("Que eliges?:");
            
            switch (scan.nextInt()) {
                case 1:
                    Jugar();
                    break;
                case 2:
                    CrearMapa();
                    break;
                case 3:
                    salirDelJuego = true;
                    break;
                default:
                    System.out.println("Opcion incorrecta, elegi otra porfa");
            }
        
        }
        
        
    }
    
    public static void CrearMapa(){
        
        Scanner scanner = new Scanner(System.in);
        Grafo grafoCreado = new Grafo();
        
        System.out.println("Bienvenido al modo creador");
        System.out.println("Con cuantas salas va a tener tu juego?");
        
        int cantidadSalas = scanner.nextInt();
        scanner.nextLine();
        
        Nodo[] nodosCreados = new Nodo[cantidadSalas];
        
        for (int i = 0; i < cantidadSalas; i++) {
            System.out.println("Creando sala: "+ i);
            System.out.println("Agregale un nombre o descripcion a la sala:");
            String nombreSala = scanner.nextLine();
            
            System.out.println("Esta sala es la salida? (Escribi 'false' o 'true'(verdadero))");
            boolean essalida = scanner.nextBoolean();
            scanner.nextLine();
            
            Sala nuvaSala = new Sala(i, nombreSala, essalida, null);
            Nodo nuevoNodo = new Nodo(nuvaSala);
            
            nodosCreados[i] = nuevoNodo;
            grafoCreado.agregarNodo(nuevoNodo);
            
            System.out.println("Sala "+ nombreSala + " creada exitosamente");
        }
        
        System.out.println("todas las salas creadas");

        for (int i = 0; i < cantidadSalas; i++) {
            System.out.println("Estan en la sala: " + nodosCreados[i].getSala().getDescripcionSala());
            System.out.println("Cuantos caminos a otras salas tiene?:");
            int cantidadCaminos = scanner.nextInt();
            
            if (cantidadCaminos > 0) {
                Nodo[] sig = new Nodo[cantidadCaminos];
                int[] puntos = new int[cantidadCaminos];
                
                for (int j = 0; j < cantidadCaminos; j++) {
                    System.out.println("A que Sala lleva el camino: " + (j + 1)+ "? (De 0 a " + (cantidadSalas - 1)+ ") "  );
                    int destino = scanner.nextInt();
                    sig[j] = nodosCreados[destino];
                    
                    System.out.println("Cuantoas puntos gana el jugador por llegar  aesta sala?");
                    puntos[j] = scanner.nextInt();
                }
                nodosCreados[i].setSiguiente(sig);
                nodosCreados[i].setPuntos(puntos);
                
            }
        }
        System.out.println("Salas Conectadas!!");
        
        Nodo nActual = nodosCreados[0];
        Jugador jugarCrearMapa = new Jugador();
        
        
                System.out.println("-------------------");
        System.out.println("Comienza el juegoo..");

        String ROJO = "\u001B[31m";
        String RESET = "\u001B[0m";

        while (nActual != null) {

            if (nActual.getSala().isSalida()) {
                System.out.println("LLegaste a la salida!!");
                System.out.println("Puntaje final: " + jugarCrearMapa.getPuntaje());
                    break;
            }

            mostrarMensajeSala(nActual.getSala());

            System.out.println("Ubicacion Actual: " + nActual.getSala().getNumeroSala());
            System.out.println("Descripcion sala Actual: " + nActual.getSala().getDescripcionSala());
            System.out.println("Tu puntaje: " + ROJO + jugarCrearMapa.getPuntaje() + RESET);

            nActual = mostrarOpcionesCreadorMapa(nActual, jugarCrearMapa);
        }
        
        
    }
    
    public static Nodo mostrarOpcionesCreadorMapa(Nodo nActual, Jugador jugador) {
        Scanner scanner = new Scanner(System.in);
        boolean t = true;
        int num = 0;
        
        while (t) {
            try {
                System.out.println("1: avanzar");
                System.out.println("2: analizar sala");
                if (nActual.getSala().isAnalizada() && nActual.getSala().getObjeto() != null) {
                    System.out.println("3: agarrar objeto");
                }
                System.out.println("4: regresar a sala anterior");
                
                
                num = scanner.nextInt();
                if (num == 1 && num == 2) {
                    t = false;
                }    
            } catch (Exception e) {
                System.out.println("Prfa ingrtesa un numero");
                scanner.nextLine();
            }
        }
        
        switch (num) {
            case 1:
                System.out.println("Cuartos Para Avanzar");
                nActual.opcionesDeAvanzar();
                System.out.println("Selecione un cuarto a avanzar(o no hacer nada 0)");
                jugador.setnAnterior(nActual);
                int avanzar = scanner.nextInt();         
                nActual = nActual.avanzar(avanzar);
                
                break;
                
            case 2:
                if (jugador.getnAnterior() != null && jugador.isYaVolvioAtras() == false) {
                    System.out.println("Retrocendiendo");
                    nActual = jugador.getnAnterior();
                    jugador.setYaVolvioAtras(true);
                } else {
                    System.out.println("No puedes regresar de sala mas de una vez");
                }
                break;
        }

        return nActual;
    }

    
    public static void Jugar() {
        Reglas.reglas();
        Grafo grafo = new Grafo();

        Cofre cofre = new Cofre();
        Escalera escalera = new Escalera();
        Fosforo fosforo = new Fosforo();
        LLave llave = new LLave();
        Lupa lupa = new Lupa();

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

        nInicio.setSiguiente(new Nodo[]{nSala1, nSala2});
        nSala1.setSiguiente(new Nodo[]{nSala2, nSala4});
        nSala2.setSiguiente(new Nodo[]{nSala1, nSala5});
        nCentral.setSiguiente(new Nodo[]{nSala1, nSala2, nSala4, nSala5});
        nSala4.setSiguiente(new Nodo[]{nSala1, nSala5, nSala6});
        nSala5.setSiguiente(new Nodo[]{nSala2, nSala4, null});
        nSala6.setSiguiente(new Nodo[]{nSala4});

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
        Stack<Nodo> pilaNodos = new Stack<>();
        
        System.out.println("-------------------");
        System.out.println("Comienza el juegoo..");

        cargarTip();
        
        String ROJO = "\u001B[31m";
        String RESET = "\u001B[0m";

        while (nActual != null) {

            if (nActual.getSala().isSalida()) {
                if (jugador.getEscalera() != null) {
                    System.out.println("Colocas la escalera y alcanzas la salida.");
                    System.out.println("FELICITACIONES, ESCAPASTE DE LA MANSION!!");
                    break;
                } else {
                    System.out.println("La salida esta demasiado alta.");
                    System.out.println("nesesito una forma de llegar hasta alla arriba.");
                }
            }

            mostrarMensajeSala(nActual.getSala());

            System.out.println("Ubicacion Actual: " + nActual.getSala().getNumeroSala());
            System.out.println("Descripcion sala Actual: " + nActual.getSala().getDescripcionSala());
            System.out.println("Tu puntaje: " + ROJO + jugador.getPuntaje() + RESET);

            nActual = mostrarOpciones(nActual, jugador, nSala5, nCentral, pilaNodos);
        }
    }

    public static Nodo mostrarOpciones(Nodo nActual, Jugador jugador, Nodo sala5, Nodo nCentral, Stack<Nodo> pilaNodos) {
        Scanner scanner = new Scanner(System.in);
        boolean t = true;
        int num = 0;
        
        while (t) {
            try {
                System.out.println("1: avanzar");
                System.out.println("2: analizar sala");
                if (nActual.getSala().isAnalizada() && nActual.getSala().getObjeto() != null) {
                    System.out.println("3: agarrar objeto");
                }
                System.out.println("4: regresar a sala anterior");
                
                if (nActual.getSala().isAnalizada() && jugador.getFosforo() != null) {
                    System.out.println("5: Prender Fosforo");
                }
                
                num = scanner.nextInt();
                if (num > 0 && num < 6) {
                    t = false;
                }    
            } catch (Exception e) {
            }
        }
        
        switch (num) {
            case 1:
                System.out.println("Cuartos Para Avanzar");
                nActual.opcionesDeAvanzar();
                System.out.println("Selecione un cuarto a avanzar(o no hacer nada 0)");
                
                int avanzar = scanner.nextInt();            
                if (avanzar != 0) {
                    pilaNodos.push(nActual);
                    jugador.setnAnterior(nActual);
                    nActual = nActual.avanzar(avanzar);
                }
                
                if (nActual.getSala().getNumeroSala() == 3 && jugador.getFosforo() == null) {
                    System.out.println("Esta demasiado oscuro para entrar. Necesitas un fosforo.");
                    if (!pilaNodos.isEmpty()) {
                        nActual = pilaNodos.pop();
                    }
                }
                break;
                
            case 2:
                System.out.println("Analizando sala");
                analizarSala(nActual, jugador, sala5, nCentral);
                break;
                
            case 3:
                System.out.println("Agarrar el objeto de esta sala");
                agarrarObjeto(nActual, jugador);
                break;

            case 4:
                if (pilaNodos.isEmpty()) {
                    System.out.println("No hay salas anteriores!");
                } else if (jugador.isYaVolvioAtras()) {
                    System.out.println(" Solo podias retroceder una vez");
                } else {
                    System.out.println("Retrocediendo a la sala anterior");
                    nActual = pilaNodos.pop();
                    jugador.setYaVolvioAtras(true);
                    System.out.println("Ya no puedes retroceder mas");
                }
                break;
                
            case 5:
                if (nActual.getSala().getNumeroSala() == 5) {
                    System.out.println("Prendiendo fósforo en el laboratorio...");
                    analizarSala(nActual, jugador, sala5, nCentral);
                } else {
                    System.out.println("Prendés el fósforo, pero no parece revelar nada nuevo aquí.");
                }
                break;
        }

        return nActual;
    }

    public static void analizarSala(Nodo nActual, Jugador jugador, Nodo sala5, Nodo nCentral) {
        String AZUL_OSCURO = "\u001B[34m";
        String RESET = "\u001B[0m";

        if (nActual.getSala().getNumeroSala() == 1) {
            System.out.println(AZUL_OSCURO + "🔍 Aqui hay muchas cosas, cigarillos, polillas, nesesitaria algo para ver mas de cerca entre tantas cosas,\n no voy a meter mano sin poder ver bien" + RESET);
            nActual.getSala().setAnalizada(true);
        }

        if (nActual.getSala().getNumeroSala() == 2) {
            System.out.println(AZUL_OSCURO + "🔍 Aqui hay muchos tesoros, un cofre dorado por ahi, es muy brillante" + RESET);
            nActual.getSala().setAnalizada(true);
        }

        if (nActual.getSala().getNumeroSala() == 4) {
            System.out.println(AZUL_OSCURO + "🔍 esta habitacion esta llena de cosas fascinantes, planetas de telgopor, pinturas, microscopios y una llave reluciente" + RESET);
            nActual.getSala().setAnalizada(true);
        }
        
        if (nActual.getSala().getNumeroSala() == 3) {
            System.out.println(AZUL_OSCURO + "🔍 Prendo otro fosforo, veo una escalera áhi" + RESET);
            nActual.getSala().setAnalizada(true);
        }

        if (nActual.getSala().getNumeroSala() == 5) {
            if (jugador.getFosforo() != null) {
                jugador.getFosforo().usarFosforo();
                System.out.println(AZUL_OSCURO + "🔍 detras de un gran cuadro veo un camino para para ir a una sala oculta detras de una maquina del laboratorio" + RESET);
                sala5.setSiguiente(new Nodo[]{sala5.getSiguiente()[0], sala5.getSiguiente()[1], nCentral});
                nActual.getSala().setAnalizada(true);
            } else {
                System.out.println(AZUL_OSCURO + "🔍 No logro ver bien en esta sala, nesesito un poco de luz para ver" + RESET);
                nActual.getSala().setAnalizada(true);
            }
        }
        
        if (nActual.getSala().getNumeroSala() == 0) {
            System.out.println(AZUL_OSCURO + "🔍 No veo nada especial en este cuarto" + RESET);
            nActual.getSala().setAnalizada(true);
        }

        if (nActual.getSala().getNumeroSala() == 6) {
            System.out.println(AZUL_OSCURO + "🔍 No veo nada especial en este cuarto" + RESET);
            nActual.getSala().setAnalizada(true);
        }
    }

    public static void agarrarObjeto(Nodo nActual, Jugador jugador) {
        String VERDE_OSCURO = "\u001B[32m";
        String RESET = "\u001B[0m";

        if (nActual.getSala().getNumeroSala() == 4) {
            if (jugador.getLlave() == null) {
                LLave llave = (LLave) nActual.getSala().getObjeto();
                jugador.setLlave(llave);
                jugador.setPuntaje(jugador.getPuntaje() + 20);
                System.out.println(VERDE_OSCURO + "¡Encontraste una llave!" + RESET);
            }
        }

        if (nActual.getSala().getNumeroSala() == 2) {
            if (jugador.getLlave() == null) {
                System.out.println("El cofre esta cerrado..");
            } else {
                jugador.setLupa(new Lupa());
                jugador.setPuntaje(jugador.getPuntaje() + 30);
                System.out.println(VERDE_OSCURO + "Abriste el cofre y encontraste una lupa." + RESET);
            }
        }

        if (nActual.getSala().getNumeroSala() == 1) {
            if (jugador.getLupa() == null) {
                System.out.println("Necesitas algo para ver de cerca.");
            } else {
                Fosforo fosforo = (Fosforo) nActual.getSala().getObjeto();
                jugador.setFosforo(fosforo);
                jugador.setPuntaje(jugador.getPuntaje() + 10);
                System.out.println(VERDE_OSCURO + "Usando la lupa encontraste un fosforo." + RESET);
            }
        }

        if (nActual.getSala().getNumeroSala() == 3) {
            if (jugador.getEscalera() == null) {
                Escalera escalera = (Escalera) nActual.getSala().getObjeto();
                jugador.setEscalera(escalera);
                jugador.setPuntaje(jugador.getPuntaje() + 40);
                System.out.println(VERDE_OSCURO + "Encontraste una escalera." + RESET);
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
    
    public static void cargarTip() {
        int numero = (int) (Math.random() * 10) + 1;
        switch (numero) {
            case 1:
                System.out.println("Pista ALEATORIA A: Nesesitas algo para subir, podrias nesesitar una tirolina o una escalera");
                break;
            case 2:
                System.out.println("Pista ALEATORIA B: Una Lupa podria servir para ver entre tantas cosas");       
                break;
            case 3:
                System.out.println("Pista ALEATORIA C: la oscuridad no permite que vea bien todos los cuartos");  
                break;
            case 4:
                System.out.println("Pista ALEATORIA D: Ese cofree Dorado debe de tener algo importante  adentro para que lo hayan cerrado"); 
                break;
            case 5:
                System.out.println("Pista ALEATORIA E: Estas salas estan todas conectadas Pero que raro que entre ellas no haya una sala central");
                break;
            case 6:
                System.out.println("Pista ALEATORIA F: En el comedor seguro que hay algo que podria usar para usar en cuartos oscuros");
                break;
            case 7:
                System.out.println("Pista ALEATORIA G: Esta Mansion es muy solitaria, no creo que haya nadie adentro");
                break;
            case 8:
                System.out.println("Pista ALEATORIA H: Veo el Cartel del Mapa de la casa, las habitaciones son, 1,2,3,4,5,6,7 ");
                break;    
            case 9:
                System.out.println("Pista ALEATORIA I: A veces para abrir algo primero debes encontrar aquello que lo mantiene cerrado.");
                break;
            case 10:
                System.out.println("Pista ALEATORIA J: La libertad esta mas cerca de lo que crees, pero nadie alcanza las alturas con los pies en el suelo.");
                break;
        }
    }
}