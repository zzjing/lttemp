
public class ImageFlip {
    public int[][] flipAndInvert(int[][] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int row = A.length;
        int col = A[0].length;
        // reverse each row; meanwhile invert
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < (col + 1) / 2; j++) {
                int tmp = A[i][j] ^ 1;
                A[i][j] = A[i][col - 1 - j] ^ 1;
                A[i][col - 1 - j] = tmp;
            }
        }
        return A;
    }

    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int row = A.length;
        int col = A[0].length;
        // reverse each row
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col / 2; j++) {
                int tmp = A[i][j];
                A[i][j] = A[i][col - 1 - j];
                A[i][col - 1 - j] = tmp;
            }
        }
        // invert: 0 -> 1, 1 -> 0
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] == 0) {
                    A[i][j] = 1;
                } else {
                    A[i][j] = 0;
                }
            }
        }
        return A;
    }
}
