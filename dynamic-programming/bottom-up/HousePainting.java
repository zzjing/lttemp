
public class HousePainting {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int lastRow = costs.length - 1;
        for (int i = 1; i <= lastRow; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        return Math.min(Math.min(costs[lastRow][0], costs[lastRow][1]), costs[lastRow][2]);
    }

    public int minKCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int k = costs[0].length;
        // maintain two indices: smallest cost until the last row, second smallest
        int minIndex = -1;
        int min2Index = -1;
        for (int i = 0; i < n; i++) {
            int lastRowMin = minIndex;
            int lastRowMin2 = min2Index;
            minIndex = -1;
            min2Index = -1;
            for (int j = 0; j < k; j++) {
                // remember current index has to be different from that of the prev row
                if (j != lastRowMin && i > 0) { // not initialized yet (first row)
                    costs[i][j] += costs[i - 1][lastRowMin];
                } else if (i > 0) {
                    costs[i][j] += costs[i - 1][lastRowMin2];
                }
                // update the lowest cost indices for the current row
                if (minIndex < 0 || costs[i][j] < costs[i][minIndex]) {
                    min2Index = minIndex;
                    minIndex = j;
                } else if (min2Index < 0 || costs[i][j] < costs[i][min2Index]) {
                    min2Index = j;
                }
            }
        }
        return costs[n - 1][minIndex];
    }
}
