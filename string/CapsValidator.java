
public class CapsValidator {
    public boolean detectCapitalUse(String word) {
        int caps = 0;
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (Character.isUpperCase(current)) {
                if (caps == 0 && i != 0) {
                    return false;
                }
                caps++;
            }
        }
        return (caps == 0 || caps == 1 || caps == word.length());
    }
}
