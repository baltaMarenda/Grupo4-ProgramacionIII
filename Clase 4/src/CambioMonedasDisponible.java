import java.util.*;

public class CambioMonedasDisponible {
    // Función para verificar si es posible dar cambio exacto
    public static boolean esCambioExacto(int[] monedasDisponibles, int monto) {
        Arrays.sort(monedasDisponibles); // Ordenar de menor a mayor
        for (int i = monedasDisponibles.length - 1; i >= 0; i--) { // De mayor a menor
            while (monto >= monedasDisponibles[i]) {
                monto -= monedasDisponibles[i]; // Restar la moneda del monto
            }
        }
        return monto == 0; // Si se logró llegar a monto 0, es cambio exacto
    }

    public static void main(String[] args) {
        int[] monedas = {1, 5, 10, 25}; // Denominaciones disponibles
        int monto = 36; // Monto a cambiar
        boolean esPosible = esCambioExacto(monedas, monto);
        if (esPosible) {
            System.out.println("Es posible dar el cambio exacto.");
        } else {
            System.out.println("No es posible dar el cambio exacto.");
        }
    }
}
