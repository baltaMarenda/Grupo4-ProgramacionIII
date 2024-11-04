public class Act1DosReinas {
    static final int N = 4;

    public static void main(String[] args) {
        boolean[][] tablero = new boolean[N][N];
        encontrarConfiguraciones(tablero, 0, 0, 0);
    }

    static void encontrarConfiguraciones(boolean[][] tablero, int fila, int col, int reinasColocadas) {
        if (reinasColocadas == 2) {
            imprimirTablero(tablero);
            return;
        }

        if (fila >= N) return;

        for (int j = col; j < N; j++) {
            if (esSeguro(tablero, fila, j)) {
                tablero[fila][j] = true;
                encontrarConfiguraciones(tablero, fila + 1, 0, reinasColocadas + 1);
                tablero[fila][j] = false;
            }
        }
        encontrarConfiguraciones(tablero, fila + 1, 0, reinasColocadas);
    }

    static boolean esSeguro(boolean[][] tablero, int fila, int col) {
        for (int i = 0; i < N; i++) {
            if (tablero[fila][i] || tablero[i][col]) return false;
        }
        for (int i = -N; i < N; i++) {
            if (fila + i >= 0 && fila + i < N && col + i >= 0 && col + i < N && tablero[fila + i][col + i])
                return false;
            if (fila + i >= 0 && fila + i < N && col - i >= 0 && col - i < N && tablero[fila + i][col - i])
                return false;
        }
        return true;
    }

    static void imprimirTablero(boolean[][] tablero) {
        for (boolean[] fila : tablero) {
            for (boolean casilla : fila) {
                System.out.print(casilla ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
