class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int left = 0;
        int result = 0;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            freq[c - 'A']++;
            maxFreq = Math.max( freq[c - 'A'], maxFreq);
            int distance = i -left + 1;
            while(maxFreq + k<distance){
                freq[s.charAt(left) - 'A']--;
                left++;
                distance = i - left + 1;
            }

            result = Math.max(result, distance);
        }

        return result; 
    }
}
