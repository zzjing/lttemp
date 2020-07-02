/**
 * Search for an element in a row-wise and column-wise sorted 2D matrix
 * 
 * @author Zezhou Jing, University of Washington
 * @date August 27, 2016
 */
public class SortedMatrixSearch {
    // @param matrix: a row-wise and column-wise sorted matrix
    // @param target: an integer to look for
    // @return: whether matrix contains the target element
    // binary search method; Time complexity O[log (m * n)], space O(1)
    // where m is the number of rows and n is the number of columns
    public boolean searchMatrix(int[][] matrix, int target) {
        // completely empty matrix; or a matrix composed by one empty row
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // number of rows
        int row = matrix.length;
        // number of columns
        int column = matrix[0].length;
        // begin binary search
        int start = 0;
        // last entry of the matrix (in terms of index; note it starts with 0)
        int end = row * column - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // the 'central' entry of the matrix
            // we can view it as if the entire matrix
            // is expanded into one single array
            int midEntry = matrix[mid / column][mid % column];
            if (midEntry == target) {
                return true;
            } else if (midEntry < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        // not found
        return false;
    }
}
