
public class WildcardMatch {
    public boolean isMatch(String s, String p) {
        if (s == null && p != null) {
            return false;
        }
        int sMatch = 0;
        int pMatch = 0;
        int match = 0;
        int starIndex = -1;
        while (sMatch < s.length()) {
            // if current characters match w/o "*" -> move both pointers
            if (pMatch < p.length() &&
                (s.charAt(sMatch) == p.charAt(pMatch) || p.charAt(pMatch) == '?')) {
                sMatch++;
                pMatch++;
            } else if (pMatch < p.length() && p.charAt(pMatch) == '*') {
                // '*' occurs -> move p pointer past '*'
                starIndex = pMatch;
                match = sMatch;
                pMatch++;
            } else if (starIndex != -1) {
                // does not match but last index is a '*'
                pMatch = starIndex + 1;
                match++;
                sMatch = match;
            } else { // current characters do not match, no available '*' in p (current or last)
                return false;
            }
        }
        // check remaining characters in p -> match iff they are '*' (empty)
        while (pMatch < p.length() && p.charAt(pMatch) == '*') {
            pMatch++;
        }
        return pMatch == p.length();
    }
}
