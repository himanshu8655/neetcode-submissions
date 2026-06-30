class Solution {
    //[0 1 2 3 4 1]
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for(int i = 0; i<=amount; i++){
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for(int i = 1; i<=amount; i++){
            for(Integer c : coins){
                if(i - c>=0)
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
