import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Actividad1 {

    private HashMap<Usuario, Set<Usuario>> seguidores;

    public Actividad1() {
        seguidores = new HashMap<>();
    }

    // Agrega un nuevo usuario al sistema
    public void AgregarUsuario(Usuario u) {
        if (!seguidores.containsKey(u)) {
            seguidores.put(u, new HashSet<>()); // Inicializa una lista vacía de usuarios que sigue
        }
    }

    // Permite que un usuario siga a otro
    public void Seguir(Usuario seguidor, Usuario seguido) {
        if (seguidores.containsKey(seguidor) && seguidores.containsKey(seguido)) {
            seguidores.get(seguidor).add(seguido);
        }
    }

    // Permite que un usuario deje de seguir a otro
    public void DejarDeSeguir(Usuario seguidor, Usuario seguido) {
        if (seguidores.containsKey(seguidor) && seguidores.get(seguidor).contains(seguido)) {
            seguidores.get(seguidor).remove(seguido);
        }
    }

    // Devuelve la lista de usuarios que sigue un usuario dado
    public Set<Usuario> ListaDeSeguidos(Usuario u) {
        return seguidores.getOrDefault(u, new HashSet<>());
    }

    // Devuelve la lista de usuarios que siguen a un usuario dado
    public Set<Usuario> ListaDeSeguidores(Usuario u) {
        Set<Usuario> listaSeguidores = new HashSet<>();
        for (Usuario key : seguidores.keySet()) {
            if (seguidores.get(key).contains(u)) {
                listaSeguidores.add(key);
            }
        }
        return listaSeguidores;
    }

    public static void main(String[] args) {
        Actividad1 sistema = new Actividad1();

        // Creación de usuarios
        Usuario usuario1 = new Usuario(1);
        Usuario usuario2 = new Usuario(2);
        Usuario usuario3 = new Usuario(3);

        // Agregar usuarios al sistema
        sistema.AgregarUsuario(usuario1);
        sistema.AgregarUsuario(usuario2);
        sistema.AgregarUsuario(usuario3);

        // Usuario 1 sigue a Usuario 2 y Usuario 3
        sistema.Seguir(usuario1, usuario2);
        sistema.Seguir(usuario1, usuario3);

        // Usuario 2 sigue a Usuario 3
        sistema.Seguir(usuario2, usuario3);

        // Mostrar la lista de seguidos por Usuario 1
        System.out.println("Usuario 1 sigue a: " + sistema.ListaDeSeguidos(usuario1));

        // Mostrar la lista de seguidores de Usuario 3
        System.out.println("Usuario 3 es seguido por: " + sistema.ListaDeSeguidores(usuario3));

        // Usuario 1 deja de seguir a Usuario 3
        sistema.DejarDeSeguir(usuario1, usuario3);

        // Mostrar la lista actualizada de seguidos por Usuario 1
        System.out.println("Usuario 1 sigue a: " + sistema.ListaDeSeguidos(usuario1));
    }
}

class Usuario {
    int id;

    public Usuario(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                '}';
    }
}
