import java.util.Arrays;

public class OlympicRanks {
    public String[] findRelativeRanks(int[] nums) {
        // Sorting and hashing solution; O(n logn) time, O(n) space.
        // copy to a new array to sort
        Integer[] indices = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indices[i] = i;
        }
        // sort the index array by scores
        Arrays.sort(indices, (a, b) -> (nums[b] - nums[a]));
        // such that index of the highest score goes first
        String[] ranks = new String[nums.length];
        // assign ranks according to indices recorded
        for (int i = 0; i < ranks.length; i++) {
            if (i == 0) {
                ranks[indices[0]] = "Gold Medal";
            } else if (i == 1) {
                ranks[indices[1]] = "Silver Medal";
            } else if (i == 2) {
                ranks[indices[2]] = "Bronze Medal";
            } else {
                ranks[indices[i]] = "" + (i + 1);
            }
        }
        return ranks;
    }
}
