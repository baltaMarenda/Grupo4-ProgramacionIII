package git;
import java.util.*;

class Almacen {
    private String id;
    private String nombre;

    public Almacen(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ")";
    }
}

class Grafo {
    private Map<Almacen, List<Almacen>> listaAdyacencia;

    public Grafo() {
        listaAdyacencia = new HashMap<>();
    }

    // Agregar un almacén al grafo
    public void agregarAlmacen(Almacen almacen) {
        listaAdyacencia.putIfAbsent(almacen, new ArrayList<>());
    }

    // Conectar dos almacenes con una ruta directa
    public void conectarAlmacenes(Almacen origen, Almacen destino) {
        if (listaAdyacencia.containsKey(origen) && listaAdyacencia.containsKey(destino)) {
            listaAdyacencia.get(origen).add(destino);
            listaAdyacencia.get(destino).add(origen); // Conexión bidireccional
        } else {
            System.out.println("Error: Uno o ambos almacenes no existen.");
        }
    }

    // Realizar recorrido DFS desde un almacén de inicio
    public void DFS(Almacen inicio) {
        Set<Almacen> visitados = new HashSet<>();
        System.out.println("Recorrido DFS:");
        DFSRecursivo(inicio, visitados);
        System.out.println();
    }

    private void DFSRecursivo(Almacen actual, Set<Almacen> visitados) {
        visitados.add(actual);
        System.out.println("Visitando: " + actual);

        for (Almacen vecino : listaAdyacencia.get(actual)) {
            if (!visitados.contains(vecino)) {
                DFSRecursivo(vecino, visitados);
            }
        }
    }

    // Realizar recorrido BFS desde un almacén de inicio
    public void BFS(Almacen inicio) {
        Queue<Almacen> cola = new LinkedList<>();
        Set<Almacen> visitados = new HashSet<>();

        cola.add(inicio);
        visitados.add(inicio);

        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            Almacen actual = cola.poll();
            System.out.println("Visitando: " + actual);

            for (Almacen vecino : listaAdyacencia.get(actual)) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
        System.out.println();
    }
}

public class RedDeAlmacenes {
    public static void main(String[] args) {
        Grafo redAlmacenes = new Grafo();

        // Crear almacenes
        Almacen a1 = new Almacen("1", "Almacen A");
        Almacen a2 = new Almacen("2", "Almacen B");
        Almacen a3 = new Almacen("3", "Almacen C");
        Almacen a4 = new Almacen("4", "Almacen D");

        // Agregar almacenes al grafo
        redAlmacenes.agregarAlmacen(a1);
        redAlmacenes.agregarAlmacen(a2);
        redAlmacenes.agregarAlmacen(a3);
        redAlmacenes.agregarAlmacen(a4);

        // Conectar almacenes
        redAlmacenes.conectarAlmacenes(a1, a2);
        redAlmacenes.conectarAlmacenes(a1, a3);
        redAlmacenes.conectarAlmacenes(a2, a4);
        redAlmacenes.conectarAlmacenes(a3, a4);

        // Realizar recorridos
        redAlmacenes.DFS(a1); 
        redAlmacenes.BFS(a1); 
    }
}