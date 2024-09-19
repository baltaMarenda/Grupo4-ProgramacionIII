public class Actividad1FuerzaBruta {

    static int[] pesos = {3, 4, 2};
    static int[] valores = {4, 5, 3};
    static int capacidad = 6;
    public static void main(String[] args) {
        int n = pesos.length;
        int maxValor = mochila(0, 0, 0, n);
        System.out.println("El valor máximo obtenido es: " + maxValor);
    }


    static int mochila(int indice, int pesoActual, int valorActual, int n) {
        if (indice == n) {
            return valorActual;
        }
        // Caso en que no tomamos el objeto actual
        int sinTomar = mochila(indice + 1, pesoActual, valorActual, n);


        int conTomar = 0;
        if (pesoActual + pesos[indice] <= capacidad) {
            conTomar = mochila(indice + 1, pesoActual + pesos[indice], valorActual + valores[indice], n);
        }

        return Math.max(sinTomar, conTomar);
    }
}
