/**
 * Reverse an integer if possible.
 *
 * @author Zezhou Jing, University of Washington
 * @date October 22, 2016
 */

public class NumberReverser {
    // @param n: an integer to be reversed
    // @return: a reversed integer, -1 if overflow happens
    // O(n) time complexity, O(1) space.
    public int reverse(int n) {
        // simple boundary case: a single digit integer does not need reversal
        if (n / 10 == 0) {
            return n;
        }
        int preReverse = 0;
        int reversed = 0;
        while (n != 0) {
            int lastDigit = n % 10;
            preReverse = reversed * 10 + lastDigit;
            // check if overflow happens
            if ((preReverse - lastDigit) / 10 != reversed) {
                return -1;
            }
            reversed = preReverse;
            n /= 10;
        }
        return reversed;
    }
}
