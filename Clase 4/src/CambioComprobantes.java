import java.util.*;

public class CambioComprobantes {
    // Función para encontrar la cantidad mínima de comprobantes necesarios
    public static List<Integer> encontrarMinimoComprobantes(int[] comprobantes, int monto) {
        Arrays.sort(comprobantes); // Ordenar de menor a mayor
        List<Integer> resultado = new ArrayList<>();
        for (int i = comprobantes.length - 1; i >= 0; i--) { // De mayor a menor
            while (monto >= comprobantes[i]) {
                monto -= comprobantes[i]; // Restar el comprobante del monto
                resultado.add(comprobantes[i]); // Agregar comprobante a la lista
            }
        }
        return resultado; // Devolver la lista de comprobantes usados
    }

    public static void main(String[] args) {
        int[] comprobantes = {10, 20, 50, 100}; // Valores de comprobantes
        int monto = 270; // Monto que se desea cambiar
        List<Integer> resultado = encontrarMinimoComprobantes(comprobantes, monto);
        System.out.println("Comprobantes utilizados para hacer " + monto + ": " + resultado);
    }
}
