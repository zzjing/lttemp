
public class RegexMatch {
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) {
            return true;
        } else if (s == null || p == null) {
            return false;
        }
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[s.length()][p.length()] = true;
        // i counter leads j counter by 1
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean firstCharMatch = i < s.length() &&
                        (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    match[i][j] = (match[i][j + 2] || (firstCharMatch && match[i + 1][j]));
                } else {
                    match[i][j] = (firstCharMatch && match[i + 1][j + 1]);
                }
            }
        }
        return match[0][0];
    }
}
