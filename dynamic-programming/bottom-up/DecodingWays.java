
public class DecodingWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int oneDigitDecode = 1;
        int twoDigitDecode = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                oneDigitDecode = 0;
            }
            if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
                int oldOneDigitDecode = oneDigitDecode;
                oneDigitDecode += twoDigitDecode;
                twoDigitDecode = oldOneDigitDecode;
            } else {
                twoDigitDecode = oneDigitDecode;
            }
        }
        return oneDigitDecode;
    }

    public int getDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] decodingWays = new int[s.length() + 1];
        decodingWays[0] = 1;
        if (s.charAt(0) == '0') {
            decodingWays[1] = 0;
        } else {
            decodingWays[1] = 1;
        }
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                decodingWays[i] += decodingWays[i - 1];
            }
            if (s.charAt(i - 2) == '1'
                || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')) {
                decodingWays[i] += decodingWays[i - 2];
            }
        }
        return decodingWays[s.length()];
    }
}
