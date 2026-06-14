class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;//1
        for(int i = 2; i<=cost.length; i++){
            if(i == 2)
                dp[i] = cost[i-1];
            else
            dp[i] = Math.min(cost[i-1] + dp[i-1], dp[i-2] + cost[i-2]);
        }

        return dp[n];
    }
}
