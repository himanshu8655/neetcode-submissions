class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
       int[] freq1 = new int[26];
       int[] freq2 = new int[26];

        for(char c : s1.toCharArray()){
            freq1[c - 'a']++;
        }
        int left = 0;
        for(int right = 0; right<s2.length(); right++){
            char c =  s2.charAt(right);
            freq2[c - 'a']++;
            while(freq2[c - 'a']>freq1[c - 'a']){
                char leftChar = s2.charAt(left); 
                freq2[leftChar - 'a']--;
                left++;
            }
            if(isEqual(freq1, freq2)){
                return true;
            }
        }

        return false;
    }

    public boolean isEqual(int[] freq1, int[] freq2){
        for(int i = 0; i<26; i++){
            if(freq1[i]!=freq2[i]){
                return false;
            }
        }
        return true;
    }
}
