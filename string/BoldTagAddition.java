
public class BoldTagAddition {
    public String addBoldTag(String s, String[] dict) {
        if (dict == null || dict.length == 0 || s == null) {
            return s;
        }
        boolean[] isBold = new boolean[s.length()];
        for (String word : dict) {
            markBolded(isBold, word, s);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < isBold.length; i++) {
            if (isBold[i] && (i == 0 || !isBold[i - 1])) {
                sb.append("<b>");
            }
            sb.append(s.charAt(i));
            if (isBold[i] && (i == isBold.length - 1 || !isBold[i + 1])) {
                sb.append("</b>");
            }
        }
        return sb.toString();
    }

    private void markBolded(boolean[] isBold, String word, String s) {
        int wordLen = word.length();
        for (int i = 0; i <= s.length() - wordLen; i++) {
            if (s.substring(i, i + wordLen).equals(word)) {
                for (int j = i; j < i + wordLen; j++) {
                    isBold[j] = true;
                }
            }
        }
    }
}
