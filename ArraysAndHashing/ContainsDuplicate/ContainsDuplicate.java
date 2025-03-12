import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            if (numsSet.contains(num)) {
                return true;
            }
            numsSet.add(num);
        }
        return false;
    }

    public boolean hasDuplicate3(int[] nums) {
        Map<Integer, Integer> countNums = new HashMap<>();
        for (int num : nums) {
            countNums.put(num, countNums.getOrDefault(num, 0) + 1);
        }
        for (int value : countNums.values()) {
            if (value > 1) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDuplicate2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; ((j < nums.length) && (j != i)); j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide an array of elements as arguments");
            return;
        }

        int[] nums = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            nums[i] = Integer.parseInt(args[i]);
        }
        Solution solution = new Solution();
        boolean result = solution.hasDuplicate(nums);
        System.out.println(result);
    }

    public boolean hasDuplicate10(int[] nums) {
        
    }
}