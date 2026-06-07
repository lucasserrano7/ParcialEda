/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialeda;

import objetos.Escalera;
import objetos.Fosforo;
import objetos.Lupa;

/**
 *
 * @author Ema
 */
public class Jugador {
    
    String nombreJugador;
    int putaje;
    Fosforo fosforo;
    Lupa lupa;
    Escalera escalera;

    
    //getters y setters
    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getPutaje() {
        return putaje;
    }

    public void setPutaje(int putaje) {
        this.putaje = putaje;
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
    
    
    
    
}
