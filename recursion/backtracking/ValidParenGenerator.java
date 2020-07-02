import java.util.LinkedList;
import java.util.List;

public class ValidParenGenerator {
    public List<String> generateParenthesis(int n) {
        List<String> parens = new LinkedList<>();
        if (n <= 0) {
            return parens;
        }
        generateParenthesis(n, n, parens, new StringBuilder());
        return parens;
    }

    private void generateParenthesis(int leftBrace, int rightBrace,
        List<String> parens, StringBuilder sb) {
        if (leftBrace == 0 && rightBrace == 0) {
            parens.add(sb.toString());
            return;
        }
        if (leftBrace > 0) {
            sb.append("(");
            generateParenthesis(leftBrace - 1, rightBrace, parens, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rightBrace > leftBrace) {
            sb.append(")");
            generateParenthesis(leftBrace, rightBrace - 1, parens, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
