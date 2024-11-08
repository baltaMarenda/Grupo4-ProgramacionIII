import java.util.*;

public class Grafo {
    private Map<Integer, Almacen> almacenes;
    private Map<Integer, List<Integer>> adjList;

    public Grafo() {
        this.almacenes = new HashMap<>();
        this.adjList = new HashMap<>();
    }

    // Agregar un almacén al grafo
    public void agregarAlmacen(Almacen almacen) {
        almacenes.put(almacen.getId(), almacen);
        adjList.putIfAbsent(almacen.getId(), new ArrayList<>());
    }

    // Conectar dos almacenes mediante una ruta directa
    public void conectarAlmacenes(int id1, int id2) {
        adjList.get(id1).add(id2);
        adjList.get(id2).add(id1); // Asumiendo que es un grafo no dirigido
    }

    // Método DFS para recorrer en profundidad desde un almacén de inicio
    public void recorridoDFS(int inicioId) {
        Set<Integer> visitados = new HashSet<>();
        System.out.print("Recorrido DFS: ");
        dfsHelper(inicioId, visitados);
        System.out.println();
    }

    private void dfsHelper(int id, Set<Integer> visitados) {
        visitados.add(id);
        System.out.print(almacenes.get(id) + " ");

        for (int vecino : adjList.get(id)) {
            if (!visitados.contains(vecino)) {
                dfsHelper(vecino, visitados);
            }
        }
    }

    // Método BFS para recorrer en anchura desde un almacén de inicio
    public void recorridoBFS(int inicioId) {
        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> cola = new LinkedList<>();
        cola.add(inicioId);
        visitados.add(inicioId);

        System.out.print("Recorrido BFS: ");
        while (!cola.isEmpty()) {
            int id = cola.poll();
            System.out.print(almacenes.get(id) + " ");

            for (int vecino : adjList.get(id)) {
                if (!visitados.contains(vecino)) {
                    cola.add(vecino);
                    visitados.add(vecino);
                }
            }
        }
        System.out.println();
    }
}
