class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        int n1 = s1.length();
        int n2 = s2.length();
        if(n1>n2)
            return false;
        int left = 0;

        for(int i = 0; i<n1; i++){
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(freq1,freq2))
            return true;
            
        for(int i = n1; i<n2;i++){
            char lChar = s1.charAt(left);
            char c = s2.charAt(i);
            freq2[lChar - 'a']--;
            freq2[c - 'a']++;
            left++;
            if(Arrays.equals(freq1,freq2))
                return true;
        }
        return false;
    }
}
