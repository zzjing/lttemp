
public class MatrixZeroSetter {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // the first column is handled separately since the first cell 
        boolean setZerothCol = false;
        for (int i = 0; i < row; i++) {
            // check elements of the first column first
            // s.t. later operations (marking state of row/col)
            // will not affect the original state of the first col
            if (matrix[i][0] == 0) {
                setZerothCol = true;
            }
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (setZerothCol) {
                matrix[i][0] = 0;
            }
        }
    }
}
