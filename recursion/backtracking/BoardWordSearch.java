
public class BoardWordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return true;
        }
        char startChar = word.charAt(0);
        int row = board.length;
        int col = board[0].length;
        // dfs the board
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == startChar) {
                    if (dfsBoard(board, word, i, j, 0)) {
                        return true;
                    }
                }
                // less readable version
                /* if (board[i][j] == startChar && dfsBoard(board, word, i, j, 0)) {
                    return true;
                } */
            }
        }
        return false;
    }

    private boolean dfsBoard(char[][] board, String word, int i, int j, int currentIndex) {
        if (currentIndex == word.length()) {
            return true; // found the word since all previous char search returns true
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
            || board[i][j] != word.charAt(currentIndex)) {
            return false;
        }
        board[i][j] = '#'; // mark the current position as visited/matched by "#"
        // continue searching the next character(s) toward every direction
        boolean found = dfsBoard(board, word, i - 1, j, currentIndex + 1) ||
            dfsBoard(board, word, i + 1, j, currentIndex + 1) ||
            dfsBoard(board, word, i, j - 1, currentIndex + 1) ||
            dfsBoard(board, word, i, j + 1, currentIndex + 1);
        // after all recursive (search) calls, backtrack the board to original state
        // since we will need it to search around other positions
        board[i][j] = word.charAt(currentIndex);
        // since the char on board matches the word char of the last level of recursion
        return found;
    }
}
