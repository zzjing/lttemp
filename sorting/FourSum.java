/**
 * Variation of the famous two sum problem.
 * Find all unique quadruplets in an integer array
 * such that their sums all yield the target value.
 * 
 * @author Zezhou Jing, University of Washington
 * @date August 26, 2016
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
    // @param nums: an integer array to search for pairs
    // @param target: the target element to add up to
    // sorting technique; Time complexity O(n^2).
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadSet = new ArrayList<List<Integer>>();
        // simple boundary cases
        if (nums == null || nums.length < 4) {
            return quadSet;
        }
        // sort the given array, assuming complexity O(n log n)
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            // preserve the uniqueness property; skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                // preserve the uniqueness property; skip duplicates
                if (j > i + 1  && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        List<Integer> quadruplet = new ArrayList<>();
                        quadruplet.add(nums[i]);
                        quadruplet.add(nums[j]);
                        quadruplet.add(nums[k]);
                        quadruplet.add(nums[l]);
                        quadSet.add(quadruplet);
                        k++;
                        l--;
                        // preserve the uniqueness property; skip duplicates
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return quadSet;
    }
}
