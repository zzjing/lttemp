import java.util.HashMap;
import java.util.Map;

public class PatternCheck {
    // Hash table to check valid bijections solution; O(n) time and O(n) space
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        Map<Character, String> bijections = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char current = pattern.charAt(i);
            if (bijections.containsKey(current)) {
                if (!bijections.get(current).equals(words[i])) {
                    return false;
                }
            } else {
                // current bijections do not contain the key but
                // contain the value, meaning that bijection relation is violated
                if (bijections.containsValue(words[i])) {
                    return false;
                }
                bijections.put(current, words[i]);
            }
        }
        return true;
    }
}
