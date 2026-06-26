class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i = 1; i<=amount; i++){
            dp[i] = amount+1;
        }

        for(int currAmt = 1; currAmt<=amount; currAmt++){//currAmt = 5
            for(int coin : coins){
                if(currAmt - coin<0)
                    break;
               dp[currAmt] =  Math.min(dp[currAmt], 1 + dp[currAmt - coin]);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
