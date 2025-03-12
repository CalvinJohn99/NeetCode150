class Solution {
    public int maxProfit (int[] prices) {
        int l = 0, r = 1;
        int maxProfit = 0;
        while (r < prices.length) {
            int profit = prices[r] - prices[l];
            if (profit < 0) {
                l = r;
            } else {
                maxProfit = Math.max(maxProfit, profit);
            }
            r++;
        }
        return maxProfit;
    }

    public static void main (String args[]) {
        if (args.length == 0) {
            System.out.println("Please proved the prices");
            return;
        }
        int[] prices = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            prices[i] = Integer.parseInt(args[i]);
        }
        Solution solution = new Solution();
        System.out.println(solution.maxProfit10(prices));
    }

    public int maxProfit10 (int[] prices) {
        int maxProfit = 0;
        int l = 0, r = 1;
        while (r < prices.length) {
            int profit = prices[r] - prices[l];
            if (profit < 0) {
                l = r;
            } else {
                maxProfit = Math.max(maxProfit, profit);
            }
            r++;
        }
        return maxProfit;
    }
}