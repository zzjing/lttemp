import java.util.HashMap;
import java.util.Map;

public class KdistanceSameNum {
    /**
     * @param nums: the arrays
     * @param k: the distance of the same number
     * @return: the ans of this question: lintcode 1368
     */
    public boolean sameNumber(int[] nums, int k) {
        // Write your code here
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!numToIndex.containsKey(nums[i])) {
                numToIndex.put(nums[i], i);
            } else {
                if (Math.abs(i - numToIndex.get(nums[i])) < k) {
                    return true;
                } else {
                    numToIndex.put(nums[i], i);
                }
            }
        }
        return false;
    }
}
