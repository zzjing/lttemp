// raw title, clean titles; find the one with highest match

public class NormalizedTitle {
    public String getHighestTitle(String rawTitle, String[] cleanTitles) {
        String[] rawTitleWords = rawTitle.split(" ");
        Map<String, Integer> wordToFrequency = new HashMap<>();
        for (String word : rawTitleWords) {
            if (!wordToFrequency.containsKey(word)) {
                wordToFrequency.put(word, 0);
            }
            wordToFrequency.put(word, wordToFrequency.get(word) + 1);
        }
        int highScore = 0;
        String highest = "";
        for (String ct : cleanTitles) {
            String[] cleanTitleWords = ct.split(" ");
            Map<String, Integer> cleanwordToFrequency = new HashMap<>();
            for (String word : cleanTitleWords) {
                if (!cleanwordToFrequency.containsKey(word)) {
                    cleanwordToFrequency.put(word, 0);
                }
                cleanwordToFrequency.put(word, cleanwordToFrequency.get(word) + 1);
            }
            int currentScore = 0;
            for (String cleanword : cleanwordToFrequency.keySet()) {
                if (wordToFrequency.containsKey(cleanword)) {
                    currentScore += Math.min(wordToFrequency.get(cleanword), cleanwordToFrequency.get(cleanword));
                }
            }
            if (currentScore > highScore) {
                highScore = currentScore;
                highest = ct;
            }
        }
        return highest;
    }
}
// Time O(n * m) n = number of cleanTitles, m = number of words in a cleanTitle
// Space O(k) k = number of words in rawTitle/cleanTitle
