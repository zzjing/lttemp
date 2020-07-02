import java.util.Stack;

public class RevPolishEvaluation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> revEval = new Stack<>();
        int bufferVal = 0;
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                revEval.push(Integer.parseInt(token));
            } else {
                if (token.equals("+")) {
                    bufferVal += revEval.pop();
                    bufferVal += revEval.pop();
                } else if (token.equals("-")) {
                    bufferVal -= revEval.pop();
                    bufferVal += revEval.pop();
                } else if (token.equals("*")) {
                    bufferVal += revEval.pop();
                    bufferVal *= revEval.pop();
                } else {
                    int divisor = revEval.pop();
                    bufferVal += revEval.pop();
                    bufferVal /= divisor;
                }
                revEval.push(bufferVal);
                bufferVal = 0;
            }
        }
        return revEval.pop();
    }
}
