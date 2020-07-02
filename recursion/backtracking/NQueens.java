import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        char[][] board = new char[n][n];
        initialize(board, n);
        List<List<String>> solution = new ArrayList<>();
        dfs(board, 0, solution);
        return solution;
    }
    // initialize the chess board with all spots empty
    private void initialize(char[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
    }
    // dfs each row of the chess board, from left to right
    private void dfs(char[][] board, int colIndex, List<List<String>> curSoln) {
        // this row is complete, add it to the solution
        if (colIndex == board.length) {
            curSoln.add(addRow(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, curSoln);
                board[i][colIndex] = '.';
            }
        }
    }

    private List<String> addRow(char[][] board) {
        List<String> row = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String square = new String(board[i]);
            row.add(square);
        }
        return row;
    }

    private boolean validate(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'Q' &&
                   (x + j == y + i || x + y == i + j || x == i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
