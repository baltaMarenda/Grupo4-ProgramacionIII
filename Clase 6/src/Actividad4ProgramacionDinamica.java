public class Actividad4ProgramacionDinamica {

    static int[] costos = {12, 20, 15, 25}; // Costos de los paquetes
    static int[] ganancias = {150, 200, 100, 300}; // Ganancias esperadas
    static int presupuesto = 35; // Presupuesto disponible

    public static void main(String[] args) {
        int n = costos.length;
        int maxGanancia = seleccionPaquetesDinamica(n, presupuesto);
        System.out.println("La ganancia máxima obtenida es: " + maxGanancia);
    }

    static int seleccionPaquetesDinamica(int n, int presupuesto) {
        int[][] dp = new int[n + 1][presupuesto + 1];

        for (int i = 1; i <= n; i++) {
            for (int p = 0; p <= presupuesto; p++) {
                if (costos[i - 1] <= p) {
                    dp[i][p] = Math.max(dp[i - 1][p], dp[i - 1][p - costos[i - 1]] + ganancias[i - 1]);
                } else {
                    dp[i][p] = dp[i - 1][p];
                }
            }
        }

        return dp[n][presupuesto];
    }
}
//Complejidad: Tiempo: O(n * presupuesto)
