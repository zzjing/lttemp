import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combSets = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return combSets;
        }
        // Arrays.sort(candidates);
        combinationSum(candidates, target, 0, combSets, new ArrayList<>());
        return combSets;
    }

    private void combinationSum(int[] candidates, int target,
            int candidatePos, List<List<Integer>> combSets, List<Integer> oneSum) {
        if (target == 0) {
            combSets.add(new ArrayList<>(oneSum));
            return;
        }
        if (target < 0) { // not equal to the desired sum, do nothing
            return;
        }
        // i starts with the initial position of the last unexhausted candidate
        for (int i = candidatePos; i < candidates.length; i++) {
            oneSum.add(candidates[i]);
            // ensure that we can reuse candidates[i] later -- but not duplicate ones
            // i.e. adding candidate[i] to the oneSum twice or more
            combinationSum(candidates, target - candidates[i], i, combSets, oneSum);
            oneSum.remove(oneSum.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combSets = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return combSets;
        }
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, combSets, new ArrayList<>());
        return combSets;
    }

    private void combinationSum2(int[] candidates, int target, int candidatePos,
            List<List<Integer>> combSets, List<Integer> oneSum) {
        if (target == 0) {
            combSets.add(new ArrayList<>(oneSum));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = candidatePos; i < candidates.length; i++) {
            // avoid duplicate set invoked by using identital elements
            // would result in duplcate combinations added to the set otherwise
            if (i != candidatePos && candidates[i] == candidates[i - 1]) {
                continue;
            }
            oneSum.add(candidates[i]); // update candidate position: avoid reusing the same element
            combinationSum2(candidates, target - candidates[i], i + 1, combSets, oneSum);
            oneSum.remove(oneSum.size() - 1);
        }
    }
}
