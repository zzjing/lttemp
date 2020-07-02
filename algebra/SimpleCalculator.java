import java.util.Stack;

public class SimpleCalculator {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> buffer = new Stack<Integer>();
        int number = 0;
        char operator = '+';
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                number = (int)(current - '0') + number * 10;
            }
            if ((!Character.isDigit(current) && current != ' ') || i == s.length() - 1) {
                if (operator == '-') {
                    buffer.push(-number);
                }
                if (operator == '+') {
                    buffer.push(number);
                }
                if (operator == '*') {
                    buffer.push(buffer.pop() * number);
                }
                if (operator == '/') {
                    buffer.push(buffer.pop() / number);
                }
                operator = current;
                number = 0;
            }
        }
        int result = 0;
        for (int val : buffer) {
            result += val;
        }
        return result;
    }
}
