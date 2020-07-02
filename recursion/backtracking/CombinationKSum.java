import java.util.ArrayList;
import java.util.List;

public class CombinationKSum {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combSet = new ArrayList<>();
        if (k <= 0) {
            return combSet;
        }
        combinationSum3(k, n, combSet, 1, new ArrayList<>());
        return combSet;
    }

    private void combinationSum3(int k, int n,
            List<List<Integer>> combSet, int candidatePos, List<Integer> oneSum) {
        if (k == 0 && n == 0) {
            combSet.add(new ArrayList<>(oneSum));
            return;
        }
        if (k < 0 || n < 0) {
            return;
        }
        for (int i = candidatePos; i <= 9; i++) {
            oneSum.add(i);
            combinationSum3(k - 1, n - i, combSet, i + 1, oneSum);
            oneSum.remove(oneSum.size() - 1);
        }
    }
}
