/**
 * Implementation of the exponentiation operations in mathematics.
 * 
 * @author Zezhou Jing, University of Washington
 * @date August 25, 2016
 */
public class Exponentiation {
    // @param x: the base
    // @param n: the exponent
    // @return: the nth power of the base element
    public double pow(double x, int n) {
        // skipped positive and negative infinity cases
        // divide and conquer solution; time complexity O(log n), space O(1)
        // negative powers case, take the reciprocal and change sign
        if (n < 0) {
            return 1 / power(x, -n);
        } else {
            return power(x, n);
        }
    }

    private double power(double x, int n) {
        // base case, any number's zeroth power is 1
        if (n == 0) {
            return 1;
        }
        // recursively divide the power factor
        double halfPow = power(x, n / 2);
        // check odd and even cases and do the calculation
        if (n % 2 == 0) {
            return halfPow * halfPow;
        } else {
            // odd power, multiply by x
            return x * halfPow * halfPow;
        }
    }
}
