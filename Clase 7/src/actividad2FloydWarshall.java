public class actividad2FloydWarshall {
    final static int INF = 99999; // Usamos un valor grande para representar el infinito

    // Método para aplicar el algoritmo de Floyd-Warshall
    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];

        // Inicializar la matriz de distancias
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Actualizar la matriz de distancias
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    // Si el nodo k mejora la distancia entre i y j, actualizamos
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Comprobar la existencia de ciclos negativos
        if (hasNegativeCycle(dist, V)) {
            System.out.println("El grafo contiene ciclos negativos, lo que podría resultar en ahorro infinito.");
        } else {
            // Imprimir la matriz de distancias
            printSolution(dist, V);
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

    public static void main(String[] args) {
        actividad2FloydWarshall fwa = new actividad2FloydWarshall();

        // Grafo dado: representa tiempos de entrega entre centros de distribución
        int graph[][] = {
                { 0, 3, INF, 7 },  // Centro 1
                { 8, 0, 2, INF },  // Centro 2
                { 5, INF, 0, 1 },  // Centro 3
                { 2, INF, INF, 0 } // Centro 4
        };

        int V = graph.length;
        fwa.floydWarshall(graph, V);
    }
}
