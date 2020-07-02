import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null) {
            return false;
        }
        return wordBreak(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }

    private boolean wordBreak(String s, Set<String> wordDict, int startIndex, Boolean[] memo) {
        // all possible words are checked (a null-word is trivially in the dict)
        if (startIndex == s.length()) {
            return true; 
        }
        // enable the memoization array to return its entries
        if (memo[startIndex] != null) {
            return memo[startIndex];
        }
        // the endIndex of a word starts one place ahead of the startIndex
        // but it has to be equal to s.length() to substring a last word
        for (int endIndex = startIndex + 1; endIndex <= s.length(); endIndex++) {
            if (wordDict.contains(s.substring(startIndex, endIndex))
                && wordBreak(s, wordDict, endIndex, memo)) { // pass endIndex param
                // all subsequent words must be in the dictionary (recursive case)
                memo[startIndex] = true;
                return memo[startIndex];
            }
        }
        memo[startIndex] = false;
        return memo[startIndex];
    }
}
