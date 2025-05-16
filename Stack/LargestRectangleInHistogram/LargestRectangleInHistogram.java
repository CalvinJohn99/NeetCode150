import java.util.Stack;
import java.util.Arrays;

class Solution {
    // NeetCode Solution
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>(); // pair: (index, height)

        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
            }
            stack.push(new int[]{start, heights[i]});
        }

        for (int[] pair : stack) {
            int index = pair[0];
            int height = pair[1];
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }
        return maxArea;
    }

    // My Solution
    public int largestRectangleAreaMine(int[] heights) {
        int largestArea = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && heights[i] < stack.peek()[1]) {
                int[] pair = stack.pop();
                largestArea = Math.max(largestArea, pair[1] * (i - pair[0]));
                start = pair[0];
            }
            stack.push(new int[]{start, heights[i]});
        }
        for (int[] pair : stack) {
            largestArea = Math.max(largestArea, pair[1] * (heights.length - pair[0]));
        }
        return largestArea;
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide the histogram bar heights");
            return;
        }
        int[] heights = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            heights[i] = Integer.parseInt(args[i]);
        }
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea10(heights));
    }

    public int largestRectangleArea10(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] pair = stack.pop();
                int index = pair[0];
                int height = pair[1];
                maxArea = Math.max(maxArea, (i - index) * height);
                start = index;
            }
            stack.push(new int[]{start, heights[i]});
        }
        for (int[] pair : stack) {
            int index = pair[0];
            int height = pair[1];
            maxArea = Math.max(maxArea, (heights.length - index) * height);
        }
        return maxArea;        
    }
}