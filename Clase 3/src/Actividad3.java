class Cliente2 {
    int id;
    String nombre;
    int scoring;

    public Cliente2(int id, String nombre, int scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }

    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nombre='" + nombre + "', scoring=" + scoring + "}";
    }
}

public class Actividad3 {
    public static void main(String[] args) {
        Cliente2[] clientes = {
                new Cliente2(1, "Juan", 80),
                new Cliente2(2, "Ana", 95),
                new Cliente2(3, "Luis", 85),
                new Cliente2(4, "Pedro", 75),
                new Cliente2(5, "Maria", 92)
        };

        Cliente2[] resultado = encontrarDosMayoresClientes(clientes);
        System.out.println("Cliente con mayor scoring: " + resultado[0]);
        System.out.println("Cliente con segundo mayor scoring: " + resultado[1]);
    }

    private static Cliente2[] encontrarDosMayoresClientes(Cliente2[] clientes) {
        return encontrarDosMayoresClientes(clientes, 0, clientes.length);
    }

    private static Cliente2[] encontrarDosMayoresClientes(Cliente2[] clientes, int inicio, int fin) {
        if (fin - inicio == 1) {
            return new Cliente2[]{clientes[inicio], null}; // Solo un cliente
        }

        if (fin - inicio == 2) {
            Cliente2 mayor = (clientes[inicio].scoring > clientes[inicio + 1].scoring) ? clientes[inicio] : clientes[inicio + 1];
            Cliente2 segundoMayor = (mayor == clientes[inicio]) ? clientes[inicio + 1] : clientes[inicio];
            return new Cliente2[]{mayor, segundoMayor}; // Dos clientes
        }

        int mitad = (fin + inicio) / 2;
        Cliente2[] izq = encontrarDosMayoresClientes(clientes, inicio, mitad);
        Cliente2[] der = encontrarDosMayoresClientes(clientes, mitad, fin);

        Cliente2 nuevoMayor, nuevoSegundoMayor;

        if (izq[0].scoring > der[0].scoring) {
            nuevoMayor = izq[0];
            nuevoSegundoMayor = (izq[1] != null && izq[1].scoring > der[0].scoring) ? izq[1] : der[0];
        } else {
            nuevoMayor = der[0];
            nuevoSegundoMayor = (der[1] != null && der[1].scoring > izq[0].scoring) ? der[1] : izq[0];
        }

        return new Cliente2[]{nuevoMayor, nuevoSegundoMayor};
    }
}
