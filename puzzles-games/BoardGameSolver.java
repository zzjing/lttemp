
public class BoardGameSolver {
    public void solve(char[][] board) {
        if (board == null || board.length < 2 || board[0].length < 2) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                dfsBoundary(board, i, 0);
            }
            if (board[i][col - 1] == 'O') {
                dfsBoundary(board, i, col - 1);
            }
        }
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') {
                dfsBoundary(board, 0, j);
            }
            if (board[row - 1][j] == 'O') {
                dfsBoundary(board, row - 1, j);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
        
    }

    private void dfsBoundary(char[][] board, int i, int j) {
        if (i < 0 || j > board[0].length - 1) {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = 'S';
        }
        if (i > 1 && board[i - 1][j] == 'O') {
            dfsBoundary(board, i - 1, j);
        }
        if (i < board.length - 2 && board[i + 1][j] == 'O') {
            dfsBoundary(board, i + 1, j);
        }
        if (j > 1 && board[i][j - 1] == 'O') {
            dfsBoundary(board, i, j - 1);
        }
        if (j < board[0].length - 2 && board[i][j + 1] == 'O') {
            dfsBoundary(board, i, j + 1);
        }
    }
}
