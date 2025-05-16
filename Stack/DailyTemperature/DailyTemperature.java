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
        int[] result = solution.dailyTemperatures10(temperatures);
        System.out.println(Arrays.toString(result));
    }

    public int[] dailyTemperatures10(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[1]) {
                int[] pair = stack.pop();
                res[pair[0]] = i - pair[0];
            }
            stack.push(new int[]{i, temperatures[i]});
        }
        return res;
    }
}