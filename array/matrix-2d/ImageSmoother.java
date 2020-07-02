
public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        if (M == null || M.length == 0) {
            return null;
        }
        int row = M.length;
        int col = M[0].length;
        int[][] smoothen = new int[row][col];
        int[] rowDirs = new int[]{-1, 0, 1};
        int[] colDirs = new int[]{-1, 0, 1};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cells = 0;
                int sum = 0;
                for (int rowDir : rowDirs) {
                    for (int colDir : colDirs) {
                        if (cellValid(i + rowDir, j + colDir, row, col)) {
                            cells++;
                            sum += M[i + rowDir][j + colDir];
                        }
                    }
                }
                smoothen[i][j] = sum / cells;
            }
        }
        return smoothen;
    }

    private boolean cellValid(int i, int j, int row, int col) {
        if (i < 0 || i > row - 1 || j < 0 || j > col - 1) {
            return false;
        }
        return true;
    }
}
