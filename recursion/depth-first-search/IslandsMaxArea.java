
public class IslandsMaxArea {
    public int maxAreaOfIsland(boolean[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    maxArea = Math.max(maxArea, getIslandArea(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    public int numsofBigIsland(boolean[][] grid, int k) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    if (getIslandArea(grid, i, j) >= k) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private int getIslandArea(boolean[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length || !grid[i][j]) {
            return 0;
        }
        grid[i][j] = false;
        return 1 + getIslandArea(grid, i - 1, j) + getIslandArea(grid, i + 1, j)
            + getIslandArea(grid, i, j - 1) + getIslandArea(grid, i, j + 1);
    }
}
