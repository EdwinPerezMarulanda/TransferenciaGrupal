// Importamos las librerías necesarias
import java.util.*;
import java.io.*;


/**
 * Un grafo es como un mapa con ciudades (nodos) y caminos (aristas).
 */
public class Grafo {
    // Declaramos los atributos de la clase Grafo
    private ArrayList<String> nodos;    // Lista que guarda todos los nodos (ciudades)
    private ArrayList<String> aristas;  // Lista que guarda todas las aristas (caminos)

    /**
     * Constructor sin parametros
     */
    public Grafo() {
        // Inicializamos las listas vacías cuando creamos un nuevo grafo
        nodos = new ArrayList<String>();    // Creamos lista vacía de nodos
        aristas = new ArrayList<String>();  // Creamos lista vacía de aristas
    }

    /**
     * Método para verificar si el grafo está vacío
     *
     * true si no tiene nodos, false si tiene nodos
     */
    public boolean estaVacio() {
        // Si el tamaño de la lista de nodos es 0, entonces está vacío
        return nodos.size() == 0;
    }

    /**
     * Método para agregar un nodo nuevo al grafo
     *
     * la variable nodo es el nombre del nodo que queremos agregar
     * true si se agregó correctamente, false si ya existía
     */
    public boolean insertarNodo(String nodo) {
        // Verificamos si el nodo ya existe en la lista
        if (!nodos.contains(nodo)) {
            // Si no existe, lo agregamos a la lista
            nodos.add(nodo);
            // Mostramos mensaje de éxito en la consola
            System.out.println("Nodo: " + nodo + " agregado");
            return true;  // Retornamos true porque se agregó correctamente
        } else {
            // Si ya existe, mostramos mensaje de error
            System.out.println("El nodo: " + nodo + " ya existe");
            return false; // Retornamos false porque no se pudo agregar
        }
    }

    /**
     * Método para agregar una arista (camino) entre dos nodos
     *
     * la variable origen es el Nodo de donde sale la arista
     * la variable destino es el Nodo a donde llega la arista
     * true si se agregó correctamente, false si ya existía
     */
    public boolean insertarArista(String origen, String destino) {
        // Primero verificamos que el nodo origen exista
        if (!nodos.contains(origen)) {
            // Si no existe, lo creamos automáticamente
            insertarNodo(origen);
        }
        // Luego verificamos que el nodo destino exista
        if (!nodos.contains(destino)) {
            // Si no existe, lo creamos automáticamente
            insertarNodo(destino);
        }

        // Creamos una representación de la arista como string
        String arista = origen + " -> " + destino;

        // Verificamos si la arista ya existe
        if (!aristas.contains(arista)) {
            // Si no existe, la agregamos a la lista
            aristas.add(arista);
            // Mostramos mensaje de éxito
            System.out.println("Arista: " + arista + " agregada");
            return true;  // Retornamos true porque se agregó correctamente
        } else {
            // Si ya existe, mostramos mensaje de error
            System.out.println("La arista: " + arista + " ya existe");
            return false; // Retornamos false porque no se pudo agregar
        }
    }

    /**
     * Método para buscar si un nodo existe en el grafo
     *
     * la variable nodo es el nodo que queremos buscar
     * true si existe, false si no existe
     */
    public boolean buscarNodo(String nodo) {
        // Verificamos si el nodo está en la lista de nodos
        if (nodos.contains(nodo)) {
            // Si existe, mostramos mensaje de éxito
            System.out.println("El nodo: " + nodo + " existe");
            return true;  // Retornamos true porque lo encontramos
        } else {
            // Si no existe, mostramos mensaje de error
            System.out.println("El nodo: " + nodo + " no existe");
            return false; // Retornamos false porque no lo encontramos
        }
    }

    /**
     * Método para mostrar todo el contenido del grafo
     */
    public void mostrarGrafo() {
        // Imprimimos un título
        System.out.println("\n********** GRAFO ACTUAL **********");
        // Mostramos todos los nodos
        System.out.println("Nodos: " + nodos);
        // Mostramos todas las aristas
        System.out.println("Aristas: " + aristas);
        // Cerramos
        System.out.println("**********************************\n");
    }
}

