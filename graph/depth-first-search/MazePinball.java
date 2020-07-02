
public class MazePinball {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfsPath(maze, start, destination, visited);
    }

    private boolean dfsPath(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        if (visited[start[0]][start[1]]) {
            return false;
        }
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }
        visited[start[0]][start[1]] = true;
        // coordinates may already be around a boundary position; have to bounce it to move
        // pre-processed already; have to backtrack later
        int left = start[1] - 1;
        int right = start[1] + 1;
        int up = start[0] - 1;
        int down = start[0] + 1;
        while (left >= 0 && maze[start[0]][left] == 0) {
            left--;
        }
        // backtrack the left coordinate
        if (dfsPath(maze, new int[] {start[0], left + 1}, destination, visited)) {
            return true;
        }
        while (right < maze[0].length && maze[start[0]][right] == 0) {
            right++;
        }
        if (dfsPath(maze, new int[] {start[0], right - 1}, destination, visited)) {
            return true;
        }
        while (up >= 0 && maze[up][start[1]] == 0) {
            up--;
        }     
        if (dfsPath(maze, new int[] {up + 1, start[1]}, destination, visited)) {
            return true;
        }
        while (down < maze.length && maze[down][start[1]] == 0) {
            down++;
        }
        if (dfsPath(maze, new int[] {down - 1, start[1]}, destination, visited)) {
            return true;
        }
        return false;
    }
}
