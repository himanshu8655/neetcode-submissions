class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] freq = new int[128];
        char[] arr = s.toCharArray();
        int left = 0;
        int res = 0;

        for(int right = 0; right<arr.length; right++){
            char c = arr[right];
            freq[c]++;
            while(freq[c]>1){
                freq[arr[left]]--;
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
