class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        int[] freq1 = new int[26];

        for(int i = 0; i<s1.length(); i++){
            char c = s1.charAt(i);
            freq1[c - 'a']++;
        }

        int left = 0;
        int right = s1.length() - 1;
        int[] freq2 = new int[26];
        for(int i = 0; i<=right; i++){
            char c = s2.charAt(i);
            freq2[c - 'a']++;
            if(checkEquality(freq1, freq2))
                return true;
        }
        for(int i = right+1; i<s2.length(); i++){
            freq2[s2.charAt(left) - 'a']--;
            freq2[s2.charAt(i) - 'a']++;
            left++;
            if(checkEquality(freq1, freq2))
                return true;
        }
        return false;
    }
    public boolean checkEquality(int[] freq1, int[] freq2){
        for(int i = 0; i<freq1.length; i++){
            if(freq1[i]!=freq2[i])
                return false;
        }
        return true;
    }
}
