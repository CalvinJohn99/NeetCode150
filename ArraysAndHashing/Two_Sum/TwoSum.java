import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int toSumValue = target - nums[i];
            if (numIndex.containsKey(toSumValue)) {
                return new int[]{numIndex.get(toSumValue), i};
            }
            numIndex.put(nums[i], i);
        }
        return new int[0];
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            boolean sumFound = false;
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    result[0] = i;
                    result[1] = j;
                    sumFound = true;
                    break;
                }
            }
            if (sumFound) {
                break;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide an array of integers");
            return;
        }
        int target = Integer.parseInt(args[args.length - 1]);
        int[] nums = new int[args.length - 1];
        for (int i = 0; i < args.length - 1; i++) {
            nums[i] = Integer.parseInt(args[i]);
        }
        Solution solution = new Solution();
        int[] result = solution.twoSum10(nums, target);
        for (int value : result) {
            System.out.println(value);
        }
    }

    public int[] twoSum10(int[] nums, int target) {
        Map<Integer, Integer> numIndices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int toSum = target - nums[i];
            if (numIndices.containsKey(toSum)) {
                return new int[]{i, numIndices.get(toSum)};
            }
            numIndices.put(nums[i], i);
        }
        return new int[0];
    }
}