
public class MazeLongestPath {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] cellPaths = new int[row][col];
        int pathLen = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                pathLen = Math.max(pathLen, dfsPaths(matrix, i, j, row, col, cellPaths, dirs));
            }
        }
        return pathLen;
    }

    private int dfsPaths(int[][] matrix, int i, int j, int row, int col, int[][] cellPaths, int[][] dirs) {
        if (cellPaths[i][j] != 0) {
            return cellPaths[i][j];
        }
        for (int[] direction : dirs) {
            int nextX = i + direction[0];
            int nextY = j + direction[1];
            if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col
                && matrix[nextX][nextY] > matrix[i][j]) {
                cellPaths[i][j] = Math.max(cellPaths[i][j],
                                           dfsPaths(matrix, nextX, nextY, row, col, cellPaths, dirs));
            }
        }
        cellPaths[i][j]++;
        return cellPaths[i][j];
    }
}
