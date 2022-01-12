// shortest distance between two different words
public int shortestDistance(String[] wordsDict, String word1, String word2) {
    int index1 = -1;
    int index2 = -1;
    int minDistance = Integer.MAX_VALUE;
    for (int i = 0; i < wordsDict.length; i++) {
        if (wordsDict[i].equals(word1)) { // complexity
            index1 = i;
            if (index2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(index1 - index2));
            }
        }
        if (wordsDict[i].equals(word2)) {
            index2 = i;
            if (index1 != -1) {
                minDistance = Math.min(minDistance, Math.abs(index1 - index2));
            }
        }
    }
    return minDistance;
} // Time O(n * m) n = number of words, m = total length of two input words; Space O(1)

class WordDistance { // query about word distances between two words
    Map<String, List<Integer>> wordToIndex; // all occurances
    Map<String, Integer> distanceCache; // cache of two-word-distance results

    public WordDistance(String[] wordsDict) { // constructor, finds all indices
        wordToIndex = new HashMap<>();
        distanceCache = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            if (!wordToIndex.containsKey(wordsDict[i])) {
                wordToIndex.put(wordsDict[i], new ArrayList<>());
            }
            wordToIndex.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        // handles repeated calls
        String cacheKey = word1 + "::" + word2;
        String cacheKeyReversed = word2 + "::" + word1;
        if (distanceCache.containsKey(cacheKey)) {
            return distanceCache.get(cacheKey);
        }
        if (distanceCache.containsKey(cacheKeyReversed)) {
            return distanceCache.get(cacheKeyReversed);
        }
        List<Integer> word1Indices = wordToIndex.get(word1);
        List<Integer> word2Indices = wordToIndex.get(word2);
        int i = 0;
        int j = 0;
        int minDistance = Integer.MAX_VALUE;
        // two pointers
        while (i < word1Indices.size() && j < word2Indices.size()) {
            int word1Index = word1Indices.get(i);
            int word2Index = word2Indices.get(j);
            if (word1Index > word2Index) { // shrinks the range (must be ++ due to 0)
                minDistance = Math.min(minDistance, word1Index - word2Index);
                j++;
            } else {
                minDistance = Math.min(minDistance, word2Index - word1Index);
                i++;
            }
            if (minDistance == 1) { // cannot do better
                distanceCache.put(cacheKey, minDistance);
                distanceCache.put(cacheKeyReversed, minDistance);
                return minDistance;
            }
        }
        distanceCache.put(cacheKey, minDistance);
        distanceCache.put(cacheKeyReversed, minDistance);
        return minDistance;
    } // Time O(n + m) Space O(n + m) number of words
}
/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */

// word distance between two words which can be the same
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int minDistance = Integer.MAX_VALUE;
        boolean sameWord = word1.equals(word2); // flag
        for (int i = 0; i < wordsDict.length; i++) {
            // only one condition will be triggered at once
            if (wordsDict[i].equals(word1)) {
                index1 = i;
            } else if (wordsDict[i].equals(word2)) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                minDistance = Math.min(minDistance, Math.abs(index1 - index2));
            }
            // moves cursor to index2 to avoid zero distance: defers calculation
            if (sameWord && wordsDict[i].equals(word1)) {
                index2 = index1;
                index1 = -1;
            }
        }
        return minDistance;
    } // Time O(n * m) n = number of words, m = total length of two input words; Space O(1)
