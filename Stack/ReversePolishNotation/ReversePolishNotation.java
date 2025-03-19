import java.util.Stack;

class Solution{

    // YAY!!! First problem I solved efficiently by myself!
    // neetcode solution looks slightly prettier...
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String str : tokens) {
            if (str.equals("+")) {
                int top = Integer.parseInt(stack.pop());
                int result = Integer.parseInt(stack.pop()) + top;
                stack.push(Integer.toString(result));
            } else if (str.equals("*")) {
                int top = Integer.parseInt(stack.pop());
                int result = Integer.parseInt(stack.pop()) * top;
                stack.push(Integer.toString(result));
            } else if (str.equals("-")) {
                int top = Integer.parseInt(stack.pop());
                int result = Integer.parseInt(stack.pop()) - top;
                stack.push(Integer.toString(result));
            } else if (str.equals("/")) {
                int top = Integer.parseInt(stack.pop());
                int result = Integer.parseInt(stack.pop()) / top;
                stack.push(Integer.toString(result));
            } else {
                stack.push(str);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    // NeetCode Solution:
    public int evalRPNNeetCode(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String c : tokens) {
            if (c.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (c.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (c.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (c.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide an expression");
            return;
        }
        String[] tokens = new String[args.length];
        for (int i = 0; i < args.length; i++) {
            tokens[i] = args[i];
        }
        Solution solution = new Solution();
        System.out.println(solution.evalRPN10(tokens));
    }

    public int evalRPN10(String[] tokens) {
        Stack<Integer> stack = new Stack<>(); 
        for (String str : tokens) {
            if (str.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (str.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (str.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (str.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}