
public class SubseqInorderCheck {
    public boolean isSubsequenceInOrder(String sub, String str) {
        int j = 0;
        for (int i = 0; i < str.length() && j < sub.length(); i++) {
            if (sub.charAt(j) == str.charAt(i)) {
                j++;
            }
        }
        return j == sub.length();
    }
}
