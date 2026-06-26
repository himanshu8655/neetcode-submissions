class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();//8
        boolean[] dp = new boolean[n+1];
        dp[0]= true;
        for(int i = 1; i<=n; i++){
            for(String word : wordDict){
                if(i - word.length()<0)
                    continue;
                
                if(dp[i - word.length()] && word.equals(s.substring(i - word.length(), i))){
                    dp[i] = true;
                }
            }
        }

        return dp[n];
    }
}
