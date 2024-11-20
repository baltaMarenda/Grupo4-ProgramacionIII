public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Crear y agregar almacenes al grafo
        Almacen a1 = new Almacen(1, "Almacen A");
        Almacen a2 = new Almacen(2, "Almacen B");
        Almacen a3 = new Almacen(3, "Almacen C");
        Almacen a4 = new Almacen(4, "Almacen D");
        Almacen a5 = new Almacen(5, "Almacen E");

        grafo.agregarAlmacen(a1);
        grafo.agregarAlmacen(a2);
        grafo.agregarAlmacen(a3);
        grafo.agregarAlmacen(a4);
        grafo.agregarAlmacen(a5);

        // Conectar almacenes
        grafo.conectarAlmacenes(1, 2);
        grafo.conectarAlmacenes(1, 3);
        grafo.conectarAlmacenes(2, 4);
        grafo.conectarAlmacenes(3, 5);
        grafo.conectarAlmacenes(4, 5);

        // Realizar recorridos desde el almacén 1
        grafo.recorridoDFS(1);
        grafo.recorridoBFS(1);
    }
}
