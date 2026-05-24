class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];
        int left = 0;
        int res = 0;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            freq[c]++;
            while(freq[c]>1){
                freq[s.charAt(left)]--;
                left++;
            }

            res = Math.max(res, i - left + 1);
        }

        return res;
    }
}
