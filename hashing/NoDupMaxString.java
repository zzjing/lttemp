import java.util.HashMap;
import java.util.Map;

public class NoDupMaxString {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int longest = 0;
        Map<Character, Integer> charToIndex = new HashMap<>();
        // formulate a sliding window
        // max length can be found when j is in bounds
        for (int i = 0, j = 0; j < s.length(); j++) {
            // "right edge" of the window
            char current = s.charAt(j);
            // if repeated char is detected, adjust the window edge
            // such that no char is repeated
            if (charToIndex.containsKey(current)) {
                i = Math.max(i, charToIndex.get(current) + 1);
            }
            // update the substring length and position
            longest = Math.max(longest, j - i + 1);
            charToIndex.put(current, j);
        }
        return longest;
    }
}
