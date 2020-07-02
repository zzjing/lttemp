
public class ShortestMatchingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        if (licensePlate == null || licensePlate.length() == 0 ||
            words == null || words.length == 0) {
            return "";
        }
        String shortest = "";
        int[] plateCharFreq = findFrequency(licensePlate);
        for (int i = 0; i < words.length; i++) {
            int[] wordCharFreq = findFrequency(words[i]);
            if (checkCompletion(plateCharFreq, wordCharFreq)
                && (words[i].length() < shortest.length() || shortest.length() == 0)) {
                shortest = words[i];
            }
        }
        return shortest;
    }

    private int[] findFrequency(String str) {
        int[] freqArray = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int cur = Character.toLowerCase(str.charAt(i)) - 'a';
            if (cur < 26 && cur >= 0) {
                freqArray[cur]++;
            }
        }
        return freqArray;
    }

    private boolean checkCompletion(int[] plateCharFreq, int[] wordCharFreq) {
        for (int i = 0; i < 26; i++) {
            if (wordCharFreq[i] < plateCharFreq[i]) {
                return false;
            }
        }
        return true;
    }
}
