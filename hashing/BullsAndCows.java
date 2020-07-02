
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        // Assume lengths are always equal
        int bulls = 0;
        int cows = 0;
        int[] digits = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) {
                bulls++;
            } else {
                if (digits[s] < 0) {
                    cows++;
                }
                if (digits[g] > 0) {
                    cows++;
                }
            }
            digits[s]++;
            digits[g]--;
        }
        String hint = bulls + "A" + cows + "B";
        return hint;
    }
}
