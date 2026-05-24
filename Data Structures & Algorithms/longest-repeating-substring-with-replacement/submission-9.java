class Solution {
    public int characterReplacement(String s, int k) {
        char[] arr = s.toCharArray();
        int left = 0;
        int res = 0;
        int[] freq = new int[26];
        for(int i = 0; i<arr.length; i++){
            char c = arr[i];
            freq[c - 'A']++;
            while(!isValid(freq, k, i - left + 1)){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
        res = Math.max(res, i - left + 1);
        }

        return res;
    }

    public boolean isValid(int[] freq, int k, int len){
        int max_freq = 0;
        for(int i = 0; i<26; i++){
            if(max_freq<freq[i])
                max_freq = freq[i];
        }

    return max_freq+k>=len;
    }
}
