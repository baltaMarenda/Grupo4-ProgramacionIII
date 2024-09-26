import java.util.Scanner;

public class actividad3FloydWarshall {
    final static int INF = 99999; // Usamos un valor grande para representar el infinito

    // Método para aplicar el algoritmo de Floyd-Warshall
    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];
        int next[][] = new int[V][V]; // Matriz para reconstruir el camino

        // Inicializar la matriz de distancias y la matriz de siguiente nodo
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != INF && i != j) {
                    next[i][j] = j; // El siguiente nodo en el camino es j
                } else {
                    next[i][j] = -1; // No hay siguiente nodo
                }
            }
        }

        // Actualizar la matriz de distancias
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k]; // Actualizar el siguiente nodo
                    }
                }
            }
        }

        // Comprobar la existencia de ciclos negativos
        if (hasNegativeCycle(dist, V)) {
            System.out.println("El grafo contiene ciclos negativos, lo que podría resultar en ahorro infinito.");
        } else {
            printSolution(dist, V);
            printShortestPath(next, V);
        }
    }

    // Método para comprobar si existe un ciclo negativo
    boolean hasNegativeCycle(int dist[][], int V) {
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                return true; // Si la distancia de un nodo a sí mismo es negativa, hay un ciclo negativo
            }
        }
        return false;
    }

    // Método para imprimir la matriz de distancias más cortas
    void printSolution(int dist[][], int V) {
        System.out.println("Matriz de tiempos mínimos de entrega entre cada par de centros de distribución:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método para imprimir el camino más corto entre dos nodos
    void printShortestPath(int next[][], int V) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nodo de origen (0 a " + (V-1) + "): ");
        int start = scanner.nextInt();
        System.out.print("Ingrese el nodo de destino (0 a " + (V-1) + "): ");
        int end = scanner.nextInt();

        if (start < 0 || start >= V || end < 0 || end >= V) {
            System.out.println("Nodos de origen o destino inválidos.");
            return;
        }

        if (next[start][end] == -1) {
            System.out.println("No hay un camino desde el nodo " + start + " hasta el nodo " + end + ".");
            return;
        }

        System.out.print("El camino más corto desde " + start + " hasta " + end + " es: " + start);
        while (start != end) {
            start = next[start][end];
            System.out.print(" -> " + start);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        actividad3FloydWarshall fwa = new actividad3FloydWarshall();

        // Grafo dado: representa tiempos de entrega entre centros de distribución
        int graph[][] = {
                { 0, 3, INF, 7 },  // Centro 0
                { 8, 0, 2, INF },  // Centro 1
                { 5, INF, 0, 1 },  // Centro 2
                { 2, INF, INF, 0 } // Centro 3
        };

        int V = graph.length;
        fwa.floydWarshall(graph, V);
    }
}
