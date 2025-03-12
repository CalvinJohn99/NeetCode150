import java.util.Arrays;

class Solution {
    public int trap (int[] height) {
        int l = 0, r = height.length - 1, maxRight = height[height.length - 1], maxLeft = height[0], waterBlocks = 0;
        while (l < r) {
            if (maxLeft <= maxRight) {
                l++;
                waterBlocks += Math.max(maxLeft - height[l], 0);
                maxLeft = Math.max(maxLeft, height[l]);
            } else {
                r--;
                waterBlocks += Math.max(maxRight - height[r], 0);
                maxRight = Math.max(maxRight, height[r]);
            }
            // System.out.println("height array: " + Arrays.toString(height));
            // System.out.println("MaxLeft: " + maxLeft + ", MaxRight: " + maxRight);
            // System.out.println("WaterBlocks: " + waterBlocks);
        }
        return waterBlocks;
    }

    public int trap2 (int[] height) {
        int[] maxLefts = new int[height.length];
        int maxLeft = 0;
        for (int i = 0; i < height.length; i++) {
            maxLefts[i] = maxLeft;
            maxLeft = Math.max(maxLeft, height[i]);
        }
        int[] maxRights = new int[height.length];
        int maxRight = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            maxRights[i] = maxRight;
            maxRight = Math.max(maxRight, height[i]);
        }
        int waterBlocks = 0;
        for (int i = 0; i < height.length; i++) {
            waterBlocks += Math.max(Math.min(maxLefts[i], maxRights[i]) - height[i], 0);
        }
        return waterBlocks;
    }

    public static void main (String args[]) {
        if (args.length == 0) {
            System.out.println("Please proved the array of numbers representing bar heights");
            return;
        }
        int[] height = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            height[i] = Integer.parseInt(args[i]);
        }
        Solution solution = new Solution();
        System.out.println(solution.trap10(height));
    }

    public int trap10 (int[] height) {
        int l = 0, r = height.length - 1;
        int maxLeft = height[0], maxRight = height[height.length - 1];
        int waterBlocks = 0;
        while (l < r) {
            if (maxLeft <= maxRight) {
                l++;
                waterBlocks += Math.max(maxLeft - height[l], 0);
                maxLeft = Math.max(maxLeft, height[l]);
            } else if (maxRight < maxLeft) {
                r--;
                waterBlocks += Math.max(maxRight - height[r], 0);
                maxRight = Math.max(maxRight, height[r]);
            }
        }
        return waterBlocks;
    }
}