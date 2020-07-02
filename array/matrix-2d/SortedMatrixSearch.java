
public class SortedMatrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // start from the top right corner, where col is min and row is max
        // so need to rule out col / row
        int row = 0;
        int col = matrix[0].length - 1;
        while (col >= 0 & row < matrix.length) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--; // there is no target in this col because it is already at its min
            } else { // (matrix[row][col] < target) 
                row++; // there is no target in this row because it is already at its max
            }
        }
        return false;
        // O(m + n) solution since we cross out one row/column each time
    }

    public int searchFreq(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = col - 1;
        int freq = 0;
        while (i < row && j >= 0) {
            if (matrix[i][j] == target) {
                freq++;
                i++;
                j--;
                continue;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return freq;
    }
}
