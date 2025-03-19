import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int l = 0;
        for (int r = 0; r < n; r++) {
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }
            q.addLast(r);
            if (l > q.getFirst()) {
                q.removeFirst();
            }
            if ((r + 1) >= k) {
                output[l] = nums[q.getFirst()];
                l++;
            }
        }
        return output;
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide nums and k");
            return;
        }
        int[] nums = new int[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            nums[i] = Integer.parseInt(args[i]);
        }
        int k = Integer.parseInt(args[args.length-1]);
        Solution solution = new Solution();
        int[] result = solution.maxSlidingWindow10(nums, k);
        System.out.println(Arrays.toString(result));
    }

    public int[] maxSlidingWindow10(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }
            q.addLast(r);
            if (l > q.getFirst()) {
                q.removeFirst();
            }
            if ((r + 1) >= k) {
                output[l] = nums[q.getFirst()];
                l++;
            }
        }
        return output;
    }
}