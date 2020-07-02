import java.util.HashSet;
import java.util.Set;

public class HappyNumCheck {
    public boolean isHappy(int n) {
        Set<Integer> happyNums = new HashSet<>();
        // That a number cannot be added to the set of intermediate "happy numbers"
        // means that it leads to an infinite loop since it already exists
        while (happyNums.add(n)) {
            int squareSum = 0;
            while (n > 0) {
                int nextDigit = n % 10;
                squareSum += nextDigit * nextDigit;
                n /= 10;
            }
            if (squareSum == 1) {
                return true;
            } else {
                n = squareSum;
            }
        }
        return false;
    }
}
