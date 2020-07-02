import java.util.Arrays;

public class ArrayBalance {
    // O(nlogn + n)
    public int minMoves(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int steps = 0;
        while (start < end) {
            steps += nums[end] - nums[start];
            start++;
            end--;
        }
        return steps;
    }
}
