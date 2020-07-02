import java.util.Stack;

public class RoundPointsRecorder {
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) {
            return 0;
        }
        int points = 0;
        Stack<Integer> rdScores = new Stack<Integer>();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("+")) {
                int lastValid = rdScores.pop();
                int secLast = rdScores.peek();
                int plusPts = lastValid + secLast;
                rdScores.push(lastValid);
                rdScores.push(plusPts);
                points += plusPts;
            } else if (ops[i].equals("D")) {
                int dPts = 2 * rdScores.peek();
                rdScores.push(dPts);
                points += dPts;
            } else if (ops[i].equals("C")) {
                points -= rdScores.pop();
            } else {
                points += Integer.valueOf(ops[i]);
                rdScores.push(Integer.valueOf(ops[i]));
            }
        }
        return points;
    }
}
