class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;
        int maxFreq = 0; // 4
        int left = 0;
        int n = s.length();
        int[] freq = new int[26];
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            freq[c - 'A']++;//B = 2
            maxFreq = Math.max(maxFreq, freq[c - 'A']);//4

            while(maxFreq+k < i - left + 1){ //4+2<5-1+1
                char lChar = s.charAt(left);
                freq[lChar - 'A']--;
                left++;
            }

            maxFreq = Math.max(maxFreq, i - left + 1);
        }

        return maxFreq;
    }
}
