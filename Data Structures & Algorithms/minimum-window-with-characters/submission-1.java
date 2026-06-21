class Solution {
    public String minWindow(String s, String t) {
        String result = null;
        int[] freq1 = new int[128];
        int[] freq2 = new int[128];
        int matches = 128;
        if(s.length()<t.length())
            return "";
        for(int i = 0; i<t.length(); i++){
            freq2[t.charAt(i)]++;
            if(freq2[t.charAt(i)] == 1)
                matches--;
        }

        int left = 0;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            freq1[c]++;
            if(freq1[c] == freq2[c]){
                matches++;
            }

            while(matches == 128){
                int distance = i - left + 1;
                if(result == null || result.length()>distance)
                    result = s.substring(left, i+1);
                
                freq1[s.charAt(left)]--;
                if(freq1[s.charAt(left)] == freq2[s.charAt(left)]-1)
                    matches--;
                left++;
            }
        }

        return result == null ? "" : result;
    }
}
