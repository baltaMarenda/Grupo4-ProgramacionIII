package git;
import java.util.Random;

public class Sudoku6x6 {
    private static final int SIZE = 6;
    private static final int SUBGRID_SIZE = 2;
    private static final int EMPTY = 0;
    private int[][] board;

    public Sudoku6x6() {
        board = new int[SIZE][SIZE];
    }
    public void generateSudoku() {
        fillBoard();
        removeNumbers();
    }

    private boolean fillBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) {
                    for (int num = 1; num <= SIZE; num++) {
                        if (isValid(row, col, num)) {
                            board[row][col] = num;
                            if (fillBoard()) {
                                return true;
                            }
                            board[row][col] = EMPTY;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        int subGridRow = row / SUBGRID_SIZE * SUBGRID_SIZE;
        int subGridCol = col / 3 * 3;
        for (int i = 0; i < SUBGRID_SIZE; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[subGridRow + i][subGridCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }


    private void removeNumbers() {
        Random rand = new Random();
        int cellsToRemove = 12 + rand.nextInt(6);
        while (cellsToRemove > 0) {
            int row = rand.nextInt(SIZE);
            int col = rand.nextInt(SIZE);

            if (board[row][col] != EMPTY) {
                board[row][col] = EMPTY;
                cellsToRemove--;
            }
        }
    }
    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    System.out.print(". ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Sudoku6x6 sudoku = new Sudoku6x6();
        sudoku.generateSudoku();
        sudoku.printBoard();
    }

}