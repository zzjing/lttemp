import java.util.Arrays;

public class KthLargestEntry {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
