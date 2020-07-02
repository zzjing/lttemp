import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        Set<String> dictionary = new HashSet<>(wordList);
        if (!dictionary.contains(endWord)) {
            return 0;
        }
        Queue<String> bfsWords = new LinkedList<>();
        bfsWords.offer(beginWord);
        int curLevel = 1;
        while (!bfsWords.isEmpty()) {
            // bfs: current level is the number of current candidates
            int candidates = bfsWords.size(); // essential to cache this
            for (int i = 0; i < candidates; i++) {
                String curWord = bfsWords.poll();
                for (int j = 0; j < curWord.length(); j++) {
                    char[] wordArr = curWord.toCharArray();
                    for (char k = 'a'; k <= 'z'; k++) {
                        wordArr[j] = k;
                        String nextCandidate = new String(wordArr);
                        if (nextCandidate.equals(endWord)) {
                            return curLevel + 1;
                        }
                        if (dictionary.contains(nextCandidate)) {
                            bfsWords.offer(nextCandidate);
                            dictionary.remove(nextCandidate); // mark the current word as visited
                        }
                    }
                }
            } // run out of the current level of word candidates
            curLevel++;
        }
        return 0;
    }
}
