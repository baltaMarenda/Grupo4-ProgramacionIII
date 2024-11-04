public class Actividad4FuerzaBruta {

    static int[] costos = {12, 20, 15, 25}; // Costos de los paquetes
    static int[] ganancias = {150, 200, 100, 300}; // Ganancias esperadas
    static int presupuesto = 35; // Presupuesto disponible

    public static void main(String[] args) {
        int n = costos.length;
        int maxGanancia = seleccionPaquetes(0, 0, 0, n);
        System.out.println("La ganancia máxima obtenida es: " + maxGanancia);
    }

    static int seleccionPaquetes(int indice, int costoActual, int gananciaActual, int n) {
        if (indice == n) {
            return gananciaActual;
        }

        int sinTomar = seleccionPaquetes(indice + 1, costoActual, gananciaActual, n);

        int conTomar = 0;
        if (costoActual + costos[indice] <= presupuesto) {
            conTomar = seleccionPaquetes(indice + 1, costoActual + costos[indice], gananciaActual + ganancias[indice], n);
        }

        return Math.max(sinTomar, conTomar);
    }
}

//Complejidad: Tiempo: O(2^n)