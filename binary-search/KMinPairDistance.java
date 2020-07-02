import java.util.Arrays;

public class KMinPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(nums);
        int start = 0;
        int end = nums[nums.length - 1] - nums[0];
        while (start < end) {
            int mid = start + (end - start) / 2;
            int pairCount = 0;
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                while (nums[right] - nums[left] > mid) {
                    left++;
                }
                pairCount += (right - left);
            }
            if (pairCount >= k) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
