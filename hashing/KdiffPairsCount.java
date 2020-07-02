import java.util.HashSet;
import java.util.Set;

public class KdiffPairsCount {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        Set<Integer> unique = new HashSet<Integer>();
        Set<Integer> pairs = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int kPlus = nums[i] + k;
            int kMinus = nums[i] - k;
            // store only the smaller element of the pair
            if (unique.contains(kPlus)) {
                pairs.add(nums[i]);
            }
            if (unique.contains(kMinus)) {
                pairs.add(kMinus);
            }
            unique.add(nums[i]);
        }
        return pairs.size();
    }
}
