class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0;
        int[] freq = new int[128];
        for(int i = 0; i<s.length(); i++){
            freq[s.charAt(i)]++;
            while(freq[s.charAt(i)]>1){
                freq[s.charAt(left)]--;
                left++;
            }
            result = Math.max(result, i - left + 1);
        }
        return result;
    }
}
