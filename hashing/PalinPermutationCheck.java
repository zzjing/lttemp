
public class PalinPermutationCheck {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int oddFreqPair = 0;
        int[] charCount = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            charCount[cur]++;
            // the same character appears even times
            if (charCount[cur] % 2 == 0) {
                oddFreqPair--;
            }
            if (charCount[cur] % 2 == 1) {
                oddFreqPair++;
            }
        }
        return (oddFreqPair <= 1);
    }
}
