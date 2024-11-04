import java.util.ArrayList;
import java.util.List;

public class Actividad2 {

    private int[][] matrizAdyacencia;
    private int cantidadVertices;

    public Actividad2(int cantidadVertices) {
        this.cantidadVertices = cantidadVertices;
        matrizAdyacencia = new int[cantidadVertices][cantidadVertices];
    }

    public void agregarArista(int x, int y) {
        matrizAdyacencia[x][y] = 1;
    }

    public void eliminarArista(int x, int y) {
        matrizAdyacencia[x][y] = 0;
    }

    public boolean verificarArista(int x, int y) {
        return matrizAdyacencia[x][y] == 1;
    }

    public List<Integer> listarAdyacentes(int x) {
        List<Integer> adyacentes = new ArrayList<>();
        for (int i = 0; i < cantidadVertices; i++) {
            if (matrizAdyacencia[x][i] == 1) {
                adyacentes.add(i);
            }
        }
        return adyacentes;
    }

    public int contarGradoSalida(int x) {
        int gradoSalida = 0;
        for (int i = 0; i < cantidadVertices; i++) {
            if (matrizAdyacencia[x][i] == 1) {
                gradoSalida++;
            }
        }
        return gradoSalida;
    }

    public int contarGradoEntrada(int x) {
        int gradoEntrada = 0;
        for (int i = 0; i < cantidadVertices; i++) {
            if (matrizAdyacencia[i][x] == 1) {
                gradoEntrada++;
            }
        }
        return gradoEntrada;
    }

    public void imprimirMatrizAdyacencia() {
        for (int i = 0; i < cantidadVertices; i++) {
            for (int j = 0; j < cantidadVertices; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Actividad2 grafo = new Actividad2(5);

        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(3, 4);

        System.out.println("Arista de 0 a 1: " + grafo.verificarArista(0, 1));
        System.out.println("Arista de 0 a 3: " + grafo.verificarArista(0, 3));

        System.out.println("Adyacentes de 0: " + grafo.listarAdyacentes(0));

        System.out.println("Grado de salida de 0: " + grafo.contarGradoSalida(0));
        System.out.println("Grado de entrada de 3: " + grafo.contarGradoEntrada(3));

        grafo.imprimirMatrizAdyacencia();
    }
}
