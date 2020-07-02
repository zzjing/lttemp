
public class StringAddtion {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carryOn = 0;
        int digit1 = 0;
        int digit2 = 0;
        // carryOn == 1 is to check the corner case such that
        // there is one last digit to append to the head
        for (int i = num1.length() - 1, j = num2.length() - 1;
            i >= 0 || j >= 0 || carryOn == 1; i--, j--) {
            if (i < 0) {
                digit1 = 0;
            } else {
                digit1 = num1.charAt(i) - '0';
            }
            if (j < 0) {
                digit2 = 0;
            } else {    
                digit2 = num2.charAt(j) - '0';
            }
            // current digit
            sb.append((digit1 + digit2 + carryOn) % 10);
            // value to carry on to the next addition
            carryOn = (digit1 + digit2 + carryOn) / 10;
        }
        return sb.reverse().toString();
    }
}
