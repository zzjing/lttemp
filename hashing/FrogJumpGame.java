import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJumpGame {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length <= 1) {
            return true;
        }
        Map<Integer, Set<Integer>> stoneToSteps = new HashMap<>(stones.length - 1);
        for (int i = 0; i < stones.length - 1; i++) {
            stoneToSteps.put(stones[i], new HashSet<>());
        }
        stoneToSteps.get(0).add(1);
        for (int i = 0; i < stones.length - 1; i++) {
            int stone = stones[i];
            for (int step : stoneToSteps.get(stone)) {
                int canReach = stone + step;
                if (canReach == stones[stones.length - 1]) {
                    return true;
                }
                Set<Integer> stepsCanTake = stoneToSteps.get(canReach);
                if (stepsCanTake != null) {
                    stepsCanTake.add(step);
                    stepsCanTake.add(step + 1);
                    if (step - 1 > 0) {
                        stepsCanTake.add(step - 1);
                    }
                }
            }
        }
        return false;
    }
}
