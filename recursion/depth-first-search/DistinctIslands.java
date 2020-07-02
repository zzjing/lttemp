import java.util.HashSet;
import java.util.Set;

public class DistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        Set<String> distinct = new HashSet<>();
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfsIsland(grid, sb, i, j, "o");
                    distinct.add(sb.toString());
                    // the paths taken by dfs is the same iff the shapes are the same
                }
            }
        }
        return distinct.size();
    }

    private void dfsIsland(int[][] grid, StringBuilder sb, int i, int j, String dirMark) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        sb.append(dirMark);
        grid[i][j] = 0;
        dfsIsland(grid, sb, i - 1, j, "l");
        dfsIsland(grid, sb, i + 1, j, "r");
        dfsIsland(grid, sb, i, j - 1, "u");
        dfsIsland(grid, sb, i, j + 1, "d");
        sb.append("e"); // end the dfs search
    }
}
