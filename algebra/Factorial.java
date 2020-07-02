/**
 * Compute the factorial of a nonnegative integer (n!).
 * 
 * @author Zezhou Jing, University of Washington
 * @date October 3, 2016
 */

public class Factorial {
    // recursive approach
    public int factorial(int n) {
        if (n < 2) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // iterative approach
    public int fact(int n) {
        int factorial = 1;
        for (int i = n; i > 1; i--) {
            factorial *= i;
        }
        return factorial;
    }
}
