public class Actividad1ProgramacionDinamica {


        static int[] pesos = {3, 4, 2};
        static int[] valores = {4, 5, 3};
        static int capacidad = 6;

        public static void main(String[] args) {
            int n = pesos.length;
            int maxValor = mochilaDinamica(n, capacidad);
            System.out.println("El valor máximo obtenido es: " + maxValor);
        }


        static int mochilaDinamica(int n, int capacidad) {
            int[][] dp = new int[n + 1][capacidad + 1];


            for (int i = 1; i <= n; i++) {
                for (int w = 0; w <= capacidad; w++) {
                    if (pesos[i - 1] <= w) {
                        dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - pesos[i - 1]] + valores[i - 1]);
                    } else {
                        dp[i][w] = dp[i - 1][w];
                    }
                }
            }


            return dp[n][capacidad];
        }
}


