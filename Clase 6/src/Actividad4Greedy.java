import java.util.Arrays;

public class Actividad4Greedy {

    static int[] costos = {12, 20, 15, 25}; // Costos de los paquetes
    static int[] ganancias = {150, 200, 100, 300}; // Ganancias esperadas
    static int presupuesto = 35; // Presupuesto disponible

    public static void main(String[] args) {
        int n = costos.length;
        Paquete[] paquetes = new Paquete[n];

        for (int i = 0; i < n; i++) {
            paquetes[i] = new Paquete(costos[i], ganancias[i]);
        }

        Arrays.sort(paquetes, (a, b) -> Double.compare(b.ratio(), a.ratio()));

        int costoActual = 0;
        int gananciaTotal = 0;

        for (int i = 0; i < n; i++) {
            if (costoActual + paquetes[i].costo <= presupuesto) {
                costoActual += paquetes[i].costo;
                gananciaTotal += paquetes[i].ganancia;
            }
        }

        System.out.println("La ganancia máxima obtenida es: " + gananciaTotal);
    }

    static class Paquete {
        int costo;
        int ganancia;

        Paquete(int costo, int ganancia) {
            this.costo = costo;
            this.ganancia = ganancia;
        }

        double ratio() {
            return (double) ganancia / costo;
        }
    }
}
//Complejidad: Tiempo: O(n log n)
