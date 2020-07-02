
public class IslandCounter {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int islands = 0;
        // boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfsIsland(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfsIsland(char[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 ||
            grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        dfsIsland(grid, i + 1, j);
        dfsIsland(grid, i - 1, j);
        dfsIsland(grid, i, j + 1);
        dfsIsland(grid, i, j - 1);
    }
}
