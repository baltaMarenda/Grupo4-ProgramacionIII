class Clientes {
    int id;
    String nombre;
    int scoring;

    public Clientes(int id, String nombre, int scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }

    @Override
    public String toString() {
        return "Clientes{id=" + id + ", nombre='" + nombre + "', scoring=" + scoring + "}";
    }
}

public class Actividad1 {
    public static void main(String[] args) {
        Clientes[] clientes = {
                new Clientes(1, "Juan", 80),
                new Clientes(2, "Ana", 95),
                new Clientes(3, "Luis", 85),
                new Clientes(4, "Pedro", 75),
                new Clientes(5, "Maria", 92)
        };

        Clientes maxCliente = encontrarMaxCliente(clientes);
        System.out.println("Cliente con el mayor scoring: " + maxCliente);
    }

    private static Clientes encontrarMaxCliente(Clientes[] clientes) {
        return encontrarMaxCliente(clientes, 0, clientes.length);
    }

    private static Clientes encontrarMaxCliente(Clientes[] clientes, int i, int f) {
        if (i == f - 1) return clientes[i];

        int mitad = (f + i) / 2;
        Clientes izq = encontrarMaxCliente(clientes, i, mitad);
        Clientes der = encontrarMaxCliente(clientes, mitad, f);

        return (izq.scoring > der.scoring) ? izq : der;
    }
}
