/**
 * Validate if every pair of parentheses within a pile match.
 * i.e. Every left bracket correctly matches the right one.
 * 
 * @author Zezhou Jing, University of Washington
 * @date July 3, 2016
 */
import java.util.Stack;

public class ParenValidator {
    // @param s: the string representation of parentheses
    // @return: whether every bracket pair is valid
    // Stack solution; Time complexity O(n), space O(n).
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        } else if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> validator = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                validator.push(current);
            } else if (current == ')') {
                if (validator.isEmpty() || validator.pop() != '(') {
                    return false;
                }
            } else if (current == ']') {
                if (validator.isEmpty() || validator.pop() != '[') {
                    return false;
                }
            } else if (current == '}') {
                if (validator.isEmpty() || validator.pop() != '{') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return validator.isEmpty();
    }
}
