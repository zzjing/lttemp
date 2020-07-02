import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class SimilarSentenceCheck {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if ((words1 == null && words2 == null) || (words1.length == 0 && words2.length == 0)) {
            return true;
        } else if (words1 == null || words2 == null) {
            return false;
        } else if (words1.length != words2.length) {
            return false;
        }
        Map<String, List<String>> wordGraph = new HashMap<>();
        for (String[] pair : pairs) {
            if (!wordGraph.containsKey(pair[0])) {
                wordGraph.put(pair[0], new LinkedList<>());
            }
            if (!wordGraph.containsKey(pair[1])) {
                wordGraph.put(pair[1], new LinkedList<>());
            }
            wordGraph.get(pair[0]).add(pair[1]);
            wordGraph.get(pair[1]).add(pair[0]);
        }
        // DFS via stack
        for (int i = 0; i < words1.length; i++) {
            String word1 = words1[i];
            String word2 = words2[i];
            Stack<String> dfsGraph = new Stack<>();
            Set<String> visited = new HashSet<>();
            dfsGraph.push(word1);
            visited.add(word1);
            boolean similarPath = false;
            while (!dfsGraph.isEmpty()) {
                String curWord1 = dfsGraph.pop();
                if (curWord1.equals(word2)) {
                    // a path to word2 is found
                    // --> similar by transitive property
                    similarPath = true;
                    break;
                }
                if (wordGraph.containsKey(curWord1)) {
                    for (String next : wordGraph.get(curWord1)) {
                        if (!visited.contains(next)) {
                            dfsGraph.push(next);
                            visited.add(next);
                        }
                    }
                }
            }
            if (!similarPath) {
                return false;
            }
        }
        return true;
    }
}
