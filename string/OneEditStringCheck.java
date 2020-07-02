
public class OneEditStringCheck {
    public boolean isOneEditDistance(String s, String t) {
        int shortLen = Math.min(s.length(), t.length());
        for (int i = 0; i < shortLen; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                // same length --> replace the character in the current position
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else if (s.length() < t.length()) {
                    // t is longer --> delete the character from t's front
                    return s.substring(i).equals(t.substring(i + 1));
                } else { // s is longer --> delete the character from s's front
                    return s.substring(i + 1).equals(t.substring(i));
                }
            }
        }
        // delete the character from the end of either s or t, whichever is longer
        return (Math.abs(s.length() - t.length()) == 1);
    }
}
