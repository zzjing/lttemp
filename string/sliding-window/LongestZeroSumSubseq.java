import java.util.HashMap;
import java.util.Map;

public class LongestZeroSumSubseq {
    public int getLongestSubseq(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxLen = 1;
        int sumSoFar = 0;
        Map<Integer, Integer> sumsofarToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sumSoFar += nums[i];
            if (!sumsofarToIndex.containsKey(sumSoFar)) {
                sumsofarToIndex.put(sumSoFar, i);
            } else {
                int curLen = i - sumsofarToIndex.get(sumSoFar) + 1;
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}
