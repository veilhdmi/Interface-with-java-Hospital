package control;

import modelo.*;

public class GestorServicio {

    private Servicio[] arr; // Arreglo de personas
    private final static int MAX = 100;
    private int n; // Cantidad de personas registradas en el arreglo

    public GestorServicio() {
        arr = new Servicio[MAX];
        n = 0;
    }

    // Operaciones
    // Longitud: Cantidad de personas en el arreglo

    public int longitud() {
        return n;
    }

    // Agregar una persona al Arreglo

    public void agregar(Servicio servicio) {
        if (n < MAX) { // hay espacio en el arreglo
            arr[n] = servicio;
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

    public int posicion(int id) {
        for (int i = 0; i < n; i++) {
            if (arr[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Servicio iesimo(int pos) {
        if (pos >= 0 && pos < n) {
            return arr[pos];
        }
        return null;
    }

    public void ordenarPorNombres() {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j].getNombre().compareTo(arr[j - 1].getNombre()) < 0) {
                    // Intercambiar
                    Servicio aux = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = aux;
                }
            }
        }
    }
}
