import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueSubsets {
    // increasing the position of the candidate to be chosen from
    // would keep track of the layer of recursion (pos = level of recursion)
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return allSubsets;
        }
        // Arrays.sort(nums);
        getSubsets(nums, allSubsets, new ArrayList<>(), 0);
        return allSubsets;
    }

    private void getSubsets(int[] nums, List<List<Integer>> allSubsets,
        List<Integer> set, int candidatePos) {
        // add all possible (but unique) subsets without returning
        allSubsets.add(new ArrayList<>(set));
        // the loop terminates itself after exhausting all elements in nums
        // no need to "skip duplicates" since nums is of distinct elements
        for (int i = candidatePos; i < nums.length; i++) {
            set.add(nums[i]);
            getSubsets(nums, allSubsets, set, i + 1);
            set.remove(set.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> uniqueSets = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return uniqueSets;
        }
        Arrays.sort(nums);
        subsetsWithDup(nums, uniqueSets, new ArrayList<>(), 0);
        return uniqueSets;
    }

    private void subsetsWithDup(int[] nums, List<List<Integer>> uniqueSets,
        List<Integer> set, int candidatePos) {
        // add all possible (but unique) subsets without returning
        uniqueSets.add(new ArrayList<>(set));
        // need to "skip duplicates" since nums is not of distinct elements
        // but *because of missing return statement above
        // for the same level of recursion, all duplicate elements are used
        // i.e. after backtracking, duplicate elements won't be used
        for (int i = candidatePos; i < nums.length; i++) {
            if (i != candidatePos && nums[i] == nums[i - 1]) {
                continue;
            }
            set.add(nums[i]);
            subsetsWithDup(nums, uniqueSets, set, i + 1);
            set.remove(set.size() - 1);
        }
    }
}
