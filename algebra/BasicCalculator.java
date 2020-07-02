import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> buffer = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            // test whether the current character is a digit
            // if so, evaluate it from left to right
            if (Character.isDigit(current)) {
                number = (int)(current - '0') + 10 * number;
            } else if (current == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (current == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (current == '(') {
                // cache the result and sign outside the parenthesis
                buffer.push(result);
                buffer.push(sign);
                // reset the result and sign to evaluate inside
                sign = 1;
                result = 0;
            } else if (current == ')') {
                result += sign * number;
                number = 0;
                // switch the sign in favor of the value before the parenthesis
                result *= buffer.pop();
                result += buffer.pop();
            }
        }
        // edge case when the expression ends with a number
        if (number != 0) {
            result += sign * number;
        }
        return result;
    }
}
