package modelo;

import java.util.Calendar;
import java.util.Date;

public class Cita {
    private int numero;
    private Date fecha;
    private Paciente cliente;
    private LineaCita[] lineasCita;
    private final static int MAX = 10;
    private int numCitas;

    public Cita(int numero, Date fecha, Paciente cliente) {
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.lineasCita = new LineaCita[MAX];
        this.numCitas = 0;
    }
    public Cita() {
        this.numero = 0;
        Calendar calendar = Calendar.getInstance();
        this.fecha = calendar.getTime();
        this.numCitas = 0;
        this.lineasCita = new LineaCita[MAX];
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Paciente getCliente() {
        return cliente;
    }

    public void setCliente(Paciente cliente) {
        this.cliente = cliente;
    }

    public LineaCita[] getLineasCita() {
        return lineasCita;
    }

    public void setLineasCita(LineaCita[] lineasCita) {
        this.lineasCita = lineasCita;
    }

    public int getNumCitas() {
        return numCitas;
    }

    public void setNumCitas(int numCitas) {
        this.numCitas = numCitas;
    }
    
    public void agregarLinea(LineaCita linea) {
        if (numCitas >= 0 && numCitas < MAX) {
            lineasCita[numCitas] = linea;
            numCitas++;
        }
    }

    public void eliminar(int pos) {
        if (pos >= 0 && pos < numCitas) { // La posicion existe en el arreglo
            // Desplazar los elementos a la izquieda
            for (int i = pos; i < numCitas - 1; i++) {
                lineasCita[i] = lineasCita[i + 1];
            }
            numCitas--;
        }
    }
    
    public int numCitas(){
        return numCitas;
    }
    

}
