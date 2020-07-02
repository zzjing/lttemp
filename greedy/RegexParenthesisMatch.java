
public class RegexParenthesisMatch {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        // smallest possible number of open left brackets
        // largest possible number of open left brackets
        int minLeft = 0;
        int maxLeft = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                minLeft++;
            } else {
                minLeft--;
            }
            if (cur == ')') {
                maxLeft--;
            } else {
                maxLeft++;
            }
            // can never have enough left bracket at this point
            if (maxLeft < 0) {
                return false;
            }
            // by choosing '*' as either empty or '(' as needed
            // we can never have less than zero open left bracket
            minLeft = Math.max(minLeft, 0);
        }
        // check if there is exactly 0 left bracket after some pairing
        return minLeft == 0;
    }
}
