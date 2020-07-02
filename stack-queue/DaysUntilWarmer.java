import java.util.Stack;

public class DaysUntilWarmer {
    public int[] getDays(int[] temperatures) {
        if (temperatures == null || temperatures.length <= 1) {
            return new int[]{0};
        }
        int[] warmerIndex = new int[temperatures.length];
        Stack<Integer> tempIndex = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int curTemp = temperatures[i];
            while (!tempIndex.isEmpty() && curTemp > temperatures[tempIndex.peek()]) {
                int lastColder = tempIndex.pop();
                warmerIndex[lastColder] = i - lastColder;
            }
            tempIndex.push(i);
        }
        return warmerIndex;
    }
}
