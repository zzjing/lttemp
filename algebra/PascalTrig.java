/**
 * Generate Pascal's triangle in terms of a list of
 * given number of rows.
 * @author Zezhou Jing, University of Washington
 * @date August 29, 2016
 */
import java.util.List;
import java.util.ArrayList;

public class PascalTrig {
    // @param numRows: number of rows to generate for Pascal's triangle
    // @return: rows of the triangle as a list
    // math solution; Time complexity O(n^2), space O(n)
    public List<List<Integer>> generatePascal(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        // simple boundary case
        if (numRows == 0) {
            return triangle;
        }
        // do the first row at the top, fence post problem
        List<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(0, 1);
        triangle.add(firstRow);
        // we are done with the first row so start with i = 1
        // i deals with the rows; j deals with elements in each row
        for (int i = 1; i < numRows; i++) {
            // second row has two element, third has three and so on
            // so we know the size of the list
            List<Integer> currentRow = new ArrayList<Integer>(i + 1);
            // temporarily fill (i + 1) -1s to the list
            for (int j = 0; j < i + 1; j++) {
                currentRow.add(-1);
            }
            // get the previous row
            List<Integer> prevRow = triangle.get(i - 1);
            // at index 0, we have 1 for every row (Pascal trig)
            currentRow.set(0, prevRow.get(0));
            // at index i (last one), we have 1 for every row (equal to (i - 1))
            currentRow.set(i, prevRow.get(i - 1));
            // traverse from the second elmt to second to the last one
            for (int j = 1; j < i; j++) { // remember size is i + 1, last index is i
                // critical step, Pascal trig property
                currentRow.set(j, prevRow.get(j - 1) + prevRow.get(j));
            }
            triangle.add(currentRow);
        }
        return triangle;
    }
}
