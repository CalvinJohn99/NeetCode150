import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int threeSum = nums[i] + nums[l] + nums[r];
                if (threeSum < 0) {
                    l++;
                } else if (threeSum > 0) {
                    r--;
                } else {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    l++;
                    while (nums[l] == nums[l - 1] && l < r) {
                        l++;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> sumIndices = new ArrayList<>();
            Map<Integer, Integer> numIndices = new HashMap<>();
            int target = 0 - nums[i];
            for (int j = 0; j < nums.length && j != i; j++) {
                int toSum = target - nums[j];
                if (numIndices.containsKey(toSum)) {
                    sumIndices.add(toSum);
                    sumIndices.add(nums[i]);
                    sumIndices.add(nums[j]);
                }
                numIndices.put(nums[j], j);
                for (List<Integer> indices : result) {
                    if ((new HashSet<>(indices)).equals(new HashSet<>(sumIndices))) {
                        sumIndices = new ArrayList<>();
                    }
                }
                if (sumIndices.size() > 0) {
                    result.add(sumIndices);
                    sumIndices = new ArrayList<>();
                }
            }
        }
        return result;
    }

    public static void main (String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide an array of numbers");
            return;
        }
        int[] nums = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            nums[i] = Integer.parseInt(args[i]);
        }
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum10(nums);
        for (List<Integer> threeSum : result) {
            System.out.println(threeSum.toString());
        }
    }

    public List<List<Integer>> threeSum10 (int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    while (nums[l] == nums[l - 1] && l < r) {
                        l++;
                    }
                }
            }
        }
        return res;
    }
}