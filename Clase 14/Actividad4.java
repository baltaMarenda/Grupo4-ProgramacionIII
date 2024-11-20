package git;

import java.util.*;

class Usuario {
    private String id;
    private String nombre;

    public Usuario(String id, String nombre) {
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

class RedSocial {
    private Map<Usuario, List<Usuario>> listaAdyacencia;

    public RedSocial() {
        listaAdyacencia = new HashMap<>();
    }

    // Agregar un usuario a la red social
    public void agregarUsuario(Usuario usuario) {
        listaAdyacencia.putIfAbsent(usuario, new ArrayList<>());
    }

    // Conectar dos usuarios como amigos
    public void conectarUsuarios(Usuario usuario1, Usuario usuario2) {
        if (listaAdyacencia.containsKey(usuario1) && listaAdyacencia.containsKey(usuario2)) {
            listaAdyacencia.get(usuario1).add(usuario2);
            listaAdyacencia.get(usuario2).add(usuario1); // Conexión bidireccional
        } else {
            System.out.println("Error: Uno o ambos usuarios no existen en la red.");
        }
    }

    // Realizar recorrido DFS desde un usuario dado
    public void DFS(Usuario inicio) {
        Set<Usuario> visitados = new HashSet<>();
        System.out.println("Recorrido DFS:");
        DFSRecursivo(inicio, visitados);
        System.out.println();
    }

    private void DFSRecursivo(Usuario actual, Set<Usuario> visitados) {
        visitados.add(actual);
        System.out.println("Visitando: " + actual);

        for (Usuario amigo : listaAdyacencia.get(actual)) {
            if (!visitados.contains(amigo)) {
                DFSRecursivo(amigo, visitados);
            }
        }
    }

    // Realizar recorrido BFS desde un usuario dado
    public void BFS(Usuario inicio) {
        Queue<Usuario> cola = new LinkedList<>();
        Set<Usuario> visitados = new HashSet<>();

        cola.add(inicio);
        visitados.add(inicio);

        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            Usuario actual = cola.poll();
            System.out.println("Visitando: " + actual);

            for (Usuario amigo : listaAdyacencia.get(actual)) {
                if (!visitados.contains(amigo)) {
                    visitados.add(amigo);
                    cola.add(amigo);
                }
            }
        }
        System.out.println();
    }
}

public class RedSocialMain {
    public static void main(String[] args) {
        RedSocial red = new RedSocial();

        // Crear usuarios
        Usuario u1 = new Usuario("1", "Alice");
        Usuario u2 = new Usuario("2", "Bob");
        Usuario u3 = new Usuario("3", "Carlos");
        Usuario u4 = new Usuario("4", "Diana");

        // Agregar usuarios a la red
        red.agregarUsuario(u1);
        red.agregarUsuario(u2);
        red.agregarUsuario(u3);
        red.agregarUsuario(u4);

        // Conectar usuarios
        red.conectarUsuarios(u1, u2);
        red.conectarUsuarios(u1, u3);
        red.conectarUsuarios(u2, u4);
        red.conectarUsuarios(u3, u4);

        // Realizar recorridos
        red.DFS(u1); 
        red.BFS(u1); 
    }
}