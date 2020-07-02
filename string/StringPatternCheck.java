
public class StringPatternCheck {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int length = s.length();
        for (int i = length / 2; i >= 1; i--) {
            // can divide the current length of a substring
            if (length % i == 0) {
                int div = length / i;
                String subStr = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                // note that an eligible substring
                // must not come from the middle of s
                for (int j = 0; j < div; j++) {
                    sb.append(subStr);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
