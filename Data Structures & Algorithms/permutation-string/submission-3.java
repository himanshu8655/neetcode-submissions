class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(int i = 0; i<s1.length(); i++){
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for(int i = 0; i<26; i++){
            if(freq1[i] == freq2[i])
                matches++;
        }
        if(matches == 26)
            return true;

        int left = 0;
        for(int i = s1.length(); i<s2.length(); i++){
            int idx = s2.charAt(left++) - 'a';
            if(freq2[idx] == freq1[idx]){
                matches--;
            }
            freq2[idx]--;
            if(freq2[idx] == freq1[idx]){
                matches++;
            }
            int idx2 = s2.charAt(i) - 'a';
            if(freq2[idx2] == freq1[idx2]){
                matches--;
            }
            freq2[idx2]++;
             if(freq2[idx2] == freq1[idx2]){
                matches++;
            }
            if(matches == 26)
                return true;
        }

        return false;
    }
}
