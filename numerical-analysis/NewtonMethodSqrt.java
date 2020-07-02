/**
 * Use Newton's method (iterative) to compute the square root of
 * a nonnegative number, with not very high accuracy.
 * Namely solve for zeros of x^2 = n, or f(x) = x^2 - n.
 *
 * @author Zezhou Jing, University of Washington
 * @date August 23, 2016
 */

public class NewtonMethodSqrt {
    // @param n: a nonnegative integer to compute its square root
    public double sqrt(int n) {
        // square root of 0.0 is 0
        if (n == 0) {
            return 0.0;
        }
        // x_0 = s, an initial guess
        // iteration: x_{n + 1} = x_n - f(x_n)/f'(x_n)
        // here f'(x) = 2x, so we have x_{n + 1} = (n / x + x) / 2
        double lastRoot = 0.0;
        double currentRoot = 1.0;
        // the ideal case, current root converges to the fixed point solution
        while (currentRoot != lastRoot) {
            // save the "current" root as x_n to compute the next
            lastRoot = currentRoot;
            // update the root to x_{n + 1}
            currentRoot = (n / currentRoot + currentRoot) / 2.0;
        }
        return currentRoot;
    }
}
