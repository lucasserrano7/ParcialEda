/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialeda;

import objetos.Escalera;
import objetos.Fosforo;
import objetos.LLave;
import objetos.Lupa;


/**
 *
 * @author Ema
 */
public class Jugador {
    
    String nombreJugador;
    int puntaje;
    Fosforo fosforo;
    Lupa lupa;
    Escalera escalera;
    LLave llave;
    Nodo nAnterior;
    boolean yaVolvioAtras;

    
    //getters y setters
    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje += puntaje;
    }


    public Fosforo getFosforo() {
        return fosforo;
    }

    public void setFosforo(Fosforo fosforo) {
        this.fosforo = fosforo;
    }

    public Lupa getLupa() {
        return lupa;
    }

    public void setLupa(Lupa lupa) {
        this.lupa = lupa;
    }

    public Escalera getEscalera() {
        return escalera;
    }

    public void setEscalera(Escalera escalera) {
        this.escalera = escalera;
    }
    
    public LLave getLlave() {
    return llave;
}

public void setLlave(LLave llave) {
    this.llave = llave;
}

    public Nodo getnAnterior() {
        return nAnterior;
    }

    public void setnAnterior(Nodo nAnterior) {
        this.nAnterior = nAnterior;
    }

    public boolean isYaVolvioAtras() {
        return yaVolvioAtras;
    }

    public void setYaVolvioAtras(boolean yaVolvioAtras) {
        this.yaVolvioAtras = yaVolvioAtras;
    }
    
    
    
}
