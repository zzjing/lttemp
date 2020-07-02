/**
 * Find the square root of a positive integer.
 * 
 * @author Zezhou Jing, University of Washington
 * @date August 26, 2016
 */
public class SquareRoot {
    // @param x: a positive integer
    // @return: the integer's square root that rounds to the nearest integer
    // binary search method; Time complexity O(log n), space O(1)
    public int sqrt(int x) {
        long start = 0;
        // a positive number x's square root cannot exceed x / 2 + 1
        long end = x / 2 + 1;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long square = mid * mid;
            // found it, return casted value
            if (square == x) {
                return (int) mid;
            } else if (square < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        // all values run out, return the the only possibility (mid - 1)
        // that is why we choose end = x / 2 + 1 initially
        // but remember to convert back
        return (int) end;
    }
}
