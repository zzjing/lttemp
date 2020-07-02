
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        // 4 * # of island components - # of adjacent components
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int perimeter = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        perimeter--; // check upside
                    }
                    if (i < row - 1 && grid[i + 1][j] == 1) {
                        perimeter--; // check downside
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        perimeter--; // check leftside
                    }
                    if (j < col - 1 && grid[i][j + 1] == 1) {
                        perimeter--; // check rightside
                    }
                }
            }
        }
        return perimeter;
    }
}
