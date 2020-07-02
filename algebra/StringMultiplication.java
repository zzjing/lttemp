
public class StringMultiplication {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "";
        }
        int num1Len = num1.length();
        int num2Len = num2.length();
        int[] product = new int[num1Len + num2Len];
        for (int i = num1Len - 1; i >= 0; i--) {
            for (int j = num2Len - 1; j >=0; j--) {
                int digitPrdct = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int digit1 = i + j;
                int digit2 = i + j + 1;
                // if there is a number to the right already
                int curSum = digitPrdct + product[digit2];
                product[digit2] = (curSum % 10);
                product[digit1] += (curSum / 10);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int digit : product) {
            if (!(sb.length() == 0 && digit == 0)) {
                sb.append(digit);
            }
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }
}
