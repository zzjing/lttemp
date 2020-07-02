
public class AdditionByOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[0];
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] sum = new int[digits.length + 1];
        sum[0] = 1;
        return sum;
    }
}
