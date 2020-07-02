class IslandCounter {
public:
    int numIslands(vector<vector<char>>& grid) {
        if (grid.size() == 0 || grid[0].size() == 0) {
            return 0;
        }
        int islandCount = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (grid[i][j] == '1') {
                    exploreIsland(grid, i, j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

private:
    void exploreIsland(vector<vector<char>>& grid, int x, int y) {
        if (x < 0 || x >= grid.size() || y < 0 || y >= grid[0].size() || grid[x][y] != '1') {
            return;
        }
        grid[x][y] = '0';
        exploreIsland(grid, x - 1, y);
        exploreIsland(grid, x + 1, y);
        exploreIsland(grid, x, y - 1);
        exploreIsland(grid, x, y + 1);
    }
};
