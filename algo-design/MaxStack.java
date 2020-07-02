import.java.util.Stack;

public class MaxStack {
    // The normal stack is the stack we maintain and modify
    // The maxStack keeps track on the max element, which is at its top
    // The two stacks should have the same number of elements
    private Stack<Integer> stack;
    private Stack<Integer> maxStack;

    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        int tempMax = Integer.MIN_VALUE;
        if (!maxStack.isEmpty()) {
            tempMax = maxStack.peek();
        }
        // determines the current max element and updates both stacks
        tempMax = Math.max(x, tempMax);
        stack.push(x);
        // pushes a copy of the max element to the maxStack
        maxStack.push(tempMax);
    }
    // Removes the top elements from both stacks
    public int pop() {
        maxStack.pop();
        return stack.pop();
    }
    // Peeks the normal stack to get the top element
    public int top() {
        return stack.peek();
    }
    // Peeks the maxStack to get the max element
    public int peekMax() {
        return maxStack.peek();
    }
    // Removes the max element at the top and all its copies
    public int popMax() {
        int currentMax = maxStack.peek();
        // auxiliary stack to hold all other elements needed
        Stack<Integer> tmp = new Stack<>();
        while (stack.peek() != currentMax) {
            tmp.push(stack.pop());
            maxStack.pop(); // removes all associated copies
        }
        // removes the max element itself
        stack.pop();
        maxStack.pop();
        // pushes all elements needed back to the normal stack
        while (!tmp.isEmpty()) {
            push(tmp.pop());
        }
        return currentMax;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
 
