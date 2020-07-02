import java.util.ArrayList;
import java.util.List;

public class ValidParenGenerator {
    public List<String> generateParenthesis(int n) {
        List<String> parens = new ArrayList<String>();
        if (n <= 0) {
            return parens;
        }
        generateParenthesis(n, n, parens, "");
        return parens;
    }

    private void generateParenthesis(int leftBrace, int rightBrace,
        List<String> parens, String parenthesis) {
        if (leftBrace == 0 && rightBrace == 0) {
            parens.add(parenthesis);
            return;
        }
        if (leftBrace > 0) {
            generateParenthesis(leftBrace - 1, rightBrace, parens, parenthesis + "(");
        }
        if (rightBrace > leftBrace) {
            generateParenthesis(leftBrace, rightBrace - 1, parens, parenthesis + ")");
        }
    }
}
