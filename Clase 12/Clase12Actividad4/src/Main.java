public class Main {
    public static void main(String[] args) {
        RedSocial redSocial = new RedSocial();

        // Crear y agregar usuarios a la red
        Usuario u1 = new Usuario(1, "Alice");
        Usuario u2 = new Usuario(2, "Bob");
        Usuario u3 = new Usuario(3, "Charlie");
        Usuario u4 = new Usuario(4, "Diana");
        Usuario u5 = new Usuario(5, "Eve");

        redSocial.agregarUsuario(u1);
        redSocial.agregarUsuario(u2);
        redSocial.agregarUsuario(u3);
        redSocial.agregarUsuario(u4);
        redSocial.agregarUsuario(u5);

        // Conectar usuarios (amistades)
        redSocial.conectarUsuarios(1, 2);
        redSocial.conectarUsuarios(1, 3);
        redSocial.conectarUsuarios(2, 4);
        redSocial.conectarUsuarios(3, 5);
        redSocial.conectarUsuarios(4, 5);

        // Realizar recorridos desde el usuario Alice (ID 1)
        redSocial.recorridoDFS(1);
        redSocial.recorridoBFS(1);
    }
}
