import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
        Stack<Double> stack = new Stack<>();
        for (int[] p : pairs) {
            stack.push((double) (target - p[0]) / p[1]);
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }
        return stack.size();
    }

    public static void main (String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide input");
            return;
        }
        int target = Integer.parseInt(args[0]);
        int carCount = Integer.parseInt(args[args.length - 1]);
        int[] position = new int[carCount];
        for (int i = 0; i < carCount; i++) {
            position[i] = Integer.parseInt(args[i+1]);
        }
        int[] speed = new int[carCount];
        for (int i = 0; i < carCount; i++) {
            speed[i] = Integer.parseInt(args[i+carCount+1]);
        }
        // System.out.println("Target: " + target);
        // System.out.println("Position: " + Arrays.toString(position));
        // System.out.println("speed: " + Arrays.toString(speed));
        Solution solution = new Solution();
        System.out.println(solution.carFleet10(target, position, speed));
    }

    public int carFleet10(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < position.length; i++) {
            stack.push((double) (target - cars[i][0]) / cars[i][1]);
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }
        return stack.size();
    }
}