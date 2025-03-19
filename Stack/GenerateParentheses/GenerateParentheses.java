import java.util.List;
import java.util.ArrayList;

class Solution {
    public void backtrack(int openN, int closedN, int n, List<String>res, StringBuilder stack) {
        if (closedN == openN && openN == n) {
            res.add(stack.toString());
            return;
        }
        if (openN < n) {
            stack.append('(');
            backtrack(openN + 1, closedN, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
        if (closedN < openN) {
            stack.append(')');
            backtrack(openN, closedN + 1, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }

    public List<String> generateParentheses(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0, 0, n, res, stack);
        return res;
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide a number");
            return;
        }
        int n = Integer.parseInt(args[0]);
        Solution solution = new Solution();
        System.out.println(solution.generateParentheses10(n));
    }

    public void backtrack10(int openN, int closedN, int n, List<String> res, StringBuilder stack) {
        if (closedN == openN && openN == n) {
            res.add(stack.toString());
            return;
        }
        if (openN < n) {
            stack.append('(');
            backtrack(openN + 1, closedN, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
        if (closedN < openN) {
            stack.append(')');
            backtrack(openN, closedN + 1, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }

    public List<String> generateParentheses10(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0, 0, n, res, stack);
        return res;
    }
}