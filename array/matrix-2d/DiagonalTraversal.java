
public class DiagonalTraversal {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] diagOrder = new int[row * col];
        int i = 0;
        int j = 0;
        int dir = 1;
        for (int index = 0; index < row * col; index++) {
            // record the current valid entry
            diagOrder[index] = matrix[i][j];
            // attempt to traverse
            i -= dir;
            j += dir;
            // order of these statements cannot be changed
            if (i >= row) {
                i = row - 1;
                j += 2;
                dir = -dir;
            }
            if (j >= col) {
                j = col - 1;
                i += 2;
                dir = -dir;
            }
            if (i < 0) {
                i = 0;
                dir = -dir;
            }
            if (j < 0) {
                j = 0;
                dir = -dir;
            }
        }
        return diagOrder;
    }
}
