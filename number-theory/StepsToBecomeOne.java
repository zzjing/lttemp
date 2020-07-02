import java.util.HashSet;
import java.util.Set;

public class StepsToBecomeOne {
    public int getSteps(int num) {
        if (num <= 1) {
            return 0;
        }
        Set<Integer> occurance = new HashSet<>();
        int steps = 0;
        while (occurance.add(num)) {
            // odd
            if (num % 2 == 1) {
                num *= 3;
                num++;
                steps++;
            } else if (num % 2 == 0) {
                num /= 2;
                steps++;
                
            }
            if (num == 1) {
                return steps;
            }
        }
        return -1;
    }
}
