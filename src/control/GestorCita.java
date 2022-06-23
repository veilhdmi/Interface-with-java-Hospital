package control;

import modelo.*;

public class GestorCita {

    private Cita[] arr; // Arreglo de personas
    private final static int MAX = 100;
    private int n; // Cantidad de personas registradas en el arreglo

    public GestorCita() {
        arr = new Cita[MAX];
        n = 0;
    }

    // Operaciones
    // Longitud: Cantidad de personas en el arreglo

    public int longitud() {
        return n;
    }

    // Agregar una persona al Arreglo

    public void agregar(Cita cita) {
        if (n < MAX) { // hay espacio en el arreglo
            arr[n] = cita;
            n++;
        }
    }

    public void eliminar(int pos) {
        if (pos >= 0 && pos < n) { // La posicion existe en el arreglo
            // Desplazar los elementos a la izquieda
            for (int i = pos; i < n - 1; i++) {
                arr[i] = arr[i + 1];
            }
            n--;
        }
    }

    // Buscar una persona

    public int posicion(int numero) {
        for (int i = 0; i < n; i++) {
            if (arr[i].getNumero() == numero) {
                return i;
            }
        }
        return -1;
    }

    public Cita iesimo(int pos) {
        if (pos >= 0 && pos < n) {
            return arr[pos];
        }
        return null;
    }
}