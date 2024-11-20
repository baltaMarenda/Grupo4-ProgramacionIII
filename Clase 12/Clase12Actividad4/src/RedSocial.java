import java.util.*;

public class RedSocial {
    private Map<Integer, Usuario> usuarios;
    private Map<Integer, List<Integer>> adjList;

    public RedSocial() {
        this.usuarios = new HashMap<>();
        this.adjList = new HashMap<>();
    }

    // Agregar un usuario a la red social
    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
        adjList.putIfAbsent(usuario.getId(), new ArrayList<>());
    }

    // Conectar dos usuarios (amistad bidireccional)
    public void conectarUsuarios(int id1, int id2) {
        adjList.get(id1).add(id2);
        adjList.get(id2).add(id1);
    }

    // Recorrido DFS desde un usuario dado
    public void recorridoDFS(int inicioId) {
        Set<Integer> visitados = new HashSet<>();
        System.out.print("Recorrido DFS desde " + usuarios.get(inicioId) + ": ");
        dfsHelper(inicioId, visitados);
        System.out.println();
    }

    private void dfsHelper(int id, Set<Integer> visitados) {
        visitados.add(id);
        System.out.print(usuarios.get(id) + " ");

        for (int amigo : adjList.get(id)) {
            if (!visitados.contains(amigo)) {
                dfsHelper(amigo, visitados);
            }
        }
    }

    // Recorrido BFS desde un usuario dado
    public void recorridoBFS(int inicioId) {
        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> cola = new LinkedList<>();
        cola.add(inicioId);
        visitados.add(inicioId);

        System.out.print("Recorrido BFS desde " + usuarios.get(inicioId) + ": ");
        while (!cola.isEmpty()) {
            int id = cola.poll();
            System.out.print(usuarios.get(id) + " ");

            for (int amigo : adjList.get(id)) {
                if (!visitados.contains(amigo)) {
                    cola.add(amigo);
                    visitados.add(amigo);
                }
            }
        }
        System.out.println();
    }
}
