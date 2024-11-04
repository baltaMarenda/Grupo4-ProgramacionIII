public class Act3ComputadorasImpresoras {
    static final int N = 4;

    public static void main(String[] args) {
        boolean[][] tablero = new boolean[N][N];
        encontrarDistribuciones(tablero, 0, 0, 0, 4, 4);
    }

    static void encontrarDistribuciones(boolean[][] tablero, int fila, int col, int colocados, int totalComputadoras, int totalImpresoras) {
        if (colocados == totalComputadoras + totalImpresoras) {
            imprimirTablero(tablero);
            return;
        }

        if (fila >= N) return;

        for (int j = col; j < N; j++) {
            if (esSeguro(tablero, fila, j)) {
                tablero[fila][j] = true;
                encontrarDistribuciones(tablero, fila + 1, 0, colocados + 1, totalComputadoras, totalImpresoras);
                tablero[fila][j] = false;
            }
        }
        encontrarDistribuciones(tablero, fila + 1, 0, colocados, totalComputadoras, totalImpresoras);
    }

    static boolean esSeguro(boolean[][] tablero, int fila, int col) {
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] || tablero[i][col]) return false;
        }
        return true;
    }

    static void imprimirTablero(boolean[][] tablero) {
        for (boolean[] fila : tablero) {
            for (boolean casilla : fila) {
                System.out.print(casilla ? "E " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
