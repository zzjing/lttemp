import java.util.HashSet;
import java.util.Set;

public class MatrixSubRectangle {
    public boolean canFindRectangle(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        Set<String> horizontalLines = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // find a point to the left corner
                if (matrix[i][j] == 1) {
                    String left = Integer.toString(i) + "," + Integer.toString(j);
                    for (int k = j + 1; k < col; k++) {
                        // find a point to the right corner
                        if (matrix[i][j] == 1) {
                            String right = Integer.toString(i) + "," + Integer.toString(j);
                            String line = left + "." + right;
                            if (horizontalLines.contains(line)) {
                                return true;
                            } else {
                                horizontalLines.add(line);
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
