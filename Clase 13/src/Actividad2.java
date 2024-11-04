import java.util.*;

class Nodo {
    String nombre;
    Map<Nodo, Integer> conexiones;

    public Nodo(String nombre) {
        this.nombre = nombre;
        this.conexiones = new HashMap<>();
    }

    public void agregarConexion(Nodo destino, int costo) {
        conexiones.put(destino, costo);
    }
}

class Grafo {
    List<Nodo> nodos;

    public Grafo() {
        nodos = new ArrayList<>();
    }

    public void agregarNodo(Nodo nodo) {
        nodos.add(nodo);
    }

    public List<Nodo> obtenerNodos() {
        return nodos;
    }

    public Integer costo(Nodo origen, Nodo destino) {
        return origen.conexiones.get(destino);
    }
}

class ColaPrioridad {
    private PriorityQueue<Entrada> cola;

    public ColaPrioridad() {
        cola = new PriorityQueue<>(Comparator.comparingInt(e -> e.costo));
    }

    public void insertar(Nodo nodo, int costo) {
        cola.add(new Entrada(nodo, costo));
    }

    public Entrada extraerMin() {
        return cola.poll();
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }

    public static class Entrada {
        public Nodo nodo;
        public int costo;

        public Entrada(Nodo nodo, int costo) {
            this.nodo = nodo;
            this.costo = costo;
        }
    }
}

public class Actividad2 {
    public static int UCS(Grafo grafo, Nodo nodoInicial, Nodo nodoObjetivo) {
        ColaPrioridad colaPrioridad = new ColaPrioridad();
        colaPrioridad.insertar(nodoInicial, 0);

        Map<Nodo, Integer> costosMinimos = new HashMap<>();
        costosMinimos.put(nodoInicial, 0);

        while (!colaPrioridad.estaVacia()) {
            ColaPrioridad.Entrada entrada = colaPrioridad.extraerMin();
            Nodo nodoActual = entrada.nodo;
            int costoActual = entrada.costo;

            if (nodoActual.equals(nodoObjetivo)) {
                return costoActual;
            }

            for (Nodo vecino : nodoActual.conexiones.keySet()) {
                int costoVecino = costoActual + grafo.costo(nodoActual, vecino);

                if (!costosMinimos.containsKey(vecino) || costoVecino < costosMinimos.get(vecino)) {
                    costosMinimos.put(vecino, costoVecino);
                    colaPrioridad.insertar(vecino, costoVecino);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        Nodo A = new Nodo("A");
        Nodo B = new Nodo("B");
        Nodo C = new Nodo("C");
        Nodo D = new Nodo("D");

        grafo.agregarNodo(A);
        grafo.agregarNodo(B);
        grafo.agregarNodo(C);
        grafo.agregarNodo(D);

        A.agregarConexion(B, 1);
        A.agregarConexion(C, 4);
        B.agregarConexion(D, 2);
        C.agregarConexion(D, 1);

        int costoMinimo = UCS(grafo, A, D);
        System.out.println("El costo mínimo desde A hasta D es: " + costoMinimo);
    }
}
