import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWallCut {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) {
            return 0;
        }
        int alignCount = 0;
        Map<Integer, Integer> brickToAlign = new HashMap<>();
        for (List<Integer> row : wall) {
            int rowLen = 0;
            // we do not consider cutting throw the end of the wall
            for (int i = 0; i < row.size() - 1; i++) {
                rowLen += row.get(i);
                if (!brickToAlign.containsKey(rowLen)) {
                    brickToAlign.put(rowLen, 1);
                } else {
                    brickToAlign.put(rowLen, brickToAlign.get(rowLen) + 1);
                }
                alignCount = Math.max(alignCount, brickToAlign.get(rowLen));
            }
        }
        return wall.size() - alignCount;
    }
}
