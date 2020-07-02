import java.util.Stack;

public class BSTPreorderCheck {
    public boolean verifyPreorder(int[] preorder) {
        int lowerBound = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack<>();
        for (int current : preorder) {
            if (current < lowerBound) {
                return false;
            }
            // left subtree exists and we reach the right subtree
            while (!path.isEmpty() && current > path.peek()) {
                // remove all left tree nodes (relative to this node)
                // the lowerBound is the last node smaller than it
                // (since the left subtree is completely explored and popped)
                lowerBound = path.pop();
            }
            // continue pushing elements into the stack
            // until reaching a node to its right
            path.push(current);
        }
        return true;
    }
}
