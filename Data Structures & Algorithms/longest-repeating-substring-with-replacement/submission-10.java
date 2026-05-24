class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int right = 1;
        freq[s.charAt(left) - 'A']++;
        int res = 1;
        while(right<s.length()){    
            freq[s.charAt(right) - 'A']++;
            while(getMaxChar(freq) + k<(right - left +  1) && left<right){
            freq[s.charAt(left) - 'A']--;
            left++;
        }
        res = Math.max(res, right - left + 1);
        right++;
        }
    return res;
    }

    public int getMaxChar(int[] freq){
        int candidate = 0;
        for(int i = 0; i<26; i++){
            if(freq[i]>candidate){
                candidate = freq[i];
            }
        }
        return candidate;
    }
}
