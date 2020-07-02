import java.util.HashMap;
import java.util.Map;

public class MaxSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || k <= 0) {
            return 0;
        }
        Map<Character, Integer> charToFreq = new HashMap<>();
        int leftIndex = 0;
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (!charToFreq.containsKey(current)) {
                charToFreq.put(current, 1);
            } else {
                charToFreq.put(current, charToFreq.get(current) + 1);
            }
            // has more than k distinct characters: move the left side of the window
            while (charToFreq.size() > k) {
                char leftChar = s.charAt(leftIndex);
                charToFreq.put(leftChar, charToFreq.get(leftChar) - 1);
                if (charToFreq.get(leftChar) == 0) {
                    charToFreq.remove(leftChar);
                }
                leftIndex++;
            }
            longest = Math.max(longest, i - leftIndex + 1);
        }
        return longest;
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.isEmpty() || k == 0) {
            return 0;
        }
        TreeMap<Integer, Character> lastOccurrence = new TreeMap<>();
        Map<Character, Integer> inWindow = new HashMap<>();
        int j = 0;
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            char in = s.charAt(i);
            while (inWindow.size() == k && !inWindow.containsKey(in)) {
                int first = lastOccurrence.firstKey();
                char out = lastOccurrence.get(first);
                inWindow.remove(out);
                lastOccurrence.remove(first);
                j = first + 1;
            }
            //update or add in's position in both maps
            if (inWindow.containsKey(in)) {
                lastOccurrence.remove(inWindow.get(in));
            }
            inWindow.put(in, i);
            lastOccurrence.put(i, in);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
