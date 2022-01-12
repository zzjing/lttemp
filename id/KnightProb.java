// exactly k moves
public double knightProbability(int n, int k, int row, int column) {
    int[][] dirVectors = new int[][]{{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
    double[][][] memo = new double[n][n][k + 1];
    return findProbability(n, k, row, column, memo, dirVectors);
}

private double findProbability(int n, int k, int x, int y, double[][][] memo, int[][] dirVectors) {
    // out of bounds, zero chance to stay on board
    if (x < 0 || x > n - 1 || y < 0 || y > n - 1) {
        return 0;
    }
    if (k == 0) {
        return 1; // not moving at all, probability = 1
    }
    if (memo[x][y][k] != 0) {
        return memo[x][y][k];
    }
    double prob = 0;
    for (int[] direction : dirVectors) { // the probability of moving to any cell is 0.125 * probability before the move
        prob += 0.125 * findProbability(n, k - 1, x + direction[0], y + direction[1], memo, dirVectors);
    }
    memo[x][y][k] = prob;
    return prob;
}
