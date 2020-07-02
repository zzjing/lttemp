
public class SubarrayMaxSum {
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxArrSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            maxArrSum = Math.max(maxArrSum, currentSum);
            currentSum = Math.max(currentSum, 0);
        }
        return maxArrSum;
    }
}
