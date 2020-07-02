
public class BoardGameSolver {
    public void solve(char[][] board) {
        if (board == null || board.length < 2 || board[0].length < 2) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                boundaryDFS(board, 0, i);
            }
            if (board[row - 1][i] == 'O') {
                boundaryDFS(board, row - 1, i);
            }
        }
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                boundaryDFS(board, i, 0);
            }
            if (board[i][col - 1] == 'O') {
                boundaryDFS(board, i, col - 1);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void boundaryDFS(char[][] board, int i, int j) {
        if (board[i][j] == 'O') {
            board[i][j] = 'S';
        }
        if (i > 1 && board[i - 1][j] == 'O') {
            boundaryDFS(board, i - 1, j);
        }
        if (i < board.length - 1 && board[i + 1][j] == 'O') {
            boundaryDFS(board, i + 1, j);
        }
        if (j > 1 && board[i][j - 1] == 'O') {
            boundaryDFS(board, i, j - 1);
        }
        if (j < board[i].length - 1 && board[i][j + 1] == 'O') {
            boundaryDFS(board, i, j + 1);
        }
    }
}
