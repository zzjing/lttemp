
public class SubarrayMaxProduct {
    public int maxProduct(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int curMax = nums[0];
        int curMin = nums[0];
        int maxProduct = nums[0];
        for (int i = 1 ; i < nums.length; i++) {
            // a negative entry turns a max to min...
            if (nums[i] < 0) { // thus swap them
                int tmp = curMax;
                curMax = curMin;
                curMin = tmp;
            }
            // update max/min products or revert to the current entry
            curMax = Math.max(nums[i], nums[i] * curMax);
            curMin = Math.min(nums[i], nums[i] * curMin);
            maxProduct = Math.max(maxProduct, curMax);
        }
        return maxProduct;
    }
}
