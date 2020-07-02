
public class PalindromePrefix {
    public String shortestPalindrome(String s) {
        if (s == null) {
            return "";
        }
        for (int i = s.length(); i > 0; i--) {
            String substr = s.substring(0, i);
            if (isPalindrome(substr)) {
                return reverse(s.substring(i)) + s;
            }
        }
        return "";
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private String reverse(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] sArray = s.toCharArray();
        while (start < end) {
            char tmp = sArray[start];
            sArray[start] = sArray[end];
            sArray[end] = tmp;
            start++;
            end--;
        }
        return new String(sArray);
    }
}
