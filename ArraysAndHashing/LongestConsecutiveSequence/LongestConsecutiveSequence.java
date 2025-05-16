import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int LongestConsecutiveSequence(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longest = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 0;
                while (numSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    public int LongestConsecutiveSequence2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int longest = 0, next = nums[0], streak = 0, i = 0;
        while (i < nums.length) {
            if (next != nums[i]) {
                next = nums[i];
                streak = 0;
            }
            while (i < nums.length && next == nums[i]) {
                i++;
            }
            streak++;
            next++;
            longest = Math.max(longest, streak);
        }
        return longest;
    }

    public static void main (String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide an array of numbers.");
            return;
        }
        int[] nums = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            nums[i] = Integer.parseInt(args[i]);
        }
        Solution solution = new Solution();
        System.out.println(solution.LongestConsecutiveSequence10(nums));
    }

    public int LongestConsecutiveSequence10(int[] nums) {
        int res = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 0;
                while (numSet.contains(num + length)) {
                    length++;
                }
                res = Math.max(res, length);
            }
        }
        return res;
    }
}