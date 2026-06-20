class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];
        int result = 0;
        int n = s.length();
        int left = 0;
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            freq[c]++;
            while(freq[c]>1){
                char lChar = s.charAt(left);
                freq[lChar]--;
                left++;
            }

            result = Math.max(result, i - left + 1);
        }
        return result;
    }
}
