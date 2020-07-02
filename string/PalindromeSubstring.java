
public class PalindromeSubstring {
    private int strCount;
    public int countSubstrings(String s) {
        strCount = 0;
        if (s == null || s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i);
            expandAroundCenter(s, i, i + 1);
        }
        return strCount;
    }

    private void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() &&
            left <= right && s.charAt(left) == s.charAt(right)) {
            strCount++;
            left--;
            right++;
        }
    }
}
