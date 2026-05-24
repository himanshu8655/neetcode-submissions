class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];
        int leftIdx = 0;
        int maxLen = 0;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            freq[c]++;
            while(freq[c]>1){
                freq[s.charAt(leftIdx)]--;
                leftIdx++;
            }

            maxLen = Math.max(maxLen, i - leftIdx + 1);
        }

        return maxLen;
    }
}
