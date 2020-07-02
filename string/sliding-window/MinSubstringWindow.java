import java.util.HashMap;
import java.util.Map;

public class MinSubstringWindow {
    public String minWindow(String s, String t) {
        if (s == null && t == null) {
            return "";
        } else if (s == null) {
            return "";
        }
        Map<Character, Integer> charToFreq = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char cur = t.charAt(i);
            if (!charToFreq.containsKey(cur)) {
                charToFreq.put(cur, 1);
            } else {
                charToFreq.put(cur, charToFreq.get(cur) + 1);
            }
        }
        int minLen = Integer.MAX_VALUE;
        int uniqueCount = charToFreq.size();
        int strStart = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            char cur = s.charAt(j);
            if (charToFreq.containsKey(cur)) {
                charToFreq.put(cur, charToFreq.get(cur) - 1);
                if (charToFreq.get(cur) == 0) {
                    uniqueCount--;
                }
            }
            while (uniqueCount == 0) {
                char leftChar = s.charAt(i);
                // make the leftmost character available again (if possible)
                if (charToFreq.containsKey(leftChar)) {
                    if (charToFreq.get(leftChar) == 0) {
                        uniqueCount++;
                    }
                    charToFreq.put(leftChar, charToFreq.get(leftChar) + 1);
                }
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    strStart = i;
                }
                i++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(strStart, strStart + minLen);
    }
}
