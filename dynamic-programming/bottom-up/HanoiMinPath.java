import java.util.List;

public class HanoiMinPath {
    public int getMinPath(List<List<Integer>> triangle) {
        // note that the height of the pile = length of the last row
        int[] minPath = new int[triangle.size() + 1];
        int row = triangle.size() - 1;
        for (int i = row; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                // the entry j + 1 in the last row is why we need minPath = int[triangle.size() + 1]
                minPath[j] = Math.min(minPath[j], minPath[j + 1]) + triangle.get(i).get(j);
            }
        }
        return minPath[0];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        // begin with second to the last row
        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int curEntry = triangle.get(i).get(j);
                int curMinPath = curEntry +
                        Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, curMinPath);
            }
        }
        return triangle.get(0).get(0);
    }
}
