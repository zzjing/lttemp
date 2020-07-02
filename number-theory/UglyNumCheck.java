/**
 * Check whether a number is an ugly number,
 * which is defined as positive numbers with only prime factors 2, 3, 5.
 * 1 is an ugly number.
 * 
 * @author Zezhou Jing, University of Washington
 * @date October 22, 2016
 */
public class UglyNumCheck {
    // @param n: a positive number to be checked
    // @return: whether that number is an ugly number
    // math solution; time O(n), space O(1)
    // special case
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        // eliminate factor 2
        while (num % 2 == 0) {
            num /= 2;
        }
        // eliminate factor 3
        while (num % 3 == 0) {
            num /= 3;
        }
        // eliminate factor 5
        while (num % 5 == 0) {
            num /= 5;
        }
        // check 2, 3, 5 factors
        return (num == 1);
    }
}
