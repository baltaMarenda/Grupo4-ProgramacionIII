public class Actividad1PruebaEscritorioFloydWarshall {
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

            // Imprimir la matriz de distancias
            printSolution(dist, V);
        }

        // Método para imprimir la matriz de distancias más cortas
        void printSolution(int dist[][], int V) {
            System.out.println("Matriz de distancias más cortas entre cada par de vértices:");
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
            Actividad1PruebaEscritorioFloydWarshall fwa = new Actividad1PruebaEscritorioFloydWarshall();

            // Grafo dado (4 nodos) basado en la actividad que mencionaste
            int graph[][] = {
                    { 0, 2, INF, 5 }, // Nodo 1
                    { INF, 0, INF, 4 }, // Nodo 2
                    { INF, INF, 0, INF }, // Nodo 3
                    { INF, INF, 2, 0 } // Nodo 4
            };

            int V = graph.length;
            fwa.floydWarshall(graph, V);
        }
    }

