import java.util.*;

class Objeto {
    int valor, peso;
    Objeto(int valor, int peso) {
        this.valor = valor;
        this.peso = peso;
    }
}

public class MochilaFraccional {
    // Función para resolver el problema de la mochila fraccional
    public static double mochilaFraccional(Objeto[] objetos, int capacidad) {
        Arrays.sort(objetos, (a, b) -> Double.compare((double) b.valor / b.peso, (double) a.valor / a.peso));
        double valorMaximo = 0.0;

        for (Objeto objeto : objetos) {
            if (capacidad >= objeto.peso) {
                capacidad -= objeto.peso;
                valorMaximo += objeto.valor;
            } else {
                valorMaximo += (double) objeto.valor * capacidad / objeto.peso;
                break;
            }
        }
        return valorMaximo;
    }

    public static void main(String[] args) {
        Objeto[] objetos = {new Objeto(30, 10), new Objeto(50, 20), new Objeto(60, 30)};
        int capacidad = 50;
        double valorMaximo = mochilaFraccional(objetos, capacidad);
        System.out.println("Valor máximo que se puede obtener: " + valorMaximo);
    }
}
