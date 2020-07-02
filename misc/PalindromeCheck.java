/**
 * Check whether a number is a palindrome.
 *
 * @author Zezhou Jing, University of Washington
 * @date October 22, 2016
 */

public class PalindromeCheck {
    // Math solution; Time complexity O(n), in space.
    public boolean isPalindrome(int n) {
        // negative numbers cannot be palindromes
        // but single-digit positive numbers are
        if (n < 0) {
            return false;
        } else if (n / 10 == 0) {
            return true;
        }
        // initialize a divisor to deal with the leftmost digit
        int divisor = 1;
        while (n / divisor >= 10) {
            divisor *= 10;
        }
        // check whether a number ispalindromic
        while (n != 0) { // cannot change this, consider "1000021"
            int leftMost = n / divisor;
            int rightMost = n % 10;
            if (leftMost != rightMost) {
                return false;
            }
            // eliminate the leftmost and rightmost digits
            n %= divisor;
            n /= 10;
            divisor /= 100;
        }
        return true;
    }
}
