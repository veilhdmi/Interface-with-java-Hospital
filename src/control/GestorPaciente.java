package control;

import modelo.*;

public class GestorPaciente {

    private Paciente[] arr; // Arreglo de personas
    private final static int MAX = 100;
    private int n; // Cantidad de personas registradas en el arreglo

    public GestorPaciente() {
        arr = new Paciente[MAX];
        n = 0;
    }

    // Operaciones
    // Longitud: Cantidad de personas en el arreglo

    public int longitud() {
        return n;
    }

    // Agregar una persona al Arreglo

    public void agregar(Paciente paciente) {
        if (n < MAX) { // hay espacio en el arreglo
            arr[n] = paciente;
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

    // Buscar un paciente

    public int posicion(int dni) {
        for (int i = 0; i < n; i++) {
            if (arr[i].getDni() == dni) {
                return i;
            }
        }
        return -1;
    }

    public Paciente iesimo(int pos) {
        if (pos >= 0 && pos < n) {
            return arr[pos];
        }
        return null;
    }

    public String mostrar() {
        String cadena = "";
        for (int i = 0; i < n; i++) {
            cadena = cadena + arr[i].getNombres() + "\n";
        }
        return cadena;
    }

    public void ordenarPorNombres() {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j].getNombres().compareTo(arr[j - 1].getNombres()) < 0) {
                    // Intercambiar
                    Paciente aux = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = aux;
                }
            }
        }
    }

    public void ordenarPorCiudad() {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j].getLugarNacimiento().
                        compareTo(arr[j - 1].getLugarNacimiento()) < 0) {
                    // Intercambiar
                    Paciente aux = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = aux;
                }
            }
        }
    }

}