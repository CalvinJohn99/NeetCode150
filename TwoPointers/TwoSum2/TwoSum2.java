import java.util.Arrays;

class Solution {
    // Using 2 pointer more memory efficient: O(1)
    // Already sorted so we can use pointer solution with time complexity: O(n)
    public int[] twoSum (int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] > target) {
                r--;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }
        return new int[0];
    }

    public static void main (String args[]) {
        if (args.length == 0) {
            System.out.println("please provide an array of integers for the problem");
            return;
        }
        int target = Integer.parseInt(args[args.length - 1]);
        int[] nums = new int[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            nums[i] = Integer.parseInt(args[i]);
        }
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}