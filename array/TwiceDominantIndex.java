
public class TwiceDominantIndex {
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int maxIndex = -1;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != maxIndex && maxVal < nums[i] * 2) {
                return -1;
            }
        }
        return maxIndex;
    }
}
