import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i]; 
        }
        return result;
    }

    public int[] productExceptSelf4(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i] * prefix[i - 1];
        }
        int[] postfix = new int[n];
        postfix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            postfix[i] = nums[i] * postfix[i + 1];
        }
        for (int i = 0; i < n; i++) {
            result[i] = ((i == 0) ? 1 : prefix[i - 1]) * ((i == n - 1) ? 1 : postfix[i + 1]);
        }
        return result;
    }

    // restriction: we cannot use the division operator
    public int[] productExceptSelf3(int[] nums) {
        int[] result = new int[nums.length];
        int allProduct = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
                continue;
            }
            allProduct *= num;
        }
        if (zeroCount > 1) {
            return new int[nums.length];
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 0) {
                result[i] = (nums[i] == 0) ? allProduct : 0;
                continue;
            }
            result[i] = allProduct / nums[i];
        }
        return result;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                product *= nums[j];
            }
            result[i] = product;
        }
        return result;
    }

    public static void main (String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide an array of int's");
            return;
        }
        int[] nums = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            nums[i] = Integer.parseInt(args[i]);
        }
        Solution solution = new Solution();
        int[] result = solution.productExceptSelf10(nums);
        for (int val : result) {
            System.out.println(val);
        }
    }

    public int[] productExceptSelf10(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i];
        }
        int[] suffix = new int[nums.length];
        suffix[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = ((i > 0) ? prefix[i - 1] : 1) * ((i < nums.length - 1) ? suffix[i + 1] : 1);
        }
        return res;
    }
}