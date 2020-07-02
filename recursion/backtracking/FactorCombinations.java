import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> factors = new ArrayList<List<Integer>>();
        getFactors(factors, new ArrayList<Integer>(), n, 2);
        return factors;
    }

    private void getFactors(List<List<Integer>> factors, List<Integer> valFactor,
        int n, int start) {
        if (n <= 1) {  // i <= n is required otherwise cannot reach the base case
            if (valFactor.size() > 1) {
                factors.add(new ArrayList<Integer>(valFactor));
            }
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                valFactor.add(i); // wish to reuse the same factor later
                getFactors(factors, valFactor, n / i, i);
                valFactor.remove(valFactor.size() - 1);
            }
        }
    }
}
