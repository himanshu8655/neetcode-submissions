class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;

        for(int i = m - 1; i>=0; i--)
            for(int j = n - 1; j>=0; j--){
                int num1 = j + 1 < n ? dp[i][j+1] : 0;
                int num2 = i + 1 < m ? dp[i+1][j] : 0;
                dp[i][j] = Math.max(dp[i][j], num1 + num2);
            }
        
        return dp[0][0];
    }
}
