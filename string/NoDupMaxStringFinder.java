import java.util.HashMap;
import java.util.Map;

public class NoDupMaxStringFinder {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int longest = 0;
        Map<Character, Integer> charToIndex = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            char current = s.charAt(j);
            if (charToIndex.containsKey(current)) {
                i = Math.max(i, charToIndex.get(current)); // move i cursor
            }
            longest = Math.max(longest, j - i + 1); // update length of the string
            charToIndex.put(current, j + 1); // position for i to jump to in the future
        }
        return longest;
    }
}
