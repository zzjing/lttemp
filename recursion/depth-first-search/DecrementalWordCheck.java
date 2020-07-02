import java.util.HashSet;
import java.util.Set;

public class DecrementalWordCheck {
    public boolean isDecremental(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        Set<String> visited = new HashSet<>();
        return isDecremental(word, visited);
    }

    private boolean isDecremental(String word, Set<String> visited) {
        if (visited.contains(word) || isValid(word)) {
            return false;
        }
        if (word.length() == 1 && isValid(word)) {
            return true;
        }
        for (int i = 0; i <= word.length() - 1; i++) {
            visited.add(word);
            String afterDelete = word.substring(0, i) + word.substring(i + 1);
            if (isDecremental(afterDelete, visited)) {
                return true;
            }
        }
        return false;
    }
}
