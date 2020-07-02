
public class SubarrayMaxSum {
    // Jon Bentley
    // (Sep. 1984 Vol. 27 No. 9 Communications of the ACM P885)
    public int getMaxSubarray(int[] nums) {
        // define a maximum sum assuming that nums[i] would be included
        // and a maximum sum w/o considering current entry nums[i] yet
        int maxSumIcCur = nums[0];
        int maxSumSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // only two cases for ExCur: a contiguous array + nums[i]
            // or an array with only nums[i] > maxSumExCur
            maxSumIcCur = Math.max(maxSumIcCur + nums[i], nums[i]);
            maxSumSoFar = Math.max(maxSumSoFar, maxSumIcCur);
        }
        return maxSumSoFar;
    }

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
