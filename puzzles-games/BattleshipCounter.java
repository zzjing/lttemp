
public class BattleshipCounter {
    public int countBattleships(char[][] board) {
        if (board == null) {
            return 0;
        }
        int row = board.length;
        if (row == 0) {
            return 0;
        }
        int col = board[0].length;
        int ships = 0;
        // traverse through the entire board row-col-wise
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // no ship is detected within the current cell
                if (board[i][j] == '.') {
                    continue;
                }
                // count a *new ship only if it does not have an adjacent ship
                // that is, there is no ship part to its left or to its top
                if (i > 0 && board[i - 1][j] == 'X') {
                    continue; // ship part is to its top
                }
                if (j > 0 && board[i][j - 1] == 'X') {
                    continue; // ship part is to its left
                }
                ships++;
            }
        }
        return ships;
    }
}
