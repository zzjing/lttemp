public int[] getLegalMoves(int i, int j) {
    return new int[]{{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}};
}

public boolean canVisitAllZeroes(int[][] matrix, int x, int y) {
    boolean[][] visited = new boolean[matrix.length - 1][matrix[0].length - 1];
    visitZeroes(matrix, visited, x, y);
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[i][j] == 0 && !visited[i][j]) {
                return false;
            }
        }
    }
    return true;
}

private void visitZeroes(int[][] matrix, boolean[][] visited, int x, int y) {
    if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || visited[x][y] || matrix[x][y] != 0) {
        return;
    }
    visited[x][y] = true;
    visitZeroes(matrix, visited, x - 1, y);
    visitZeroes(matrix, visited, x + 1, y);
    visitZeroes(matrix, visited, x, y - 1);
    visitZeroes(matrix, visited, x, y + 1);
}