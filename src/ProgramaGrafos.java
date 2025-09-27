import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Clase principal con métodos
 */
public class ProgramaGrafos {

    /**
     * Método para leer una matriz de adyacencia desde un archivo txt
     *
     * nombreArchivo es el nombre del archivo que contiene la matriz
     * La matriz como array bidimensional, o null si hay error
     */
    public static int[][] leerMatrizDesdeArchivo(String nombreArchivo) {
        try {
            // Creamos un Scanner para leer el archivo
            Scanner archivo = new Scanner(new File(nombreArchivo));
            // Creamos una lista temporal para guardar las filas
            ArrayList<int[]> filas = new ArrayList<int[]>();

            // Leemos cada línea del archivo mientras haya líneas disponibles
            while (archivo.hasNextLine()) {
                // Obtenemos la línea actual y eliminamos espacios extra con trim()
                String linea = archivo.nextLine().trim();

                // Solo procesamos líneas que no estén vacías
                if (!linea.isEmpty()) {
                    // Separamos los números por espacios
                    String[] numeros = linea.split(" ");
                    // Creamos un array para esta fila
                    int[] fila = new int[numeros.length];

                    // Convertimos cada string a número entero
                    for (int i = 0; i < numeros.length; i++) {
                        fila[i] = Integer.parseInt(numeros[i]);
                    }
                    // Agregamos la fila a nuestra lista temporal
                    filas.add(fila);
                }
            }
            // Cerramos el archivo para liberar recursos
            archivo.close();

            // Convertimos ArrayList a array bidimensional
            int[][] matriz = new int[filas.size()][];  // Creamos array con el número correcto de filas
            for (int i = 0; i < filas.size(); i++) {
                matriz[i] = filas.get(i);  // Copiamos cada fila
            }

            return matriz;  // Retornamos la matriz completa

        } catch (FileNotFoundException e) {
            // Si no encontramos el archivo, mostramos error
            System.out.println("Error: No se encontró el archivo: " + nombreArchivo);
            return null;  // Retornamos null para indicar error
        } catch (Exception e) {
            // Si hay cualquier otro error, lo mostramos
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return null;  // Retornamos null para indicar error
        }
    }

    /**
     * Método para calcular los grados de entrada y salida de cada nodo
     *
     * La variable matriz es la matriz de adyacencia del grafo
     */
    public static void calcularGrados(int[][] matriz) {
        int n = matriz.length; // Obtenemos el número de nodos (filas de la matriz)

        // Mostramos título
        System.out.println("\n********** ANÁLISIS DE GRADOS (Grafo con " + n + " nodos) **********");

        // Procesamos cada nodo (cada fila/columna)
        for (int i = 0; i < n; i++) {
            // GRADO DE SALIDA: contamos las aristas que salen del nodo i
            int gradoSalida = 0;
            // Sumamos todos los valores de la fila i
            for (int j = 0; j < n; j++) {
                gradoSalida += matriz[i][j];  // Cada 1 representa una arista que sale
            }

            // GRADO DE ENTRADA: contamos las aristas que llegan al nodo i
            int gradoEntrada = 0;
            // Sumamos todos los valores de la columna i
            for (int j = 0; j < n; j++) {
                gradoEntrada += matriz[j][i];  // Cada 1 representa una arista que llega
            }

            // Mostramos los resultados para este nodo
            System.out.println("Nodo " + i + ": Grado de salida = " + gradoSalida +
                    ", Grado de entrada = " + gradoEntrada);
        }
    }

    /**
     * Método para crear un archivo
     */
    public static void crearArchivoEjemplo() {
        try {
            // Creamos un objeto PrintWriter para escribir en el archivo
            PrintWriter archivo = new PrintWriter("matriz_ejemplo.txt");

            // Escribimos cada fila de la matriz de ejemplo
            archivo.println("0 1 0 1");  // Nodo 0: conecta con nodos 1 y 3
            archivo.println("0 0 1 0");  // Nodo 1: conecta con nodo 2
            archivo.println("1 0 0 1");  // Nodo 2: conecta con nodos 0 y 3
            archivo.println("0 0 0 0");  // Nodo 3: no conecta con ninguno

            // Cerramos el archivo para guardar los cambios
            archivo.close();
            // Mostramos mensaje de éxito
            System.out.println("Archivo matriz_ejemplo.txt creado");

        } catch (Exception e) {
            // Si hay error al crear el archivo, lo mostramos
            System.out.println("Error al crear archivo: " + e.getMessage());
        }
    }

    /**
     * Método para mostrar una matriz
     *
     * La variable matriz es la matriz que queremos mostrar
     */
    public static void mostrarMatriz(int[][] matriz) {
        System.out.println("Matriz leída:");

        // Recorremos cada fila de la matriz
        for (int i = 0; i < matriz.length; i++) {
            // Mostramos el número de fila
            System.out.print("Fila " + i + ": ");

            // Recorremos cada columna de esta fila
            for (int j = 0; j < matriz[i].length; j++) {
                // Imprimimos cada elemento seguido de un espacio
                System.out.print(matriz[i][j] + " ");
            }
            // Saltamos a la siguiente línea cuando terminamos la fila
            System.out.println();
        }
    }

}
