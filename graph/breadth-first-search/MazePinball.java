import java.util.LinkedList;
import java.util.Queue;

public class MazePinball {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> bfsMaze = new LinkedList<>();
        bfsMaze.offer(start);
        visited[start[0]][start[1]] = true;
        while (!bfsMaze.isEmpty()) {
            int[] current = bfsMaze.poll();
            if (current[0] == destination[0] && current[1] == destination[1]) {
                return true;
            }
            for (int[] direction : dirs) {
                // the ball may be already located around a boundary
                // but this does not mean we cannot bounce it to move
                int bounceX = current[0] + direction[0];
                int bounceY = current[1] + direction[1];
                while (bounceX >= 0 && bounceX < maze.length && bounceY >= 0
                        && bounceY < maze[0].length && maze[bounceX][bounceY] == 0) {
                    bounceX += direction[0];
                    bounceY += direction[1];
                }
                // current location is already out of bounds; have to backtrack
                if (!visited[bounceX - direction[0]][bounceY - direction[1]]) {
                    bfsMaze.offer(new int[] {bounceX - direction[0], bounceY - direction[1]});
                    visited[bounceX - direction[0]][bounceY - direction[1]] = true;
                }
            }
        }
        return false;
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // record minimum distance of every point reachable from the starting point
        // also serves as a martix to record whether a point is visted
        int[][] minDistance = new int[maze.length][maze[0].length];
        for (int i = 0; i < minDistance.length; i++) {
            Arrays.fill(minDistance[i], Integer.MAX_VALUE);
        }
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> bfsMaze = new LinkedList<>();
        bfsMaze.offer(start);
        minDistance[start[0]][start[1]] = 0;
        while (!bfsMaze.isEmpty()) {
            int[] current = bfsMaze.poll();
            for (int[] direction : dirs) {
                int bounceX = current[0] + direction[0];
                int bounceY = current[1] + direction[1];
                int count = 0; // one count behind, but does not matter
                while (bounceX >= 0 && bounceX < maze.length
                    && bounceY >= 0 && bounceY < maze[0].length && maze[bounceX][bounceY] == 0) {
                    bounceX += direction[0];
                    bounceY += direction[1];
                    count++;
                }
                int actualX = bounceX - direction[0];
                int actualY = bounceY - direction[1];
                if (minDistance[current[0]][current[1]] + count < minDistance[actualX][actualY]) {
                    minDistance[actualX][actualY] = minDistance[current[0]][current[1]] + count;
                    // only revisit if a different distance is found (which mostly indicates a different path)
                    bfsMaze.offer(new int[]{actualX, actualY});
                }
            }
        }
        if (minDistance[destination[0]][destination[1]] == Integer.MAX_VALUE) {
            return -1;
        }
        return minDistance[destination[0]][destination[1]];
    }
}
