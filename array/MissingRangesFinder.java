import java.util.ArrayList;
import java.util.List;

public class MissingRangesFinder {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> missingRanges = new ArrayList<>();
        if (nums == null || lower > upper) {
            return missingRanges;
        }
        // next number to be found: initialized as lower bound
        int nextLowerBd = lower;
        for (int i = 0 ; i < nums.length; i++) {
            // exclude numbers that are not within the range
            if (nums[i] < nextLowerBd) {
                continue;
            }
            // move the lower bound to the next consecutive number
            if (nums[i] == nextLowerBd) {
                nextLowerBd++;
                continue;
            }
            // missing range: current lower bound -> current num - 1
            missingRanges.add(getRange(nextLowerBd, nums[i] - 1));
            nextLowerBd = nums[i] + 1; // update lower bound
        }
        // solve the fence post condition
        if (nextLowerBd <= upper) {
            missingRanges.add(getRange(nextLowerBd, upper));
        }
        return missingRanges;
    }

    private String getRange(int low, int high) {
        if (low == high) {
            return String.valueOf(low);
        }
        return low + "->" + high;
    }
}
