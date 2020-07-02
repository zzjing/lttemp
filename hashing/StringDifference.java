import java.util.HashMap;
import java.util.Map;

public class StringDifference {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (!freq.containsKey(current)) {
                freq.put(current, 1);
            } else {
                freq.put(current, freq.get(current) + 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char current = t.charAt(i);
            if (!freq.containsKey(current)) {
                return current;
            }
            freq.put(current, freq.get(current) - 1);
            if (freq.get(current) < 0) {
                return current;
            }
        }
        return ' ';
    }

    public char getDifference(String s, String t) {
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            frequency[current - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char current = t.charAt(i);
            if (frequency[current - 'a'] == 0) {
                return current;
            }
            frequency[current - 'a']--;
            if (frequency[current - 'a'] < 0) {
                return current;
            }
        }
        return ' ';
    }
}
