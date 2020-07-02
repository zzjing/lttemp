
public class MatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return new int[0][0];
        }
        // (rowA * colA) * (colA * colB) = (rowA * colB)
        int rowA = A.length;
        int colA = A[0].length;
        int colB = B[0].length;
        int[][] product = new int[rowA][colB];
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colA; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < colB; k++) {
                        if (B[j][k] != 0) {
                            product[i][k] += (A[i][j] * B[j][k]);
                        }
                    }
                }
            }
        }
        return product;
    }
}
