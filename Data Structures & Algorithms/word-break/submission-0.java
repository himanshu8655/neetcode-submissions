class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 1; i<=s.length(); i++){
            for(String word : wordDict){
                int len = word.length();
                int idx = i - len;
                if(idx>=0 && dp[idx]){
                    dp[i] = true;
                    break;
                }
                    
                
            }
        }
        return dp[n];
    }
}
