public class Actividad2FuerzaBruta {

    static int[] pesos = {2, 5, 6, 7};
    static int[] valores = {4, 2, 1, 6};
    static int capacidad = 10;

    public static void main(String[] args) {
        int n = pesos.length;
        int maxValor = mochila(0, 0, 0, n);
        System.out.println("El valor máximo obtenido es: " + maxValor);
    }

    // Función recursiva que prueba todas las combinaciones
    static int mochila(int indice, int pesoActual, int valorActual, int n) {
        if (indice == n) {
            return valorActual;
        }

        int sinTomar = mochila(indice + 1, pesoActual, valorActual, n);

        int conTomar = 0;
        if (pesoActual + pesos[indice] <= capacidad) {
            conTomar = mochila(indice + 1, pesoActual + pesos[indice], valorActual + valores[indice], n);
        }

        return Math.max(sinTomar, conTomar);
    }
}

