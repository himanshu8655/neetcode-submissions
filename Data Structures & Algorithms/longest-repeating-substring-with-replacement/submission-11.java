class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int left = 0;
        int res = 0;
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            freq[c - 'A']++;
            int maxValue = Arrays.stream(freq).max().getAsInt();

            while(maxValue + k < i - left + 1){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, i - left + 1);
        }

        return res;
    }
}
