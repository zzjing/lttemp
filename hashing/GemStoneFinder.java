import java.util.HashSet;
import java.util.Set;

public class GemStoneFinder {
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return 0;
        }
        Set<Character> allJewels = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            char jewel = J.charAt(i);
            allJewels.add(jewel);
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char current = S.charAt(i);
            if (allJewels.contains(current)) {
                count++;
            }
        }
        return count;
    }
}
