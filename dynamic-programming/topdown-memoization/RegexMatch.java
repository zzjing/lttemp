
public class RegexMatch {
    // recursive method
    public boolean checkMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        } else if (s == null || p == null) {
            return false;
        }
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstCharMatch = !s.isEmpty() &&
                (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return checkMatch(s, p.substring(2)) ||
                   (firstCharMatch && checkMatch(s.substring(1), p));
        } else {
            return (firstCharMatch && checkMatch(s.substring(1), p.substring(1)));
        }
    }
}
