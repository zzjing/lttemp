
public class ProductKSubarray {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return 0;
        }
        int subarrayNum = 0;
        int winProduct = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            winProduct *= nums[j];
            while (i <= j && winProduct >= k) {
                winProduct /= nums[i];
                i++;
            }
            subarrayNum += (j - i + 1);
        }
        return subarrayNum;
    }
}
