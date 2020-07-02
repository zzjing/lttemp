
public class NearestGate {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    gateDFSroom(rooms, i, j, 0);
                }
            }
        }
    }

    private void gateDFSroom(int[][] rooms, int i, int j, int distance) {
        if (i < 0 || i > rooms.length - 1 ||
            j < 0 || j > rooms[0].length - 1 || rooms[i][j] < distance) {
            return;
        }
        rooms[i][j] = distance;
        gateDFSroom(rooms, i - 1, j, distance + 1);
        gateDFSroom(rooms, i + 1, j, distance + 1);
        gateDFSroom(rooms, i, j - 1, distance + 1);
        gateDFSroom(rooms, i, j + 1, distance + 1);
    }
}
