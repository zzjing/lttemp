import java.util.ArrayList;
import java.util.List;

public class PathToOceans {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> validSpots = new ArrayList<int[]>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return validSpots;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            dfsPaths(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfsPaths(matrix, atlantic, Integer.MIN_VALUE, i, col - 1);
        }
        for (int i = 0; i < col; i++) {
            dfsPaths(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfsPaths(matrix, atlantic, Integer.MIN_VALUE, row - 1, i);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    validSpots.add(new int[] {i, j});
                }
            }
        }
        return validSpots;
    }

    private void dfsPaths(int[][]matrix, boolean[][]canFlow, int height, int i, int j) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (i < 0 || i > row - 1 || j < 0 || j > col - 1 || canFlow[i][j] || matrix[i][j] < height) {
            return;
        }
        canFlow[i][j] = true;
        dfsPaths(matrix, canFlow, matrix[i][j], i - 1, j);
        dfsPaths(matrix, canFlow, matrix[i][j], i + 1, j);
        dfsPaths(matrix, canFlow, matrix[i][j], i, j - 1);
        dfsPaths(matrix, canFlow, matrix[i][j], i, j + 1);
    }
}
