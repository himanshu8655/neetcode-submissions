class Solution {
    public int coinChange(int[] coins, int amount) {
        //[0 0 0 0 0 0 0 0 0 0 0 0]
        //[0 1 0 0 0 ]
        int[] dp = new int[amount + 1];
        for(int i = 0; i<=amount; i++){
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for(int i = 0; i<=amount; i++){
            for(int c : coins){
                if(i-c>=0)
                    dp[i] = Math.min(dp[i], dp[i-c]+1);
            }
        }
        return dp[amount]!=amount+1 ? dp[amount]:-1;
    }
}
