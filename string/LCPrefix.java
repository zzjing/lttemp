
public class LCPrefix {
    public String longestCommonPrefix(String[] strs) {
        // vertical scanning solution; time O(ij), ij = number of all characters
        // space O(1)
        if (strs == null || strs.length == 0) {
            return ""; // simple boundary cases
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char current = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                // exceeds the length of a string; or prefix is not common anymore
                if (i == strs[j].length() || strs[j].charAt(i) != current) {
                    String lcp = strs[j].substring(0, i);
                    return lcp;
                }
            }
        }
        return strs[0];
    }
}
