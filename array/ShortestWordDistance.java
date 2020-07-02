
public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length <= 1 || word1 == null || word2 == null) {
            return -1;
        }
        int mostRecent1 = -1;
        int mostRecent2 = -1;
        int minDistance = words.length;
        for (int i = 0; i < words.length; i++) {
            String current = words[i];
            if (current.equals(word1)) {
                mostRecent1 = i;
            } else if (current.equals(word2)) {
                mostRecent2 = i;
            }
            if (mostRecent1 != -1 && mostRecent2 != -1) {
                int absDistance = Math.abs(mostRecent2 - mostRecent1);
                minDistance = Math.min(minDistance, absDistance);
            }
        }
        return minDistance;
    }
}
