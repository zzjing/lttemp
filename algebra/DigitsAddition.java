
public class DigitsAddition {
    public int addDigits(int num) {
        if (num / 10 == 0) {
            return num;
        }
        if (num % 9 == 0) {
            return 9;
        } else {
            return num % 9;
        }
    }
}
