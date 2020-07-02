
public class MatrixTranspose {
    public int[][] transpose(int[][] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int[][] transpose = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                transpose[j][i] = A[i][j];
            }
        }
        return transpose;
    }
}
