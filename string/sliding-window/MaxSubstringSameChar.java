import java.util.HashMap;
import java.util.Map;

public class MaxSubstringSameChar {
    public int getLongestSameChar(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int maxLen = 1;
        Map<Character, Integer> charToIndex = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (!charToIndex.containsKey(cur)) {
                charToIndex.put(cur, i);
            } else {
                int curLen = i - charToIndex.get(cur) + 1;
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}
