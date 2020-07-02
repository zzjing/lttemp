import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SimilarSentenceCheck {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if ((words1 == null && words2 == null) || (words1.length == 0 && words2.length == 0)) {
            return true;
        } else if (words1 == null || words2 == null) {
            return false;
        } else if (words1.length != words2.length) {
            return false;
        }
        Map<String, Set<String>> similars = new HashMap<>();
        for (String[] pair : pairs) {
            if (pair.length == 2) {
                if (!similars.containsKey(pair[0])) {
                    similars.put(pair[0], new HashSet<String>());
                }
                if (!similars.containsKey(pair[1])) {
                    similars.put(pair[1], new HashSet<String>());
                }
                similars.get(pair[0]).add(pair[1]);
                similars.get(pair[1]).add(pair[0]);
            }
        }
        for (int i = 0; i < words1.length; i++) {
            String word1 = words1[i];
            String word2 = words2[i];
            if (word1.equals(word2)) {
                continue;
            }
            if (!similars.containsKey(word1)) {
                return false;
            }
            if (!similars.get(word1).contains(word2)) {
                return false;
            }
        }
        return true;
    }
}
