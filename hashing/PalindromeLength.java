
public class PalindromeLength {
    public int longestPalindrome(String s) {
        int[] ascii = new int[256];
        for (int i = 0; i < s.length(); i++) {
            int asciiVal = (int) (s.charAt(i));
            ascii[asciiVal]++;
        }
        int maxLength = 0;
        boolean oddCount = false;
        for (int i = 0; i < 256; i++) {
            if (ascii[i] % 2 == 1) {
                oddCount = true;
            }
            maxLength += ascii[i] / 2 * 2;
        }
        if (oddCount) {
            maxLength++;
        }
        return maxLength;
    }
}
