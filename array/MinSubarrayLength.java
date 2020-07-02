
public class MinSubarrayLength {
    // O(n) using "sliding window" (two pointers)
    public int minSubArrayLen(int sum, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // two pointers, in which j is the latter one
        int i = 0;
        int j = 0;
        int currentSum = 0;
        int minLen = Integer.MAX_VALUE;
        // can visualize two while loops using a "sliding window"
        while (j < nums.length) {
            currentSum += nums[j];
            j++;
            // when the current sum exceeds the desired sum
            // shrink the subarray by taking away one element from left
            while (currentSum >= sum) {
                minLen = Math.min(minLen, j - i); // update minimum length
                currentSum -= nums[i];
                i++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return 0;
        }
        return minLen;
    }
}
