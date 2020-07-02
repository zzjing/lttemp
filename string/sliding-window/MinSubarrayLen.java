
public class MinSubarrayLen {
    // O(n) using "sliding window" (two pointers)
    public int minSubArrayLen(int sum, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int curSum = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            while (curSum >= s) {
                minLen = Math.min(minLen, i - start + 1);
                // shrink the subarray by taking away one element from left
                curSum -= nums[start];
                start++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLen;
        }
    }
}
