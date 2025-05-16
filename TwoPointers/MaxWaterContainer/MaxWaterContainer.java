class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int l = 0, r = heights.length - 1;
        while (l < r) {
            int containerHeight = Math.min(heights[l], heights[r]);
            int containerWidth = r - l;
            int area = containerHeight * containerWidth;
            maxArea = Math.max(maxArea, area);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

    public int maxArea2(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int containerHeight = Math.min(heights[i], heights[j]);
                int containerWidth = j - i;
                int area = containerHeight * containerWidth;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    public static void main (String args[]) {
        if (args.length == 0) {
            System.out.println("Please provide the integer array representing possible container bars.");
            return;
        }
        int[] heights = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            heights[i] = Integer.parseInt(args[i]);
        }
        Solution solution = new Solution();
        System.out.println(solution.maxArea10(heights));
    }

    public int maxArea10 (int[] heights) {
        int maxArea = 0;
        int l = 0, r = heights.length - 1;
        while (l < r) {
            int height = Math.min(heights[l], heights[r]);
            int width = r - l;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}