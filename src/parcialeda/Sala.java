/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parcialeda;

/**
 *
 * @author lucas
 */
public class Sala {
    
    private int numeroSala;
    private String descripcionSala;
    private boolean salida;
    private Object objeto;
    boolean analizada = false;

    public boolean isAnalizada() {
        return analizada;
    }

    public void setAnalizada(boolean analizada) {
        this.analizada = analizada;
    }
    

// constructor
    public Sala(int numeroSala, String descripcionSala, boolean salida,Object objeto) {
        this.numeroSala = numeroSala;
        this.descripcionSala = descripcionSala;
        this.salida = salida;
        this.objeto = objeto;
    }
    
    // Getters y Setters

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public String getDescripcionSala() {
        return descripcionSala;
    }

    public void setDescripcionSala(String descripcionSala) {
        this.descripcionSala = descripcionSala;
    }

    public boolean isSalida() {
        return salida;
    }

    public void setSalida(boolean salida) {
        this.salida = salida;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }
    
    
}


