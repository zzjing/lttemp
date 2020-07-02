import java.util.HashMap;
import java.util.Map;

public class LongestContigArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> sumToIndex = new HashMap<Integer, Integer>();
        sumToIndex.put(0, -1);
        int maxLen = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                // treat the one entry as 1
                sum++;
            } else {
                // treat the zero entry as -1
                sum--;
            }
            // if current sum is 0 (which is in the map)
            if (sumToIndex.containsKey(sum)) {
                // it is a valid contiguous array with
                // length = current index - last starting index
                maxLen = Math.max(maxLen, i - sumToIndex.get(sum));
            } else {
                // record current sum and index
                sumToIndex.put(sum, i);
            }
        }
        return maxLen;
    }
}
