
// paint the boundary of islands on a map with a desired color 
public class BoundaryPainter {
    public char[][] colorIslandBoundary(char[][] map, char highLight) {
        if (map == null || map.length <= 1) {
            return map;
        }
        // 0: water; 1: island.
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == '1') {
                    explore(map, i, j);
                }
            }
        }
        // paint the boundary
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'B') {
                    map[i][j] = highLight;
                }
                if (map[i][j] == 'W') {
                    map[i][j] = '0';
                }
            }
        }
        return map;
    }

    private boolean isBoundary(char[][] map, int i, int j) {
        if ((i == 0 || j == 0 || i == map.length - 1 || j == map[0].length - 1) &&
            map[i][j] == '1') {
            return true;
        }
        return (map[i + 1][j] == '0' || map[i - 1][j] == '0' ||
                map[i][j + 1] == '0' || map[i][j - 1] == '0');
    }

    private void explore(char[][] map, int i, int j) {
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length || map[i][j] != '1') {
            return;
        }
        if (isBoundary(map, i, j)) {
            map[i][j] = 'B';
        } else {
            map[i][j] = 'W';
        }
        explore(map, i + 1, j);
        explore(map, i - 1, j);
        explore(map, i, j + 1);
        explore(map, i, j - 1);
    }
}
