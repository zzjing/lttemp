import java.util.Arrays;

public class DungeonRescue {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0) {
            return 1;
        }
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] healthLeft = new int[row + 1][col + 1];
        for (int i = 0; i <= row; i++) {
            Arrays.fill(healthLeft[i], Integer.MAX_VALUE);
        }
        // health when the knight reaches the princess has to be at least 1
        healthLeft[row][col - 1] = 1;
        healthLeft[row - 1][col] = 1;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                int minNeeded = Math.min(healthLeft[i + 1][j], healthLeft[i][j + 1]) - dungeon[i][j];
                if (minNeeded <= 0) {
                    healthLeft[i][j] = 1;
                } else {
                    healthLeft[i][j] = minNeeded;
                }
            }
        }
        return healthLeft[0][0];
    }
}
