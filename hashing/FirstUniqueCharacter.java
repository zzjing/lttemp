import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {
    // O(n) using a hash table
    public int firstUniqChar(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        char[] input = s.toCharArray();
        for (int i = 0; i < input.length; i++) {
            if (!freq.containsKey(input[i])) {
                freq.put(input[i], 1);
            } else {
                freq.put(input[i], freq.get(input[i]) + 1);
            }
        }
        for (int i = 0; i < input.length; i++) {
            if (freq.get(input[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
    // O(n) without actually using a hash table
    public int getFirstUnique(String s) {
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (frequency[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
