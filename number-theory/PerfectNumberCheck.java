
public class PerfectNumberCheck {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                // i is a divisor; so is num / i.
                sum += i + num / i;
            }
        }
        // don't forget to add one
        sum++;
        return (sum == num);
    }
}
