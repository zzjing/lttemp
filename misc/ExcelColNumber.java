
// base-26 expansion
public class ExcelColNumber {
    public int columnToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int titleNum = 0;
        int digitsLeft = s.length() - 1;
        int curPower = 0;
        // expand from the rightmost digit
        while (digitsLeft >= 0) {
            char current = s.charAt(digitsLeft);
            titleNum += (int) Math.pow(26, curPower) * (current - 'A' + 1);
            curPower++;
            digitsLeft--; // move toward the left
        }
        return titleNum;
    }
}
