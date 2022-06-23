/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LENOVO
 */
public class LineaCita {
    private int numeroLinea;
    private Cita cita;
    private Servicio Servicio;

    public LineaCita(int numeroLinea, Cita cita, Servicio Servicio) {
        this.numeroLinea = numeroLinea;
        this.cita = cita;
        this.Servicio = Servicio;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(int numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public Servicio getServicio() {
        return Servicio;
    }

    public void setServicio(Servicio Servicio) {
        this.Servicio = Servicio;
    }

    
}
