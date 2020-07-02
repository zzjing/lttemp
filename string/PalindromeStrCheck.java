
public class PalindromeStrCheck {
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reversed = new StringBuffer(actual).reverse().toString();
        return actual.equals(reversed);
    }
}
