class Solution {
    public int lengthOfLongestSubstring(String s) {
    int[] freq = new int[128];
    int leftPointer = 0;
    int result = 0;
    for(int i = 0; i<s.length(); i++){
        char c = s.charAt(i);
        freq[c]++;
        while(freq[c]>1){
            char leftCharacter = s.charAt(leftPointer);
            freq[leftCharacter]--;
            leftPointer++;
            }
        result = Math.max(result, i - leftPointer + 1);
        }
        return result;
    }
}
