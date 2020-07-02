 /**
 * Variation of the famous two sum problem.
 * Find all unique triplets in an integer array
 * such that their sums are all zero.
 * 
 * @author Zezhou Jing, University of Washington
 * @date August 26, 2016
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    // @param nums: an integer array to search for pairs
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triSet = new ArrayList<List<Integer>>();
        // simple boundary cases
        if (nums == null || nums.length < 3) {
            return triSet;
        }
        // sorting process, complexity O(n log n)
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // ensure uniqueness of the solution set
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // determine the remaining two pivots
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                // one solution set is found
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    triSet.add(triplet);
                    j++;
                    k--;
                    // skip other duplicates
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return triSet;
    }
}
