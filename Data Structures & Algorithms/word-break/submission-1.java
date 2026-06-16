class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        //T F F T T
        //  C A T S I N C A R
        for(int i = 1; i<=s.length(); i++){
            for(String word : wordDict){
                int len = word.length();
                int idx = i - len;
                if(idx>=0 && dp[idx]){
                    if(s.substring(idx, i).equals(word)){
                        dp[i] = true;
                        break;
                    }
                    
                }
                    
                
            }
        }
        return dp[n];
    }
}
