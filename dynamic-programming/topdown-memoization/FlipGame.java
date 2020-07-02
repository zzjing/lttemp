import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> moves = new ArrayList<>();
        if (s == null || s.length() <= 1) {
            return moves; // no valid next move
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                String nextMove = s.substring(0, i - 1) + "--" + s.substring(i + 1);
                moves.add(nextMove);
            }
        }
        return moves;
    }

    public boolean canWin(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }
        Map<String, Boolean> hasNext = new HashMap<>();
        return canWin(s, hasNext);
    }

    private boolean canWin(String s, Map<String, Boolean> hasNext) {
        if (hasNext.containsKey(s)) {
            return hasNext.get(s);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String nextForOpp = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!canWin(nextForOpp, hasNext)) {
                    hasNext.put(s, true);
                    return true;
                }
            }
        }
        hasNext.put(s, false);
        return false;
    }
}
