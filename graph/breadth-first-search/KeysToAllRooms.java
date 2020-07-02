import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysToAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) {
            return true;
        }
        Set<Integer> hasKeys = new HashSet<>();
        Queue<Integer> bfsRooms = new LinkedList<>();
        hasKeys.add(0);
        bfsRooms.offer(0);
        while (!bfsRooms.isEmpty()) {
            int currentRoom = bfsRooms.poll();
            // conditional bfs; explores the next room only if has key
            if (!hasKeys.contains(currentRoom)) {
                continue;
            }
            // obtains keys to other rooms; skip intermediate steps to reach that room
            List<Integer> keys = rooms.get(currentRoom);
            for (Integer nextKey : keys) {
                if (!hasKeys.contains(nextKey)) {
                    hasKeys.add(nextKey);
                    bfsRooms.offer(nextKey);
                }
            }
            // this should be outside the for loop since list of keys in a room can be empty
            if (hasKeys.size() == rooms.size()) {
                return true;
            }
        }
        return false;
    }
}
