import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwiceOccuranceEntry {
    // Traditional hashing solution; O(n) time, O(n) space
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> numsFreq = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!numsFreq.containsKey(nums[i])) {
                numsFreq.put(nums[i], 1);
            } else {
                numsFreq.put(nums[i], numsFreq.get(nums[i]) + 1);
            }
        }
        List<Integer> duplicates = new ArrayList<Integer>();
        for (Integer n : numsFreq.keySet()) {
            if (numsFreq.get(n) == 2) {
                duplicates.add(n);
            }
        }
        return duplicates;
    }

    // Optimized hashing solution; O(n) time, O(1) space
    public List<Integer> getDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<Integer>();
        if (nums == null) {
            return duplicates;
        }
        for (int i = 0; i < nums.length; i++) {
            // the location to memorize if current number has occurred before
            int memoLocation = Math.abs(nums[i]) - 1;
            // current number has occurred before
            if (nums[memoLocation] < 0) {
                duplicates.add(Math.abs(nums[i]));
            } else {
                // mark the current number as occurred
                // since it occurs at most twice,
                // we don't have to worry about flipping signs
                nums[memoLocation] = -nums[memoLocation];
            }
        }
        // optional: revert the array to its original
        // for (int i = 0; i < nums.length; i++) {
            // nums[i] = Math.abs(nums[i]);
        // }
        return duplicates;
    }
}
