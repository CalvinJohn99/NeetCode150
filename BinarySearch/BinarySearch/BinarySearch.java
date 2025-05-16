class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) / 2); // (l + r) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide numbers for the binary search");
            return;
        }
        int target = Integer.parseInt(args[args.length - 1]);
        int[] nums = new int[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            nums[i] = Integer.parseInt(args[i]);
        }
        Solution solution = new Solution();
        System.out.println(solution.search10(nums, target));
    }

    public int search10(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}