
public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        } else if (A.length == 1) {
            return true;
        }
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                increasing = false;
            }
            if (A[i] < A[i + 1]) {
                decreasing = false;
            }
        }
        return increasing || decreasing;
    }
}
