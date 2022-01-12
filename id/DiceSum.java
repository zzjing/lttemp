// a dice to roll multiple times = n dice to roll once
// find the possibility the sum of points is a target number

public int numRollsToTarget(int d, int 6, int target) {
    // c.f. coin change 2; but this is permutation problem while the other is combination
    // faces = 6, total ways = 6^n
    // final int MOD = 1000000007;
    int[] waysToSum = new int[target + 1];
    // base case: only one way to get 0 sum
    waysToSum[0] = 1;
    // for each die and each of its faces
    // compute the ways to get to target sum
    for (int i = 1; i <= d; i++) { // for each die
        int[] waysToSumByFace = new int[target + 1];
        for (int j = 1; j <= 6; j++) { // for each chosen face to be rolled of that die
            for (int k = j; k <= target; k++) {
                waysToSumByFace[k] = (waysToSumByFace[k] + waysToSum[k - j]); //% MOD
            }
        }
        waysToSum = waysToSumByFace; // only need to store counts for the previous die
    }
    return (double) waysToSum[target] / Math.pow(6, d);
}

Time O(d * 6 * target)
Space O(target)
