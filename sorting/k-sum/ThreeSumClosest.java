/**
 * Variation of the famous two sum problem.
 * Find a triplet in an integer array such that its sum is closest to a target.
 * 
 * @author Zezhou Jing, University of Washington
 * @date August 27, 2016
 */
import java.util.Arrays;

public class ThreeSumClosest {
    // Sorting solution; Time complexity O(n^2).
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(nums);
        // assume a closest triplet
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int currentSum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                    closestSum = currentSum;
                }
                if (currentSum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return closestSum;
    }
}
