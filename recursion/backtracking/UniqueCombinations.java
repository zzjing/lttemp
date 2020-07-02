import java.util.LinkedList;
import java.util.List;

public class UniqueCombinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new LinkedList<>();
        if (k <= 0) {
            return combinations;
        }
        combine(n, k, combinations, new LinkedList<>(), 1);
        return combinations;
    }

    private void combine(int n, int k, List<List<Integer>> combinations,
            List<Integer> oneComb, int candidatePos) {
        if (oneComb.size() == k) {
            combinations.add(new LinkedList<>(oneComb));
            return;
        }
        // a number can be used only once; move on to the next one at once
        // note to pass (i + 1) instead of (start + 1) (e.g. [2, 4] and [4, 2])
        // s.t. you choose only from larger elements to avoid duplicates
        for (int i = candidatePos; i <= n; i++) {
            oneComb.add(i);
            combine(n, k, combinations, oneComb, i + 1);
            oneComb.remove(oneComb.size() - 1);
        }
    }
}
