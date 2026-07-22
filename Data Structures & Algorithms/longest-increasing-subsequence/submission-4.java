class Solution {
    public int lengthOfLIS(int[] nums) {
        int n =  nums.length;
        if(n == 1)
            return 1;
        int[] dp = new int[n];
        for(int i = 0; i<n; i++)
            dp[i] = 1;
        for(int i = n - 2; i>=0; i--){
            int currNum = nums[i];
            for(int j = i+1; j<n; j++){
                if(currNum<nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }  
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
