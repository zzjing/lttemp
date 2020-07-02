/**
 * Finds out in terms of indices the first pair of numbers
 * which sum up to a specific value.
 * Solution to the famous two sum problem in linear time.
 * 
 * @author Zezhou Jing, University of Washington
 * @date September 2, 2016
 */
import java.util.Map;
import java.util.HashMap;

public class TwoSum {
    // @param nums: an array of integers.
    // @param target: a specific value to sum up to.
    // @return: indices of the first pair of numbers which sum up to target.
    // Hashing solution; Time complexity O(n); Space O(n).
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[2];
        }
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numToIndex.containsKey(complement)) {
                int[] sumPair = new int[]{numToIndex.get(complement), i};
                return sumPair;
            } else {
                numToIndex.put(nums[i], i);
            }
        }
        return new int[2];
    }
}
