import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return spiral;
        }
        // define four pointers to indicate current start/end pos
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // traverse rightwards
            for (int j = colBegin; j <= colEnd; j++) {
                spiral.add(matrix[rowBegin][j]);
            }
            rowBegin++; // done with this row
            // traverse downwards
            for (int i = rowBegin; i <= rowEnd; i++) {
                spiral.add(matrix[i][colEnd]); // note we "begin" from left to right
            }
            colEnd--; // done with rightmost column
            if (rowBegin <= rowEnd) { // rowBegin has changed, check if inbounds
                // traverse leftwards
                for (int j = colEnd; j >= colBegin; j--) {
                    spiral.add(matrix[rowEnd][j]); // at the bottom, rowEnd
                }
                rowEnd--;
            }
            if (colBegin <= colEnd) {
                // traverse upwards
                for (int i = rowEnd; i >= rowBegin; i--) {
                    spiral.add(matrix[i][colBegin]);
                }
                colBegin++;
            }
        }
        return spiral;
    }

    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }
        int[][] spiral = new int[n][n];
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        int curNum = 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // traverse rightwards
            for (int j = colBegin; j <= colEnd; j++) {
                spiral[rowBegin][j] = curNum;
                curNum++;
            }
            rowBegin++;
            // traverse downwards
            for (int i = rowBegin; i <= rowEnd; i++) {
                spiral[i][colEnd] = curNum;
                curNum++;
            }
            colEnd--;
            // traverse leftwards
            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j--) {
                    spiral[rowEnd][j] = curNum;
                    curNum++;
                }
                rowEnd--;
            }
            // traverse upwards
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    spiral[i][colBegin] = curNum;
                    curNum++;
                }
                colBegin++;
            }
        }
        return spiral;
    }
}
