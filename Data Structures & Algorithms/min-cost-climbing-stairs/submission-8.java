class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n =cost.length;
        if(n == 0)
            return 0;
        if(n == 1)
            return cost[0];
        int dp1 = 0;
        int dp2 = 0;
        int minCost = 0;
        for(int i = 2; i<=n; i++){
            int min = Math.min(dp2 + cost[i-2], dp1 + cost[i-1]);
            dp1 = dp2;
            dp2 = min;
            
        }

        return dp2;
    }
}
