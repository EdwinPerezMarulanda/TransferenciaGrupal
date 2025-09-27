public class Main {

    public static void main(String[] args) {
        // Mostramos el título en consola
        System.out.println("ROGRAMA DE GRAFOS PARA ESTUDIANTES\n");

        System.out.println("PARTE 1: TAD Grafo");
        System.out.println("------------------------------");

        // Creamos un nuevo objeto grafo  (vacío)
        Grafo miGrafo = new Grafo();

        // Verificamos si el grafo está vacío
        System.out.println("¿El grafo está vacío?: " + miGrafo.estaVacio());

        // Agregamos algunos nodos al grafo
        miGrafo.insertarNodo("A");
        miGrafo.insertarNodo("B");
        miGrafo.insertarNodo("C");

        // Agregamos aristas entre los nodos
        miGrafo.insertarArista("A", "B");
        miGrafo.insertarArista("B", "C");
        miGrafo.insertarArista("A", "C");

        // Probamos buscar nodos existentes y no existentes
        miGrafo.buscarNodo("A");
        miGrafo.buscarNodo("D");

        // Mostramos el estado final del grafo
        miGrafo.mostrarGrafo();


        System.out.println("\nPARTE 2: Análisis de Grados");
        System.out.println("------------------------------");

        // Creamos un archivo de ejemplo si no existe
        ProgramaGrafos.crearArchivoEjemplo();

        // Leemos la matriz desde el archivo
        int[][] matriz = ProgramaGrafos.leerMatrizDesdeArchivo("matriz_ejemplo.txt");

        // Verificamos si la matriz se leyó correctamente
        if (matriz != null) {
            // Si se leyó bien, la mostramos en pantalla
            ProgramaGrafos.mostrarMatriz(matriz);

            // Calculamos y mostramos los grados de cada nodo
            ProgramaGrafos.calcularGrados(matriz);
        }
        // Si matriz es null, significa que hubo un error y ya se mostró el mensaje

        // Mensaje final del programa
        System.out.println("\n¡Programa terminado!");
    }
}
