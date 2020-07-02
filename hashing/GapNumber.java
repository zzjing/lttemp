import java.util.ArrayList;
import java.util.List;

public class GapNumber {
    // Hashing solution; O(n) time, O(1) space
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missing = new ArrayList<Integer>();
        if (nums == null) {
            return missing;
        }
        for (int i = 0; i < nums.length; i++) {
            // the location to memorize if current number has occurred before
            int memoLocation = Math.abs(nums[i]) - 1;
            if (nums[memoLocation] > 0) {
                // mark the current number as occurred
                nums[memoLocation] = -nums[memoLocation];
            }
        }
        // find missing numbers and revert the array to its original
        // (its corresponding bucket is positive)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing.add(i + 1);
            }
            nums[i] = Math.abs(nums[i]);
        }
        return missing;
    }
}
