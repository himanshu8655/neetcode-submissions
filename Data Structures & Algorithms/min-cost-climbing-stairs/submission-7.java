class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n =cost.length;
        if(n == 0)
            return 0;
        if(n == 1)
            return cost[0];
        int[] dp = new int[n+1];
        int minCost = 0;
        for(int i = 2; i<=n; i++){
            dp[i] = Math.min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1]);
        }
        // 0 0 1 2
        //[1,2,1,2,1,1,1]
        return dp[n];
    }
}
