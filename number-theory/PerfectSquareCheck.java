
public class PerfectSquareCheck {
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        return (Math.pow(sqrt, 2) == num);
    }

    public boolean isPerfectSquareSum(int num) {
        if (num < 0) {
            return false;
        }
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (isPerfectSquare(num - i * i)) {
                return true;
            }
        }
        return false;
    }
}
