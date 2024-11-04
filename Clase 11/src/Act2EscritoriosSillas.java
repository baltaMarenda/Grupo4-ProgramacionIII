public class Act2EscritoriosSillas {
    static final int N = 4;

    public static void main(String[] args) {
        boolean[][] tablero = new boolean[N][N];
        encontrarCombinaciones(tablero, 0, 0, 0, 2);
    }

    static void encontrarCombinaciones(boolean[][] tablero, int fila, int col, int colocados, int totalObjetos) {
        if (colocados == totalObjetos) {
            imprimirTablero(tablero);
            return;
        }

        if (fila >= N) return;

        for (int j = col; j < N; j++) {
            if (esSeguro(tablero, fila, j)) {
                tablero[fila][j] = true;
                encontrarCombinaciones(tablero, fila + 1, 0, colocados + 1, totalObjetos);
                tablero[fila][j] = false;
            }
        }
        encontrarCombinaciones(tablero, fila + 1, 0, colocados, totalObjetos);
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
                System.out.print(casilla ? "X " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
