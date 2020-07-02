/**
 * Generate a specific row of Pascal's triangle.
 * @author Zezhou Jing, University of Washington
 * @date August 29, 2016
 */
import java.util.List;
import java.util.ArrayList;

public class PascalRow {
    // @param rowIndex: nth row to be generated
    // @return: the nth row as a list
    // math solution; Time complexity O(n^2), space O(n)
    public List<Integer> generateRow(int rowIndex) {
        // simple boundary case
        if (rowIndex == 0) {
            List<Integer> lastRow = new ArrayList<Integer>();
            lastRow.add(1);
            return lastRow;
        }
        List<Integer> lastRow = new ArrayList<Integer>();
        // do the first row at the top, fence post problem
        lastRow.add(1);
        // we are done with the first row so start with i = 1
        // i deals with the rows; j deals with elements in each row
        for (int i = 1; i < rowIndex + 1; i++) {
            // second row has two element, third has three and so on
            // so we know the size of the list
            List<Integer> currentRow = new ArrayList<Integer>(i + 1);
            // temporarily fill (i + 1) -1s to the list
            for (int j = 0; j < i + 1; j++) {
                currentRow.add(-1);
            }
            // at index 0, we have 1 for every row (Pascal trig)
            currentRow.set(0, lastRow.get(0));
            // at index i (last one), we have 1 for every row (equal to (i - 1))
            currentRow.set(i, lastRow.get(i - 1));
            // traverse from the second elmt to second to the last one
            for (int j = 1; j < i; j++) { // remember size is i + 1, last index is i
                // critical step, Pascal trig property
                currentRow.set(j, lastRow.get(j - 1) + lastRow.get(j));
            }
            // update the last row
            lastRow = currentRow;
        }
        // just return the last row of the list
        return lastRow;
    }
}
