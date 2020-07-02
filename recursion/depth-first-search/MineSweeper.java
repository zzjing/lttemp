
public class MineSweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int col = click[1];
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }
        dfsBoard(board, row, col);
        return board;
    }
    
    private void dfsBoard(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != 'E') {
            return;
        }
        int mines = numOfMines(board, i, j);
        if (mines == 0) {
            board[i][j] = 'B';
            dfsBoard(board, i - 1, j);
            dfsBoard(board, i + 1, j);
            dfsBoard(board, i, j - 1);
            dfsBoard(board, i, j + 1);
            dfsBoard(board, i - 1, j - 1);
            dfsBoard(board, i + 1, j + 1);
            dfsBoard(board, i - 1, j + 1);
            dfsBoard(board, i + 1, j - 1);
        } else {
            board[i][j] = (char)('0' + mines);
        }
    }

    private int numOfMines(char[][] board, int x, int y) {
        int mines = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int xCoord = x + i;
                int yCoord = y + j;
                if (xCoord < 0 || xCoord > board.length - 1 || yCoord < 0 || yCoord > board[0].length - 1) {
                    continue;
                }
                if (board[xCoord][yCoord] == 'M') {
                    mines++;
                }
            }
        }
        return mines;
    }
}
