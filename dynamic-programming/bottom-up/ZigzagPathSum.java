
public class ZigzagPathSum {
    public int minFallingPathSum(int[][] A) {
        int minPath = Integer.MAX_VALUE;
        if (A == null || A.length == 0) {
            return minPath;
        } else if (A.length == 0) {
            return A[0][0];
        }
        for (int i = A.length - 2; i >= 0; i--) {
            for (int j = 0; j < A[i].length; j++) {
                if (j == 0) {
                    A[i][j] += Math.min(A[i + 1][j], A[i + 1][j + 1]);
                } else if (j == A[i].length - 1) {
                    A[i][j] += Math.min(A[i + 1][j], A[i + 1][j - 1]);
                } else {
                    A[i][j] += Math.min(A[i + 1][j], Math.min(A[i + 1][j - 1], A[i + 1][j + 1]));
                }
            }
        }
        for (int j = 0; j < A[0].length; j++) {
            minPath = Math.min(minPath, A[0][j]);
        }
        return minPath;
    }
}
