import java.util.Arrays;

class Solution {
    public int findMin(int[] nums) {
        int res = nums[0];
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }
            int m = (l + r) / 2;
            res = Math.min(res, nums[m]);
            if (nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide numbers");
            return;
        }
        int[] nums = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            nums[i] = Integer.parseInt(args[i]);
        }
        Solution solution = new Solution();
        System.out.println(solution.findMin(nums));
    }
}