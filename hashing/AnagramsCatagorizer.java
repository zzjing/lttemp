import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramsCatagorizer {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new LinkedList<>();
        }
        Map<String, List<String>> labelToGrams = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String word = strs[i];
            char[] freq = new char[26];
            for (int j = 0; j < word.length(); j++) {
                freq[word.charAt(j) - 'a']++; // - 'a' required; otherwise outofbounds
            }
            // utilize Java language properties: #1#2#8#... to represent letter frequencies
            String label = new String(freq);
            if (!labelToGrams.containsKey(label)) {
                labelToGrams.put(label, new LinkedList<>());
            }
            labelToGrams.get(label).add(word);
        }
        return new LinkedList<>(labelToGrams.values());
    }
}
