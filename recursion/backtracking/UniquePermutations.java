import java.util.ArrayList;
import java.util.List;

public class UniquePermutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return permutations;
        }
        // Arrays.sort(nums);
        permute(nums, permutations, new ArrayList<>());
        return permutations;
    }

    private void permute(int[] nums, List<List<Integer>> permutations, List<Integer> onePerm) {
        if (onePerm.size() == nums.length) {
            permutations.add(new ArrayList<>(onePerm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (onePerm.contains(nums[i])) {
                continue;
            }
            // recursive tracing
            // 1, 2, 3 -> 1, (2->3), 2; (1->2), 1, 3...
            onePerm.add(nums[i]);
            permute(nums, permutations, onePerm);
            onePerm.remove(onePerm.size() - 1);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return permutations;
        }
        Arrays.sort(nums);
        permuteUnique(nums, permutations, new ArrayList<>(), new boolean[nums.length]);
        return permutations;
    }

    private void permuteUnique(int[] nums, List<List<Integer>> permutations,
        List<Integer> onePerm, boolean[] visited) {
        if (onePerm.size() == nums.length) {
            permutations.add(new ArrayList<>(onePerm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // the number is already used
            if (visited[i]) {
                continue;
            }
            // add an (second, third...) identical number only if its previous copy is used
            // duplicate permutations are thus skipped by only using each copy exactly once
            if (i > 0 && (nums[i] == nums[i - 1]) && !visited[i - 1]) {
               continue;
            }
            onePerm.add(nums[i]);
            visited[i] = true;
            permuteUnique(nums, permutations, onePerm, visited);
            // undo the last choice and mark the choice as unused
            onePerm.remove(onePerm.size() - 1);
            visited[i] = false;
        }
    }
}
