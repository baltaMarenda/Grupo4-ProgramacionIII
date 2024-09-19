public class Actividad3ProgramacionDinamica {

    static int[] costos = {10, 15, 20, 25};
    static int[] beneficios = {100, 200, 150, 300};
    static int presupuesto = 40;

    public static void main(String[] args) {
        int n = costos.length;
        int maxBeneficio = seleccionProyectosDinamica(n, presupuesto);
        System.out.println("El beneficio máximo obtenido es: " + maxBeneficio);
    }


    static int seleccionProyectosDinamica(int n, int presupuesto) {
        int[][] dp = new int[n + 1][presupuesto + 1];


        for (int i = 1; i <= n; i++) {
            for (int p = 0; p <= presupuesto; p++) {
                if (costos[i - 1] <= p) {
                    dp[i][p] = Math.max(dp[i - 1][p], dp[i - 1][p - costos[i - 1]] + beneficios[i - 1]);
                } else {
                    dp[i][p] = dp[i - 1][p];
                }
            }
        }


        return dp[n][presupuesto];
    }
}
//Complejidad: Tiempo: O(n*P) - donde n es el número de proyectos y P es el presupuesto.
// Esto se debe a que la solución involucra iterar sobre cada proyecto para cada posible
// presupuesto hasta el máximo disponible.
