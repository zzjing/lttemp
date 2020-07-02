
public class IsomorphicStringCheck {
    public boolean isIsomorphic(String s, String t) {
        // record the last position a character is seen
        int[] lastSeen = new int[512];
        for (int i = 0; i < s.length(); i++) {
            if (lastSeen[s.charAt(i)] != lastSeen[t.charAt(i) + 256]) {
                return false;
            }
            // cannot start with 0 because everything is 0 by default
            lastSeen[s.charAt(i)] = i + 1;
            lastSeen[t.charAt(i) + 256] = i + 1;
        }
        return true;
    }
}
