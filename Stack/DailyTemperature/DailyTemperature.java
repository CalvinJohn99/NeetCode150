import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[0] < t) {
                int[] pair = stack.pop();
                result[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{t, i});
        }
        return result;
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide the daily temperatures");
            return;
        }
        int[] temperatures = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            temperatures[i] = Integer.parseInt(args[i]);
        }
        Solution solution = new Solution();
        int[] result = solution.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(result));
    }
}