import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.empty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.empty()) {
            return;
        }
        int top = stack.pop();
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide commands for MinStack");
            return;
        }
        MinStack minStack = new MinStack();
        int i = 0;
        while (i < args.length) {
            if (args[i].equals("push") && i < args.length - 1) {
                i = i + 1;
                minStack.push(Integer.parseInt(args[i]));
                System.out.println("null");
            } else if (args[i].equals("getMin")) {
                System.out.println(minStack.getMin());
            } else if (args[i].equals("pop")) {
                minStack.pop();
                System.out.println("null");
            } else if (args[i].equals("top")) {
                System.out.println(minStack.top());
            } 
            i++;
        }
    }
}